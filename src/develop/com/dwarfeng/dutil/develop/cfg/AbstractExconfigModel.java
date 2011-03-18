package com.dwarfeng.dutil.develop.cfg;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.develop.cfg.obv.ExconfigObverser;
import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * ���� Ex����ģ�͡�
 * <p>
 * Ex����ģ�͵ĳ���ʵ�֡�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractExconfigModel<O extends ExconfigObverser> implements ExconfigModel<O> {

	/** �۲������� */
	protected final Set<O> obversers;

	/**
	 * ����һ��Ĭ�ϵĳ���Ex����ģ�͡�
	 */
	public AbstractExconfigModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ�������������ϵĵĳ���Ex����ģ�͡�
	 * 
	 * @param obversers
	 *            ָ�������������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractExconfigModel(Set<O> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTEXCONFIGMODEL_0));
		this.obversers = obversers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<O> getObversers() {
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
	public boolean addObverser(O obverser) {
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
	public boolean removeObverser(O obverser) {
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
	 * ֪ͨ����ģ����ָ�������ü��ĵ�ǰֵ�����˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ���ü��ľ�ֵ��
	 * @param newValue
	 *            ���ü�����ֵ��
	 * @param validValue
	 *            ���ü���ǰ����Чֵ��
	 */
	protected void fireCurrentValueChanged(ConfigKey configKey, String oldValue, String newValue, String validValue) {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireCurrentValueChanged(configKey, oldValue, newValue, validValue);
		}
	}

	/**
	 * ֪ͨ����ģ���е����ü������������
	 */
	protected void fireConfigKeyCleared() {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireConfigKeyCleared();
		}
	}

	/**
	 * ֪ͨ����ģ����ָ�������ü��������Ƴ���
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param configFirmProps
	 *            ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 * @param valueParser
	 *            ָ�������ü���Ӧ��ֵ��������
	 * @param currentValue
	 *            ָ�������ü���Ӧ�ĵ�ǰֵ��
	 */
	protected void fireConfigKeyRemoved(ConfigKey configKey, ConfigFirmProps configFirmProps, ValueParser valueParser,
			String currentValue) {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireConfigKeyRemoved(configKey, configFirmProps, valueParser, currentValue);
		}
	}

	/**
	 * ֪ͨ����ģ����ָ�������ü���������ӡ�
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param configFirmProps
	 *            ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 * @param valueParser
	 *            ָ�������ü���Ӧ��ֵ��������
	 * @param currentValue
	 *            ָ�������ü���Ӧ�ĵ�ǰֵ��
	 */
	protected void fireConfigKeyAdded(ConfigKey configKey, ConfigFirmProps configFirmProps, ValueParser valueParser,
			String currentValue) {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireConfigKeyAdded(configKey, configFirmProps, valueParser, currentValue);
		}
	}

	/**
	 * ֪ͨ����ģ����ָ�������ü��Ĺ̶����Է����˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�����ü��ľɵĹ̶����ԡ�
	 * @param newValue
	 *            ָ�������ü����µĹ̶����ԡ�
	 */
	protected void fireConfigFirmPropsChanged(ConfigKey configKey, ConfigFirmProps oldValue, ConfigFirmProps newValue) {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireConfigFirmPropsChanged(configKey, oldValue, newValue);
		}
	}

	/**
	 * ֪ͨ����ģ����ָ�������ü���ֵ�����������˸ı䡣
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param oldValue
	 *            ָ�������ü���Ӧ�ľɵ�ֵ��������
	 * @param newValue
	 *            ָ�������ü���Ӧ���µ�ֵ��������
	 */
	protected void fireValueParserChanged(ConfigKey configKey, ValueParser oldValue, ValueParser newValue) {
		for (ExconfigObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireValueParserChanged(configKey, oldValue, newValue);
		}
	}

}
