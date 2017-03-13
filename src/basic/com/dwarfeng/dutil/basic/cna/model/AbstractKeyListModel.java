package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.KeyListObverser;
import com.dwarfeng.dutil.basic.prog.ElementWithKey;

/**
 * �����ֵ�б�ģ�͡�
 * <p>
 * �б�ģ�͵ĳ���ʵ�֡�
 * <p>
 * ����ʵ����ģ����������ע�����Ƴ��ķ������Լ�֪ͨ�������ķ�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractKeyListModel<K, V extends ElementWithKey<K>, O extends KeyListObverser<K, V>>
		implements KeyListModel<K, V, O> {

	/** �����б�ģ�͵����������ϡ� */
	private final Set<O> obversers;

	/**
	 * ����һ��Ĭ�ϵĳ����ֵ�б�ģ�͡�
	 */
	public AbstractKeyListModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ�������������ϵĵĳ����ֵ�б�ģ�͡�
	 * 
	 * @param obversers
	 *            ָ�������������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractKeyListModel(Set<O> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTKEYLISTMODEL_0));
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
	 * ֪ͨ�۲�����ģ����ָ����λ���������ָ����Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param key
	 *            ָ����Ԫ�صļ���
	 * @param value
	 *            ָ����Ԫ�ء�
	 */
	protected void fireAdded(int index, K key, V value) {
		for (KeyListObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireAdded(index, key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����ָ����λ�����Ƴ���Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param key
	 *            ��һ������Ԫ�صļ���
	 * @param value
	 *            ���Ƴ���Ԫ�ء�
	 */
	protected void fireRemoved(int index, K key, V value) {
		for (KeyListObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireRemoved(index, key, value);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ��ָ����λ�ô���Ԫ�ط����˸ı䡣
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param oldKey
	 *            �ɵ�Ԫ�صļ���
	 * @param oldValue
	 *            �ɵ�Ԫ�ء�
	 * @param newKey
	 *            �µ�Ԫ�صļ���
	 * @param newValue
	 *            �µ�Ԫ�ء�
	 */
	protected void fireChanged(int index, K oldKey, V oldValue, K newKey, V newValue) {
		for (KeyListObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireChanged(index, oldKey, oldValue, newKey, newValue);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ���е�Ԫ�ر������
	 */
	protected void fireCleared() {
		for (KeyListObverser<K, V> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireCleared();
		}
	}

}
