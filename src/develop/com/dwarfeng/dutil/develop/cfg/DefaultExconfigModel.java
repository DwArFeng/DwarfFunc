package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.develop.cfg.obv.ExconfigObverser;
import com.dwarfeng.dutil.develop.cfg.struct.ExconfigEntry;
import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * Ĭ��Ex����ģ�͡�
 * <p>
 * Ex����ģ�͵�Ĭ��ʵ�֡�
 * <p>
 * ��ʵ��ʹ����һ��ӳ�����洢���е�������Ϣ����ӳ���ֵ�������� {@link ExconfigBean}��
 * ���ܻ�ȡ���������õĹ̶����ԡ���ǰֵ��ֵ������������� {@link DefaultConfigModel}��˫��ӳ�䣬 ��ģ�͵Ľṹ��ʮ�ּ򵥵ġ�
 * <p>
 * ֻ��һ��ӳ����ζ�����ô���ͳ�ֵ�Ƿǳ�����ģ����� {@link DefaultConfigModel} ������Ҫ��������ӳ��Ĵ���
 * ��ʵ��ֻ��Ҫ����һ��ӳ��Ĵ����Ӷ������� {@link DefaultConfigModel}�Ĵ�����ֲ�һ�µ����⡣
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class DefaultExconfigModel extends AbstractExconfigModel {

	/**
	 * Ex����Bean��
	 * <p>
	 * ���ڻ�ȡ������ {@link ExconfigModel} ����Ҫ�Ĺ̶����ԡ���ǰֵ��ֵ��������
	 * 
	 * @author DwArFeng
	 * @since 0.1.0-beta
	 */
	public static class ExconfigBean {

		private ConfigFirmProps configFirmProps;
		private String currentValue;
		private ValueParser valueParser;

		/**
		 * ����һ��Ĭ�ϵ� Ex����Bean��
		 */
		public ExconfigBean() {
			this(null, null, null);
		}

		/**
		 * ���ɾ���ָ������ֵ�� Ex����Bean��
		 * 
		 * @param configFirmProps
		 *            ָ���Ĺ̶����ԡ�
		 * @param currentValue
		 *            ָ���ĵ�ǰֵ��
		 * @param valueParser
		 *            ָ����ֵ��������
		 */
		public ExconfigBean(ConfigFirmProps configFirmProps, String currentValue, ValueParser valueParser) {
			this.configFirmProps = configFirmProps;
			this.currentValue = currentValue;
			this.valueParser = valueParser;
		}

		/**
		 * ��ȡ��Bean�е����ù̶����ԡ�
		 * 
		 * @return ��Bean�е����ù̶����ԡ�
		 */
		public ConfigFirmProps getConfigFirmProps() {
			return configFirmProps;
		}

		/**
		 * ���ø�Bean�е����ù̶�����Ϊָ��ֵ��
		 * 
		 * @param configFirmProps
		 *            ָ�������ù̶����ԡ�
		 */
		public void setConfigFirmProps(ConfigFirmProps configFirmProps) {
			this.configFirmProps = configFirmProps;
		}

		/**
		 * ��ȡ��Bean�еĵ�ǰֵ��
		 * 
		 * @return ��Bean�еĵ�ǰֵ��
		 */
		public String getCurrentValue() {
			return currentValue;
		}

		/**
		 * ���ø�Bean�еĵ�ǰֵΪָ��ֵ��
		 * 
		 * @param currentValue
		 *            ָ���ĵ�ǰֵ��
		 */
		public void setCurrentValue(String currentValue) {
			this.currentValue = currentValue;
		}

		/**
		 * ��ȡ��Bean�е�ֵ��������
		 * 
		 * @return ��Bean�е�ֵ��������
		 */
		public ValueParser getValueParser() {
			return valueParser;
		}

		/**
		 * ���ø�Bean�е�ֵ������Ϊָ��ֵ��
		 * 
		 * @param valueParser
		 *            ��Bean�е�ֵ��������
		 */
		public void setValueParser(ValueParser valueParser) {
			this.valueParser = valueParser;
		}

	}

	/** Ex����ģ�͵�ӳ����� */
	protected final Map<ConfigKey, ExconfigBean> delegate;

	/**
	 * ����һ������ָ����ʼֵ��ڵ�Ex����ģ�͡�
	 * 
	 * @param entries
	 *            ָ���ĳ�ʼֵ��ڵļ��ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultExconfigModel(Collection<ExconfigEntry> entries) {
		this(entries, new HashMap<>(), Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ����ʼֵ��ڡ�ӳ�����ָ���Ĺ۲������ϵ�Ex����ģ�͡�
	 * <p>
	 * ֻ�г�ʼֵ��ڼ����е���Ч��ڲŻᱻ��ӵ�ģ���С�
	 * 
	 * @param entries
	 *            ָ���ĳ�ʼֵ��ڵļ��ϡ�
	 * @param delegate
	 *            ָ����ӳ�����
	 * @param obversers
	 *            ָ���Ĺ۲������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultExconfigModel(Collection<ExconfigEntry> entries, Map<ConfigKey, ExconfigBean> delegate,
			Set<ExconfigObverser> obversers) {
		super(obversers);

		Objects.requireNonNull(delegate, DwarfUtil.getStringField(StringFieldKey.DEFAULTEXCONFIGMODEL_0));
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.DEFAULTEXCONFIGMODEL_1));

		this.delegate = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#clear()
	 */
	@Override
	public void clear() {
		delegate.clear();
		fireConfigKeyCleared();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#containsKey(com.dwarfeng.
	 * dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public boolean containsKey(ConfigKey configKey) {
		return delegate.containsKey(configKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#getCurrentValue(com.dwarfeng
	 * .dutil.develop.cfg.ConfigKey)
	 */
	@Override
	public String getCurrentValue(ConfigKey configKey) {
		return delegate.get(configKey).getCurrentValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#keySet()
	 */
	@Override
	public Set<ConfigKey> keySet() {
		return delegate.keySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#add(com.dwarfeng.dutil.
	 * develop.cfg.struct.ExconfigEntry)
	 */
	@Override
	public boolean add(ExconfigEntry exconfigEntry) {
		if (Objects.isNull(exconfigEntry))
			return false;
		if (ConfigUtil.nonValid(exconfigEntry))
			return false;
		if (delegate.containsKey(exconfigEntry))
			return false;
		delegate.put(exconfigEntry.getConfigKey(), new ExconfigBean(exconfigEntry.getConfigFirmProps(),
				exconfigEntry.getCurrentValue(), exconfigEntry.getValueParser()));
		fireConfigKeyAdded(exconfigEntry.getConfigKey(), exconfigEntry.getConfigFirmProps(),
				exconfigEntry.getValueParser(), exconfigEntry.getCurrentValue());
		return true;
	}

	@Override
	public boolean addAll(Collection<ExconfigEntry> exconfigEntries) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<ConfigKey> configKeys) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<ConfigKey> configKeys) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isValueValid(ConfigKey configKey, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getValidValue(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setCurrentValue(ConfigKey configKey, String currentValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAllCurrentValue(Map<ConfigKey, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetCurrentValue(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetAllCurrentValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueParser getValueParser(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setValueParser(ConfigKey configKey, ValueParser valueParser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getParsedValue(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParsedDefaultValue(ConfigKey configKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getParsedValue(ConfigKey configKey, Class<T> clas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getParsedDefaultValue(ConfigKey configKey, Class<T> clas) {
		// TODO Auto-generated method stub
		return null;
	}

}
