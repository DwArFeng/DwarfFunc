package com.dwarfeng.dutil.basic.num;

/**
 * ����ֵ��������
 * <p> �ܹ���������ֵ�Ľӿڡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface NumberValueFilter{

	/**
	 * ���ظù������Ƿ����ָ��������ֵ��
	 * @param value ����ֵ��
	 * @return �Ƿ����ָ��������ֵ��
	 */
	public boolean accept(NumberValue value);
	
}
