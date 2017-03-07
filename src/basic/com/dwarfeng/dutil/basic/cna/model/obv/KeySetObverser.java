package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.cna.model.KeySetModel;
import com.dwarfeng.dutil.basic.prog.ElementWithKey;
import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ��ֵ����ģ�͹۲�����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface KeySetObverser<K, V extends ElementWithKey<K>>  extends Obverser{
	
	/**
	 * ֪ͨģ���������ָ����Ԫ�ء�
	 * @param key ָ��Ԫ�صļ���
	 * @param value ָ����Ԫ�ء�
	 */
	public void fireAdded(K key, V value);
	
	/**
	 * ֪ͨģ�����Ƴ���ָ����Ԫ�ء�
	 * @param key ָ����Ԫ�صļ���
	 * @param value ָ����Ԫ�ء�
	 */
	public void fireRemoved(K key, V value);
	
	/**
	 * ֪ͨģ����ָ���ļ���Ӧ��Ԫ�ط����˸ı䡣
	 * @param key ָ���ļ���
	 * @param oldValue ָ���ļ���Ӧ�ľɵ�Ԫ�ء�
	 * @param newValue ָ���ļ���Ӧ���µ�Ԫ�ء�
	 */
	public void fireChanged(K key, V oldValue, V newValue);
	
	/**
	 * ֪ͨģ�ͱ���ա�
	 * <p> �÷���Ϊ�����Ч�ʶ�����ģ�����ģ��ִ�� {@link KeySetModel#clear()} ������ʱ��
	 * �ᴥ����֪ͨ������һ�����ش��� {@link #fireRemoved(int, Object)}��
	 */
	public void fireCleared();

}
