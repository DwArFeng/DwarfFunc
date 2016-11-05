package com.dwarfeng.dutil.develop.cfg;

/**
 * ����ֵ�������
 * <p> ���ڼ������ֵ�Ƿ�Ϸ���
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigValueChecker {

	/**
	 * ���ָ����ֵ�Ƿ���Ч��
	 * @param value ָ����ֵ��
	 * @return ָ����ֵ�Ƿ���Ч��
	 */
	public boolean isValid(String value);
	
	/**
	 * ���ָ����ֵ�Ƿ���Ч��
	 * @param value ָ����ֵ��
	 * @return ָ����ֵ�Ƿ���Ч��
	 */
	public default boolean nonValid(String value){
		return ! isValid(value);
	}
	
}
