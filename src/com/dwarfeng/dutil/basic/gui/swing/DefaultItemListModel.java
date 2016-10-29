package com.dwarfeng.dutil.basic.gui.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * ����Ĭ����Ŀ���б�ģ�͡�
 * <p> ��ģ�͵�ʹ�÷�Χ��һЩ����Ĭ��ѡ��� Combobox ����Ĭ����Ŀ�� List�����磺��һ����Ա����ѡ����ѡ���г��˾��и�����Ա����Ŀ֮�⣬����
 * ��һ����ӵ��һ��Ĭ����Ŀ��ѡ��������Ա��ȫѡ������
 * <br> ���б�ģ��������������ɣ�Ĭ����Ŀ��һ����Ŀ����Ȼ��ģ�Ͳ���һ��ֱ�ӵ� {@link List}ʵ�֣��������е�Ĭ����Ŀ��һ����Ŀ��Ϊ 
 * {@link List}ʵ�֡��ڸ�ģ���У�Ĭ����Ŀ��һ����Ŀ��������Ĭ����Ŀʼ����һ����Ŀ�Ϸ���
 * <br> Ĭ����Ŀ��һ����Ŀ��������Ϊ {@link List}���أ����ֱ���в�������ģ��Ҳ�ṩ��ֱ�ӵĲ�����������Щֱ�ӵĲ����������ܹ�����һ����Ŀ��
 * <p> �������ͨ��ָ����ڵĲ�������֤�б�Ĳ�ͬʵ�֣�����ͬ���б���Ϊʵ�־Ϳ��Ա�֤���з�����ͬ����
 * <p> �����ָ���κ�Ĭ��Ԫ�أ���ģ�͵�ͬ�� {@link DefaultListModel}��
 * @author  DwArFeng
 * @since 1.8
 */
public class DefaultItemListModel<E> extends AbstractListModel<E> {

	/**Ĭ����Ŀ�б�*/
	protected final DefalutItemList defaultItemList;
	/**һ����Ŀ�б�*/
	protected final NormalItemList normalItemList;
	
	/**
	 * ����һ��ʹ�� {@link ArrayList}ʵ�ֵ�Ĭ����Ŀ�б�ģ�͡�
	 */
	public DefaultItemListModel() {
		this(new ArrayList<E>(), new ArrayList<E>());
	}
	
	/**
	 * ����һ������ָ��ʵ�ֵ�Ĭ����Ŀ�б�ģ�͡�
	 * @param defalutDelegate Ĭ����Ŀ���б�ʵ�֡�
	 * @param normalDelegate һ����Ŀ���б�ʵ�֡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultItemListModel(List<E> defalutDelegate, List<E> normalDelegate) {
		this.defaultItemList = new DefalutItemList(defalutDelegate);
		this.normalItemList = new NormalItemList(normalDelegate);
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize() {
		return defaultItemList.size() + normalItemList.size();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public E getElementAt(int index) {
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			return defaultItemList.get(index);
		}else{
			return normalItemList.get(index - defaultSize); 
		}
	}
	
	/**
	 * �ڴ��б��ָ��λ�ô�����ָ����Ԫ�ء�
	 *<p> �������������Χ<code>��index < 0 || index > size()��</code>�����׳� ArrayIndexOutOfBoundsException��
	 * @param index ָ��Ԫ�صĲ���λ�õ�������
	 * @param element Ҫ�����Ԫ�ء�
	 */
	public void add(int index, E element){
		//TODO
	}
	
	/**
	 * ��ָ�������ӵ�������ĩβ��
	 * @param element Ҫ��ӵ������
	 */
	public void addElement(E element){
		//TODO
	}
	
	/**
	 * ���ش��б�ĵ�ǰ������ 
	 * <p> �÷����� {@link #getSize()}������ͬ��ʵ�����������Ϊ�˱�֤�� {@link DefaultListModel}�еķ���һ�¡�
	 * @return ��ǰ������
	 */
	public int capacity(){
		return getSize();
	}
	
	/**
	 * �Ӵ��б����Ƴ�����һ��Ԫ�ء��˵��÷��غ�һ��Ԫ���б��ǿյģ���Ĭ��Ԫ���б������������Ǹõ����׳��쳣���� 
	 */
	public void clear(){
		normalItemList.clear();
	}
	
	/**
	 * ����ָ�������Ƿ�Ϊ������е������
	 * @param elem ����
	 * @return ���ָ�������Ǵ��б��е�������򷵻� <code>true</code>��
	 */
	public boolean contains(Object elem){
		return defaultItemList.contains(elem) || normalItemList.contains(elem);
	}
	
	/**
	 * �����б��������Ƶ�ָ�������С���������㹻���ܹ�������б��е����ж��󣬷����׳� IndexOutOfBoundsException�� 
	 * @param anArray Ҫ��������Ƶ����е����顣
	 */
	public void copyInto(Object[] anArray){
		//TODO
	}
	
