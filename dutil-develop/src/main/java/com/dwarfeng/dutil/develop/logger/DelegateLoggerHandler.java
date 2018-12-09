package com.dwarfeng.dutil.develop.logger;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.ExceptionStringKey;
import com.dwarfeng.dutil.basic.cna.model.KeySetModel;
import com.dwarfeng.dutil.basic.cna.model.MapKeySetModel;
import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;
import com.dwarfeng.dutil.develop.logger.obv.LoggerObverser;

/**
 * 代理记录器处理器。
 * <p>
 * 通过代理一个 <code>KeySetModel</code> 来记录记录器信息，并通过代理一个 <code>Map</code>
 * 来记录使用记录器映射的记录器处理器。
 * 
 * @author DwArFeng
 * @since 0.2.0-beta
 */
public final class DelegateLoggerHandler implements LoggerHandler {

	private class DelegateIterator implements Iterator<LoggerInfo> {

		private final Iterator<LoggerInfo> delegate;
		private LoggerInfo loggerInfo;

		public DelegateIterator(Iterator<LoggerInfo> delegate) {
			this.delegate = delegate;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return delegate.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public LoggerInfo next() {
			loggerInfo = delegate.next();
			return loggerInfo;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void remove() {
			delegate.remove();
			unuseOne(loggerInfo, true);
		}

	}

	/** 被代理的键值集合。 */
	protected final KeySetModel<String, LoggerInfo> delegateKeySet;

	/** 被代理的映射。 */
	protected final Map<LoggerInfo, Logger> delegateMap;

	/**
	 * 生成一个默认的代理记录器处理器。
	 */
	public DelegateLoggerHandler() {
		this(new MapKeySetModel<>(), new LinkedHashMap<>());
	}

	/**
	 * 生成一个具有指定的键值集合代理的记录器处理器。
	 * 
	 * @param delegateKeySet
	 *            指定的键值集合代理。
	 * @throws NullPointerException
	 *             入口参数为 <code>null</code>。
	 */
	public DelegateLoggerHandler(KeySetModel<String, LoggerInfo> delegateKeySet) {
		this(delegateKeySet, new LinkedHashMap<>());
	}

	/**
	 * 生成一个具有指定代理键值集合模型和指定代理映射的记录器处理器。
	 * 
	 * @param delegateKeySet
	 *            指定的键值集合代理。
	 * @param delegateMap
	 *            指定的映射代理。
	 * @throws NullPointerException
	 *             入口参数为 <code>null</code>。
	 */
	public DelegateLoggerHandler(KeySetModel<String, LoggerInfo> delegateKeySet, Map<LoggerInfo, Logger> delegateMap) {
		Objects.requireNonNull(delegateKeySet,
				DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_0));
		Objects.requireNonNull(delegateMap, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_1));

