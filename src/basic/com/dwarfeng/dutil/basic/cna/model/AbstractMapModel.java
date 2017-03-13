package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.MapObverser;

/**
 * ����ӳ��ģ�͡�
 * <p>
 * ӳ��ģ�͵ĳ���ʵ�֡�
 * <p>
 * ����ʵ����ģ����������ע�����Ƴ��ķ������Լ�֪ͨ�������ķ�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractMapModel<K, V, O extends MapObverser<K, V>> implements MapModel<K, V, O> {

	/** ���󼯺�ģ�͵����������ϡ� */
	private final Set<O> obversers;

	/**
	 * ����һ��Ĭ�ϵĳ���ӳ��ģ�͡�
	 */
	public AbstractMapModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ�������������ϵĵĳ���ӳ��ģ�͡�
	 * 
	 * @param obversers
	 *            ָ�������������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractMapModel(Set<O> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTMAPMODEL_0));
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
	 * ֪ͨ�۲�����ģ����ָ���ļ�-ֵ�Ա���ӡ�
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @param value
	 *            ָ����ֵ��
	 */
	protected void firePut(K key, V value) {
		for (MapObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.firePut(key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����ָ���ļ����Ƴ���
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @param value
	 *            ����Ӧ��ֵ��
	 */
	protected void fireRemoved(K key, V value) {
		for (MapObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireRemoved(key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����ָ���ļ��Ķ�Ӧֵ�����ı䡣
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @param oldValue
	 *            ����Ӧ�ľ�ֵ��
	 * @param newValue
	 *            ����Ӧ����ֵ��
	 */
	protected void fireChanged(K key, V oldValue, V newValue) {
		for (MapObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireChanged(key, oldValue, newValue);
		}
	}

	/**
	 * ֪ͨ��ģ���еļ�-ֵ�Ա������
	 */
	protected void fireCleared() {
		for (MapObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireCleared();
		}
	}

}
