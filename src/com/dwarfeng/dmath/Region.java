package com.dwarfeng.dmath;

/**
 * ��
 * <p> ��ӿڱ�������ʵ����ɱ�ʾΪһ���й��ڷ���<code>T</code>�ķ�Χ��
 * @author DwArFeng
 * @since 1.8
 */
public interface Region<T> extends DMath{

	/**
	 * �ж����Ƿ����ָ��Ԫ�ء�
	 * @param t ָ����Ԫ�ء�
	 * @return ָ����Ԫ���Ƿ����������
	 */
	public boolean contains(T t);
	
}
