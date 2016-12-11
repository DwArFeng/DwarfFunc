package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ñ�������
 * <p> ���ڱ���ָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigSaver {
	
	/**
	 * ����ָ�������á�
	 * @param configReflect ָ��������ӳ�䡣
	 * @throws IOException IO�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void saveConfig(ConfigModel configReflect) throws SaveFailedException;

}
