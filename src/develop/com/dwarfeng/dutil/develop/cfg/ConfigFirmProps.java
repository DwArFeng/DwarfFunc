package com.dwarfeng.dutil.develop.cfg;

/**
 * ���õĹ̶����ԡ�
 * <p> �ýṹ������һ������Ӧ��ӵ�е����й̶����ԣ���Щ�������������ɿ�ʼ���Ͳ�Ӧ���ٷ����ı䡣
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigFirmProps {

	/**
	 * ��ȡ����Ĭ��ֵ��
	 * @return ����Ĭ��ֵ��
	 */
	public String getDefaultValue();
	
	/**
	 * ��ȡ����ֵ�������
	 * @return ����ֵ�������
	 */
	public ConfigChecker getConfigChecker();
	
}
