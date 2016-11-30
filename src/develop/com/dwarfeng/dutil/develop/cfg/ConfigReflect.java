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
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @return ���ü���������
	 */
	public default int size(){
		return keySet().size();
	}
	
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
	 * <p> �÷��������ӳ���еļ�ֵ�����ĳ����ֵ�Ǹ����ñ���ģ���а����ģ���ô��������õ�ǰֵ������������
	 * @param currentValueMap ָ���ĵ�ǰֵӳ�䡣
	 * @return �þٶ��Ƿ�����һ�δ������Թ۲�����֪ͨ��
	 */
	public default boolean setAll(Map<ConfigKey, String> currentValueMap){
		boolean result = false;
		for(Map.Entry<ConfigKey, String> entry : currentValueMap.entrySet()){
			if(contains(entry.getKey())){
				if(set(entry.getKey(), entry.getValue())) result = true;
			}
		}
		return result;
	}
	
	/**
	 * ��ȡ��Ӧ���ü�����Ч����ֵ��
	 * <p> �����ü��ĵ�ǰ����ֵ��Чʱ���ظ����ü���Ĭ������ֵ�����򷵻ص�ǰ����ֵ��
	 * <p> ������ü����ڸ����ñ���ģ���У��򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ��Чֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>������û��ָ��������ֵ�������
	 */
	public default String getValidValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigReflect_0));
		if(! contains(configKey)) return null;
		
		String defaultValue = getDefaultValueMap().get(configKey);
		String currentValue = getCurrentValueMap().get(configKey);
		ConfigChecker checker = getConfigCheckerMap().get(configKey);
		
		Objects.requireNonNull(checker, DwarfUtil.getStringField(StringFieldKey.ConfigReflect_1));
		
		return checker.isValid(currentValue) ? currentValue : defaultValue;
	}
	

}
