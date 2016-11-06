package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * ���ý���ģ�͹۲�����
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigGuiModelObverser {

	/**
	 * ֪ͨ��ͼģ�����Ԫ�ء�
	 * @param index ���Ԫ�ص���š�
	 * @param configKey ���Ԫ�ص����ü���
	 * @param configValueChecker ���Ԫ�ص�ֵ�������
	 * @param defaultValue ���Ԫ�ص�Ĭ��ֵ��
	 * @param currentValue ���Ԫ�صĵ�ǰֵ��
	 */
	public void fireEntryAdded(int index, ConfigKey configKey, ConfigValueChecker configValueChecker, String defaultValue, String currentValue);
	
	/**
	 * ֪ͨ��ͼģ�ͱ��Ԫ�ء�
	 * @param index ���Ԫ�ص���š�
	 * @param configKey ������µ����ü���
	 * @param configValueChecker ������µ�Ԫ��ֵ�������
	 * @param defaultValue ������µ�Ĭ��ֵ��
	 * @param currentValue ������µĵ�ǰֵ��
	 */
	public void fireEntryChanged(int index, ConfigKey configKey, ConfigValueChecker configValueChecker, String defaultValue, String currentValue);
	
	/**
	 * ֪ͨ��ͼģ���Ƴ�Ԫ�ء�
	 * @param index Ԫ���Ƴ���λ�á�
	 */
	public void fireEntryRemoved(int index);
	
	/**
	 * ֪ͨ��ͼģ�����Ԫ�ء�
	 * @param ģ�ͱ����֮ǰ���е�Ԫ��������
	 */
	public void fireEntryCleared(int size);
	
}
