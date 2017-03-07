package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;

/**
 * ���󼯺�ģ�͡�
 * <p> ����ģ�͵ĳ���ʵ�֡�
 * <p> ����ʵ����ģ����������ע�����Ƴ��ķ������Լ�֪ͨ�������ķ�����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractSetModel<E> implements SetModel<E> {

	/**���󼯺�ģ�͵����������ϡ�*/
	private final Set<SetObverser<E>> obversers;
	
	/**
	 * ����һ��Ĭ�ϵĳ��󼯺�ģ�͡�
	 */
	public AbstractSetModel() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}
	
	/**
	 * ����һ������ָ�������������ϵĵĳ��󼯺�ģ�͡�
	 * @param obversers ָ�������������ϡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractSetModel(Set<SetObverser<E>> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTSETMODEL_0));
		this.obversers = obversers;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<SetObverser<E>> getObversers() {
		return Collections.unmodifiableSet(obversers);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.dutil.basic.prog.Obverser)
	 */
	@Override
	public boolean addObverser(SetObverser<E> obverser) {
		return obversers.add(obverser);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng.dutil.basic.prog.Obverser)
	 */
	@Override
	public boolean removeObverser(SetObverser<E> obverser) {
		return obversers.remove(obverser);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
	 */
	@Override
	public void clearObverser() {
		obversers.clear();
	}
}
