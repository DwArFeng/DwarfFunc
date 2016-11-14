package com.dwarfeng.dutil.develop.cfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel;
import com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModelObverser;

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
	public static ConfigPort newConfigPort(Iterable<ConfigElements> entries){
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
	public static ConfigPort newConfigPort(ConfigElements[] entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		return newConfigPort(ArrayUtil.array2Iterable(entries));
	}
	
	private static void checkValid(Iterable<ConfigElements> entries){
		for(ConfigElements entry : entries){
			if(
					Objects.isNull(entry.getConfigKey()) || 
					Objects.isNull(entry.getConfigChecker()) ||
					entry.getConfigChecker().nonValid(entry.getDefaultValue())
			)
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.ConfigUtil_1));
		}
	}
	
	private static final class InnerConfigPort implements ConfigPort{
		
		private final Set<ConfigObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());
		private final Map<ConfigKey, ConfigProps> map;
		
		public InnerConfigPort(Iterable<ConfigElements> entries) {
			map = new LinkedHashMap<>();
			for(ConfigElements entry : entries){
				ConfigKey configKey = entry.getConfigKey();
				String defaultValue = entry.getDefaultValue();
				ConfigChecker checker = entry.getConfigChecker();
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
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#getConfigCheckerMap()
		 */
		@Override
		public Map<ConfigKey, ConfigChecker> getConfigCheckerMap() {
			LinkedHashMap<ConfigKey, ConfigChecker> configCheckerMap = new LinkedHashMap<>();
			for(Map.Entry<ConfigKey, ConfigProps> entry : map.entrySet()){
				configCheckerMap.put(entry.getKey(), entry.getValue().configChecker);
			}
			return Collections.unmodifiableMap(configCheckerMap);
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
			map.put(configKey, new ConfigProps(currentValue, cp.defaultValue, cp.configChecker));
			for(ConfigObverser obverser : obversers){
				if(Objects.nonNull(obverser) && obverser.isInteresedIn(configKey)){
					obverser.fireValueChanged(configKey, oldValue, currentValue);
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
			return cp.configChecker.isValid(cp.currentValue);
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
			return cp.configChecker.isValid(cp.currentValue);
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigPort#checkValid(com.dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean checkValid(ConfigKey configKey, String value) {
			Objects.requireNonNull(configKey, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_2));
			if(! contains(configKey)) return true;
			return map.get(configKey).configChecker.isValid(value);
		}
		
		private static class ConfigProps {
			
			public final String currentValue;
			public final String defaultValue;
			public final ConfigChecker configChecker;
			
			public ConfigProps(String currentValue, String defaultValue, ConfigChecker configChecker) {
				this.currentValue = currentValue;
				this.defaultValue = defaultValue;
				this.configChecker = configChecker;
			}
			
		}
		
	}
	
	/**
	 * ͨ������վ���������ý���ģ�͡�
	 * <p> ���ɵ�ģ�;��������ص�
	 * <blockquote>
	 * 		�� û��ע���κι۲�����<br>
	 * 		�� ���е�Ԫ�ؾ�Ϊ����վ���Ԫ�ء�<br>
	 * 		�� Ԫ�ص�˳�������վ��ĵ���˳����ͬ��
	 * </blockquote>
	 * @param configPort ָ���Ŀ���վ�㡣
	 * @return ��ָ���Ŀ���վ�����ɵ����ý���ģ�͡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static ConfigGuiModel newConfigGuiModel(ConfigPort configPort){
		Objects.requireNonNull(configPort, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_3));
		return new PortConfigGuiModel(configPort);
	}
	
	private static class PortConfigGuiModel implements ConfigGuiModel{
		
		private final Set<ConfigGuiModelObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());
		
		private final List<ModelProps> list = new ArrayList<>();

		public PortConfigGuiModel(ConfigPort configPort) {
			for(ConfigKey configKey : configPort.keySet()){
				ConfigChecker configChecker = configPort.getConfigCheckerMap().get(configKey);
				String defaultValue = configPort.getDefaultValue(configKey);
				String currentValue = configPort.getCurrentValue(configKey);
				ModelProps modelProps = new ModelProps(configKey, configChecker, defaultValue, currentValue);
				list.add(modelProps);
			}
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#getConfigKey(int)
		 */
		@Override
		public ConfigKey getConfigKey(int index) {
			return list.get(index).configKey;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#getCurrentValue(int)
		 */
		@Override
		public String getCurrentValue(int index) {
			return list.get(index).currentValue;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#getDefaultValue(int)
		 */
		@Override
		public String getDefaultValue(int index) {
			return list.get(index).defaultValue;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#getConfigChecker(int)
		 */
		@Override
		public ConfigChecker getConfigChecker(int index) {
			return list.get(index).configChecker;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#size()
		 */
		@Override
		public int size() {
			return list.size();
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#setValue(int, java.lang.String)
		 */
		@Override
		public void setValue(int index, String value) {
			ModelProps oldOne = list.get(index);
			ModelProps newOne = new ModelProps(oldOne.configKey, oldOne.configChecker, oldOne.defaultValue, value);
			list.set(index, newOne);
			for(ConfigGuiModelObverser obverser : obversers){
				if(Objects.nonNull(obverser)){
					obverser.fireValueChanged(index, newOne.configKey, newOne.configChecker, newOne.defaultValue, newOne.currentValue);
				}
			}
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#addObverser(com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModelObverser)
		 */
		@Override
		public boolean addObverser(ConfigGuiModelObverser obverser) {
			return obversers.add(obverser);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#removeObverser(com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModelObverser)
		 */
		@Override
		public boolean removeObverser(ConfigGuiModelObverser obverser) {
			return obversers.remove(obverser);
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel#clearObverser()
		 */
		@Override
		public void clearObverser() {
			obversers.clear();
		}
		
		private static class ModelProps{
			
			public final ConfigKey configKey;
			public final ConfigChecker configChecker;
			public final String defaultValue;
			public final String currentValue;
			
			public ModelProps(
					ConfigKey configKey,
					ConfigChecker configChecker,
					String defaultValue,
					String currentValue
			){
				this.configKey = configKey;
				this.configChecker = configChecker;
				this.defaultValue = defaultValue;
				this.currentValue = currentValue;
			}
		}
		
	}
	
}
