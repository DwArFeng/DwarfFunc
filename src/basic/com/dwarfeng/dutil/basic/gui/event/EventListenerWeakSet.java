package com.dwarfeng.dutil.basic.gui.event;

import java.util.Collection;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * 用于存放事件侦听器的弱引用集合。
 * <p> 该集合能够存放不同种类的事件侦听器，并且能够根据其类的不同进行分别操作（如取出特定类型的侦听集合）。
 * <br> 该集合使用弱引用集合对这些事件侦听器进行引用，当外部的所有强引用消失以后（如释放掉注册源）时
 * ，该引用会在垃圾回收器运行的时候自行消失。
 * <br> 之所以使用弱引用集合是为了保证因用户疏忽而没有被及时释放的事件侦听器造成内存的泄露。因此，这样做只是提供了一种保障，
 * 而绝对不是鼓励用户在使用该集合时不释放侦听。
 * <p> 该集合的操作是线程不安全的，如果涉及到同步操作，请使用外部同步代码。
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class EventListenerWeakSet implements Set<EventListener>{
	
	/**用于存放侦听的弱引用集合*/
	protected final Set<EventListener> set = Collections.newSetFromMap(new WeakHashMap<EventListener, Boolean>());

	/**
	 * 生成一个新的侦听器弱引用集合。
	 */
	public EventListenerWeakSet() {}
	
	/**
	 * 返回由指定类以及指定类组成的子类组成的集合。
	 * <p> 该集合是个强引用集合，因此使用完该集合之后应该迅速的回收掉这个集合。把这个集合放在一个方法里是最好的，因为
	 * 方法结束后相关的局部变量将会被释放。
	 * @param cl 指定的类。
	 * @param <T> 指定的类的类型。
	 * @return 指定的类或者其子类组成的集合。
	 */
	public <T extends EventListener> Set<T> subSet(Class<T> cl){
		Set<T> sub = new HashSet<T>(set.size());
		for(EventListener listener : set){
			if(cl.isAssignableFrom(listener.getClass())){
				//由于使用if判断是否类型相等或是否是子类的问题，因此在这里不存在转换问题。
				@SuppressWarnings("unchecked")
				T tListener = (T) listener;
				sub.add(tListener);
			}
		}
		return sub;
	}
	
	/**
	 * 在侦听器集合中移除是指定类或者指定类的子类的所有侦听器。
	 * @param cl 指定的类。
	 * @param <T> 指定的类的类型。
	 * @return 该操作是否改变了集合，集是否删除了至少一个元素。
	 */
	public<T extends EventListener> boolean remove(Class<T> cl){
		Set<T> sub = subSet(cl);
		return set.removeAll(sub);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Set#size()
	 */
	@Override
	public int size() {
		return set.size();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#iterator()
	 */
	@Override
	public Iterator<EventListener> iterator() {
		return set.iterator();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#toArray()
	 */
	@Override
	public Object[] toArray() {
		return set.toArray();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#toArray(java.lang.Object[])
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}

	/**
	 * 向集合中添加事件侦听。
	 * @param e 指定的侦听。
	 * @throws NullPointerException 如果入口参数<code>e</code>为<code>null</code>。
	 */
	@Override
	public boolean add(EventListener e) {
		if(e == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.EVENTLISTENERWEAKSET_0));
		return set.add(e);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends EventListener> c) {
		return set.addAll(c);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Set#clear()
	 */
	@Override
	public void clear() {
		set.clear();
	}
	

}
