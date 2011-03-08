package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.List;

import com.dwarfeng.dutil.basic.cna.model.obv.KeyListObverser;
import com.dwarfeng.dutil.basic.prog.ElementWithKey;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ��ֵ�б�ģ�͡�
 * <p>
 * ģ�Ϳ�������һ�������ӵ��������Ԫ�أ����ṩһϵ�еĲ��������� ��ģ��ͬ�����Զ�Ԫ�ظ����������в�������ģ����һ�� {@link List}ʵ�֡�
 * 
 * @author DwArFeng
 * @param <K>
 *            ����K������Ԫ�ؼ������͡�
 * @param <V>
 *            ����V������Ԫ�ص����͡�
 * @since 0.1.0-beta
 */
public interface KeyListModel<K, V extends ElementWithKey<K>> extends List<V>, ObverserSet<KeyListObverser<K, V>> {

	/**
	 * ����б����ָ���ļ����򷵻� <code>true</code>��
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @return �������ָ���ļ����򷵻� <code>true</code>��
	 */
	public boolean containsKey(Object key);

	/**
	 * ����б����ָ�� {@link Collection} �����м����򷵻� <code>true</code>��
	 * 
	 * @param c
	 *            Ҫ���б��м��������Ե� {@link Collection}
	 * @return ����б����ָ�� {@link Collection} �����м����򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean containsAllKey(Collection<?> c);

	/**
	 * ���ش��б��е�һ�γ��ֵ�ָ������������ ������б������ü����򷵻� <code>-1</code>��
	 * 
	 * @param o
	 *            Ҫ�����ļ���
	 * @return ���б��е�һ�γ��ֵ�ָ����������������б������ü����򷵻� <code>-1</code>��
	 */
	public int indexOfKey(Object o);

	/**
	 * ���ش��б������һ�γ��ֵ�ָ������������ ������б������ü����򷵻� <code>-1</code>��
	 * 
	 * @param o
	 *            Ҫ�����ļ���
	 * @return ���б������һ�γ��ֵ�ָ����������������б������ü����򷵻� <code>-1</code>��
	 */
	public int lastIndexOfKey(Object o);

	/**
	 * �Ӵ��б����Ƴ���һ�γ��ֵ�ָ������������ڣ�����ѡ��������
	 * 
	 * @param key
	 *            Ҫ�Ӹ��б����Ƴ��ļ���
	 * @return ����б����ָ���ļ����򷵻� <code>true</code>��
	 */
	public boolean removeKey(Object key);

	/**
	 * ���б����Ƴ�ָ�� {@link Collection} �а�����������Ԫ�أ���ѡ��������
	 * 
	 * @param c
	 *            �����Ӵ��б����Ƴ���Ԫ�ص� {@link Collection}��
	 * @return ������б����ڵ��ö��������ģ��򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean removeAllKey(Collection<?> c);

	/**
	 * �����б��б���ָ�� {@link Collection} ����������Ԫ�أ���ѡ��������
	 * 
	 * @param c
	 *            �����������ڴ��б��е�Ԫ�ص� {@link Collection}��
	 * @return ������б����ڵ��ö��������ģ��򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean retainAllKey(Collection<?> c);

	/**
	 * �����б���ָ���� fromIndex������ ���� toIndex����������֮��Ĳ�����ͼ��
	 * <p>
	 * ����� fromIndex �� toIndex ��ȣ��򷵻ص��б�Ϊ�գ���
	 * ���ص��б��ɴ��б�֧�֣���˷����б��еķǽṹ�Ը��Ľ���ӳ�ڴ��б��У���֮��Ȼ�� ���ص��б�֧�ִ��б�֧�ֵ����п�ѡ�б������
	 * <p>
	 * �˷���ʡȥ����ʽ��Χ�������˲���ͨ�����������ڣ��� ͨ������ subList ��ͼ���������б������б���κβ�����������Χ������
	 * ���磬����������б����Ƴ���Ԫ�صķ�Χ��
	 * 
	 * <pre>
	 * list.subList(from, to).clear();
	 * </pre>
	 * <p>
	 * ���Զ� indexOf �� lastIndexOf �������Ƶ���䣬���� Collections ���е������㷨������Ӧ���� subList��
	 * <p>
	 * ���֧���б������б�ͨ���κ�������ʽ��������ͨ�����ص��б��ӽṹ���޸ģ�
	 * ��˷������ص��б����彫��Ϊδ���壨�ӽṹ���޸���ָ�����б�Ĵ�С��������������ʽ�����б� ʹ���ڽ��еĵ�����������Ľ������
	 * 
	 * @param fromIndex
	 *            subList �ĵͶˣ���������
	 * @param toIndex
	 *            subList �ĸ߶ˣ��������� ��
	 * @return �б���ָ����Χ����ͼ��
	 * @throws IndexOutOfBoundsException
	 *             �Ƿ��Ķ˵�ֵ
	 *             <code>(fromIndex &lt; 0 || toIndex &gt; size || fromIndex &gt; toIndex)</code>
	 */
	@Override
	public KeyListModel<K, V> subList(int fromIndex, int toIndex);
}
