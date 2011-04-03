package com.dwarfeng.dutil.basic.gui.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.cna.CollectionUtil;

/**
 * ����Ĭ����Ŀ���б�ģ�͡�
 * <p> ��ģ�͵�ʹ�÷�Χ��һЩ����Ĭ��ѡ��� Combobox ����Ĭ����Ŀ�� List�����磺��һ����Ա����ѡ����ѡ���г��˾��и�����Ա����Ŀ֮�⣬����
 * ��һ����ӵ��һ��Ĭ����Ŀ��ѡ��������Ա��ȫѡ������
 * <br> ���б�ģ��������������ɣ�Ĭ����Ŀ��һ����Ŀ����Ȼ��ģ�Ͳ���һ��ֱ�ӵ� {@link List}ʵ�֣��������е�Ĭ����Ŀ��һ����Ŀ��Ϊ 
 * {@link List}ʵ�֡��ڸ�ģ���У�Ĭ����Ŀ��һ����Ŀ��������Ĭ����Ŀʼ����һ����Ŀ�Ϸ���
 * <br> Ĭ����Ŀ��һ����Ŀ��������Ϊ {@link List}���أ����ֱ���в�������ģ��Ҳ�ṩ��ֱ�ӵĲ�����������Щֱ�ӵĲ����������ܹ�����һ����Ŀ��
 * �磺��Ӳ���ֻ�ܶ�һ��Ԫ�ؽ��в����������Ĭ��Ԫ�����ڵ�������в����������ᱻ�����ܾ�����ղ���ֻ�ܽ�һ��Ԫ����գ���Ĭ��Ԫ���򲻻�ı䡣
 * <br> ����Ĭ��Ԫ�صķ����ǣ�ʹ�� {@link #getDefaultList()}��ȡĬ��Ԫ�����ڵ��б�Ȼ����б���в�����
 * <p> �������ͨ��ָ����ڵĲ�������֤�б�Ĳ�ͬʵ�֣�����ͬ���б���Ϊʵ�־Ϳ��Ա�֤���з�����ͬ����
 * <p> �����ָ���κ�Ĭ��Ԫ�أ���ģ�͵�ͬ�� {@link DefaultListModel}��
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultItemListModel<E> extends AbstractListModel<E> implements Iterable<E>{
	
	private static final long serialVersionUID = 8547542339038946434L;
	
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
		Objects.requireNonNull(defalutDelegate);
		Objects.requireNonNull(normalDelegate);
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
		if(index <0 || index >= getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			return defaultItemList.get(index);
		}else{
			return normalItemList.get(index - defaultSize); 
		}
	}
	
	/**
	 * �ڴ��б��ָ��λ�ô�����ָ����Ԫ�ء�
	 *<p> �������������Χ <code>��index &lt; 0 || index &gt; size()��</code>�����׳� IndexOutOfBoundsException��
	 *<p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param index ָ��Ԫ�صĲ���λ�õ�������
	 * @param element Ҫ�����Ԫ�ء�
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 * @throws IllegalArgumentException ��ͼ��Ĭ��Ԫ���������Ԫ�ء�
	 */
	public void add(int index, E element){
		if(index < 0 || index > getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		
		int defalutSize = defaultItemList.size();
		if(index < defalutSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_0));
		}
		normalItemList.delegate.add(index - defalutSize, element);
		fireIntervalAdded(this, index, index);
	}
	
	/**
	 * ��ָ�������ӵ�������ĩβ��
	 * @param element Ҫ��ӵ������
	 */
	public void addElement(E element){
		int index = getSize();
		normalItemList.delegate.add(element);
		fireIntervalAdded(this, index, index);
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
		int index0 = defaultItemList.size();
		int index1 = getSize() - 1;
		normalItemList.delegate.clear();
		fireIntervalRemoved(this, index0, index1);
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
	 * @throws IndexOutOfBoundsException ���鲻���������ڲ��ܷ������ж���
	 */
	public void copyInto(Object[] anArray){
		Objects.requireNonNull(anArray, DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_5));
		if(anArray.length < getSize()){
			throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_6));
		}
		Object[] def = defaultItemList.toArray();
		Object[] nor = normalItemList.toArray();
		System.arraycopy(def, 0, anArray, 0, def.length);
		System.arraycopy(nor, 0, anArray, def.length, nor.length);
	}
	
	/**
	 * ����ָ����������������������Ϊ����С���б�Ĵ�С�����׳� IndexOutOfBoundsException�� 
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� get(int)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ�
	 * @param index ���б��е�һ��������
	 * @return ָ���������������
	 */
	public E elementAt(int index){
		return getElementAt(index);
	}
	
	/**
	 * ���ش��б�����ö�١� 
	 * @return ���б�����ö�١�
	 */
	public Enumeration<E> elements(){
		return CollectionUtil.iterator2Enumeration(iterator());
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
	 * <p> �������������Χ<code>��index &lt; 0 || index &gt;= size()��</code>�����׳� IndexOutOfBoundsException�� 
	 * @param index Ҫ���ص�Ԫ�ص�������
	 * @return ָ��λ�ô���Ԫ�ء�
	 * @throws IndexOutOfBoundsException �±�Խ�硣
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
	 * <p> ���������Ч�����׳� IndexOutOfBoundsException�� 
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� add(int,Object)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ� 
	 * @param obj Ҫ����������
	 * @param index �����������λ�� ��
	 * @throws IllegalArgumentException ���С�ڵ�һ��һ����Ŀ����š�
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public void insertElementAt(E obj, int index){
		add(index, obj);
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
		for(int i = getSize() - 1 ; i >= 0 ; i--){
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
	 * <p> �������������Χ<code>��index &lt; 0 || index &gt;= size()��</code>�����׳� IndexOutOfBoundsException��
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param index Ҫ�Ƴ���Ԫ�ص�������
	 * @return ���ص�Ԫ�ء�
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public E remove(int index){
		if(index < 0 || index >= getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_1));
		}
		E e = normalItemList.delegate.remove(index - defaultSize);
		fireIntervalRemoved(this, index, index);
		return e;
	}
	
	/**
	 * �Ӵ��б����Ƴ�����������������ǵĴ�С����Ϊ�㡣 
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� clear���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ�
	 */
	public void removeAllElements(){
		clear();
	}
	
	/**
	 * ��һ���б����Ƴ������ĵ�һ����������С�ģ�ƥ��� 
	 * @param obj Ҫ�Ƴ������ ��
	 * @return ����ò�����һ���б��һ��������򷵻� <code>true</code>�����򷵻� <code>false</code>��
	 */
	public boolean removeElement(Object obj){
		int index = normalItemList.indexOf(obj);
		boolean flag = normalItemList.delegate.remove(obj);
		if(flag){
			fireIntervalRemoved(this, index + defaultItemList.size(), index + defaultItemList.size());
		}
		return flag;
	}
	
	/**
	 * ɾ��ָ��������������� 
	 * <p> ���������Ч�����׳� IndexOutOfBoundsException�� 
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� remove(int)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ� 
	 * @param index Ҫ�Ƴ����������
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 * @throws IllegalArgumentException �±�����Ĭ����Ŀ����
	 */
	public void removeElementAt(int index){
		remove(index);
	}
	
	/**
	 * ɾ��ָ��������Χ�е�������Ƴ��������ָ����Χ�����˵㴦�������
	 * <p> ���������Ч�����׳� IndexOutOfBoundsException����� <code>fromIndex &gt; toIndex</code>�����׳� IllegalArgumentException��
	 * <p> �������а���С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param fromIndex ��Χ�Ͷ˵��������
	 * @param toIndex ��Χ�߶˵��������
	 * @throws IndexOutOfBoundsException �±�Խ��
	 * @throws IllegalArgumentException �±������а�������Ĭ����Ŀ������±ꡣ
	 */
	public void removeRange(int fromIndex, int toIndex){
		int defaultSize = defaultItemList.size();
		if(fromIndex < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_1));
		}
		if(fromIndex < 0 ){
			throw new IndexOutOfBoundsException(String.valueOf(fromIndex));
		}
		if(toIndex >= getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(toIndex));
		}
		for(int i = fromIndex ; i <= toIndex ; i ++){
			normalItemList.delegate.remove(fromIndex - defaultSize);
		}
		fireIntervalRemoved(this, fromIndex, toIndex);
	}
	
	/**
	 * ʹ��ָ��Ԫ���滻���б���ָ��λ���ϵ�Ԫ�ء� 
	 * <p> �������������Χ<code>��index &lt; 0 || index &gt;= size()��</code>�����׳� IndexOutOfBoundsException��
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * @param index Ҫ�滻��Ԫ�ص�������
	 * @param element Ҫ�洢��ָ��λ���ϵ�Ԫ�ء�
	 * @return ��ǰ��ָ��λ���ϵ�Ԫ�ء�
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 * @throws IllegalArgumentException �±�����Ĭ����Ŀ����
	 * @throws IndexOutOfBoundsException �±�ԽԽ�硣
	 */
	public E set(int index,E element){
		if(index < 0 || index >= getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		int defaultSize = defaultItemList.size();
		if(index < defaultSize){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultListItemModel_2));
		}
		E e = normalItemList.delegate.set(index - defaultSize, element);
		fireContentsChanged(this, index, index);
		return e;
	}
	
	/**
	 * �����б�ָ�� index �����������Ϊָ���Ķ��󡣶�����λ����ǰ������� 
	 * <p> ���������Ч�����׳� IndexOutOfBoundsException�� 
	 * <p> ������С�ڵ�һ��һ����Ŀ����ţ�����׳� {@link IllegalArgumentException};
	 * <p> ע�����ܴ˷���δ��ʱ������ѡʹ�÷����� set(int,Object)���÷���ʵ�� 1.2 Collections ����ж���� List �ӿڡ� 
	 * @param obj ���������Ŀ�ꡣ
	 * @param index ָ����������
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 * @throws IllegalArgumentException �±�����Ĭ����Ŀ����
	 */
	public void setElementAt(E obj, int index){
		set(index, obj);
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
	 * ����ȷ˳�򷵻ذ���Ĭ���б��Լ�һ���б�������Ԫ�ص����顣 
	 * @return �����б�Ԫ�ص����顣
	 */
	public Object[] toArray(){
		Object[] arr1 = defaultItemList.toArray();
		Object[] arr2 = normalItemList.toArray();
		return ArrayUtil.concat(arr1, arr2);
	}
	
	/**
	 * ����ȷ˳�򷵻ذ���Ĭ���б��Լ�һ���б�������Ԫ�ص����顣
	 * �������������ʱ������ָ�����������ʱ���͡����ָ���������������б��򽫸��б��ش˴���
	 * ���򣬽�����һ������ָ�����������ʱ���ͺʹ��б��С�������顣
	 * <p> ���ָ�������������ɶ��У�����ʣ��Ŀռ䣨�������Ԫ�رȶ��жࣩ����ô�Ὣ�����н��� collection β����Ԫ������Ϊ null��
	 * ���� �ڵ�����֪���б��в������κ� null Ԫ��ʱ�����ô˷���ȷ���б��ȣ���  
	 * @param a  Ҫ�����д洢�б�Ԫ�ص����飨������㹻�󣩣�����Ϊ�˷���һ��������ͬ����ʱ���͵������顣
	 * @param <T> ����T�� 
	 * @return �����б�Ԫ�ص����顣
	 */
	public<T> T[] toArray(T[] a){
		T[] t1 = defaultItemList.toArray(a);
		T[] t2 = normalItemList.toArray(a);
		return ArrayUtil.concat(t1, t2);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		Iterator<E> it = iterator();
        if (! it.hasNext()) return "[]";
        
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(;;){
			E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return CollectionUtil.contactIterator(defaultItemList.iterator(), normalItemList.iterator());
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
	
	/**
	 * ��ѯһ��Ԫ���Ƿ���Ĭ��Ԫ�ء�
	 * <p> һ��Ԫ�ؿ���ͬʱ��Ĭ���б��һ���б�֮�䣬��˴������ֿ����ԣ�
	 * <br> <code> isDefaultItem(e) == isNormalItem(e) == true </code>��
	 * @param element ָ����Ԫ�ء�
	 * @return ָ����Ԫ���Ƿ���Ĭ��Ԫ�ء�
	 */
	public boolean isDefaultItem(Object element){
		return defaultItemList.contains(element);
	}
	
	/**
	 * ��ѯһ��Ԫ���Ƿ���Ĭ��Ԫ�ء�
	 * @param index Ԫ�ص���š�
	 * @return ���ָ���Ԫ���Ƿ���Ĭ��Ԫ�ء�
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public boolean isDefaultItem(int index){
		if(index < 0 || index >= getSize()){
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return index < defaultItemList.size();
	}
	
	/**
	 * ��ѯһ��Ԫ���Ƿ���һ��Ԫ�ء�
	 * <p> һ��Ԫ�ؿ���ͬʱ��Ĭ���б��һ���б�֮�䣬��˴������ֿ����ԣ�
	 * <br> <code> isDefaultItem(e) == isNormalItem(e) == true </code>��
	 * @param element ָ����Ԫ�ء�
	 * @return ָ����Ԫ���Ƿ���һ��Ԫ�ء�
	 */
	public boolean isNormalItem(Object element){
		return normalItemList.contains(element);
	}
	
	/**
	 * ��ȡĬ��Ԫ���б�
	 * <p> �Ը��б���и��Ŀ��Խ�Ч��������ӳ����ͼ�С����ǣ��ɸ��б�ͨ�� {@link List#subList(int, int)}�������ص�
	 * ���б����޷��ṩ��������������Ч����
	 * @return Ĭ��Ԫ���б�
	 */
	public List<E> getDefaultList(){
		return this.defaultItemList;
	}
	
	/**
	 * ��ȡһ��Ԫ���б�
	 * <p> �Ը��б���и��Ŀ��Խ�Ч��������ӳ����ͼ�С����ǣ��ɸ��б�ͨ�� {@link List#subList(int, int)}�������ص�
	 * ���б����޷��ṩ��������������Ч����
	 * @return һ��Ԫ���б�
	 */
	public List<E> getNormalList(){
		return this.normalItemList;
	}

	private final class NormalItemList implements List<E> {
		
		private final List<E> delegate;
		
		public NormalItemList(List<E> delegate) {
			this.delegate = delegate;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#size()
		 */
		@Override
		public int size() {
			return delegate.size();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(Object o) {
			return delegate.contains(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return delegate.iterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray()
		 */
		@Override
		public Object[] toArray() {
			return delegate.toArray();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray(java.lang.Object[])
		 */
		@Override
		public <T> T[] toArray(T[] a) {
			return delegate.toArray(a);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(java.lang.Object)
		 */
		@Override
		public boolean add(E e) {
			int index = size() + defaultItemList.size();
			boolean flag = delegate.add(e);
			if(flag) fireIntervalAdded(DefaultItemListModel.this, index, index);
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(java.lang.Object)
		 */
		@Override
		public boolean remove(Object o) {
			int index = defaultItemList.size() + indexOf(o);
			boolean flag = delegate.remove(o);
			if(flag) fireIntervalRemoved(DefaultItemListModel.this, index, index);
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#containsAll(java.util.Collection)
		 */
		@Override
		public boolean containsAll(Collection<?> c) {
			return delegate.containsAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(java.util.Collection)
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) {
			boolean flag = false;
			for(E e : c){
				if(add(e)) flag = true;
			}
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(int, java.util.Collection)
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			int size = size();
			int i = 0;
			for(E e : c){
				add(index + i, e);
				i ++;
			}
			return size() != size;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#removeAll(java.util.Collection)
		 */
		@Override
		public boolean removeAll(Collection<?> c) {
			boolean flag = false;
			for(Object obj : c){
				if(remove(obj)) flag = true;
			}
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#retainAll(java.util.Collection)
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			Set<E> set = new HashSet<E>();
			for(E e : this){
				if(!c.contains(e)){
					set.add(e);
				}
			}
			return removeAll(set);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#clear()
		 */
		@Override
		public void clear() {
			int lastIndex = defaultItemList.size() + size() - 1;
			delegate.clear();
			fireIntervalRemoved(DefaultItemListModel.this, 0, lastIndex);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#get(int)
		 */
		@Override
		public E get(int index) {
			return delegate.get(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#set(int, java.lang.Object)
		 */
		@Override
		public E set(int index, E element) {
			int aIndex = index + defaultItemList.size();
			E e = delegate.set(index, element);
			fireContentsChanged(DefaultItemListModel.this, aIndex, aIndex);
			return e;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(int, java.lang.Object)
		 */
		@Override
		public void add(int index, E element) {
			int size = size();
			int aIndex = index + defaultItemList.size();
			delegate.add(index, element);
			if(size() != size) fireIntervalAdded(DefaultItemListModel.this, aIndex, aIndex);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(int)
		 */
		@Override
		public E remove(int index) {
			int aIndex = index + defaultItemList.size();
			E e = delegate.remove(index);
			fireIntervalRemoved(DefaultItemListModel.this, aIndex, aIndex);
			return e;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(Object o) {
			return delegate.indexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#lastIndexOf(java.lang.Object)
		 */
		@Override
		public int lastIndexOf(Object o) {
			return delegate.lastIndexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return delegate.listIterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return delegate.listIterator(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#subList(int, int)
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return delegate.subList(fromIndex, toIndex);
		}

	}

	private final class DefalutItemList implements List<E> {

		private final List<E> delegate;
		
		public DefalutItemList(List<E> delegate) {
			this.delegate = delegate;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.List#size()
		 */
		@Override
		public int size() {
			return delegate.size();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#contains(java.lang.Object)
		 */
		@Override
		public boolean contains(Object o) {
			return delegate.contains(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#iterator()
		 */
		@Override
		public Iterator<E> iterator() {
			return delegate.iterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray()
		 */
		@Override
		public Object[] toArray() {
			return delegate.toArray();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#toArray(java.lang.Object[])
		 */
		@Override
		public <T> T[] toArray(T[] a) {
			return delegate.toArray(a);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(java.lang.Object)
		 */
		@Override
		public boolean add(E e) {
			boolean flag = delegate.add(e);
			int index = size();
			if(flag) fireIntervalAdded(DefaultItemListModel.this, index, index);
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(java.lang.Object)
		 */
		@Override
		public boolean remove(Object o) {
			int index = this.indexOf(o);
			boolean flag = delegate.remove(o);
			if(flag) fireIntervalRemoved(DefaultItemListModel.this, index, index);
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#containsAll(java.util.Collection)
		 */
		@Override
		public boolean containsAll(Collection<?> c) {
			return delegate.containsAll(c);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(java.util.Collection)
		 */
		@Override
		public boolean addAll(Collection<? extends E> c) {
			boolean flag = false;
			for(E e : c){
				if(add(e)) flag = true;
			}
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#addAll(int, java.util.Collection)
		 */
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			int size = size();
			int i = 0;
			for(E e : c){
				add(index + i, e);
				i ++;
			}
			return size() != size;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#removeAll(java.util.Collection)
		 */
		@Override
		public boolean removeAll(Collection<?> c) {
			boolean flag = false;
			for(Object obj : c){
				if(remove(obj)) flag = true;
			}
			return flag;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#retainAll(java.util.Collection)
		 */
		@Override
		public boolean retainAll(Collection<?> c) {
			Set<E> set = new HashSet<E>();
			for(E e : this){
				if(!c.contains(e)){
					set.add(e);
				}
			}
			return removeAll(set);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#clear()
		 */
		@Override
		public void clear() {
			int lastIndex = size() - 1;
			delegate.clear();
			fireIntervalRemoved(DefaultItemListModel.this, 0, lastIndex);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#get(int)
		 */
		@Override
		public E get(int index) {
			return delegate.get(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#set(int, java.lang.Object)
		 */
		@Override
		public E set(int index, E element) {
			E e = delegate.set(index, element);
			fireContentsChanged(DefaultItemListModel.this, index, index);
			return e;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#add(int, java.lang.Object)
		 */
		@Override
		public void add(int index, E element) {
			delegate.add(index, element);
			fireIntervalAdded(DefaultItemListModel.this, index, index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#remove(int)
		 */
		@Override
		public E remove(int index) {
			E e = delegate.remove(index);
			fireIntervalRemoved(DefaultItemListModel.this, index, index);
			return e;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#indexOf(java.lang.Object)
		 */
		@Override
		public int indexOf(Object o) {
			return delegate.indexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#lastIndexOf(java.lang.Object)
		 */
		@Override
		public int lastIndexOf(Object o) {
			return delegate.lastIndexOf(o);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator()
		 */
		@Override
		public ListIterator<E> listIterator() {
			return delegate.listIterator();
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#listIterator(int)
		 */
		@Override
		public ListIterator<E> listIterator(int index) {
			return delegate.listIterator(index);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.List#subList(int, int)
		 */
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			return delegate.subList(fromIndex, toIndex);
		}

	}

}
