package com.dwarfeng.dutil.develop.cfg.io;

import java.util.Map;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ö�ȡ����
 * <p> ���ڶ�ȡָ�������á�
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public interface ConfigLoader {
	
	/**
	 * ��ȡָ�������á�
	 * @deprecated �÷����Ѿ��������������Ϊ {@link #load(ConfigModel)}���Է��������淶��
	 * @return ָ�����õĵ�ǰֵӳ�䡣
	 * @throws LoadFailedException ��ȡ�쳣��
	 */
	@Deprecated
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException;
	
	/**
	 * �����ö�ȡ��ָ��������ģ���С�
	 * @deprecated �÷����Ѿ��������������Ϊ {@link #load(ConfigModel)}���Է��������淶��
	 * @param configModel ָ��������ģ�͡�
	 * @throws LoadFailedException ��ȡʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ null��
	 */
	@Deprecated
	public void loadConfig(ConfigModel configModel) throws LoadFailedException;
	
	/**
	 * �����ö�ȡ��ָ��������ģ���С�
	 * @param configModel ָ��������ģ�͡�
	 * @throws LoadFailedException ��ȡʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ null��
	 */
	public void load(ConfigModel configModel) throws LoadFailedException;

}
