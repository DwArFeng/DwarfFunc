package com.dwarfeng.dutil.develop.cfg.struct;

import com.dwarfeng.dutil.develop.cfg.ConfigEntry;

/**
 * Ex������ڡ�
 * <p>
 * ��ԭ�е�������ڵĻ����ϣ�������ֵ��������
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ExconfigEntry extends ConfigEntry{

	/**
	 * ��ȡ��������ڵ�ֵ��������
	 * 
	 * @return ��������ڵ�ֵ��������
	 */
	public ValueParser getValueParser();

	/**
	 * ��ȡ��������ڵĵ�ǰֵ��
	 * 
	 * @return ��������ڵĵ�ǰֵ��
	 */
	public String getCurrentValue();

}
