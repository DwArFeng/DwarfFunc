package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.ListObverser;
import com.dwarfeng.dutil.basic.prog.WithKey;

/**
 * �����ֵ�б�ģ�͡�
 * <p>
 * ͨ������һ�� {@link List} ʵ�ּ�ֵ�б�ģ�͡�
 * 
 * <p>
 * ���б�ģ������������ӵ����ͬ��ֵ��Ԫ�أ�������ЩԪ�ر��벻�໥��ͻ��
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class DelegateKeyListModel<K, V extends WithKey<K>, O extends ListObverser<V>> extends DelegateListModel<V, O>
		implements KeyListModel<K, V, O> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.cna.model.DelegateListModel#add(java.lang.
	 * Object)
	 */
	@Override
	public boolean add(V e) {
		if (checkConflict(e))
			return false;
		return super.add(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.cna.model.DelegateListModel#add(int,
	 * java.lang.Object)
	 */
	@Override
	public void add(int index, V element) {
		if (checkConflict(element))
			return;
		super.add(index, element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.DelegateListModel#addAll(java.util.
	 * Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends V> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYLISTMODEL_0));
		boolean aFlag = false;
		for (V e : c) {
			if (add(e))
				aFlag = true;
		}
		return aFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.cna.model.DelegateListModel#addAll(int,
	 * java.util.Collection)
	 */
	@Override
	public boolean addAll(int index, Collection<? extends V> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYLISTMODEL_0));
		int size = delegate.size();
		int i = 0;
		for (V e : c) {
			add(index + i++, e);
		}
		return size != delegate.size();
	}

	private boolean checkConflict(V e) {
		K key = e == null ? null : e.getKey();
		if (!containsKey(key))
			return false;
		V currentElement = get(indexOfKey(key));
		return currentElement.isConflict(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#containsKey(java.lang.
	 * Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		for (Iterator<V> i = delegate.iterator(); i.hasNext();) {
			V value = i.next();
			if (Objects.equals(key, value == null ? null : value.getKey()))
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#containsAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean containsAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYLISTMODEL_0));
		for (Iterator<?> i = c.iterator(); i.hasNext();) {
			Object o = i.next();
			if (!containsKey(o))
				return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#indexOfKey(java.lang.
	 * Object)
	 */
	@Override
	public int indexOfKey(Object o) {
		for (ListIterator<V> i = delegate.listIterator(0); i.hasNext();) {
			int index = i.nextIndex();
			V value = i.next();
			if (Objects.equals(o, value == null ? null : value.getKey()))
				return index;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#lastIndexOfKey(java.lang.
	 * Object)
	 */
	@Override
	public int lastIndexOfKey(Object o) {
		for (ListIterator<V> i = delegate.listIterator(delegate.size()); i.hasPrevious();) {
			int index = i.previousIndex();
			V value = i.previous();
			if (Objects.equals(o, value == null ? null : value.getKey()))
				return index;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.cna.model.KeyListModel#removeKey(java.lang.
	 * Object)
	 */
	@Override
	public boolean removeKey(Object key) {
		for (ListIterator<V> i = delegate.listIterator(0); i.hasNext();) {
			int index = i.nextIndex();
			V value = i.next();
			if (Objects.equals(key, value == null ? null : value.getKey())){
				i.remove();
				fireRemoved(index, value);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#removeAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean removeAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYLISTMODEL_0));
		return batchRemoveKey(c, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.cna.model.KeyListModel#retainAllKey(java.util.
	 * Collection)
	 */
	@Override
	public boolean retainAllKey(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATEKEYLISTMODEL_0));
		return batchRemoveKey(c, false);

	}

	private boolean batchRemoveKey(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (ListIterator<V> i = delegate.listIterator(); i.hasNext();) {
			int index = i.nextIndex();
			V value = i.next();

			if (c.contains(value == null ? null : value.getKey()) == aFlag) {
				i.remove();
				fireRemoved(index, value);
				result = true;
			}
		}

		return result;
	}
}
