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
 * ���ڴ���¼��������������ü��ϡ�
 * <p> �ü����ܹ���Ų�ͬ������¼��������������ܹ���������Ĳ�ͬ���зֱ��������ȡ���ض����͵��������ϣ���
 * <br> �ü���ʹ�������ü��϶���Щ�¼��������������ã����ⲿ������ǿ������ʧ�Ժ����ͷŵ�ע��Դ��ʱ
 * �������û����������������е�ʱ��������ʧ��
 * <br> ֮����ʹ�������ü�����Ϊ�˱�֤���û������û�б���ʱ�ͷŵ��¼�����������ڴ��й¶����ˣ�������ֻ���ṩ��һ�ֱ��ϣ�
 * �����Բ��ǹ����û���ʹ�øü���ʱ���ͷ�������
 * <p> �ü��ϵĲ������̲߳���ȫ�ģ�����漰��ͬ����������ʹ���ⲿͬ�����롣
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class EventListenerWeakSet implements Set<EventListener>{
	
	/**���ڴ�������������ü���*/
	protected final Set<EventListener> set = Collections.newSetFromMap(new WeakHashMap<EventListener, Boolean>());

	/**
	 * ����һ���µ������������ü��ϡ�
	 */
	public EventListenerWeakSet() {}
	
	/**
	 * ������ָ�����Լ�ָ������ɵ�������ɵļ��ϡ�
	 * <p> �ü����Ǹ�ǿ���ü��ϣ����ʹ����ü���֮��Ӧ��Ѹ�ٵĻ��յ�������ϡ���������Ϸ���һ������������õģ���Ϊ
	 * ������������صľֲ��������ᱻ�ͷš�
	 * @param cl ָ�����ࡣ
	 * @param <T> ָ����������͡�
	 * @return ָ�����������������ɵļ��ϡ�
	 */
	public <T extends EventListener> Set<T> subSet(Class<T> cl){
		Set<T> sub = new HashSet<T>(set.size());
		for(EventListener listener : set){
			if(cl.isAssignableFrom(listener.getClass())){
				//����ʹ��if�ж��Ƿ�������Ȼ��Ƿ�����������⣬��������ﲻ����ת�����⡣
				@SuppressWarnings("unchecked")
				T tListener = (T) listener;
				sub.add(tListener);
			}
		}
		return sub;
	}
	
	/**
	 * ���������������Ƴ���ָ�������ָ����������������������
	 * @param cl ָ�����ࡣ
	 * @param <T> ָ����������͡�
	 * @return �ò����Ƿ�ı��˼��ϣ����Ƿ�ɾ��������һ��Ԫ�ء�
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
	 * �򼯺�������¼�������
	 * @param e ָ����������
	 * @throws NullPointerException �����ڲ���<code>e</code>Ϊ<code>null</code>��
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
