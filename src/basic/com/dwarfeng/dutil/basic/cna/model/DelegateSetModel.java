package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;

/**
 * ������ģ�͡�
 * <p>
 * ͨ������һ�� {@link Set} ʵ���б�ģ�͡�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class DelegateSetModel<E> extends AbstractSetModel<E> {

	/** �ü���ģ�͵Ĵ��� */
	protected final Set<E> delegate;

	/**
	 * ����һ��Ĭ�ϵĴ�����ģ�͡�
	 */
	public DelegateSetModel() {
		this(new HashSet<>(), Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ���Ĵ���ָ���Ĺ۲������ϵĴ�����ģ�͡�
	 * 
	 * @param delegate
	 *            ָ���Ĵ���
	 * @param obversers
	 *            ָ���Ĺ۲�������ģ�͡�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public DelegateSetModel(Set<E> delegate, Set<SetObverser<E>> obversers) {
		super(obversers);
		Objects.requireNonNull(delegate, DwarfUtil.getStringField(StringFieldKey.DELEGATESETMODEL_0));
		this.delegate = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#size()
	 */
	@Override
	public int size() {
		return delegate.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new InnerIterator(delegate.iterator());
	}

	private class InnerIterator implements Iterator<E> {

		private final Iterator<E> itr;
		private E cursor = null;

		public InnerIterator(Iterator<E> itr) {
			this.itr = itr;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public E next() {
			cursor = itr.next();
			return cursor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			itr.remove();
			fireRemoved(cursor);
			cursor = null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#toArray()
	 */
	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#toArray(java.lang.Object[])
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		if (delegate.add(e)) {
			fireAdded(e);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		if (delegate.remove(o)) {
			// ֻ�� o �������� E�����п����Ƴ��ɹ�����˴˴�����ת���ǰ�ȫ�ġ�
			@SuppressWarnings("unchecked")
			E e = (E) o;
			fireRemoved(e);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATESETMODEL_1));
		return delegate.containsAll(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATESETMODEL_1));

		boolean aFlag = false;
		for (E e : c) {
			if (add(e)) {
				aFlag = true;
			}
		}
		return aFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATESETMODEL_1));
		return batchRemove(c, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.DELEGATESETMODEL_1));
		return batchRemove(c, false);
	}

	private boolean batchRemove(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (Iterator<E> i = delegate.iterator(); i.hasNext();) {
			E element = i.next();

			if (c.contains(element) == aFlag) {
				i.remove();
				fireRemoved(element);
				result = true;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Set#clear()
	 */
	@Override
	public void clear() {
		delegate.clear();
		fireCleared();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		return delegate.equals(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return delegate.toString();
	}

}
