package com.dwarfeng.dutil.basic.cna.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.dwarfeng.dutil.basic.cna.model.obv.KeySetObverser;
import com.dwarfeng.dutil.basic.prog.WithKey;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ��ֵ����ģ�͡�
 * <p>
 * ģ�Ϳ�������һ��ӵ��������Ԫ�أ����ṩһϵ�еĲ���������ģ���е�Ԫ����û��˳��ģ� ��ͬ������ֻ�ܶ�Ӧһ��Ԫ�ء�
 * ��ģ��ͬ�����Զ�Ԫ�ظ����������в�������ģ����һ�� {@link List}ʵ�֡�
 * 
 * @author DwArFeng
 * @param <K>
 *            ����K������Ԫ�ؼ������͡�
 * @param <V>
 *            ����V������Ԫ�ص����͡�
 * @since 0.1.0-beta
 */
public interface KeySetModel<K, V extends WithKey<K>, O extends KeySetObverser<K, V>>
		extends Set<V>, ObverserSet<O> {

	/**
	 * ������ϰ���ָ���ļ����򷵻� <code>true</code>��
	 * 
	 * @param key
	 *            ָ���ļ���
	 * @return �������ָ���ļ����򷵻� <code>true</code>��
	 */
	public boolean containsKey(Object key);

	/**
	 * ������ϰ���ָ�� {@link Collection} �����м����򷵻� <code>true</code>��
	 * 
	 * @param c
	 *            Ҫ�ڼ����м��������Ե� {@link Collection}
	 * @return ������ϰ���ָ�� {@link Collection} �����м����򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean containsAllKey(Collection<?> c);

	/**
	 * �Ӵ˼������Ƴ�ָ������������ڣ�����ѡ��������
	 * 
	 * @param key
	 *            Ҫ�Ӹü������Ƴ��ļ���
	 * @return ������ϰ���ָ���ļ����򷵻� <code>true</code>��
	 */
	public boolean removeKey(Object key);

	/**
	 * �Ӽ������Ƴ�ָ�� {@link Collection} �а�����������Ԫ�أ���ѡ��������
	 * 
	 * @param c
	 *            �����Ӵ˼������Ƴ���Ԫ�ص� {@link Collection}��
	 * @return ����˼������ڵ��ö��������ģ��򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean removeAllKey(Collection<?> c);

	/**
	 * ���ڼ����б���ָ�� {@link Collection} ����������Ԫ�أ���ѡ��������
	 * 
	 * @param c
	 *            �����������ڴ˼����е�Ԫ�ص� {@link Collection}��
	 * @return ����˼������ڵ��ö��������ģ��򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean retainAllKey(Collection<?> c);

}
