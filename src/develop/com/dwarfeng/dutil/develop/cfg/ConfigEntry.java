package com.dwarfeng.dutil.develop.cfg;

/**
 * ������ڡ�
 * <p>������ڰ���һ�����ü����Լ����õĹ̶����ԡ�
 * ������������İ���������ģ�͵ļ��Լ�һ�������е����в��ɱ�Ĳ��֣�һЩ����ģ�ͻ��Ըýӿ�Ϊģ����ڡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigEntry{

	/**
	 * ��ȡ������ڵ����ü���
	 * @return ������ڵ����ü���
	 */
	public ConfigKey getConfigKey();
	
	/**
	 * ��ȡ������ڵĹ̶����ԡ�
	 * @return ������ڵĹ̶����ԡ�
	 */
	public ConfigFirmProps getConfigFirmProps();
	
}
