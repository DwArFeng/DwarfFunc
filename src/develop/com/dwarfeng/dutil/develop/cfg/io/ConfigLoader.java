package com.dwarfeng.dutil.develop.cfg.io;

import java.util.Map;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.basic.io.Loader;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ö�ȡ����
 * @deprecated �ýӿ��� {@link Loader} �ӿڴ��档
 * <p> ���ڶ�ȡָ�������á�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface ConfigLoader {
	
	@Deprecated
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException;
	@Deprecated
	public void loadConfig(ConfigModel configModel) throws LoadFailedException;
	@Deprecated
	public void load(ConfigModel configModel) throws LoadFailedException;

}
