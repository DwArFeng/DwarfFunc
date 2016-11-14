package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

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
	 * @param configChecker ���Ԫ�ص�ֵ�������
	 * @param defaultValue ���Ԫ�ص�Ĭ��ֵ��
	 * @param currentValue ���Ԫ�صĵ�ǰֵ��
	 */
	public void fireValueAdded(int index, ConfigKey configKey, ConfigChecker configChecker, String defaultValue, String currentValue);
	
	/**
	 * ֪ͨ��ͼģ�ͱ��Ԫ�ء�
	 * @param index ���Ԫ�ص���š�
	 * @param configKey ������µ����ü���
	 * @param configChecker ������µ�Ԫ��ֵ�������
	 * @param defaultValue ������µ�Ĭ��ֵ��
	 * @param currentValue ������µĵ�ǰֵ��
	 */
	public void fireValueChanged(int index, ConfigKey configKey, ConfigChecker configChecker, String defaultValue, String currentValue);
	
	/**
	 * ֪ͨ��ͼģ���Ƴ�Ԫ�ء�
	 * @param index Ԫ���Ƴ���λ�á�
	 */
	public void fireValueRemoved(int index);
	
	/**
	 * ֪ͨ��ͼģ�����Ԫ�ء�
	 * @param ģ�ͱ����֮ǰ���е�Ԫ��������
	 */
	public void fireValueCleared(int size);
	
}
