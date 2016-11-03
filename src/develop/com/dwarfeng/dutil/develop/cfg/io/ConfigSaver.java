package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigPort;

/**
 * ���ñ�������
 * <p> ���ڱ���ָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigSaver {
	
	/**
	 * ����ָ�������á�
	 * @param configPort ָ�������á�
	 * @throws IOException IO�쳣��
	 */
	public void saveConfig(ConfigPort configPort) throws SaveFailedException;

}
