package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * Ĭ������ģ�͡�
 * @author  DwArFeng
 * @since 1.8
 */
public class DefaultConfigModel extends AbstractConfigModel {

	/**����ģ�͵ĵ�ǰֵӳ��*/
	protected final Map<ConfigKey, String> currentValueMap = new HashMap<>();
	
	/**����ģ�͵Ĺ̶�����ӳ��*/
	protected final Map<ConfigKey, ConfigFirmProps> firmPropsMap = new HashMap<>();
	
	/**
	 * ����һ����ָ��������Ŀ����ɵ�Ĭ������ģ�͡�
	 * <p> ���ɵ�ģ���У�ÿ����Ŀ������ֵ��Ĭ��ֵ��ȡ�
	 * @param configEntries ָ����������Ŀ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultConfigModel(ConfigEntry[] configEntries){
		Objects.requireNonNull(configEntries, DwarfUtil.getStringField(StringFieldKey.DefaultConfigModel_0));
		
		for(ConfigEntry configEntry : configEntries){
			firmPropsMap.put(configEntry.getConfigKey(), configEntry.getConfigFirmProps());
		}
	}
	
	/**
	 * ����һ����ָ��������Ŀ������ɵ�Ĭ������ģ�͡�
	 * <p> ���ɵ�ģ���У�ÿ����Ŀ������ֵ��Ĭ��ֵ��ȡ�
	 * @param configEntries ָ����������Ŀ���ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultConfigModel(Collection<ConfigEntry> configEntries) {
		Objects.requireNonNull(configEntries, DwarfUtil.getStringField(StringFieldKey.DefaultConfigModel_0));

		for(ConfigEntry configEntry : configEntries){
			firmPropsMap.put(configEntry.getConfigKey(), configEntry.getConfigFirmProps());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#clear()
	 */
	@Override
	public void clear() {
		this.currentValueMap.clear();
		this.firmPropsMap.clear();
		fireConfigKeyCleared();
	}
	
	private void fireConfigKeyCleared(){
		for(ConfigModelObverser obverser : obversers){
			obverser.fireConfigKeyCleared();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#containsKey(com.dwarfeng.dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public boolean containsKey(ConfigKey configKey) {
		return firmPropsMap.containsKey(configKey);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#getCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public String getCurrentValue(ConfigKey configKey) {
		if(currentValueMap.containsKey(configKey)){
			return currentValueMap.get(configKey);
		}else{
			String result = firmPropsMap.get(configKey).getDefaultValue();
			currentValueMap.put(configKey, result);
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return firmPropsMap.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#configKeySet()
	 */
	@Override
	public Set<ConfigKey> configKeySet() {
		return Collections.unmodifiableSet(firmPropsMap.keySet());
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#add(com.dwarfeng.dutil.develop.cfg.ConfigEntry)
	 */
	@Override
	public boolean add(ConfigEntry configEntry) {
		if(Objects.isNull(configEntry)) return false;
		if(Objects.isNull(configEntry.getConfigKey())) return false;
		
		if(firmPropsMap.containsKey(configEntry.getConfigKey())){
			return false;
		}
		
		ConfigKey configKey = configEntry.getConfigKey();
		firmPropsMap.put(configKey, configEntry.getConfigFirmProps());
		currentValueMap.remove(configKey);
		
		fireConfigKeyAdded(configKey);
		
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<ConfigEntry> configEntries) {
		Objects.requireNonNull(configEntries, DwarfUtil.getStringField(StringFieldKey.DefaultConfigModel_0));
		
		boolean aFlag = false;
		
		for(ConfigEntry configEntry : configEntries){
			if(add(configEntry)) aFlag = true;
		}
		
		return aFlag;
	}
	
	private void fireConfigKeyAdded(ConfigKey configKey){
		for(ConfigModelObverser obverser : obversers){
			obverser.fireConfigKeyAdded(configKey);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#remove(com.dwarfeng.dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public boolean remove(ConfigKey configKey) {
		if(! firmPropsMap.containsKey(configKey)) return false;
		
		firmPropsMap.remove(configKey);
		
		fireConfigKeyRemoved(configKey);
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<ConfigKey> configKeys) {
		Objects.requireNonNull(configKeys, DwarfUtil.getStringField(StringFieldKey.DefaultConfigModel_1));
		
		boolean aFlag = false;
		
		for(ConfigKey configKey : configKeys){
			if(remove(configKey)) aFlag = true;
		}
		
		return aFlag;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<ConfigKey> configKeys) {
		Objects.requireNonNull(configKeys, DwarfUtil.getStringField(StringFieldKey.DefaultConfigModel_1));

		boolean aFlag = false;
		
		for(ConfigKey configKey : firmPropsMap.keySet()){
			if(! configKeys.contains(configKey)){
				if(remove(configKey)) aFlag = true;
			}
		}
		
		return aFlag;
	}
	
	private void fireConfigKeyRemoved(ConfigKey configKey){
		for(ConfigModelObverser obverser : obversers){
			obverser.fireConfigKeyRemoved(configKey);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#size()
	 */
	@Override
	public int size() {
		return firmPropsMap.size();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#isValueValid(com.dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
	 */
	@Override
	public boolean isValueValid(ConfigKey configKey, String value) {
		if(Objects.isNull(configKey)) return false;
		if(! firmPropsMap.containsKey(configKey)) return false;
		
		String currentValue = getCurrentValue(configKey);
		ConfigChecker configChecker = getConfigFirmProps(configKey).getConfigChecker();
		
		return configChecker.isValid(currentValue);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#getValidValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public String getValidValue(ConfigKey configKey) {
		String defaultValue = getConfigFirmProps(configKey).getDefaultValue();
		String currentValue = getCurrentValue(configKey);
		
		return isValueValid(configKey, currentValue) ? currentValue : defaultValue;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#getConfigFirmProps(com.dwarfeng.dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
		return firmPropsMap.get(configKey);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#setConfigFirmProps(com.dwarfeng.dutil.develop.cfg.ConfigKey, com.dwarfeng.dutil.develop.cfg.ConfigFirmProps)
	 */
	@Override
	public ConfigFirmProps setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetValue(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
