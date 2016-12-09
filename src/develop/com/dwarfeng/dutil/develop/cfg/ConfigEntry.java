package com.dwarfeng.dutil.develop.cfg;

/**
 * ����ӳ�����ڡ�
 * <p> ��������ڰ�ȫԭ�����Ϊֻ����ڣ��κε��޸Ķ�Ӧ���� {@link ConfigModel}����ɡ�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigEntry{
	
	/**
	 * ��ȡӳ����ڵļ���
	 * @return ӳ����ڵļ������ü�����
	 */
	public ConfigKey getKey();
	
	/**
	 * ��ȡӳ����ڵ�ֵ��
	 * @return ӳ����ڵ�ֵ���������ԣ���
	 */
	public ConfigProperties getValue();
	
}