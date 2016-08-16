package com.dwarfeng.dfunc.cls;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.dwarfeng.dfunc.cna.ArraysFunction;

/**
 * �๦�ܰ���
 * <p>�ð���װ��һЩ{@link Class}����û�еĹ��ܣ������г�һ����������ֱ��{@link Object}�����и��ࡣ
 * @author DwArFeng
 * @since 1.8
 */
public final class ClassFunction {
	
	/**
	 * ��ȡһ�����еĳ���{@link Object}��������и��ࡣ
	 * @param cl ָ�����ࡣ
	 * @return �������{@link Object}��������и�����ɵļ��ϡ�
	 */
	public static Collection<Class<?>> getAllSuperClassesCollection(Class<?> cl){
		Collection<Class<?>> collection = new HashSet<Class<?>>();
		Class<?> clas = cl.getSuperclass();
		while(clas != null && !clas.equals(Object.class)){
			collection.add(clas);
			clas = clas.getSuperclass();
		}
		return collection;
	}
	/**
	 * ��ȡһ��ʵ�������еĳ���{@link Object}��������и��ࡣ
	 * @param o ָ����ʵ����
	 * @return ��ʵ������{@link Object}��������и�����ɵļ��ϡ�
	 */
	public static Collection<Class<?>> getAllSuperClassesCollection(Object o){
		return getAllSuperClassesCollection(o.getClass());
	}
	/**
	 * 	��ȡһ��ʵ�������еĳ���{@link Object}��������и��ࡣ
	 * @param o ָ����ʵ����
	 * @return ��ʵ������{@link Object}��������и�����ɵ����顣
	 */
	public static Class<?>[] getAllSuperClassesArray(Object o){
		return getAllSuperClassesCollection(o).toArray(new Class<?>[0]);
	}
	/**
	 * 	��ȡһ�����еĳ���{@link Object}��������и��ࡣ
	 * @param cl ָ�����ࡣ
	 * @return �������{@link Object}��������и�����ɵ����顣
	 */
	public static Class<?>[] getAllSuClassesArray(Class<?> cl){
		return getAllSuperClassesCollection(cl).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵļ��ϡ�
	 */
	public static Collection<Class<?>> getAllInterfacesCollection(Class<?> cl){
		Collection<Class<?>> superClasses = getAllSuperClassesCollection(cl);
		Collection<Class<?>> allInterfaces = new HashSet<Class<?>>();
		Iterator<Class<?>> iterator = superClasses.iterator();
		for(Class<?> cla:cl.getInterfaces()){
			allInterfaces.add(cla);
		}
		while(iterator.hasNext()){
			for(Class<?> clas : iterator.next().getInterfaces()) allInterfaces.add(clas);
		}
		return allInterfaces;
	}
	/**
	 * ��ȡһ��ʵ��������ʵ�ֵ����нӿڣ���������ʵ�ֵ����нӿڡ�
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������Լ�����ʵ�ֵ����нӿ���ɵļ��ϡ�
	 */
	public static Collection<Class<?>> getAllInterfacesCollection(Object o){
		return getAllInterfacesCollection(o.getClass());
	}
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ���������ʵ�ֵ����нӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 */
	public static Class<?>[] getAllInterfacesArray(Class<?> cl){
		return getAllInterfacesCollection(cl).toArray(new Class<?>[0]);
	}
	/**
	 * ��ȡһ��ʵ��������ʵ�ֵ����нӿڣ���������ʵ�ֵ����нӿڡ�
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 */
	public static Class<?>[] getAllInterfacesArray(Object o){
		return getAllInterfacesCollection(o).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ�����Ƿ�ֱ�ӻ��߼�Ӽ̳�ĳ�������ӿڡ�
	 * @param source Դ�ࡣ
	 * @param target Ŀ���ࡣ
	 * @return Դ���Ƿ�ֱ�ӻ��Ӽ̳���Ŀ�������Ŀ��ӿڡ�
	 */
	public static boolean isSubClass(Class<?> source,Class<?> target){
		Class<?>[] superClasses = ClassFunction.getAllSuperClassesArray(source);
		Class<?>[] superInterfaces = ClassFunction.getAllInterfacesArray(source);
		return ArraysFunction.contains(superClasses, target) || ArraysFunction.contains(superInterfaces, target);
	}
	
	//�����޷�ʵ����
	private ClassFunction(){}

}
