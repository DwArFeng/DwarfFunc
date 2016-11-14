package com.dwarfeng.dutil.develop.cfg;

/**
 * ����ֵ�������
 * <p> ���ڼ������ֵ�Ƿ�Ϸ���
 * <br> ���ڼ��ֵ�Ƿ���Ч�ͼ��ֵ�Ƿ���Ч��ʹ��Ƶ�ʼ���ͬ���ߣ���ˣ�ר�Ŷ�����ֵ�Ƿ���Ч��Ĭ�Ϸ���
 * {@link #nonValid(String)}�� �����д�����������Ҫ��֤�����������<code>String value</code>
 * ֵ������ <code>null</code> ֵ������Ҫ<code>isValid(value) == ! nonValid(value)</code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigChecker {

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