	/**
	 * ����ָ����������������������Ϊ����С���б�Ĵ�С�����׳� ArrayIndexOutOfBoundsException�� 
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� get(int)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ�
	 * @param index ���б��е�һ��������
	 * @return ָ���������������
	 */
	public E elementAt(int index){
		return get(index);
	}
	
	/**
	 * ���ش��б�����ö�١� 
	 * @return ���б�����ö�١�
	 */
	public Enumeration<E> elements(){
		//TODO
		return null;
	}

	/**
	 * �÷�����ʵ���κζ�����ʵ�����������Ϊ�˱�֤�� {@link DefaultListModel}�еķ���һ�¡�
	 * @param minCapacity the minCapacity.
	 */
	public void ensureCapacity(int minCapacity){}
	
	/**
	 * ����һ���б��еĵ�һ����������������û����������׳� NoSuchElementException�� 
	 * @return ���б�ĵ�һ�������
	 */
	public E firstElement(){
		if(getSize() == 0) throw new NoSuchElementException();
		return getElementAt(0);
	}
	
	/**
	 * �����б���ָ��λ�ô���Ԫ�ء� 
	 * <p> �������������Χ<code>��index < 0 || index >= size()��</code>�����׳� ArrayIndexOutOfBoundsException�� 
	 * @param index Ҫ���ص�Ԫ�ص�������
	 * @return ָ��λ�ô���Ԫ�ء�
	 */
	public E get(int index){
		return getElementAt(index);
	}
	
	/**
	 * ���� elem �ĵ�һ�γ��֡� 
	 * @param elem һ������
	 * @return ���б��иò�����һ�γ���ʱ����λ���ϵ����������û���ҵ��ö����򷵻� <code>-1</code>��
	 */
	public int indexOf(Object elem){
		int def = defaultItemList.indexOf(elem);
		int nor = normalItemList.indexOf(elem);
		
		if(def == -1 && nor == -1) return -1;
		if(def >= 0) return def;
		
		int defalutSize = defaultItemList.size();
		return defalutSize + nor;
	}

	/**
	 * �� index ��ʼ���� elem �ĵ�һ�γ��֡� 
	 * @param elem ����������
	 * @param index �������ڵ�λ�ÿ�ʼ����������������
	 * @return ֮���һ�γ��� elem ����������������б���û���ҵ� elem���򷵻� <code>-1</code>��
	 */
	public int indexOf(Object elem, int index){
		for(int i = index ; i < getSize() ; i ++){
			Object o = getElementAt(i);
			if(Objects.isNull(o) && Objects.isNull(elem)) return i;
			if(Objects.nonNull(o) && o.equals(elem)) return i;
		}
		return -1;
	}
	
