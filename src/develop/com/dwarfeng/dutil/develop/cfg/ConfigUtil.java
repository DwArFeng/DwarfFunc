package com.dwarfeng.dutil.develop.cfg;

import java.util.Objects;

/**
 * �й������ð���һЩ���÷�����
 * @author DwArFeng
 * @since 1.8
 */
public final class ConfigUtil {
	
	/**
	 * �ж�ָ�������ù̶������Ƿ���Ч��
	 * <p> ��ָ�������ù̶����Բ�Ϊ <code>null</code>���������е�����ֵ�������Ϊ <code>null</code>��
	 * ����Ĭ��ֵ��ͨ������ֵ�����ʱ����Ϊָ�������ù̶�������Ч��
	 * @param configFirmProps ָ�������ù̶����ԡ�
	 * @return ָ�������ù̶������Ƿ���Ч��
	 */
	public static boolean isValid(ConfigFirmProps configFirmProps){
		if(Objects.isNull(configFirmProps)) return false;
		if(Objects.isNull(configFirmProps.getConfigChecker())) return false;
		
		return configFirmProps.getConfigChecker().isValid(configFirmProps.getDefaultValue());
	}
	
	/**
	 * �ж�ָ�������ù̶������Ƿ���Ч��
	 * <p> ������ù̶�ֵ����Ч������Ч�����÷�����ͬ��
	 * <code> ! isValid(configFirmProps)</code>
	 * @param configFirmProps ָ�������ù̶����ԡ�
	 * @return ָ�������ù̶�����ֵ�Ƿ���Ч��
	 */
	public static boolean nonValid(ConfigFirmProps configFirmProps){
		return ! isValid(configFirmProps);
	}
	
	/**
	 * �ж�ָ������������Ƿ���Ч��
	 * <p> ��ָ����������ڲ�Ϊ <code>null</code>�� �����е����ü���Ϊ <code>null</code>��
	 * �����е����ù̶�ֵ��Чʱ����Ϊָ�������������Ч��
	 * @param configEntry ָ����������ڡ�
	 * @return ָ������������Ƿ���Ч��
	 */
	public static boolean isValid(ConfigEntry configEntry){
		if(Objects.isNull(configEntry)) return false;
		if(Objects.isNull(configEntry.getConfigKey())) return false;
		
		return isValid(configEntry.getConfigFirmProps());
	}
	
	/**
	 * �ж�ָ������������Ƿ���Ч��
	 * <p> ���������ڲ���Ч������Ч�����÷�����ͬ��
	 * <code>�� isValid(configEntry)</code>
	 * @param configEntry ָ����������ڡ�
	 * @return ָ������������Ƿ���Ч��
	 */
	public static boolean nonValid(ConfigEntry configEntry){
		return ! isValid(configEntry);
	}
	
	//��ֹ�ⲿʵ������
	private ConfigUtil(){}

}
