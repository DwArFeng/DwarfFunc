package com.dwarfeng.dutil.develop.cfg;

/**
 * ���ò�����
 * <p> �ýӿ��ṩ��������ʼ�ղ����һЩ��ʼ����������������������վ�㡣
 * <p>����ĳ���ɸ������������ʵ�����д���ò����ӿڣ����е�һ���Ƽ��������ǣ���ö����ʵ������ӿڡ�
 * ��Ϊһ����ԣ�һ�������е�������һ���Ҹ�����ͬ�ģ���ö����ʵ���ǱȽϺ���ġ�
 * @see ConfigUtil#newConfigPort(ConfigElements[]))
 * @see ConfigUtil#newConfigPort(Iterable)
 * @see ConfigUtil#newConfigPort(Iterator)
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigElements {

	/**
	 * ��ȡ���ü���
	 * @return ���ü���
	 */
	public ConfigKey getConfigKey();
	
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
