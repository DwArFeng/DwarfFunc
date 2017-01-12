package com.dwarfeng.dutil.develop.cfg.io;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ñ�������
 * <p> ���ڱ���ָ�������á�
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public interface ConfigSaver {
	
	/**
	 * ����ָ�������á�
	 * @deprecated �÷����Ѿ���������������� {@link #save(ConfigModel)}���Է��������淶��
	 * @param configModel ָ��������ӳ�䡣
	 * @throws SaveFailedException ����ʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	@Deprecated
	public void saveConfig(ConfigModel configModel) throws SaveFailedException;

	/**
	 * ����ָ�������á�
	 * @param configModel ָ��������ӳ�䡣
	 * @throws SaveFailedException ����ʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void save(ConfigModel configModel) throws SaveFailedException;
	
}