	/**
	 * ��ָ��������Ϊ���б��е�������뵽ָ���� index ���� 
	 * <p> ���������Ч�����׳� ArrayIndexOutOfBoundsException�� 
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� add(int,Object)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ� 
	 * @param obj Ҫ����������
	 * @param index �����������λ�� ��
	 * @throws IllegalArgumentException ���С�ڵ�һ��һ����Ŀ����š�
	 */
	public void insertElementAt(E obj, int index){
		int defalutSize = defaultItemList.size();
		if(index < defalutSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_0));
		}
		normalItemList.add(index - defalutSize, obj);
	}
	
	/**
	 * ���Դ��б����Ƿ�������� 
	 * @return ���ҽ������б���û�������Ҳ����˵���СΪ�㣩ʱ���� true�����򷵻� false��
	 */
	public boolean isEmpty(){
		return defaultItemList.isEmpty() && normalItemList.isEmpty();
	}
	
	/**
	 * �����б�����һ����������������û����������׳� NoSuchElementException�� 
	 * @return �б�����һ�������
	 */
	public E lastElement(){
		if(getSize() == 0) throw new NoSuchElementException();
		return getElementAt(getSize()-1);
	}
	
	/**
	 * ���� elem ���һ�γ��ִ���������
	 * @param elem ����������
	 * @return �б��� elem ���һ�γ��ִ������������û���ҵ��ö����򷵻�<code>-1</code>��
	 */
	public int lastIndexOf(Object elem){
		for(int i = getSize() ; i >= 0 ; i--){
			Object o = getElementAt(i);
			if(Objects.isNull(o) && Objects.isNull(elem)) return i;
			if(Objects.nonNull(o) && o.equals(elem)) return i;
		}
		return -1;
	}
	
	/**
	 * ��ָ������������ʼ�������� elem�������ظö����������
	 * @param elem ����������
	 * @param index �������ڵ�λ�ÿ�ʼ�������������� ��
	 * @return �б��� index ֮ǰ���һ�γ��� elem ����������������б���û���ҵ��ö����򷵻� <code>-1</code>��
	 */
	public int lastIndexOf(Object elem, int index){
		for(int i = index ; i >= 0 ; i --){
			Object o = getElementAt(i);
			if(Objects.isNull(o) && Objects.isNull(elem)) return i;
			if(Objects.nonNull(o) && o.equals(elem)) return i;
		}
		return -1;
	}
	
	/**
	 * �Ƴ����б���ָ��λ�ô���Ԫ�ء����ش��б����Ƴ���Ԫ�ء�
	 * <p> �������������Χ<code>��index < 0 || index >= size()��</code>>�����׳� ArrayIndexOutOfBoundsException��
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param index Ҫ�Ƴ���Ԫ�ص�������
	 * @return ���ص�Ԫ�ء�
	 */
	public E remove(int index){
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_1));
		}
		return normalItemList.remove(index - defaultSize);
	}
	
	/**
	 * �Ӵ��б����Ƴ�����������������ǵĴ�С����Ϊ�㡣 
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� clear���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ�
	 */
	public void removeAllElements(){
		clear();
	}
	
	/**
	 * �Ӵ��б����Ƴ������ĵ�һ����������С�ģ�ƥ��� 
	 * @param obj Ҫ�Ƴ������ ��
	 * @return ����ò����Ǵ��б��һ��������򷵻� <code>true</code>�����򷵻� <code>false</code>��
	 */
	public boolean removeElement(Object obj){
		return normalItemList.remove(obj);
	}
	
	/**
	 * ɾ��ָ��������������� 
	 * <p> ���������Ч�����׳� ArrayIndexOutOfBoundsException�� 
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� remove(int)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ� 
	 * @param index Ҫ�Ƴ����������
	 */
	public void removeElementAt(int index){
		remove(index);
	}
	
	/**
	 * ɾ��ָ��������Χ�е�������Ƴ��������ָ����Χ�����˵㴦�������
	 * <p> ���������Ч�����׳� ArrayIndexOutOfBoundsException����� <code>fromIndex > toIndex</code>�����׳� IllegalArgumentException��
	 * <p> �������а���С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param fromIndex ��Χ�Ͷ˵��������
	 * @param toIndex ��Χ�߶˵��������
	 */
	public void removeRange(int fromIndex, int toIndex){
		int defaultSize = defaultItemList.size();
		if(fromIndex < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_1));
		}
		for(int i = fromIndex ; i <= toIndex ; i ++){
			remove(i);
		}
	}
	
	/**
	 * ʹ��ָ��Ԫ���滻���б���ָ��λ���ϵ�Ԫ�ء� 
	 * <p> �������������Χ<code>��index < 0 || index >= size()��</code>�����׳� ArrayIndexOutOfBoundsException��
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param index Ҫ�滻��Ԫ�ص�������
	 * @param element Ҫ�洢��ָ��λ���ϵ�Ԫ�ء�
	 * @return ��ǰ��ָ��λ���ϵ�Ԫ�ء�
	 */
	public E set(int index,E element){
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_2));
		}
		return normalItemList.set(index - defaultSize, element);
	}
	
	/**
	 * 
	 * @param obj
	 * @param index
	 */
	public void setElementAt(Object obj, int index){
		//TODO
	}
	
	/**
	 * �÷�����ʵ���κζ�����ʵ�����������Ϊ�˱�֤�� {@link DefaultListModel}�еķ���һ�¡�
	 * @param newSize the newSize��
	 */
	public void setSize(int newSize){}
	
	/**
	 * ���ش��б��е��������
	 * @return ���б��е��������
	 */
	public int size(){
		return getSize();
	}
	
	/**
	 * 
	 * @return
	 */
	public Object[] toArray(){
		//TODO
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		//TODO
		return "";
	}
	
	/**
	 * �÷�����ʵ���κζ�����ʵ�����������Ϊ�˱�֤�� {@link DefaultListModel}�еķ���һ�¡�
	 */
	public void trimToSize(){}
	
	/**
	 * ��ȡ��һ��һ����Ŀ���ڵ���š�
	 * @return ��һ��һ����Ŀ���ڵ���š�
	 */
	public int getFirstNormalItemIndex(){
		return defaultItemList.size();
	}


	private final class NormalItemList implements List<E> {
		
		private final List<E> delegate;
		
		public NormalItemList(List<E> delegate) {
			this.delegate = delegate;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(E e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public E get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E set(int index, E element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, E element) {
			// TODO Auto-generated method stub

		}

		@Override
		public E remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private final class DefalutItemList implements List<E> {

		private final List<E> delegate;
		
		public DefalutItemList(List<E> delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(E e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public E get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public E set(int index, E element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, E element) {
			// TODO Auto-generated method stub

		}

		@Override
		public E remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<E> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<E> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
