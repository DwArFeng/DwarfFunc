package com.dwarfeng.dutil.basic.num;

/**
 * ����ֵ��������
 * <p> �ܹ���������ֵ�Ľӿڡ�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface NumberValueFilter{

	/**
	 * ���ظù������Ƿ����ָ��������ֵ��
	 * @param value ����ֵ��
	 * @return �Ƿ����ָ��������ֵ��
	 */
	public boolean accept(NumberValue value);
	
}
