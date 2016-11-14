package com.dwarfeng.dutil.develop.cfg;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * ����վ�㡣
 * <p>����վ����������ӳ����ϵ�ĺ��ģ�����ӳ����ϵ�ڸýӿ��б�ʵ�֡�
 * <br> ����վ����Է���ӳ����ϵ������ӳ�䣬������Щӳ�䲻�ɱ����ġ�
 * <p> ע�⣺����վ���ֹ null ���ü���������ͼʹ�� null ��Ϊ���ü��Ĵ���������Ϊ
 * ���ᵼ�� <code> NullPointException </code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigPort{
	
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
	 * ����վ�����Ƿ����ָ�������ü���
	 * <p> �����ڲ���Ϊ <code>null</code> �����᷵�� <code>false</code>��
	 * @param configKey ָ�������ü���
	 * @return �Ƿ������
	 */
	public boolean contains(ConfigKey configKey);
	
	/**
	 * ��ȡ���ɸ��ĵ����ü����ϡ�
	 * <p> �ü����Ƿǿյģ����в����� <code>null</code>Ԫ�ء�
	 * @return ���ü����ϡ�
	 */
	public Set<ConfigKey> keySet();
	
	/**
	 * ��ȡ��Ӧ���ü��ĵ�ǰֵ��
	 * <p> ������ü����ڸ�����վ�㵱�У��򷵻� <code>null</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return ��ǰֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default String getCurrentValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return null;
		return getCurrentValueMap().get(configKey);
	}
	
	/**
	 * ��ȡ��Ӧ���ü���Ĭ��ֵ��
	 * <p> ������ü����ڸ�����վ���У��򷵻� <code>null</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return Ĭ��ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default String getDefaultValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return null;
		return getDefaultValueMap().get(configKey);
	}
	
	/**
	 * ��ȡ��Ӧ���ü�����Ч����ֵ��
	 * <p> �����ü��ĵ�ǰ����ֵ��Чʱ���ظ����ü���Ĭ������ֵ�����򷵻ص�ǰ����ֵ��
	 * <p> ������ü����ڸ�����վ���У��򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ��Чֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>.��
	 */
	public default String getValidValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return null;
		if(isValid(configKey)) return getCurrentValue(configKey);
		return getDefaultValue(configKey);
	}
	
	/**
	 * ����ָ�����ü��ĵ�ǰֵ��
	 * <p> ���������վ�㲻����ָ�������ü�����ôʲôҲ������
	 * @param key ָ�������ü���
	 * @param currentValue �µĵ�ǰֵ��
	 * @return �þٶ��Ƿ�����˶Թ۲�����֪ͨ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�� 
	 */
	public boolean set(ConfigKey configKey, String currentValue);
	
	/**
	 * �趨ָ����ǰֵӳ���е��������ü��ĵ�ǰֵ��
	 * <p> �÷��������ӳ���еļ�ֵ�����ĳ����ֵ�Ǹ�����վ���а����ģ���ô��������õ�ǰֵ������������
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
	 * �������վ����ӹ۲�����
	 * @param obverser ָ���Ĺ۲�����
	 * @return �Ƿ�ɹ�����ӡ�
	 */
	public boolean addObverser(ConfigObverser obverser);
	
	/**
	 * �Ӹ�����վ���Ƴ��۲�����
	 * @param obverser ָ���Ĺ۲�����
	 * @return �Ƿ�ɹ����Ƴ���
	 */
	public boolean removeObverser(ConfigObverser obverser);
	
	/**
	 * �������վ���еĹ۲�����
	 */
	public void clearObversers();
	
	/**
	 * ��ѯָ���ļ��ĵ�ǰֵ�Ƿ���Ч��
	 * <p> ������ü����ڸ�����վ���У��򷵻� <code>false</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return ָ�����ü���Ӧ�ĵ�ǰֵ�Ƿ���Ч��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default boolean isValid(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return false;
		ConfigChecker checker = getConfigCheckerMap().get(configKey);
		if(Objects.isNull(checker)) return false;
		return checker.isValid(getCurrentValue(configKey));
	}
	
	/**
	 * ��ѯָ���ļ��ĵ�ǰֵ�Ƿ���Ч��
	 * <p> ������ü����ڸ�����վ���У��򷵻� <code>true</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return ָ�������ü���Ӧ�ĵ�ǰֵ�Ƿ���Ч��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default boolean nonValid(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return true;
		ConfigChecker checker = getConfigCheckerMap().get(configKey);
		if(Objects.isNull(checker)) return true;
		return checker.nonValid(getCurrentValue(configKey));
	}
	
	/**
	 * ����ָ����ֵ��ָ���ļ�����Ч�ԡ�
	 * <p> ������ü����ڸ�����վ���У��򷵻� <code>false</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @param value ָ���Ĵ���ֵ��
	 * @return ָ���Ĵ���ֵ�Ƿ���Ч��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default boolean checkValid(ConfigKey configKey, String value){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPort_0));
		if(! contains(configKey)) return false;
		ConfigChecker checker = getConfigCheckerMap().get(configKey);
		if(Objects.isNull(checker)) return false;
		return checker.isValid(value);
	}
}
