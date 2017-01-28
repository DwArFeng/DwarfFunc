package com.dwarfeng.dutil.basic.cna;

import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * �й��ڼ��ϵĹ��߰���
 * <p> �ù��߰��а����Լ��Ͻ��еĳ����Ĳ���
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public final class CollectionUtil {

	//��ֹ�ⲿʵ������
	private  CollectionUtil() {}

	/**
	 * ��ָ�����ϵĻ����ϻ�ò������� <code>null</code> Ԫ�صļ��ϡ�
	 * <p> ��õļ��ϻ�ת��ָ���ļ����еķ�������ˣ���õļ��ϵı�����ָ���ļ�����һ�µġ�
	 * <p> ��ע�⣬��ڲ��������ǿյģ���Ϊ�ǿյĲ��������Ѿ������� <code>null</code>Ԫ�ء�
	 * <br> ��õļ��ϲ��������к���nullԪ�أ���ˣ��κ���ͼ��������� <code>null</code>Ԫ��
	 * �ķ��������׳��쳣��
	 * @param set ת�˵ļ��ϡ�
	 * @param <T> ����T��
	 * @return �������� <code>null</code> Ԫ�صļ��ϡ�
	 * @throws NullPointerException ����ڲ���Ϊ <code>null</code> ʱ�׳����쳣��
	 * @throws IllegalArgumentException ����ڵĲ������ǿյ�ʱ���׳����쳣��
	 */
	public static<T> Set<T> nonNullSet(Set<T> set){
		Objects.requireNonNull(set, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_0));
		if(!set.isEmpty()){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.CollectionUtil_8));
		}
		return new NonNullSet<T>(set);
	}
	
	private static final class NonNullSet<E> implements Set<E>{

		private final Set<E> set;
		
		public NonNullSet(Set<E> set) {
			this.set = set;
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
		public Iterator<E> iterator() {
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

		/*
		 * (non-Javadoc)
		 * @see java.util.Set#add(java.lang.Object)
		 */
		@Override
		public boolean add(E e) {
			Objects.requireNonNull(e, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
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
		public boolean addAll(Collection<? extends E> c) {
			Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			if(CollectionUtil.conatinsNull(c)){
				throw new NullPointerException(
						DwarfUtil.getStringField(StringFieldKey.CollectionUtil_3));
			}
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
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return set.toString();
		}
	}
	
	/**
	 * ��ָ���б�Ļ����ϻ�ò������� <code>null</code> Ԫ�ص��б�
	 * <p> ��õ��б��ת��ָ�����б��еķ�������ˣ���õ��б�ı�����ָ�����б���һ�µġ�
	 * <p> ��ע�⣬��ڲ��������ǿյģ���Ϊ�ǿյĲ��������Ѿ������� <code>null</code>Ԫ�ء�
	 * <br> ��õ��б��������к���nullԪ�أ���ˣ��κ���ͼ��������� <code>null</code>Ԫ��
	 * �ķ��������׳��쳣��
	 * @param list ת�˵��б�
	 * @param <T> ����T��
	 * @return �������� <code>null</code> Ԫ�ص��б�
	 * @throws NullPointerException ����ڲ���Ϊ <code>null</code> ʱ�׳����쳣��
	 * @throws IllegalArgumentException ����ڵĲ������ǿյ�ʱ���׳����쳣��
	 */
	public static<T> List<T> nonNullList(List<T> list){
		Objects.requireNonNull(list, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_4));
		if(!list.isEmpty()){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.CollectionUtil_8));
		}
		return new NonNullList<T>(list);
	}
	
	private static final class NonNullList<E> implements List<E>{

		private final List<E> list;
		
		public NonNullList(List<E> list) {
			this.list = list;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.List#size()
		 */
		@Override
		public int size() {
			return list.size();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return list.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(Object o) {
			return list.contains(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return list.iterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray()
		 */
		@Override
		public Object[] toArray() {
			return list.toArray();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray(java.lang.Object[])
		 */
		@Override
		public <T> T[] toArray(T[] a) {
			return list.toArray(a);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(java.lang.Object)
		 */
		@Override
		public boolean add(E e) {
			Objects.requireNonNull(e, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			return list.add(e);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(java.lang.Object)
		 */
		@Override
		public boolean remove(Object o) {
			return list.remove(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#containsAll(java.util.Collection)
		 */
		@Override
		public boolean containsAll(Collection<?> c) {
			return list.containsAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(java.util.Collection)
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) {
			Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			if(CollectionUtil.conatinsNull(c)){
				throw new NullPointerException(
						DwarfUtil.getStringField(StringFieldKey.CollectionUtil_3));
			}
			return list.addAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(int, java.util.Collection)
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			if(CollectionUtil.conatinsNull(c)){
				throw new NullPointerException(
						DwarfUtil.getStringField(StringFieldKey.CollectionUtil_3));
			}
			return list.addAll(index, c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#removeAll(java.util.Collection)
		 */
		@Override
		public boolean removeAll(Collection<?> c) {
			return list.removeAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#retainAll(java.util.Collection)
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			return list.retainAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#clear()
		 */
		@Override
		public void clear() {
			list.clear();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#get(int)
		 */
		@Override
		public E get(int index) {
			return list.get(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#set(int, java.lang.Object)
		 */
		@Override
		public E set(int index, E element) {
			Objects.requireNonNull(element, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			return list.set(index, element);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(int, java.lang.Object)
		 */
		@Override
		public void add(int index, E element) {
			Objects.requireNonNull(element, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_1));
			list.add(index, element);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(int)
		 */
		@Override
		public E remove(int index) {
			return list.remove(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(Object o) {
			return list.indexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#lastIndexOf(java.lang.Object)
		 */
		@Override
		public int lastIndexOf(Object o) {
			return list.lastIndexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return list.listIterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return list.listIterator(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#subList(int, int)
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return new NonNullList<E>(list.subList(fromIndex, toIndex));
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return list.toString();
		}
		
	}
	
	/**
	 * ��ָ��ӳ��Ļ����ϻ�ò������� <code>null</code> Ԫ�ص�ӳ�䡣
	 * <p> ��õ�ӳ���ת��ָ����ӳ���еķ�������ˣ���õ�ӳ��ı�����ָ����ӳ����һ�µġ�
	 * <p> ��ע�⣬��ڲ��������ǿյģ���Ϊ�ǿյĲ��������Ѿ������� <code>null</code>����
	 * <br> ��õ�ӳ�䲻�������к���null������ˣ��κ���ͼ��������� <code>null</code>��
	 * �ķ��������׳��쳣��
	 * @param map ת�˵�ӳ�䡣
	 * @param <K> ����K��
	 * @param <V> ����V��
	 * @return �������� <code>null</code> ����ӳ�䡣
	 * @throws NullPointerException ����ڲ���Ϊ <code>null</code> ʱ�׳����쳣��
	 * @throws IllegalArgumentException ����ڵĲ������ǿյ�ʱ���׳����쳣��
	 */
	public static<K, V> Map<K, V> nonNullMap(Map<K, V> map){
		Objects.requireNonNull(map, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_5));
		if(!map.isEmpty()){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.CollectionUtil_8));
		}
		return new NonNullMap<K, V>(map);
	}
	
	private static final class NonNullMap<K, V> implements Map<K, V>{

		private final Map<K, V> map;
		
		public NonNullMap(Map<K, V> map) {
			this.map = map;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Map#size()
		 */
		@Override
		public int size() {
			return map.size();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return map.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#containsKey(java.lang.Object)
		 */
		@Override
		public boolean containsKey(Object key) {
			return map.containsKey(key);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#containsValue(java.lang.Object)
		 */
		@Override
		public boolean containsValue(Object value) {
			return map.containsValue(value);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#get(java.lang.Object)
		 */
		@Override
		public V get(Object key) {
			return map.get(key);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public V put(K key, V value) {
			Objects.requireNonNull(key, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_6));
			return map.put(key, value);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#remove(java.lang.Object)
		 */
		@Override
		public V remove(Object key) {
			return map.remove(key);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#putAll(java.util.Map)
		 */
		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			Objects.requireNonNull(m, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_7));
			if(CollectionUtil.conatinsNull(m.keySet())){
				throw new NullPointerException(
						DwarfUtil.getStringField(StringFieldKey.CollectionUtil_6));
			}
			map.putAll(m);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#clear()
		 */
		@Override
		public void clear() {
			map.clear();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#keySet()
		 */
		@Override
		public Set<K> keySet() {
			return map.keySet();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#values()
		 */
		@Override
		public Collection<V> values() {
			return map.values();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Map#entrySet()
		 */
		@Override
		public Set<java.util.Map.Entry<K, V>> entrySet() {
			return map.entrySet();
		}
		
	}
	
	/**
	 * ���ָ���ļ������Ƿ��� <code>null</code>Ԫ�ء�
	 * @param collection ָ���ļ��ϡ�
	 * @return �Ƿ��� <code>null</code>Ԫ�ء�
	 * @throws NullPointerException ����ڲ���Ϊ <code>null</code>ʱ��
	 */
	public static boolean conatinsNull(Collection<?> collection){
		Objects.requireNonNull(collection, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_2));
		for(Object obj : collection){
			if(Objects.isNull(obj)) return true;
		}
		return false;
	}
	
	/**
	 * Ҫ��ָ���ļ��ϲ��ܺ��� <code>null</code>Ԫ�ء�
	 * <p> ���ָ���� <code>collection</code>�к��� <code>null</code>Ԫ�أ�
	 * ���׳� {@link NullPointerException}��
	 * @param collection  ָ���ļ���Ԫ�ء�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws NullPointerException <code>collection</code> �к��� <code>null</code>Ԫ�ء�
	 */
	public static void requireNotContainsNull(Collection<?> collection){
		Objects.requireNonNull(collection, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_2));
		if(conatinsNull(collection)) throw new NullPointerException();
	}
	
	/**
	 * Ҫ��ָ���ļ��ϲ��ܺ��� <code>null</code>Ԫ�ء�
	 * <p> ���ָ���� <code>collection</code>�к��� <code>null</code>Ԫ�أ�
	 * ���׳�ӵ��ָ���쳣��Ϣ�� {@link NullPointerException}��
	 * @param collection ָ���ļ���Ԫ�ء�
	 * @param message ָ�����쳣��Ϣ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws NullPointerException <code>collection</code> �к��� <code>null</code>Ԫ�ء�
	 */
	public static void requireNotContainsNull(Collection<?> collection, String message){
		Objects.requireNonNull(collection, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_2));
		if(conatinsNull(collection)) throw new NullPointerException(message);
	}
	
	private static final class EnumerationIterator<T> implements Iterator<T>{

		private final Enumeration<T> enumeration;
		
		public EnumerationIterator(Enumeration<T> enumeration) {
			this.enumeration = enumeration;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return enumeration.hasMoreElements();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			return enumeration.nextElement();
		}
		
	}
	
	/**
	 * ͨ��ָ���� {@link Enumeration} ���ɵ� {@link Iterator}��
	 * @param enumeration ָ����ö�١�
	 * @param <T> ����T��
	 * @return ͨ��ָ����ö�����ɵĵ�������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static<T> Iterator<T> enumeration2Iterator(Enumeration<T> enumeration){
		Objects.requireNonNull(enumeration, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_9));
		return new EnumerationIterator<>(enumeration);
	}
	
	private static final class IteratorEnumeration<T> implements Enumeration<T>{

		private final Iterator<T> iterator;
		
		public IteratorEnumeration(Iterator<T> iterator) {
			this.iterator = iterator;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Enumeration#hasMoreElements()
		 */
		@Override
		public boolean hasMoreElements() {
			return iterator.hasNext();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public T nextElement() {
			return iterator.next();
		}
		
	}
	
	/**
	 * ͨ��ָ���� {@link Iterator} ���ɵ� {@link Enumeration}��
	 * @param iterator ָ���ĵ�������
	 * @param <T> ����T��
	 * @return ͨ��ָ���ĵ��������ɵ�ö�١�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static<T> Enumeration<T> iterator2Enumeration(Iterator<T> iterator){
		Objects.requireNonNull(iterator, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_10));
		return new IteratorEnumeration<>(iterator);
	}
	
	/**
	 * <p>��һ������ת��Ϊһ����������
	 * <p> ��Ȼ�������ʹ�� for-each ѭ�����������鲻������Ϊ {@link Iterable} ������в������ݣ��÷���Ϊ�˽����һ���⣬
	 * ���Խ�һ������ת��Ϊһ�� {@link Iterator}���󣬷���ĳЩ��Ҫ����������ĳ��ϡ�
	 * @deprecated �÷����Ĺ�����ù��߰��Ĺ��ܲ������Ѿ�ֹͣʹ�ã����������Ƶķ��� {@link ArrayUtil#array2Iterable(Object[])}���档
	 * @param array ָ�������顣
	 * @param <T> ����T��
	 * @return ��ָ��������ת�����ɵĵ�������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	@Deprecated
	public static<T> Iterator<T> array2Iterator(T[] array){
		Objects.requireNonNull(array, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_11));
		return ArrayUtil.array2Iterable(array).iterator();
	}
	
	/**
	 * ��������������������
	 * <p> �µĵ��������ȵ��� <code>firstIterator</code>�е�Ԫ�أ������е�Ԫ�ص�����֮�󣬼�������
	 * <code>secondIterator</code>�е�Ԫ�أ�ֱ�������������е�Ԫ��ȫ��������ɡ�
	 * @param firstIterator ��һ����������
	 * @param secondIterator �ڶ�����������
	 * @param <T> ����T��
	 * @return ���������������γɵĵ�������
	 */
	public static<T> Iterator<T> contactIterator(Iterator<T> firstIterator, Iterator<T> secondIterator){
		Objects.requireNonNull(firstIterator, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_13));
		Objects.requireNonNull(secondIterator, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_14));
		return new JointIterator.Builder<T>()
				.append(firstIterator)
				.append(secondIterator)
				.build();
	}
	
	/**
	 * ��ָ���Ķ�����˳����뵽ָ���ı��С�
	 * <p> �÷�������ָ���ıȽ�������Ƚ�ָ���Ķ������б��еĶ��󣬲���ָ���Ķ�����뵽�б���<b>��һ��</b>���ڵ������Ԫ��֮ǰ��
	 * �����ز����λ�á�
	 * <br> ���ָ�����б���֮ǰ�Ѿ����ձȽ�����˳�����кã���ô���ø÷���֮�󣬴��б���Ȼ��ѭ�Ƚ�����˳��
	 * ��ʵ�ϣ��÷�������Ϊ����Ƶġ�����һ��û��������б���ô˷�����û������ġ�
	 * <br> ��Щ�б����� <code>null</code>Ԫ�أ���Щ������������Щ���� <code>null</code>Ԫ�صĵ��б���ע�⣺
	 * ָ���ıȽ���Ҳ��Ҫ֧�� <code>null</code>Ԫ�ء�
	 * @param <T> �б��е�Ԫ�ص��ࡣ
	 * @param list ָ�����б�
	 * @param obj ָ���Ķ�������Ϊ <code>null</code>��������Ҫ�б�ͱȽ���֧�� <code>null</code>Ԫ�ء�
	 * @param c ָ���ıȽ�����
	 * @return ����Ĳ���λ�á�
	 */
	public static<T> int insertByOrder(List<T> list, T obj, Comparator<? super T> c){
		Objects.requireNonNull(list, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_15));
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.CollectionUtil_16));
		
		for(int i = 0 ; i < list.size() ; i ++){
			T t = list.get(i);
			if(c.compare(obj, t) <= 0){
				list.add(i, obj);
				return i;
			}
		}
		list.add(obj);
		return list.size() - 1;
	}
}
