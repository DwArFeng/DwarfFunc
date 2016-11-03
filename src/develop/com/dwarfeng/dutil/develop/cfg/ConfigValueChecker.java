package com.dwarfeng.dutil.develop.cfg;

/**
 * ����ֵ�������
 * <p> ���ڼ������ֵ�Ƿ�Ϸ���
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigValueChecker {

	/**
	 * ���ָ����ֵ�Ƿ�Ϸ���
	 * @param value ָ����ֵ��
	 * @return ָ����ֵ�Ƿ�Ϸ���
	 */
	public boolean isValid(String value);
	
	/**
	 * ���ָ����ֵ�Ƿ�Ƿ���
	 * @param value ָ����ֵ��
	 * @return ָ����ֵ�Ƿ�Ƿ���
	 */
	public default boolean nonValid(String value){
		return ! isValid(value);
	}
	
}
