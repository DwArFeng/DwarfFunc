package com.dwarfeng.dutil.develop.cfg;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.develop.cfg.obv.ExconfigObverser;

/**
 * ���� Ex����ģ�͡�
 * <p>
 * Ex����ģ�͵ĳ���ʵ�֡�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractExconfigModel implements ExconfigModel {

	/** �۲������� */
	protected final Set<ExconfigObverser> obversers;

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
	public AbstractExconfigModel(Set<ExconfigObverser> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTEXCONFIGMODEL_0));
		this.obversers = obversers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<ExconfigObverser> getObversers() {
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
	public boolean addObverser(ExconfigObverser obverser) {
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
	public boolean removeObverser(ExconfigObverser obverser) {
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
	
	
	protected void fireConfigKeyCleared(){
		//TODO
	}

}
