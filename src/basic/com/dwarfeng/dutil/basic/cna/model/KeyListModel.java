package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.List;

import com.dwarfeng.dutil.basic.prog.WithKey;

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
public interface KeyListModel<K, V extends WithKey<K>> extends ListModel<V> {

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

}
