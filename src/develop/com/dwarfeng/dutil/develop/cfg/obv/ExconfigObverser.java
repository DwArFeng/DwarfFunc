package com.dwarfeng.dutil.develop.cfg.obv;

import com.dwarfeng.dutil.basic.prog.Obverser;
import com.dwarfeng.dutil.develop.cfg.ConfigFirmProps;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * Ex����ģ�͹۲�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ExconfigObverser extends Obverser {

	/**
	 * ֪ͨ����ģ����ָ�������ü��ĵ�ǰֵ�����˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ���ü��ľ�ֵ��
	 * @param newValue
	 *            ���ü�����ֵ��
	 * @param validValue
	 *            ���ü���ǰ����Чֵ��
	 */
	public void fireCurrentValueChanged(ConfigKey configKey, String oldValue, String newValue, String validValue);

	/**
	 * ֪ͨ����ģ���е����ü������������
	 */
	public void fireConfigKeyCleared();

	/**
	 * ֪ͨ����ģ����ָ�������ü��������Ƴ���
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param configFirmProps
	 *            ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 * @param valueParser
	 *            ָ�������ü���Ӧ��ֵ��������
	 * @param currentValue
	 *            ָ�������ü���Ӧ�ĵ�ǰֵ��
	 */
	public void fireConfigKeyRemoved(ConfigKey configKey, ConfigFirmProps configFirmProps, ValueParser valueParser,
			String currentValue);

	/**
	 * ֪ͨ����ģ����ָ�������ü���������ӡ�
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param configFirmProps
	 *            ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 * @param valueParser
	 *            ָ�������ü���Ӧ��ֵ��������
	 * @param currentValue
	 *            ָ�������ü���Ӧ�ĵ�ǰֵ��
	 */
	public void fireConfigKeyAdded(ConfigKey configKey, ConfigFirmProps configFirmProps, ValueParser valueParser,
			String currentValue);

	/**
	 * ֪ͨ����ģ����ָ�������ü��Ĺ̶����Է����˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�����ü��ľɵĹ̶����ԡ�
	 * @param newValue
	 *            ָ�������ü����µĹ̶����ԡ�
	 */
	public void fireConfigFirmPropsChanged(ConfigKey configKey, ConfigFirmProps oldValue, ConfigFirmProps newValue);

	/**
	 * ֪ͨ����ģ����ָ�������ü���ֵ�����������˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�������ü���Ӧ�ľɵ�ֵ��������
	 * @param newValue
	 *            ָ�������ü���Ӧ���µ�ֵ��������
	 */
	public void fireValueParserChanged(ConfigKey configKey, ValueParser oldValue, ValueParser newValue);

}
