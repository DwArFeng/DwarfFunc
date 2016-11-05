package com.dwarfeng.dutil.develop.cfg;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;

/**
 * ���ù��߰���
 * @author DwArFeng
 * @since 1.8
 */
public final class ConfigUtil {

	/**
	 * ��������վ�㡣
	 * <p> ���ɵ�����վ������ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>�ĵ���˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ����վ�㡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static ConfigPort newConfigPort(Iterable<ConfigEntry> entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		checkValid(entries);
		return new InnerConfigPort(entries);
	}
	
	/**
	 * ��������վ�㡣
	 * <p> ���ɵ�����վ������ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>��˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ����վ�㡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static ConfigPort newConfigPort(ConfigEntry[] entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		return newConfigPort(ArrayUtil.array2Iterable(entries));
	}
	
	private static void checkValid(Iterable<ConfigEntry> entries){
		for(ConfigEntry entry : entries){
			if(
					Objects.isNull(entry.getConfigKey()) || 
					Objects.isNull(entry.getConfigValueChecker()) ||
					entry.getConfigValueChecker().nonValid(entry.getDefaultValue())
			)
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.ConfigUtil_1));
		}
	}
	
	private static class ConfigProps {
		
		public final String currentValue;
		public final String defaultValue;
		public final ConfigValueChecker configValueChecker;
		
		public ConfigProps(String currentValue, String defaultValue, ConfigValueChecker configValueChecker) {
			this.currentValue = currentValue;
			this.defaultValue = defaultValue;
			this.configValueChecker = configValueChecker;
		}
		
	}
	
	private static final class InnerConfigPort implements ConfigPort{
		
		private final Set<ConfigObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());
		private final Map<ConfigKey, ConfigProps> map;
		
		public InnerConfigPort(Iterable<ConfigEntry> entries) {
			map = new LinkedHashMap<>();
			for(ConfigEntry entry : entries){
				ConfigKey configKey = entry.getConfigKey();
				String defaultValue = entry.getDefaultValue();
				ConfigValueChecker checker = entry.getConfigValueChecker();
				map.put(configKey, new ConfigProps(defaultValue, defaultValue, checker));
			}
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getDefaultValueMap()
		 */
		@Override
		public Map<ConfigKey, String> getDefaultValueMap() {
			LinkedHashMap<ConfigKey, String> defaultValueMap = new LinkedHashMap<>();
			for(Map.Entry<ConfigKey, ConfigProps> entry : map.entrySet()){
				defaultValueMap.put(entry.getKey(), entry.getValue().defaultValue);
			}
			return Collections.unmodifiableMap(defaultValueMap);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getCurrentValueMap()
		 */
		@Override
		public Map<ConfigKey, String> getCurrentValueMap() {
			LinkedHashMap<ConfigKey, String> currentValueMap = new LinkedHashMap<>();
			for(Map.Entry<ConfigKey, ConfigProps> entry : map.entrySet()){
				currentValueMap.put(entry.getKey(), entry.getValue().currentValue);
			}
			return Collections.unmodifiableMap(currentValueMap);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getConfigValueCheckerMap()
		 */
		@Override
		public Map<ConfigKey, ConfigValueChecker> getConfigValueCheckerMap() {
			LinkedHashMap<ConfigKey, ConfigValueChecker> configValueCheckerMap = new LinkedHashMap<>();
			for(Map.Entry<ConfigKey, ConfigProps> entry : map.entrySet()){
				configValueCheckerMap.put(entry.getKey(), entry.getValue().configValueChecker);
			}
			return Collections.unmodifiableMap(configValueCheckerMap);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#size()
		 */
		@Override
		public int size() {
			return map.size();
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#contains(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean contains(ConfigKey configKey) {
			return map.containsKey(configKey);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#keySet()
		 */
		@Override
		public Set<ConfigKey> keySet() {
			return Collections.unmodifiableSet(map.keySet());
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getCurrentValue(ConfigKey configKey) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return null;
			return map.get(configKey).currentValue;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getDefaultValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getDefaultValue(ConfigKey configKey) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return null;
			return map.get(configKey).defaultValue;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#set(com.dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean set(ConfigKey configKey, String currentValue) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return false;
			ConfigProps cp = map.get(configKey);
			String oldValue = cp.currentValue;
			if(oldValue == currentValue) return false;
			if(Objects.nonNull(oldValue) && oldValue.equals(currentValue)) return false;
			map.put(configKey, new ConfigProps(currentValue, cp.defaultValue, cp.configValueChecker));
			for(ConfigObverser obverser : obversers){
				if(Objects.nonNull(obverser) && obverser.isInteresedIn(configKey)){
					obverser.fireConfigKeyChanged(configKey, oldValue, currentValue);
				}
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#addObverser(com.dwarfeng.dutil.develop.cfg.ConfigObverser)
		 */
		@Override
		public boolean addObverser(ConfigObverser obverser) {
			return obversers.add(obverser);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#removeObverser(com.dwarfeng.dutil.develop.cfg.ConfigObverser)
		 */
		@Override
		public boolean removeObverser(ConfigObverser obverser) {
			return obversers.remove(obverser);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#clearObversers()
		 */
		@Override
		public void clearObversers() {
			obversers.clear();
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#isValid(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean isValid(ConfigKey configKey) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return false;
			ConfigProps cp = map.get(configKey);
			return cp.configValueChecker.isValid(cp.currentValue);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#nonValid(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean nonValid(ConfigKey configKey) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return true;
			ConfigProps cp = map.get(configKey);
			return cp.configValueChecker.isValid(cp.currentValue);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#checkValid(com.dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean checkValid(ConfigKey configKey, String value) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return true;
			return map.get(configKey).configValueChecker.isValid(value);
		}
		
	}
	
}
