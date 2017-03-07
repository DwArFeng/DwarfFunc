package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.prog.ElementWithKey;

/**
 * ��ֵ�б�ģ�͹۲�����������
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class KeyListAdapter<K, V extends ElementWithKey<K>> implements KeyListObverser<K, V> {

	@Override
	public void fireAdded(int index, K key, V value) {}
	@Override
	public void fireRemoved(int index, K key, V value) {}
	@Override
	public void fireChanged(int index, K oldKey, V oldValue, K newKey, V newValue) {}
	@Override
	public void fireCleared() {}
	
}
