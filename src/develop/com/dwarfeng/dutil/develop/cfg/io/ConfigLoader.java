package com.dwarfeng.dutil.develop.cfg.io;

import java.util.Map;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ö�ȡ����
 * <p> ���ڶ�ȡָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigLoader {
	
	/**
	 * ��ȡָ�������á�
	 * <p> �÷����Ѿ��������������Ϊ {@link #loadConfig()}����ʹ�䷽���� {@link ConfigSaver}�еķ������롣
	 * @return ָ�����õĵ�ǰֵӳ�䡣
	 * @throws LoadFailedException ��ȡ�쳣��
	 */
	@Deprecated
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException;
	
	/**
	 * �����ö�ȡ��ָ��������ģ���С�
	 * @param configModel ָ��������ģ�͡�
	 * @throws LoadFailedException ��ȡʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ null��
	 */
	public void loadConfig(ConfigModel configModel) throws LoadFailedException;

}
