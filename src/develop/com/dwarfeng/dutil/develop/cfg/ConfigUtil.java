package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.develop.cfg.obv.ExconfigObverser;
import com.dwarfeng.dutil.develop.cfg.struct.ExconfigEntry;
import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * �й������ð���һЩ���÷�����
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public final class ConfigUtil {

	/**
	 * �ж�ָ�������ù̶������Ƿ���Ч��
	 * <p>
	 * ��ָ�������ù̶����Բ�Ϊ <code>null</code>���������е�����ֵ�������Ϊ <code>null</code>��
	 * ����Ĭ��ֵ��ͨ������ֵ�����ʱ����Ϊָ�������ù̶�������Ч��
	 * 
	 * @param configFirmProps
	 *            ָ�������ù̶����ԡ�
	 * @return ָ�������ù̶������Ƿ���Ч��
	 */
	public static boolean isValid(ConfigFirmProps configFirmProps) {
		if (Objects.isNull(configFirmProps))
			return false;
		if (Objects.isNull(configFirmProps.getConfigChecker()))
			return false;
		if (Objects.isNull(configFirmProps.getDefaultValue()))
			return false;

		return configFirmProps.getConfigChecker().isValid(configFirmProps.getDefaultValue());
	}

	/**
	 * �ж�ָ�������ù̶������Ƿ���Ч��
	 * <p>
	 * ������ù̶�ֵ����Ч������Ч�����÷�����ͬ�� <code> ! isValid(configFirmProps)</code>
	 * 
	 * @param configFirmProps
	 *            ָ�������ù̶����ԡ�
	 * @return ָ�������ù̶�����ֵ�Ƿ���Ч��
	 */
	public static boolean nonValid(ConfigFirmProps configFirmProps) {
		return !isValid(configFirmProps);
	}

	/**
	 * �ж�ָ������������Ƿ���Ч��
	 * <p>
	 * ��ָ����������ڲ�Ϊ <code>null</code>�� �����е����ü���Ϊ <code>null</code>��
	 * �����е����ù̶�ֵ��Чʱ����Ϊָ�������������Ч��
	 * 
	 * @param configEntry
	 *            ָ����������ڡ�
	 * @return ָ������������Ƿ���Ч��
	 */
	public static boolean isValid(ConfigEntry configEntry) {
		if (Objects.isNull(configEntry))
			return false;
		if (Objects.isNull(configEntry.getConfigKey()))
			return false;

		return isValid(configEntry.getConfigFirmProps());
	}

	/**
	 * �ж�ָ������������Ƿ���Ч��
	 * <p>
	 * ���������ڲ���Ч������Ч�����÷�����ͬ�� <code>�� isValid(configEntry)</code>
	 * 
	 * @param configEntry
	 *            ָ����������ڡ�
	 * @return ָ������������Ƿ���Ч��
	 */
	public static boolean nonValid(ConfigEntry configEntry) {
		return !isValid(configEntry);
	}

	/**
	 * ����ָ��������ģ������һ�����ɸ��ĵ�����ģ�͡�
	 * 
	 * @param configModel
	 *            ָ��������ģ�͡�
	 * @return ����ָ��ģ�����ɵĲ��ɸ��ĵ�����ģ�͡�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public static ConfigModel unmodifiableConfigModel(ConfigModel configModel) {
		Objects.requireNonNull(configModel, DwarfUtil.getStringField(StringFieldKey.CONFIGUTIL_0));
		return new UnmodifiableConfigModel(configModel);
	}

	private static final class UnmodifiableConfigModel implements ConfigModel {

		private final ConfigModel delegate;

		public UnmodifiableConfigModel(ConfigModel delegate) {
			this.delegate = delegate;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
		 */
		@Override
		public Set<ConfigObverser> getObversers() {
			return delegate.getObversers();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.
		 * dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean addObverser(ConfigObverser obverser) {
			return delegate.addObverser(obverser);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng
		 * .dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean removeObverser(ConfigObverser obverser) {
			return delegate.removeObverser(obverser);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
		 */
		@Override
		public void clearObverser() {
			delegate.clearObverser();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#clear()
		 */
		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#containsKey(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean containsKey(ConfigKey configKey) {
			return delegate.containsKey(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * getCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getCurrentValue(ConfigKey configKey) {
			return delegate.getCurrentValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#
		 * getAllCurrentValue()
		 */
		@Override
		public Map<ConfigKey, String> getAllCurrentValue() {
			return delegate.getAllCurrentValue();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#keySet()
		 */
		@Override
		public Set<ConfigKey> keySet() {
			return delegate.keySet();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#add(com.dwarfeng.dutil.
		 * develop.cfg.ConfigEntry)
		 */
		@Override
		public boolean add(ConfigEntry configEntry) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#addAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean addAll(Collection<ConfigEntry> configEntries) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#remove(com.dwarfeng.dutil.
		 * develop.cfg.ConfigKey)
		 */
		@Override
		public boolean remove(ConfigKey configKey) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#removeAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean removeAll(Collection<ConfigKey> configKeys) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#retainAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean retainAll(Collection<ConfigKey> configKeys) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#size()
		 */
		@Override
		public int size() {
			return delegate.size();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#isValueValid(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean isValueValid(ConfigKey configKey, String value) {
			return delegate.isValueValid(configKey, value);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#getValidValue(com.dwarfeng
		 * .dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getValidValue(ConfigKey configKey) {
			return delegate.getValidValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#getConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
			return delegate.getConfigFirmProps(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#setConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.ConfigFirmProps)
		 */
		@Override
		public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey,
		 * java.lang.String)
		 */
		@Override
		public boolean setCurrentValue(ConfigKey configKey, String currentValue) {
			return delegate.setCurrentValue(configKey, currentValue);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setAllCurrentValue(java.util.Map)
		 */
		@Override
		public boolean setAllCurrentValue(Map<ConfigKey, String> map) {
			return delegate.setAllCurrentValue(map);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#resetCurrentValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean resetCurrentValue(ConfigKey configKey) {
			return delegate.resetCurrentValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#resetAllCurrentValue()
		 */
		@Override
		public boolean resetAllCurrentValue() {
			return delegate.resetAllCurrentValue();
		}

	}

	/**
	 * �ж�ָ���� Ex��������ǲ�����Ч�ġ�
	 * 
	 * @param entry
	 *            ָ����������ڡ�
	 * @return ָ������������ǲ�����Ч�ġ�
	 */
	public static boolean isValid(ExconfigEntry entry) {
		if (Objects.isNull(entry))
			return false;
		if (Objects.isNull(entry.getConfigKey()))
			return false;
		if (Objects.isNull(entry.getValueParser()))
			return false;
		if (Objects.isNull(entry.getConfigFirmProps()))
			return false;
		if (Objects.isNull(entry.getCurrentValue()))
			return false;
		if (nonValid(entry.getConfigFirmProps()))
			return false;
		return true;
	}

	/**
	 * �ж�ָ���� Ex��������ǲ�����Ч�ġ�
	 * 
	 * @param entry
	 *            ָ�����������
	 * @return ָ������������ǲ�����Ч�ġ�
	 */
	public static boolean nonValid(ExconfigEntry entry) {
		return !isValid(entry);
	}

	/**
	 * ��ָ����Ex����ģ������һ���̰߳�ȫ��Ex����ģ�͡�
	 * 
	 * @param exconfigModel
	 *            ָ����Ex����ģ�͡�
	 * @return ��ָ��Ex����ģ�����ɵ��̰߳�ȫ��Ex����ģ�͡�
	 */
	public static <O extends ExconfigObverser> SyncExconfigModel<O> syncExconfigModel(ExconfigModel<O> exconfigModel) {
		Objects.requireNonNull(exconfigModel, DwarfUtil.getStringField(StringFieldKey.CONFIGUTIL_1));
		return new SyncExconfigModelImpl<>(exconfigModel);
	}

	private static class SyncExconfigModelImpl<O extends ExconfigObverser> implements SyncExconfigModel<O> {

		private final ExconfigModel<O> delegate;
		private final ReadWriteLock lock = new ReentrantReadWriteLock();

		public SyncExconfigModelImpl(ExconfigModel<O> delegate) {
			this.delegate = delegate;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe#getLock(
		 * )
		 */
		@Override
		public ReadWriteLock getLock() {
			return lock;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
		 */
		@Override
		public Set<O> getObversers() {
			lock.readLock().lock();
			try {
				return delegate.getObversers();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.
		 * dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean addObverser(O obverser) {
			lock.writeLock().lock();
			try {
				return delegate.addObverser(obverser);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng
		 * .dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean removeObverser(O obverser) {
			lock.writeLock().lock();
			try {
				return delegate.removeObverser(obverser);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#clear()
		 */
		@Override
		public void clear() {
			lock.writeLock().lock();
			try {
				delegate.clear();
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
		 */
		@Override
		public void clearObverser() {
			lock.writeLock().lock();
			try {
				delegate.clearObverser();
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#containsKey(com.dwarfeng
		 * .dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean containsKey(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.containsKey(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#getCurrentValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getCurrentValue(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getCurrentValue(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#
		 * getAllCurrentValue()
		 */
		@Override
		public Map<ConfigKey, String> getAllCurrentValue() {
			lock.readLock().lock();
			try {
				return delegate.getAllCurrentValue();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			lock.readLock().lock();
			try {
				return delegate.isEmpty();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#keySet()
		 */
		@Override
		public Set<ConfigKey> keySet() {
			lock.readLock().lock();
			try {
				return delegate.keySet();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#add(com.dwarfeng.dutil.
		 * develop.cfg.struct.ExconfigEntry)
		 */
		@Override
		public boolean add(ExconfigEntry exconfigEntry) {
			lock.writeLock().lock();
			try {
				return delegate.add(exconfigEntry);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#addAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean addAll(Collection<ExconfigEntry> exconfigEntries) {
			lock.writeLock().lock();
			try {
				return delegate.addAll(exconfigEntries);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#remove(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean remove(ConfigKey configKey) {
			lock.writeLock().lock();
			try {
				return delegate.remove(configKey);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#removeAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean removeAll(Collection<ConfigKey> configKeys) {
			lock.writeLock().lock();
			try {
				return delegate.removeAll(configKeys);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#retainAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean retainAll(Collection<ConfigKey> configKeys) {
			lock.writeLock().lock();
			try {
				return delegate.retainAll(configKeys);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#size()
		 */
		@Override
		public int size() {
			lock.readLock().lock();
			try {
				return delegate.size();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#isValueValid(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean isValueValid(ConfigKey configKey, String value) {
			lock.readLock().lock();
			try {
				return delegate.isValueValid(configKey, value);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getValidValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getValidValue(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getValidValue(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#getConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getConfigFirmProps(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#setConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.ConfigFirmProps)
		 */
		@Override
		public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
			lock.writeLock().lock();
			try {
				return delegate.setConfigFirmProps(configKey, configFirmProps);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey,
		 * java.lang.String)
		 */
		@Override
		public boolean setCurrentValue(ConfigKey configKey, String currentValue) {
			lock.writeLock().lock();
			try {
				return delegate.setCurrentValue(configKey, currentValue);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setAllCurrentValue(java.util.Map)
		 */
		@Override
		public boolean setAllCurrentValue(Map<ConfigKey, String> map) {
			lock.writeLock().lock();
			try {
				return delegate.setAllCurrentValue(map);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#resetCurrentValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean resetCurrentValue(ConfigKey configKey) {
			lock.writeLock().lock();
			try {
				return delegate.resetCurrentValue(configKey);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#resetAllCurrentValue()
		 */
		@Override
		public boolean resetAllCurrentValue() {
			lock.writeLock().lock();
			try {
				return delegate.resetAllCurrentValue();
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getValueParser(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ValueParser getValueParser(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getValueParser(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#setValueParser(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.struct.ValueParser)
		 */
		@Override
		public boolean setValueParser(ConfigKey configKey, ValueParser valueParser) {
			lock.writeLock().lock();
			try {
				return delegate.setValueParser(configKey, valueParser);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getParsedValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public Object getParsedValue(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getParsedValue(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getParsedValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.Class)
		 */
		@Override
		public <T> T getParsedValue(ConfigKey configKey, Class<T> clas) {
			lock.readLock().lock();
			try {
				return delegate.getParsedValue(configKey, clas);
			} finally {
				lock.readLock().unlock();
			}
		}

	}

	public static SyncConfigModel syncConfigModel(ConfigModel configModel) {
		Objects.requireNonNull(configModel, DwarfUtil.getStringField(StringFieldKey.CONFIGUTIL_0));
		return new SyncConfigModelImpl(configModel);
	}

	private static class SyncConfigModelImpl implements SyncConfigModel {

		private final ConfigModel delegate;
		private final ReadWriteLock lock = new ReentrantReadWriteLock();

		public SyncConfigModelImpl(ConfigModel delegate) {
			this.delegate = delegate;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe#getLock(
		 * )
		 */
		@Override
		public ReadWriteLock getLock() {
			return lock;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
		 */
		@Override
		public Set<ConfigObverser> getObversers() {
			lock.readLock().lock();
			try {
				return delegate.getObversers();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.
		 * dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean addObverser(ConfigObverser obverser) {
			lock.writeLock().lock();
			try {
				return delegate.addObverser(obverser);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng
		 * .dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean removeObverser(ConfigObverser obverser) {
			lock.writeLock().lock();
			try {
				return delegate.removeObverser(obverser);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
		 */
		@Override
		public void clearObverser() {
			lock.writeLock().lock();
			try {
				delegate.clearObverser();
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#clear()
		 */
		@Override
		public void clear() {
			lock.writeLock().lock();
			try {
				delegate.clear();
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#containsKey(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean containsKey(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.containsKey(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * getCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getCurrentValue(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getCurrentValue(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#
		 * getAllCurrentValue()
		 */
		@Override
		public Map<ConfigKey, String> getAllCurrentValue() {
			lock.readLock().lock();
			try {
				return delegate.getAllCurrentValue();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			lock.readLock().lock();
			try {
				return delegate.isEmpty();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#keySet()
		 */
		@Override
		public Set<ConfigKey> keySet() {
			lock.readLock().lock();
			try {
				return delegate.keySet();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#add(com.dwarfeng.dutil.
		 * develop.cfg.ConfigEntry)
		 */
		@Override
		public boolean add(ConfigEntry configEntry) {
			lock.writeLock().lock();
			try {
				return delegate.add(configEntry);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#addAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean addAll(Collection<ConfigEntry> configEntries) {
			lock.writeLock().lock();
			try {
				return delegate.addAll(configEntries);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#remove(com.dwarfeng.dutil.
		 * develop.cfg.ConfigKey)
		 */
		@Override
		public boolean remove(ConfigKey configKey) {
			lock.writeLock().lock();
			try {
				return delegate.remove(configKey);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#removeAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean removeAll(Collection<ConfigKey> configKeys) {
			lock.writeLock().lock();
			try {
				return delegate.removeAll(configKeys);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#retainAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean retainAll(Collection<ConfigKey> configKeys) {
			lock.writeLock().lock();
			try {
				return delegate.retainAll(configKeys);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ConfigModel#size()
		 */
		@Override
		public int size() {
			lock.readLock().lock();
			try {
				return delegate.size();
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#isValueValid(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean isValueValid(ConfigKey configKey, String value) {
			lock.readLock().lock();
			try {
				return delegate.isValueValid(configKey, value);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#getValidValue(com.dwarfeng
		 * .dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getValidValue(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getValidValue(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#getConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
			lock.readLock().lock();
			try {
				return delegate.getConfigFirmProps(configKey);
			} finally {
				lock.readLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#setConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.ConfigFirmProps)
		 */
		@Override
		public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
			lock.writeLock().lock();
			try {
				return delegate.setConfigFirmProps(configKey, configFirmProps);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setCurrentValue(com.dwarfeng.dutil.develop.cfg.ConfigKey,
		 * java.lang.String)
		 */
		@Override
		public boolean setCurrentValue(ConfigKey configKey, String currentValue) {
			lock.writeLock().lock();
			try {
				return delegate.setCurrentValue(configKey, currentValue);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.io.CurrentValueContainer#
		 * setAllCurrentValue(java.util.Map)
		 */
		@Override
		public boolean setAllCurrentValue(Map<ConfigKey, String> map) {
			lock.writeLock().lock();
			try {
				return delegate.setAllCurrentValue(map);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#resetCurrentValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean resetCurrentValue(ConfigKey configKey) {
			lock.writeLock().lock();
			try {
				return delegate.resetCurrentValue(configKey);
			} finally {
				lock.writeLock().unlock();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ConfigModel#resetAllCurrentValue()
		 */
		@Override
		public boolean resetAllCurrentValue() {
			lock.writeLock().lock();
			try {
				return delegate.resetAllCurrentValue();
			} finally {
				lock.writeLock().unlock();
			}
		}

	}

	/**
	 * ����ָ����Ex����ģ������һ�����ɱ༭��Ex����ģ�͡�
	 * 
	 * @param exconfigModel
	 *            ָ��������ģ�͡�
	 * @return ���ɱ༭��Ex����ģ�͡�
	 */
	public static <O extends ExconfigObverser> ExconfigModel<O> unmodifiableExconfigModel(
			ExconfigModel<O> exconfigModel) {
		Objects.requireNonNull(exconfigModel, DwarfUtil.getStringField(StringFieldKey.CONFIGUTIL_1));
		return new UnmodifiableExconfigModel<>(exconfigModel);
	}

	private static class UnmodifiableExconfigModel<O extends ExconfigObverser> implements ExconfigModel<O> {

		private final ExconfigModel<O> delegate;

		public UnmodifiableExconfigModel(ExconfigModel<O> delegate) {
			this.delegate = delegate;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#getCurrentValue(
		 * com.dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getCurrentValue(ConfigKey configKey) {
			return delegate.getCurrentValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
		 */
		@Override
		public Set<O> getObversers() {
			return delegate.getObversers();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.
		 * dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean addObverser(O obverser) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#
		 * getAllCurrentValue()
		 */
		@Override
		public Map<ConfigKey, String> getAllCurrentValue() {
			return delegate.getAllCurrentValue();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng
		 * .dutil.basic.prog.Obverser)
		 */
		@Override
		public boolean removeObverser(O obverser) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#clear()
		 */
		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#setCurrentValue(
		 * com.dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean setCurrentValue(ConfigKey configKey, String currentValue) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
		 */
		@Override
		public void clearObverser() {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#containsKey(com.dwarfeng
		 * .dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean containsKey(ConfigKey configKey) {
			return delegate.containsKey(configKey);
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
			return Collections.unmodifiableSet(delegate.keySet());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.CurrentValueContainer#
		 * setAllCurrentValue(java.util.Map)
		 */
		@Override
		public boolean setAllCurrentValue(Map<ConfigKey, String> map) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#add(com.dwarfeng.dutil.
		 * develop.cfg.struct.ExconfigEntry)
		 */
		@Override
		public boolean add(ExconfigEntry exconfigEntry) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#addAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean addAll(Collection<ExconfigEntry> exconfigEntries) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#remove(com.dwarfeng.
		 * dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean remove(ConfigKey configKey) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#removeAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean removeAll(Collection<ConfigKey> configKeys) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#retainAll(java.util.
		 * Collection)
		 */
		@Override
		public boolean retainAll(Collection<ConfigKey> configKeys) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#size()
		 */
		@Override
		public int size() {
			return delegate.size();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#isValueValid(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.String)
		 */
		@Override
		public boolean isValueValid(ConfigKey configKey, String value) {
			return delegate.isValueValid(configKey, value);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getValidValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public String getValidValue(ConfigKey configKey) {
			return delegate.getValidValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#getConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ConfigFirmProps getConfigFirmProps(ConfigKey configKey) {
			return delegate.getConfigFirmProps(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#setConfigFirmProps(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.ConfigFirmProps)
		 */
		@Override
		public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#resetCurrentValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public boolean resetCurrentValue(ConfigKey configKey) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.cfg.ExconfigModel#resetAllCurrentValue()
		 */
		@Override
		public boolean resetAllCurrentValue() {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getValueParser(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public ValueParser getValueParser(ConfigKey configKey) {
			return delegate.getValueParser(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#setValueParser(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey,
		 * com.dwarfeng.dutil.develop.cfg.struct.ValueParser)
		 */
		@Override
		public boolean setValueParser(ConfigKey configKey, ValueParser valueParser) {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getParsedValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey)
		 */
		@Override
		public Object getParsedValue(ConfigKey configKey) {
			return delegate.getParsedValue(configKey);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.cfg.ExconfigModel#getParsedValue(com.
		 * dwarfeng.dutil.develop.cfg.ConfigKey, java.lang.Class)
		 */
		@Override
		public <T> T getParsedValue(ConfigKey configKey, Class<T> clas) {
			return delegate.getParsedValue(configKey, clas);
		}

	}

	// ��ֹ�ⲿʵ������
	private ConfigUtil() {
	}

}