		this.delegateKeySet = delegateKeySet;
		this.delegateMap = delegateMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(LoggerInfo e) {
		return delegateKeySet.add(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends LoggerInfo> c) {
		return delegateKeySet.addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addObverser(SetObverser<LoggerInfo> obverser) {
		return delegateKeySet.addObverser(obverser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		unuseAll();
		delegateKeySet.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearObverser() {
		delegateKeySet.clearObverser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object o) {
		return delegateKeySet.contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return delegateKeySet.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAllKey(Collection<?> c) {
		return delegateKeySet.containsAllKey(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsKey(Object key) {
		return delegateKeySet.containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		return delegateKeySet.equals(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LoggerInfo get(String key) {
		return delegateKeySet.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<SetObverser<LoggerInfo>> getObversers() {
		return delegateKeySet.getObversers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return delegateKeySet.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return delegateKeySet.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<LoggerInfo> iterator() {
		return new DelegateIterator(delegateKeySet.iterator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {
		if (delegateKeySet.remove(o)) {
			LoggerInfo loggerInfo = (LoggerInfo) o;
			unuse(loggerInfo == null ? null : loggerInfo);
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchRemove(c, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchRemoveKey(c, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeKey(Object key) {
		if (!containsKey(key)) {
			return false;
		}
		// 如果该记录器处理器包含此键的话，则该键一定是 String 类型，故该类型转换安全。
		LoggerInfo loggerInfo = get((String) key);
		delegateKeySet.removeKey(key);
		unuseOne(loggerInfo, true);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeObverser(SetObverser<LoggerInfo> obverser) {
		return delegateKeySet.removeObverser(obverser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchRemove(c, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchRemoveKey(c, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return delegateKeySet.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return delegateKeySet.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return delegateKeySet.toArray(a);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean use(LoggerInfo loggerInfo) {
		return useOne(loggerInfo, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean unuse(LoggerInfo loggerInfo) {
		return unuseOne(loggerInfo, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean useKey(String key) {
		return useOne(get(key), true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean unuseKey(String key) {
		return unuseOne(get(key), true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void useAll() {
		for (LoggerInfo loggerInfo : this) {
			useOne(loggerInfo, true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unuseAll() {
		for (LoggerInfo loggerInfo : this) {
			unuseOne(loggerInfo, true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean useAll(Collection<LoggerInfo> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));

		boolean result = false;
		for (LoggerInfo loggerInfo : c) {
			if (useOne(loggerInfo, true)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean unuseAll(Collection<LoggerInfo> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchUnuse(c, true);
		// boolean result = false;
		// for (LoggerInfo loggerInfo : c) {
		// if (unuseOne(loggerInfo, true)) {
		// result = true;
		// }
		// }
		// return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean useAllKey(Collection<String> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));

		boolean result = false;
		for (String key : c) {
			if (useOne(get(key), true)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean unuseAllKey(Collection<String> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchUnuseKey(c, true);
		// boolean result = false;
		// for (String key : c) {
		// if (unuseOne(get(key), true)) {
		// result = true;
		// }
		// }
		// return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainUse(Collection<LoggerInfo> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchUnuse(c, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainUseKey(Collection<String> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.DELEGATELOGGERHANDLER_2));
		return batchUnuseKey(c, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Logger> usedLoggers() {
		return Collections.unmodifiableCollection(delegateMap.values());
	}

	/**
	 * 通知观察器记录器处理器使用了指定的记录器。
	 * 
	 * @param key
	 *            相关记录器信息的键。
	 * @param loggerInfo
	 *            相关的记录器信息。
	 * @param logger
	 *            使用的记录器。
	 */
	protected void fireLoggerUsed(String key, LoggerInfo loggerInfo, Logger logger) {
		for (SetObverser<LoggerInfo> obverser : delegateKeySet.getObversers()) {
			if (Objects.nonNull(obverser) && obverser instanceof LoggerObverser) {
				try {
					((LoggerObverser) obverser).fireLoggerUsed(key, loggerInfo, logger);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 通知观察器记录器处理器禁用了指定的记录器。
	 * 
	 * @param key
	 *            相关记录器信息的键。
	 * @param loggerInfo
	 *            相关的记录器信息。
	 * @param logger
	 *            禁用的记录器。
	 */
	protected void fireLoggerUnused(String key, LoggerInfo loggerInfo, Logger logger) {
		for (SetObverser<LoggerInfo> obverser : delegateKeySet.getObversers()) {
			if (Objects.nonNull(obverser) && obverser instanceof LoggerObverser) {
				try {
					((LoggerObverser) obverser).fireLoggerUnused(key, loggerInfo, logger);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean batchRemove(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<LoggerInfo> i = delegateKeySet.iterator(); i.hasNext();) {
			LoggerInfo loggerInfo = i.next();

			if (c.contains(loggerInfo) == aFlag) {
				i.remove();
				unuseOne(loggerInfo, true);
				result = true;
			}
		}

		return result;
	}

	private boolean batchRemoveKey(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<LoggerInfo> i = delegateKeySet.iterator(); i.hasNext();) {
			LoggerInfo loggerInfo = i.next();

			if (c.contains(loggerInfo == null ? null : loggerInfo.getKey()) == aFlag) {
				i.remove();
				unuseOne(loggerInfo, true);
				result = true;
			}
		}

		return result;
	}

	private boolean batchUnuse(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<LoggerInfo> i = delegateKeySet.iterator(); i.hasNext();) {
			LoggerInfo loggerInfo = i.next();

			if (c.contains(loggerInfo) == aFlag && unuseOne(loggerInfo, true)) {
				result = true;
			}
		}

		return result;
	}

	private boolean batchUnuseKey(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<LoggerInfo> i = delegateKeySet.iterator(); i.hasNext();) {
			LoggerInfo loggerInfo = i.next();

			if (c.contains(loggerInfo == null ? null : loggerInfo.getKey()) == aFlag && unuseOne(loggerInfo, true)) {
				result = true;
			}
		}

		return result;
	}

	private boolean unuseOne(LoggerInfo loggerInfo, boolean isObvTrigger) {
		if (!delegateMap.containsKey(loggerInfo))
			return false;
		Logger logger = delegateMap.remove(loggerInfo);
		if (isObvTrigger) {
			fireLoggerUnused(loggerInfo.getKey(), loggerInfo, logger);
		}
		return true;
	}

	private boolean useOne(LoggerInfo loggerInfo, boolean isObvTrigger) {
		if (!contains(loggerInfo))
			return false;
		if (Objects.isNull(loggerInfo))
			return false;
		if (delegateMap.containsKey(loggerInfo))
			return false;
		try {
			Logger logger = loggerInfo.newLogger();
			delegateMap.put(loggerInfo, logger);
			if (isObvTrigger) {
				fireLoggerUsed(loggerInfo.getKey(), loggerInfo, logger);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
