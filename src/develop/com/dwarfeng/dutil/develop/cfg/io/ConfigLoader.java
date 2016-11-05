package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.util.Map;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;

/**
 * ���ö�ȡ����
 * <p> ���ڶ�ȡָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigLoader {
	
	/**
	 * ��ȡָ�������á�
	 * @return ָ�����õĵ�ǰֵӳ�䡣
	 * @throws IOException IO�쳣��
	 */
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException;

}
