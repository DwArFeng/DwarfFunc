package com.dwarfeng.dutil.develop.cfg.io;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.basic.prog.Saver;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ñ�������
 * @deprecated �ýӿ��� {@link Saver} ����
 * <p> ���ڱ���ָ�������á�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface ConfigSaver {

	@Deprecated
	public void saveConfig(ConfigModel configModel) throws SaveFailedException;
	@Deprecated
	public void save(ConfigModel configModel) throws SaveFailedException;
	
}
