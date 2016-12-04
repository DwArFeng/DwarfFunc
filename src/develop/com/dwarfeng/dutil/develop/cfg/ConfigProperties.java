package com.dwarfeng.dutil.develop.cfg;

/**
 * �������ԡ�
 * <p> ����������һ��ʵ�����õ�����ӳ���ֵ��ʵ�֡�
 * ������ӵ���������ԣ��ֱ�洢һ�����ü��ĵ�ǰֵӳ�䡢Ĭ��ֵӳ�䡢ֵ�����ӳ���ֵ��
 * <p> ����������ǿ���ͨ��������һ��ӳ����ʵ�����õ�����ӳ�䡣
 * @author  DwArFeng
 * @since 1.8
 */
public class ConfigProperties {
	
	/**һ�����õĵ�ǰֵ*/
	public final String currentValue;
	/**һ�����õ�Ĭ��ֵ*/
	public final String defaultValue;
	/**һ�����õ�����ֵ�����*/
	public final ConfigChecker configChecker;
	
	/**
	 * ����һ��Ĭ�ϵ��������ԡ�
	 * 
	 * @param currentValue �������Եĵ�ǰֵ��
	 * @param defaultValue �������Ե�Ĭ��ֵ��
	 * @param configChecker �������Ե�ֵ�������
	 */
	public ConfigProperties(String currentValue, String defaultValue, ConfigChecker configChecker) {
		this.currentValue = currentValue;
		this.defaultValue = defaultValue;
		this.configChecker = configChecker;
	}
	
}
