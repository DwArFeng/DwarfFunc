package com.dwarfeng.dutil.basic.cls;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
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
		Objects.requireNonNull(cl, DwarfUtil.getStringField(StringFieldKey.ClassUtil_0));
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
		Objects.requireNonNull(o, DwarfUtil.getStringField(StringFieldKey.ClassUtil_1));
		return getSuperClasses(o.getClass());
	}
	
	/**
	 * 	��ȡһ��ʵ�������е����и��ࡣ
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������и�����ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getSuperClassArray(Object o){
		Objects.requireNonNull(o, DwarfUtil.getStringField(StringFieldKey.ClassUtil_1));
		return getSuperClasses(o).toArray(new Class<?>[0]);
	}
	
	/**
	 * 	��ȡһ�����е����и��ࡣ
	 * @param cl ָ�����ࡣ
	 * @return ��������и�����ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getSuperClassArray(Class<?> cl){
		Objects.requireNonNull(cl, DwarfUtil.getStringField(StringFieldKey.ClassUtil_0));
		return getSuperClasses(cl).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵļ��ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Collection<Class<?>> getImplInterfaces(Class<?> cl){
		Objects.requireNonNull(cl, DwarfUtil.getStringField(StringFieldKey.ClassUtil_0));
		
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
	public static Collection<Class<?>> getImplInterfaces(Object o){
		Objects.requireNonNull(o, DwarfUtil.getStringField(StringFieldKey.ClassUtil_1));
		return getImplInterfaces(o.getClass());
	}
	
	/**
	 * ��ȡһ������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param cl ָ�����ࡣ
	 * @return �����Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getImplInterfacesArray(Class<?> cl){
		Objects.requireNonNull(cl, DwarfUtil.getStringField(StringFieldKey.ClassUtil_0));
		return getImplInterfaces(cl).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ��ʵ��������ʵ�ֵ����нӿڣ����������Լ�����ʵ�ֵ����нӿں�ʵ�ֽӿڵĸ��ӿڡ�
	 * @param o ָ����ʵ����
	 * @return ��ʵ�������Լ�����ʵ�ֵ����нӿ���ɵ����顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Class<?>[] getImplInterfacesArray(Object o){
		Objects.requireNonNull(o, DwarfUtil.getStringField(StringFieldKey.ClassUtil_1));
		return getImplInterfaces(o).toArray(new Class<?>[0]);
	}
	
	/**
	 * ��ȡһ�����Ƿ�ֱ�ӻ��߼�Ӽ̳�ĳ�������ӿڡ�
	 * @param source Դ�ࡣ
	 * @param target Ŀ���ࡣ
	 * @return Դ���Ƿ�ֱ�ӻ��Ӽ̳���Ŀ�������Ŀ��ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean isSubClass(Class<?> source, Class<?> target){
		
		Objects.requireNonNull(source, DwarfUtil.getStringField(StringFieldKey.ClassUtil_2));
		Objects.requireNonNull(target, DwarfUtil.getStringField(StringFieldKey.ClassUtil_3));
		
		//��Լ����������������Ż�
		
		//�ж�target�Ƿ���source��ֱ�Ӹ����ӿ�
		if(target.equals(source.getSuperclass())) return true;
		if(ArrayUtil.contains(source.getInterfaces(), target)) return true;
		
		//�ж�һ�������
		if(getSuperClasses(source).contains(target)) return true;
		if(getImplInterfaces(source).contains(target)) return true;
		
		return false;
		
	}
	
	//�����޷�ʵ����
	private ClassUtil(){}

}
