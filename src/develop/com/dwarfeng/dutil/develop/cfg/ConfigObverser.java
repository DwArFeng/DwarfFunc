package com.dwarfeng.dutil.develop.cfg;

import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ���ù۲�����
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public interface ConfigObverser extends Obverser {

	/**
	 * ֪ͨ����ģ����ָ�������ü��ĵ�ǰֵ�����˸ı䡣
	 * @param configKey ָ�������ü���
	 * @param oldValue ���ü��ľ�ֵ��
	 * @param newValue ���ü�����ֵ��
	 * @param validValue ���ü���ǰ����Чֵ��
	 */
	public void fireCurrentValueChanged(ConfigKey configKey, String oldValue, String newValue, String validValue);
	
	/**
	 * ֪ͨ����ģ���е����ü������������
	 */
	public void fireConfigKeyCleared();
	
	/**
	 * ֪ͨ����ģ����ָ�������ü��������Ƴ���
	 * @param configKey ָ�������ü���
	 */
	public void fireConfigKeyRemoved(ConfigKey configKey);
	
	/**
	 * ֪ͨ����ģ����ָ�������ü���������ӡ�
	 * @param configKey ָ�������ü���
	 */
	public void fireConfigKeyAdded(ConfigKey configKey);
	
	/**
	 * ֪ͨ����ģ����ָ�������ü��Ĺ̶����Է����˸ı䡣
	 * @param configKey ָ�������ü���
	 * @param oldValue ָ�����ü��ľɵĹ̶����ԡ�
	 * @param newValue ָ�������ü����µĹ̶����ԡ�
	 */
	public void fireConfigFirmPropsChanged(ConfigKey configKey, ConfigFirmProps oldValue, ConfigFirmProps newValue);
	
}
