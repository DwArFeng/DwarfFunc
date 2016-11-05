package com.dwarfeng.dutil.develop.cfg;

/**
 * ������ڡ�
 * <p> �ýӿڿ���������������վ�㡣
 * <p>����ĳ���ɸ������������ʵ�����д������ڣ����е�һ���Ƽ��������ǣ���ö����ʵ������ӿڡ�
 * ��Ϊһ����ԣ�һ�������е�������һ���Ҹ�����ͬ�ģ���ö����ʵ���ǱȽϺ���ġ�
 * @see ConfigUtil#newConfigPort(ConfigEntry[])
 * @see ConfigUtil#newConfigPort(Iterable)
 * @see ConfigUtil#newConfigPort(Iterator)
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigEntry {

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
	public ConfigValueChecker getConfigValueChecker();
	
}
