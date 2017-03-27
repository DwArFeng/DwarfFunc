package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;
import com.dwarfeng.dutil.basic.prog.WithKey;

/**
 * �����ֵ����ģ�͡�
 * <p>
 * �ü���ģ����ͨ�������Լ�������ʵ�ֵġ�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class DelegateKeySetModel<K, V extends WithKey<K>, O extends SetObverser<V>> extends DelegateSetModel<V, O>
		implements KeySetModel<K, V, O> {

	/**
	 * ����һ��Ĭ�ϵĴ����ֵ����ģ�͡�
	 */
	public DelegateKeySetModel() {
		super();
	}

	/**
	 * ����һ������ָ���Ĵ���ָ���Ĺ۲������ϵĴ����ֵ����ģ�͡�
	 * 
	 * @param delegate
	 *            ָ���Ĵ���
	 * @param obversers
	 *            ָ���Ĺ۲������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ null��
	 */
	public DelegateKeySetModel(Set<V> delegate, Set<O> obversers) {
		super(delegate, obversers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeySetModel#containsKey(java.lang.
	 * Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		for (Iterator<V> i = delegate.iterator(); i.hasNext();) {
			V value = i.next();
			if (Objects.equals(value == null ? null : value.getKey(), key)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeySetModel#containsAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean containsAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYSETMODEL_0));

		for (Object obj : c) {
			if (!containsKey(obj))
				return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.cna.model.KeySetModel#removeKey(java.lang.
	 * Object)
	 */
	@Override
	public boolean removeKey(Object key) {
		for (Iterator<V> i = delegate.iterator(); i.hasNext();) {
			V value = i.next();
			if (Objects.equals(value == null ? null : value.getKey(), key)) {
				if (delegate.remove(value)) {
					fireRemoved(value);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeySetModel#removeAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean removeAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYSETMODEL_0));
		return batchRemoveKey(c, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeySetModel#retainAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean retainAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYSETMODEL_0));
		return batchRemoveKey(c, false);
	}

	private boolean batchRemoveKey(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<V> i = delegate.iterator(); i.hasNext();) {
			V element = i.next();

			if (c.contains(element == null ? null : element.getKey()) == aFlag) {
				i.remove();
				fireRemoved(element);
				result = true;
			}
		}

		return result;
	}
}
