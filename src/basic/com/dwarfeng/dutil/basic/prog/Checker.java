package com.dwarfeng.dutil.basic.prog;

/**
 * �������
 * <p> ���ڼ��ָ����ֵ�Ƿ�Ϸ���
 * @author  DwArFeng
 * @since 0.0.3-beta
 */
public interface Checker<T> {

	/**
	 * �ж�һ�������Ƿ���Ч��
	 * @param obj ָ���Ķ���
	 * @return �ö����Ƿ���Ч��
	 */
	public boolean isValid(T obj);
	
	/**
	 * �ж�һ�������Ƿ���Ч��
	 * @param obj ָ���Ķ���
	 * @return �ö����Ƿ���Ч��
	 */
	public default boolean nonValid(T obj){
		return ! isValid(obj);
	}
	
}
