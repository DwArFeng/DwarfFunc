package com.dwarfeng.dutil.develop.cfg;

import java.util.Map;
import java.util.Objects;
import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ���ñ���ģ�͡�
 * <p> ��ģ��ע�����ܣ���Ӧ�ٶȽϿ죬���ܹ�ע���Ա���Ϊ���Ĺ۲�����
 * <p>����վ����������ӳ����ϵ�ĺ��ģ�����ӳ����ϵ�ڸýӿ��б�ʵ�֡�
 * <br> ���ñ���ģ�Ϳ��Է���ӳ����ϵ������ӳ�䣬������Щӳ�䲻�ɱ����ġ�
 * <p> ע�⣺���ñ���ģ�ͽ�ֹ null ���ü���������ͼʹ�� null ��Ϊ���ü��Ĵ���������Ϊ
 * ���ᵼ�� <code> NullPointException </code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigPerformModel extends ConfigReflect, ObverserSet<ConfigPerformObverser>{
	
	/**
	 * ����վ�������ü���������
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @return ���ü���������
	 */
	@Override
	public default int size(){
		return keySet().size();
	}

	
	/**
	 * ��ȡ��Ӧ���ü��ĵ�ǰֵ��
	 * <p> ������ü����ڸ����ñ���ģ�͵��У��򷵻� <code>null</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return ��ǰֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default String getCurrentValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPerformModel_0));
		if(! contains(configKey)) return null;
		return getCurrentValueMap().get(configKey);
	}
	
	/**
	 * ��ȡ��Ӧ���ü���Ĭ��ֵ��
	 * <p> ������ü����ڸ����ñ���ģ���У��򷵻� <code>null</code>��
	 * <p> <b> ע�⣺</b> �÷�����Ĭ��ʵ��Ч�ʽ�Ϊ���£�������Ҫ������д�÷��������Ч�ʡ�
	 * @param configKey ָ�������ü���
	 * @return Ĭ��ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default String getDefaultValue(ConfigKey configKey){
		Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigPerformModel_0));
		if(! contains(configKey)) return null;
		return getDefaultValueMap().get(configKey);
	}
	
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
	
	/**
	 * �趨ָ����ǰֵӳ���е��������ü��ĵ�ǰֵ��
	 * <p> �÷��������ӳ���еļ�ֵ�����ĳ����ֵ�Ǹ����ñ���ģ���а����ģ���ô��������õ�ǰֵ������������
	 * @param currentValueMap ָ���ĵ�ǰֵӳ�䡣
	 * @return �þٶ��Ƿ�����һ�δ������Թ۲�����֪ͨ��
	 */
	@Override
	public default boolean setAll(Map<ConfigKey, String> currentValueMap){
		boolean result = false;
		for(Map.Entry<ConfigKey, String> entry : currentValueMap.entrySet()){
			if(contains(entry.getKey())){
				if(set(entry.getKey(), entry.getValue())) result = true;
			}
		}
		return result;
	}
	
}
