package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.ListObverser;

/**
 * �����б�ģ�͡�
 * <p>
 * �б�ģ�͵ĳ���ʵ�֡�
 * <p>
 * ����ʵ����ģ����������ע�����Ƴ��ķ������Լ�֪ͨ�������ķ�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractListModel<E, O extends ListObverser<E>> implements ListModel<E, O> {

	/** �����б�ģ�͵����������ϡ� */
	private final Set<O> obversers;

	/**
	 * ����һ��Ĭ�ϵĳ����б�ģ�͡�
	 */
	public AbstractListModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ�������������ϵĵĳ����б�ģ�͡�
	 * 
	 * @param obversers
	 *            ָ�������������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractListModel(Set<O> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTLISTMODEL_0));
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
	 * ֪ͨ�۲�����ģ����ָ����λ�������ָ����Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param element
	 *            ָ���ĵ�Ԫ�ء�
	 */
	protected void fireAdded(int index, E element) {
		for (ListObverser<E> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireAdded(index, element);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ����ָ����λ���Ƴ���Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param element
	 *            ���Ƴ���Ԫ�ء�
	 */
	protected void fireRemoved(int index, E element) {
		for (ListObverser<E> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireRemoved(index, element);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ��ָ��λ�ô���Ԫ�ط����˸ı䡣
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param oldElement
	 *            �ı�ǰ�ľ�Ԫ�ء�
	 * @param newElement
	 *            �ı�����Ԫ�ء�
	 */
	protected void fireChanged(int index, E oldElement, E newElement) {
		for (ListObverser<E> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireChanged(index, oldElement, newElement);
		}
	}

	/**
	 * ֪ͨ�۲�����ģ���Ƴ������е�Ԫ�ء�
	 */
	protected void fireCleared() {
		for (ListObverser<E> obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireCleared();
		}
	}

}
