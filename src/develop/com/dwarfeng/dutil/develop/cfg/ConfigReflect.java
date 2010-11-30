package com.dwarfeng.dutil.develop.cfg;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * ����ӳ�䡣
 * <p> �ýӿڶ��������õ�����ӳ����ϵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigReflect {
	
	/**
	 * ����Ĭ��ֵӳ�䡣
	 * <p> ӳ�䲻�ɸ��ġ�
	 * <p> <b> ע�⣺ </b> ��Ĭ��ֵӳ�������ֵ<b>����ȫ����Ч</b>��
	 * @return Ĭ��ֵӳ�䡣
	 */
	public Map<ConfigKey, String> getDefaultValueMap();
	
	/**
	 * ��ȡ��ǰֵӳ�䡣
	 * <p> ӳ�䲻�ɸ��ġ�
	 * @return ��ǰֵӳ�䡣
	 */
	public Map<ConfigKey, String> getCurrentValueMap();
	
	/**
	 * ��ȡ����ֵ�����ӳ�䡣
	 * <p> ӳ�䲻�ɸ��ġ�
	 * @return  ����ֵ�����ӳ�䡣
	 */
	public Map<ConfigKey, ConfigChecker> getConfigCheckerMap();
	
	/**
	 * ����վ�������ü���������
	 * @return ���ü���������
	 */
	public int size();

	/**
	 * ��ȡ���ɸ��ĵ����ü����ϡ�
	 * <p> �ü����Ƿǿյģ����в����� <code>null</code>Ԫ�ء�
	 * @return ���ü����ϡ�
	 */
	public Set<ConfigKey> keySet();
	
	/**
	 * ����վ�����Ƿ����ָ�������ü���
	 * <p> �����ڲ���Ϊ <code>null</code> �����᷵�� <code>false</code>��
	 * @param configKey ָ�������ü���
	 * @return �Ƿ������
	 */
	public boolean contains(ConfigKey configKey);
	
	/**
	 * ����ָ�����ü��ĵ�ǰֵ��
	 * <p> ��������ñ���ģ�Ͳ�����ָ�������ü�����ôʲôҲ������
	 * @param key ָ�������ü���
	 * @param currentValue �µĵ�ǰֵ��
	 * @return �þٶ��Ƿ�����˶Թ۲�����֪ͨ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�� 
	 */
	public boolean set(ConfigKey configKey, String currentValue);
	
	/**
	 * �趨ָ����ǰֵӳ���е��������ü��ĵ�ǰֵ��
	 * @param currentValueMap ָ���ĵ�ǰֵӳ�䡣
	 * @return �þٶ��Ƿ�����һ�δ������Թ۲�����֪ͨ��
	 */
	public boolean setAll(Map<ConfigKey, String> currentValueMap);
	
	/**
	 * ��ȡ��Ӧ���ü�����Ч����ֵ��
	 * <p> �����ü��ĵ�ǰ����ֵ��Чʱ���ظ����ü���Ĭ������ֵ�����򷵻ص�ǰ����ֵ��
	 * <p> ������ü����ڸ����ñ���ģ���У��򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ��Чֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>.��
	 */
	public default String getValidValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPerformModel_0));
		if(! contains(configKey)) return null;
		if(isValid(configKey)) return getCurrentValue(configKey);
		return getDefaultValue(configKey);
	}

}
