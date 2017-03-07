package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.prog.ElementWithKey;

/**
 * ��ֵ����ģ�͹۲�����������
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class KeySetAdapter<K, V extends ElementWithKey<K>> implements KeySetObverser<K, V> {

	@Override
	public void fireAdded(K key, V value) {}
	@Override
	public void fireRemoved(K key, V value) {}
	@Override
	public void fireChanged(K key, V oldValue, V newValue) {}
	@Override
	public void fireCleared() {}
	
}
