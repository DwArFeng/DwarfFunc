package com.dwarfeng.dutil.basic.io;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * �����ȡ�࣬���ڶ�ȡָ��λ���µ�ָ�����͵Ĳ����
 * <p>�����ȡ��һ��ʵ���������ȡ·���㲻���ٱ����ġ�
 * <br>����ļ�����ͨ��<code>URLClassLoader</code>��ʵ�ֵģ��÷��������Ժ󣬲����������رա�
 * Ҫ��رյĻ������{@link PluginLoader#close()}���������౻�ر��Ժ�����������ɼ��ص����ʵ���Ļ�
 * ����ܳ����Ҳ�����Դ���������ˣ���ȷ���������µ�ʵ�������Ժ��ٹرմ��ࡣ
 * @author DwArFeng
 * @since 1.8
 */
public class PluginLoader<T>{
	
	public final static String DEFAULT_DIR = "plugins";
	
	private final URLClassLoader loader;
	private final File dirFile;
	private final File[] jarFiles;
	private boolean isClose;
	
	/**
	 * ����һ��ָ��Ĭ��·���Ĳ����ȡ�ࡣ
	 * <br>Ĭ�ϵĶ�ȡλ����ͬĿ¼�µ�<code>plugins</code>�ļ��С�
	 */
	public PluginLoader(){
		this(new File(DEFAULT_DIR));
	}
	/**
	 * ����һ��ָ��ִ���ı�������·���Ĳ����ȡ�ࡣ
	 * @param path ָ����·���ı���
	 */
	public PluginLoader(String path){
		this(new File(path));
	}
	/**
	 * ����һ��ָ��ָ���ļ�������Ŀ¼�Ĳ����ȡ�ࡣ
	 * @param dirFile ָ�����ļ���
	 */
	public PluginLoader(File dirFile){
		//dirFile����Ϊnull
		if(dirFile == null) throw new NullPointerException("Dir file can't be null");
		this.dirFile = dirFile;
		File[] tempJarFiles = getDirFile().listFiles(new FileExtensionNameFiliter(".jar"));
		//����Ŀ¼���к�׺��Ϊ.jar���ļ�������null�����������
		jarFiles = tempJarFiles == null ? new File[0] : tempJarFiles;
		//����ת��Ϊurl��
		Set<URL> urls = new HashSet<URL>();
		for(int i = 0 ; i < jarFiles.length ; i ++){
			try {
				urls.add(jarFiles[i].toURI().toURL());
			} catch (MalformedURLException e) {
				CT.trace("Exception occured while transform file to url :" + jarFiles[i].getName());
			}
		}
		//��ʼ��loader
		loader = new URLClassLoader(urls.toArray(new URL[0]),Thread.currentThread().getContextClassLoader());
		//��ʼ���Ƿ�رյı�ǡ�
		isClose = false;
	}
	
	/**
	 * ���ظò����ȡ���ָ��·����
	 * @return �ò����ȡ���ָ��·����
	 */
	public File getDirFile(){return this.dirFile;}
	/**
	 * �رյ�ǰ�Ķ��������࣬���ʹ�Ѿ���ȡ���������µ�ʵ��ʱ�������⡣
	 * @throws IOException ���ֽӿ��쳣�����Ѿ��ر�ʱ�׳��쳣��
	 */
	public void close() throws IOException{
		try {
			if(isClose) throw new IOException("PluginLoader has already been closed");
			loader.close();
		} catch (IOException e) {
			throw e;
		}finally{
			isClose = true;
		}
	}
	/**
	 * ������������<code>clas</code>���������ࡣ
	 * @param clas ָ���ĸ��ࡣ
	 * @param <U> ���͡�
	 * @return ���б����صĲ��������ɵļ��ϡ�
	 * @throws IOException ���ò�����ض����Ѿ����رյ�ʱ���׳����쳣��
	 */
	@SuppressWarnings("unchecked")
	public<U extends T> Collection<Class<U>> loadPluginClass(Class<U> clas) throws IOException{
		if(isClose) throw new IOException("PluginLoader already closed");
		Collection<Class<U>> classCollection = new HashSet<Class<U>>();
		bk0:
		for(int i = 0 ; i < jarFiles.length ; i ++){
			Enumeration<JarEntry> je = null;	
			JarFile jf = null;
			
			try{
				//Ѱ��Entry�������쳣ֱ�ӷ�������jar����������һ��jar���ĵ��ȡ�
				try {
					jf = new JarFile(jarFiles[i]);
					je = jf.entries();
				} catch (IOException e) {
					CT.trace("Exception occured while getting entries : " + jarFiles[i].getName());
					continue bk0;
				}
				bk1:
				while(je.hasMoreElements()){
					JarEntry entry = je.nextElement();
					if(entry.getName() != null && entry.getName().endsWith(".class")){
						Class<?> c = null;
						//�ֱ�Ѷ�Ӧ�Ĳ������ע��������쳣������class�ļ���
						try{
							 c = loader.loadClass(entry.getName().replace("/", ".").substring(0,entry.getName().length() - 6));
							 if(clas.isAssignableFrom(c)) classCollection.add((Class<U>) c);
						}catch(ClassNotFoundException e){
							CT.trace("Exception occured while loading class : " + entry.getName());
							continue bk1;
						}
					}
				}
			}finally {
				if(Objects.nonNull(jf)){
					try{
						jf.close();
					}catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return classCollection;
	}
	/**
	 * ��ȡ��Ӽ̳�ָ��������࣬������ʵ������
	 * <p>ע�⣺�÷���ֻ��ʵ�־���Ĭ�Ϲ������������࣬��������е���û��Ĭ�ϵĹ����������������ʾ�쳣��
	 * @param clas ֱ�ӻ��Ӽ̳е��ࡣ
	 * @param <U> ���͡�
	 * @return ���������ʵ�������󼯺ϡ�
	 * @throws IOException ���ò�����ض����Ѿ����رյ�ʱ���׳����쳣��
	 */
	public<U extends T> Collection<U> loadPluginInstance(Class<U> clas) throws IOException{
		Collection<U> instanceCollection = new HashSet<U>();
		Collection<Class<U>> classCollection = loadPluginClass(clas);
		Iterator<Class<U>> iterator = classCollection.iterator();
		Class<U> next = null;
		while(iterator.hasNext()){
			try{
				next = iterator.next();
				instanceCollection.add(next.newInstance());
			}catch(IllegalAccessException | InstantiationException e){
				CT.trace("Exception occured when class was initialized" + next.getName());
			}
		}
		return instanceCollection;
	}
}
