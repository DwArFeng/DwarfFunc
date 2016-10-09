package com.dwarfeng.dutil.basic.cls;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.cna.ArrayUtil;

/**
 * �๦�ܰ���
 * <p>�ð���װ��һЩ{@link Class}����û�еĹ��ܣ������г�һ����������ֱ��{@link Object}�����и��ࡣ
 * @author DwArFeng
 * @since 1.8
 */
public final class ClassUtil {
	
	/**
	 * ��ȡһ��������и��ࡣ
	 * @param cl ָ�����ࡣ
	 * @return ��������и�����ɵļ��ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Collection<Class<?>> getSuperClasses(Class<?> cl){
		Collection<Class<?>> collection = new HashSet<Class<?>>();
		Class<?> clas = cl.getSuperclass();
		while(Objects.nonNull(clas)){
			collection.add(clas);
			clas = clas.getSuperclass();
		}
		return collection;
	}
	
	/**
	 * ��ȡһ��������и��ࡣ
	 * @param o ָ����ʵ����
	 * @return ��������и�����ɵļ��ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Collection<Class<?>> getSuperClasses(Object o){
		return getSuperClasses(o.getClass());
	}
	
	/**
	 * 	��ȡһ��ʵ�������е����и��ࡣ
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������и�����ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getSuperClassArray(Object o){
		return getSuperClasses(o).toArray(new Class<?>[0]);
	}
	
	/**
	 * 	��ȡһ�����е����и��ࡣ
	 * @param cl ָ�����ࡣ
	 * @return ��������и�����ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getSuperClassArray(Class<?> cl){
		return getSuperClasses(cl).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵļ��ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Collection<Class<?>> getAllInterfacesCollection(Class<?> cl){
//		Collection<Class<?>> superClasses = getSuperClasses(cl);
//		Collection<Class<?>> allInterfaces = new HashSet<Class<?>>();
//		Iterator<Class<?>> iterator = superClasses.iterator();
//		for(Class<?> cla:cl.getInterfaces()){
//			allInterfaces.add(cla);
//		}
//		while(iterator.hasNext()){
//			for(Class<?> clas : iterator.next().getInterfaces()) allInterfaces.add(clas);
//		}
//		return allInterfaces;
		
		Collection<Class<?>> superIntr = new HashSet<Class<?>>();
		Set<Class<?>> intrPool = new HashSet<Class<?>>();
		
		intrPool.addAll(Arrays.asList(cl.getInterfaces()));
		for(Class<?> clas : getSuperClasses(cl)){
			intrPool.addAll(Arrays.asList(clas.getInterfaces()));
		}
		
		while(intrPool.size() > 0){
			Class<?> clas = intrPool.iterator().next();
			intrPool.remove(clas);
			
			if(clas.isInterface()){
				superIntr.add(clas);
			}
			intrPool.addAll(Arrays.asList(clas.getInterfaces()));
		}
		
		return superIntr;
	}
	
	/**
	 * ��ȡһ��ʵ��������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������Լ�����ʵ�ֵ����нӿ���ɵļ��ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Collection<Class<?>> getAllInterfacesCollection(Object o){
		return getAllInterfacesCollection(o.getClass());
	}
	
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getAllInterfacesArray(Class<?> cl){
		return getAllInterfacesCollection(cl).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ��ʵ��������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getAllInterfacesArray(Object o){
		return getAllInterfacesCollection(o).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ�����Ƿ�ֱ�ӻ��߼�Ӽ̳�ĳ�������ӿڡ�
	 * @param source Դ�ࡣ
	 * @param target Ŀ���ࡣ
	 * @return Դ���Ƿ�ֱ�ӻ��Ӽ̳���Ŀ�������Ŀ��ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean isSubClass(Class<?> source,Class<?> target){
		Class<?>[] superClasses = ClassUtil.getSuperClassArray(source);
		Class<?>[] superInterfaces = ClassUtil.getAllInterfacesArray(source);
		return ArrayUtil.contains(superClasses, target) || ArrayUtil.contains(superInterfaces, target);
	}
	
	//�����޷�ʵ����
	private ClassUtil(){}

}
