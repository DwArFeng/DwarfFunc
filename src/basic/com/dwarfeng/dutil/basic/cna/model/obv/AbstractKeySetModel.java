package com.dwarfeng.dutil.basic.cna.model.obv;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.KeySetModel;
import com.dwarfeng.dutil.basic.prog.ElementWithKey;

/**
 * �����ֵ����ģ�͡�
 * <p>
 * ��ֵ����ģ�͵ĳ���ʵ�֡�
 * <p>
 * ����ʵ����ģ����������ע�����Ƴ��ķ������Լ�֪ͨ�������ķ�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractKeySetModel<K, V extends ElementWithKey<K>> implements KeySetModel<K, V> {

	/** ���󼯺�ģ�͵����������ϡ� */
	private final Set<KeySetObverser<K, V>> obversers;

	/**
	 * ����һ��Ĭ�ϵĳ��󼯺�ģ�͡�
	 */
	public AbstractKeySetModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ�������������ϵĵĳ��󼯺�ģ�͡�
	 * 
	 * @param obversers
	 *            ָ�������������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractKeySetModel(Set<KeySetObverser<K, V>> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTKEYSETMODEL_0));
		this.obversers = obversers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<KeySetObverser<K, V>> getObversers() {
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
	public boolean addObverser(KeySetObverser<K, V> obverser) {
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
	public boolean removeObverser(KeySetObverser<K, V> obverser) {
		return obversers.remove(obverser);
	}

	/**
	 * ֪ͨ�۲�����ģ����������ָ����Ԫ�ء�
	 * 
	 * @param key
	 *            ָ����Ԫ�صļ���
	 * @param value
	 *            ָ����Ԫ�ء�
	 */
	protected void fireAdded(K key, V value) {
		for (KeySetObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireAdded(key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ���Ƴ���ָ����Ԫ�ء�
	 * 
	 * @param key
	 *            ָ����Ԫ�صļ���
	 * @param value
	 *            ָ����Ԫ�ء�
	 */
	protected void fireRemoved(K key, V value) {
		for (KeySetObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireRemoved(key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����ָ���ļ���Ӧ��Ԫ�ر��ı䡣
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @param oldValue
	 *            ����Ӧ�ľɵ�Ԫ�ء�
	 * @param newValue
	 *            ����Ӧ���µ�Ԫ�ء�
	 */
	protected void fireChanged(K key, V oldValue, V newValue) {
		for (KeySetObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireChanged(key, oldValue, newValue);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����Ԫ�ر������
	 */
	protected void fireCleared() {
		for (KeySetObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireCleared();
		}
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

}
