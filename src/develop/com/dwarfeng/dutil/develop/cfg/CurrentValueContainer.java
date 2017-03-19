package com.dwarfeng.dutil.develop.cfg;

import java.util.Map;

/**
 * ��ǰֵ������
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface CurrentValueContainer {

	/**
	 * ��ȡ�����еĵ�ǰֵ��
	 * <p>
	 * ��ǰֵ���ܺϷ���Ҳ���ܲ��Ϸ���
	 * <p>
	 * ��������в�����ָ�������ü�����������ü�Ϊ <code>null</code>���򷵻� <code>null</code>��
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return ģ����ָ�����ü���Ӧ�ĵ�ǰֵ��
	 */
	public String getCurrentValue(ConfigKey configKey);

	/**
	 * ��ȡ�����е����ü��뵱ǰֵ��ӳ�䣬���ӳ����������е����е�ǰֵ��
	 * <p>
	 * ��ȡ��ӳ����ֻ���ġ�
	 * 
	 * @return �����е����ü��뵱ǰֵӳ�䡣
	 */
	public Map<ConfigKey, String> getAllCurrentValue();

	/**
	 * ����ģ����ָ�����ü��ĵ�ǰֵ��
	 * <p>
	 * ��ָ�������ü�Ϊ <code>null</code>����ָ�������ü��������ڵ�ǰ��ģ��ʱ���������κβ����� <br>
	 * ��ָ���� currentValue Ϊ <code>null</code>ʱ���������κβ�����
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param currentValue
	 *            ָ���ĵ�ǰֵ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 */
	public boolean setCurrentValue(ConfigKey configKey, String currentValue);

	/**
	 * ����ģ����ָ�����ü��ĵ�ǰֵ��
	 * <p>
	 * �ò�����ͼ��ָ����ӳ���е����е����ü�-��ǰֵ���õ�ģ���С�
	 * <p>
	 * ��ָ�������ü�Ϊ <code>null</code>����ָ�������ü��������ڵ�ǰ��ģ��ʱ���������κβ�����
	 * 
	 * @param map
	 *            ָ�������ü�-��ǰֵӳ�䡣
	 * @return �ò����Ƿ��ģ�Ͳ����˸ı䡣
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean setAllCurrentValue(Map<ConfigKey, String> map);

}
