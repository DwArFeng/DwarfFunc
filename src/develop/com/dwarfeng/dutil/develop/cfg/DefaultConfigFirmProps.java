package com.dwarfeng.dutil.develop.cfg;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * Ĭ�����ù̶����ԡ�
 * <p> ���ù̶����Խӿڵ�Ĭ��ʵ�֡�
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultConfigFirmProps implements ConfigFirmProps {
	
	private final ConfigChecker ConfigChecker;
	private final String defaultValue;

	/**
	 * ����һ���µ�Ĭ�����ù̶�����ʵ����
	 * @param configChecker ָ��������ֵ�������
	 * @param defaultValue ָ����Ĭ������ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ����Ĭ��ֵ�޷�ͨ��ָ��������ֵ������ļ��顣
	 */
	public DefaultConfigFirmProps(ConfigChecker configChecker, String defaultValue) {
		Objects.requireNonNull(configChecker, DwarfUtil.getStringField(StringFieldKey.DefaultConfigFirmProps_0));
		Objects.requireNonNull(defaultValue, DwarfUtil.getStringField(StringFieldKey.DefaultConfigFirmProps_1));
		
		if(configChecker.nonValid(defaultValue)){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultConfigFirmProps_2));
		}
		
		this.ConfigChecker = configChecker;
		this.defaultValue = defaultValue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigFirmProps#getDefaultValue()
	 */
	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigFirmProps#getConfigChecker()
	 */
	@Override
	public ConfigChecker getConfigChecker() {
		return ConfigChecker;
	}

}
