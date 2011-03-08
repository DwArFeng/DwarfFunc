package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.cna.model.KeyListModel;
import com.dwarfeng.dutil.basic.prog.ElementWithKey;
import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ��ֵ�б�ģ�͹۲�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface KeyListObverser<K, V extends ElementWithKey<K>> extends Obverser {

	/**
	 * ֪ͨģ������ָ��λ�������Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param key
	 *            ����ӵ�Ԫ�صļ���
	 * @param value
	 *            ����ӵ�Ԫ�ء�
	 */
	public void fireAdded(int index, K key, V value);

	/**
	 * ֪ͨģ����ָ��λ���Ƴ���Ԫ�ء�
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param key
	 *            ���Ƴ���Ԫ�صļ���
	 * @param value
	 *            ���Ƴ���Ԫ�ء�
	 */
	public void fireRemoved(int index, K key, V value);

	/**
	 * ֪ͨģ����ָ��λ�õ�Ԫ�ط����˸ı䡣
	 * 
	 * @param index
	 *            ָ����λ�á�
	 * @param oldKey
	 *            �ɵ�Ԫ�صļ���
	 * @param oldValue
	 *            �ɵ�Ԫ�ء�
	 * @param newKey
	 *            �µ�Ԫ�صļ���
	 * @param newValue
	 *            �µ�Ԫ�ء�
	 */
	public void fireChanged(int index, K oldKey, V oldValue, K newKey, V newValue);

	/**
	 * ֪ͨģ�ͱ���ա�
	 * <p>
	 * �÷���Ϊ�����Ч�ʶ�����ģ�����ģ��ִ�� {@link KeyListModel#clear()} ������ʱ�� �ᴥ����֪ͨ������һ�����ش���
	 * {@link #fireRemoved(int, Object, ElementWithKey)}��
	 */
	public void fireCleared();

}
