package com.dwarfeng.dutil.basic.io;

import java.util.Set;

/**
 * ��ȡ����
 * <p> ʵ�ָýӿ���ζ�Ÿö����ܹ���ĳЩ���ݼ��ص�ָ���Ķ����С�
 * <p> ��ȡ��ӵ��������Ϊ�Ķ�ȡ��ʽ��
 * <br>1����ȡ�����ж�ȡ���������쳣��ʱ�򣬶�ȡ������ֹ�����׳��쳣��
 * <br>2����ȡ�����ж�ȡ���������쳣��ʱ���ڼ����м�¼������쳣�����Ҽ�����ȡ���ȵ�ȫ����ȡ��Ϻ󣬷����쳣���ϡ�
 * <p> ��ȡ������Ƴ�һ����ʹ�õ��࣬����������һ�ֶ�ȡ����֮�󣬸�����ʧЧ����˲��ܷ������ö�ȡ������
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface Loader<T> {
	
	/**
	 * ��ָ���Ķ����ж�ȡ���ݡ�
	 * <p> �÷�����ָ���Ķ����ж�ȡ���ݣ�������ȫ����ȡ��ϣ�����������һ���쳣ʱ�������ֹͣ��
	 * @param obj ָ���Ķ���
	 * @throws LoadFailedException ��ȡʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalStateException �ظ����ö�ȡ����ʱ�׳����쳣��
	 */
	public void load(T obj) throws LoadFailedException, IllegalStateException;
	
	/**
	 * ��ָ���Ķ�����������ȡ���ݡ�
	 * <p>  �÷�����ָ���Ķ����г�����ȡ���ݣ�����ȡ�����������κ��쳣���÷����Ὣ�쳣��¼���쳣�����У�
	 * ���������׳��������е�����ȫ����ȡ��Ϻ󣬸÷����������������쳣���쳣���ϵ���ʽ���ء�
	 * @param obj ָ���Ķ���
	 * @return ��ȡ�����������������쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalStateException ���ظ����ö�ȡ����ʱ�׳����쳣��
	 */
	public Set<LoadFailedException> countinuousLoad(T obj) throws IllegalStateException;
	
}
