package com.dwarfeng.dutil.basic.gui.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.ExceptionStringKey;

/**
 * 多重操作列表模型。
 * 
 * <p>
 * 该列表模型具有 {@link DefaultListModel}的所有功能，同时优化了结构类型，并且对批量操作进行了优化。
 * 同时，这个类是一个真正的列表的实现。
 * <p>
 * 该类可以通过指定入口的参数来保证列表的不同实现，如用同步列表作为实现就可以保证其中方法的同步。
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class MuaListModel<E> extends AbstractListModel<E> implements List<E> {

	private static final long serialVersionUID = -9035220797049152472L;

	/** 模型中的列表代理。 */
	protected final List<E> delegate;

	/**
	 * 生成一个默认的，由 {@link ArrayList}实现的列表模型。
	 */
	public MuaListModel() {
		this(new ArrayList<E>());
	}

	/**
	 * 生成一个由指定列表实现的列表模型。
	 * 
	 * @param delegate 指定的列表。
	 * @throws NullPointerException 入口参数为 <code>null</code>
	 */
	public MuaListModel(List<E> delegate) {
		Objects.requireNonNull(delegate, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_0));
		this.delegate = delegate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSize() {
		return delegate.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E getElementAt(int index) {
		return delegate.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return delegate.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		return new InnerIterator(delegate.iterator());
	}

	private class InnerIterator implements Iterator<E> {

		private final Iterator<E> itr;
		private int lastRet = -1;
		private int cursor = 0;

		public InnerIterator(Iterator<E> itr) {
			this.itr = itr;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() {
			int i = cursor;
			cursor++;
			lastRet = i;
			return itr.next();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();

			cursor = lastRet;
			itr.remove();
			fireIntervalRemoved(this, lastRet, lastRet);
			lastRet = -1;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(E e) {
		int size = delegate.size();
		if (delegate.add(e)) {
			fireIntervalAdded(this, size, size);
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {
		int index = delegate.indexOf(o);
		if (delegate.remove(o)) {
			fireIntervalRemoved(this, index, index);
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
		return delegate.containsAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
		int index = delegate.size();
		boolean aFlag = delegate.addAll(c);
		if (aFlag == true) {
			fireIntervalAdded(this, index, Math.max(index, delegate.size() - 1));
		}
		return aFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
		int aIndex = delegate.size();
		boolean aFlag = delegate.addAll(index, c);
		if (aFlag == true) {
			fireIntervalAdded(this, index, Math.max(index, index + delegate.size() - aIndex - 1));
		}
		return aFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
		return batchRemove(c, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
		return batchRemove(c, false);
	}

	private boolean batchRemove(Collection<?> c, boolean aFlag) {
		boolean result = false;

		for (ListIterator<E> i = delegate.listIterator(); i.hasNext();) {
			int index = i.nextIndex();
			E element = i.next();

			if (c.contains(element) == aFlag) {
				i.remove();
				fireIntervalRemoved(this, index, index);
				result = true;
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		int index1 = delegate.size() - 1;
		delegate.clear();
		if (index1 >= 0) {
			fireIntervalRemoved(this, 0, index1);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(int index) {
		return delegate.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E set(int index, E element) {
		E oldElement = delegate.set(index, element);
		fireContentsChanged(this, index, index);
		return oldElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(int index, E element) {
		delegate.add(index, element);
		fireIntervalAdded(this, index, index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(int index) {
		E element = delegate.remove(index);
		fireIntervalRemoved(this, index, index);
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(Object o) {
		return delegate.indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(Object o) {
		return delegate.lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator() {
		return new InnerListIterator(delegate.listIterator(), 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new InnerListIterator(delegate.listIterator(index), index);
	}

	private class InnerListIterator implements ListIterator<E> {

		private final ListIterator<E> litr;
		private int lastRet = -1;
		private int cursor;

		public InnerListIterator(ListIterator<E> litr, int cursor) {
			this.litr = litr;
			this.cursor = cursor;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return litr.hasNext();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() {
			int i = cursor;
			cursor++;
			lastRet = i;
			return litr.next();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasPrevious() {
			return litr.hasPrevious();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E previous() {
			int i = cursor - 1;
			cursor = i;
			lastRet = i;
			return litr.previous();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int nextIndex() {
			return litr.nextIndex();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int previousIndex() {
			return litr.previousIndex();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();

			cursor = lastRet;
			litr.remove();
			fireIntervalRemoved(this, lastRet, lastRet);
			lastRet = -1;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void set(E e) {
			if (lastRet < 0)
				throw new IllegalStateException();

			litr.set(e);
			fireContentsChanged(this, lastRet, lastRet);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void add(E e) {
			int i = cursor;
			litr.add(e);
			fireIntervalAdded(this, i, i);
			cursor = i + 1;
			lastRet = -1;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return new SubList(fromIndex, delegate.subList(fromIndex, toIndex));
	}

	private class SubList implements List<E> {

		private final int offset;
		private List<E> subDelegate;

		public SubList(int offset, List<E> subDelegate) {
			this.offset = offset;
			this.subDelegate = subDelegate;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int size() {
			return subDelegate.size();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isEmpty() {
			return subDelegate.isEmpty();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean contains(Object o) {
			return subDelegate.contains(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Iterator<E> iterator() {
			return new SubIterator(subDelegate.iterator());
		}

		private class SubIterator implements Iterator<E> {

			private final Iterator<E> itr;
			private int lastRet = -1;
			private int cursor = 0;

			public SubIterator(Iterator<E> itr) {
				this.itr = itr;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return itr.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				int i = cursor;
				cursor++;
				lastRet = i;
				return itr.next();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void remove() {
				if (lastRet < 0)
					throw new IllegalStateException();

				cursor = lastRet;
				itr.remove();
				fireIntervalRemoved(this, lastRet + offset, lastRet + offset);
				lastRet = -1;
			}

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object[] toArray() {
			return subDelegate.toArray();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public <T> T[] toArray(T[] a) {
			return subDelegate.toArray(a);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean add(E e) {
			int size = subDelegate.size();
			if (subDelegate.add(e)) {
				fireIntervalAdded(this, size + offset, size + offset);
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean remove(Object o) {
			int index = subDelegate.indexOf(o);
			if (subDelegate.remove(o)) {
				fireIntervalRemoved(this, index + offset, index + offset);
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean containsAll(Collection<?> c) {
			Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
			return subDelegate.containsAll(c);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) {
			// TODO 此处逻辑有误，虽然结果正确，但是侦听器会触发多次。
			Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
			boolean aFlag = false;
			for (E e : c) {
				if (add(e))
					aFlag = true;
			}
			return aFlag;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			// TODO 此处逻辑有误，虽然结果正确，但是侦听器会触发多次。
			Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
			int size = subDelegate.size();
			int i = 0;
			for (E e : c) {
				add(index + i++, e);
			}
			return size != subDelegate.size();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean removeAll(Collection<?> c) {
			Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
			return batchRemove(c, true);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			Objects.requireNonNull(c, DwarfUtil.getExceptionString(ExceptionStringKey.MUALISTMODEL_1));
			return batchRemove(c, false);
		}

		private boolean batchRemove(Collection<?> c, boolean aFlag) {
			boolean result = false;

			for (ListIterator<E> i = subDelegate.listIterator(); i.hasNext();) {
				int index = i.nextIndex();
				E element = i.next();

				if (c.contains(element) == aFlag) {
					i.remove();
					fireIntervalRemoved(this, index + offset, index + offset);
					result = true;
				}
			}

			return result;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void clear() {
			int size = subDelegate.size();
			for (int i = 0; i < size; i++) {
				remove(0);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E get(int index) {
			return subDelegate.get(index);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E set(int index, E element) {
			E oldElement = subDelegate.set(index, element);
			fireContentsChanged(this, index + offset, index + offset);
			return oldElement;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void add(int index, E element) {
			subDelegate.add(index, element);
			fireIntervalAdded(this, index + offset, index + offset);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E remove(int index) {
			E element = subDelegate.remove(index);
			fireIntervalRemoved(this, index + offset, index + offset);
			return element;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int indexOf(Object o) {
			return subDelegate.indexOf(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int lastIndexOf(Object o) {
			return subDelegate.lastIndexOf(o);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator() {
			return new SubListIterator(subDelegate.listIterator(), 0);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return new SubListIterator(subDelegate.listIterator(index), index);
		}

		private class SubListIterator implements ListIterator<E> {

			private final ListIterator<E> litr;
			private int lastRet = -1;
			private int cursor;

			public SubListIterator(ListIterator<E> litr, int cursor) {
				this.litr = litr;
				this.cursor = cursor;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return litr.hasNext();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E next() {
				int i = cursor;
				cursor++;
				lastRet = i;
				return litr.next();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasPrevious() {
				return litr.hasPrevious();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public E previous() {
				int i = cursor - 1;
				cursor = i;
				lastRet = i;
				return litr.previous();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int nextIndex() {
				return litr.nextIndex();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public int previousIndex() {
				return litr.previousIndex();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void remove() {
				if (lastRet < 0)
					throw new IllegalStateException();

				cursor = lastRet;
				litr.remove();
				fireIntervalRemoved(this, lastRet + offset, lastRet + offset);
				lastRet = -1;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void set(E e) {
				if (lastRet < 0)
					throw new IllegalStateException();

				litr.set(e);
				fireContentsChanged(this, lastRet + offset, lastRet + offset);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void add(E e) {
				int i = cursor;
				litr.add(e);
				fireIntervalAdded(this, i + offset, i + offset);
				cursor = i + 1;
				lastRet = -1;
			}

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return new SubList(offset + fromIndex, subDelegate.subList(fromIndex, toIndex));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			return subDelegate.hashCode();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			return subDelegate.equals(obj);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return subDelegate.toString();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return delegate.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		return delegate.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return delegate.toString();
	}

}
