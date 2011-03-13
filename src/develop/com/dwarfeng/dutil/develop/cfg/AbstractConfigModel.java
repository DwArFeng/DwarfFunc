package com.dwarfeng.dutil.develop.cfg;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * ��������ģ��ʵ�֡�
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public abstract class AbstractConfigModel implements ConfigModel {

	/** �۲������� */
	protected final Set<ConfigObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<ConfigObverser> getObversers() {
		return Collections.unmodifiableSet(obversers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.dutil.
	 * basic.prog.Obverser)
	 */
	@Override
	public boolean addObverser(ConfigObverser obverser) {
		if (Objects.isNull(obverser))
			return false;
		return obversers.add(obverser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng.
	 * dutil.basic.prog.Obverser)
	 */
	@Override
	public boolean removeObverser(ConfigObverser obverser) {
		return obversers.remove(obverser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
	 */
	@Override
	public void clearObverser() {
		obversers.clear();
	}

	/**
	 * ֪ͨ�۲���ģ���е����ü��������
	 */
	protected void fireConfigKeyCleared() {
		for (ConfigObverser obverser : obversers) {
			obverser.fireConfigKeyCleared();
		}
	}

	/**
	 * ֪ͨ�۲���ָ�������ü�����ӡ�
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 */
	protected void fireConfigKeyAdded(ConfigKey configKey) {
		for (ConfigObverser obverser : obversers) {
			obverser.fireConfigKeyAdded(configKey);
		}
	}

	/**
	 * ֪ͨ�۲���ָ�������ü����Ƴ���
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 */
	protected void fireConfigKeyRemoved(ConfigKey configKey) {
		for (ConfigObverser obverser : obversers) {
			obverser.fireConfigKeyRemoved(configKey);
		}
	}

	/**
	 * ֪ͨ�۲���ָ�������ü���Ӧ���������Ա��ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�������ü���Ӧ�ľɵ��������ԡ�
	 * @param newValue
	 *            ָ�������ü���Ӧ���µ��������ԡ�
	 */
	protected void fireConfigFirmPropsChanged(ConfigKey configKey, ConfigFirmProps oldValue, ConfigFirmProps newValue) {
		for (ConfigObverser obverser : obversers) {
			obverser.fireConfigFirmPropsChanged(configKey, oldValue, newValue);
		}
	}

	/**
	 * ֪ͨ�۲���ָ���ĵ�ǰֵ���ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�������ü���Ӧ�ľɵĵ�ǰֵ��
	 * @param newValue
	 *            ָ�������ü���Ӧ���µĵ�ǰֵ��
	 * @param validValue
	 *            ָ�������ü���Ӧ�ĵ�ǰֵ�ı����µ���Чֵ��
	 */
	protected void fireCurrentValueChanged(ConfigKey configKey, String oldValue, String newValue, String validValue) {
		for (ConfigObverser obverser : obversers) {
			obverser.fireCurrentValueChanged(configKey, oldValue, newValue, validValue);
		}
	}

}
