package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.cna.model.MapModel;
import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ӳ��ģ�͹۲�����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface MapObverser<K, V> extends Obverser {
	
	/**
	 * ָ֪ͨ���ļ�-ֵ�Ա���ӡ�
	 * @param key ָ���ļ���
	 * @param value ָ����ֵ��
	 */
	public void firePut(K key, V value);
	
	/**
	 * ָ֪ͨ���ļ�ӳ���Ԫ�ر��ı䡣
	 * <p> ע�⣬������ {@link MapModel#put(Object, Object)} ����ʱ�����ģ�����Ѿ�����ָ���ļ���
	 * ��ģ�ͻ���ø÷�������֪ͨ�������ǵ��� {@link #firePut(Object, Object)}��������֪ͨ��
	 * @param key ָ���ļ���
	 * @param oldValue �ü��ɵ�ӳ��ֵ��
	 * @param newValue �ü��µ�ӳ��ֵ��
	 */
	public void fireChanged(K key, V oldValue, V newValue);
	
	/**
	 * ֪ͨģ�����Ƴ���ָ���ļ���
	 * @param key ָ���ļ���
	 * @param value �ü��Ķ�Ӧֵ��
	 */
	public void fireRemoved(K key, V value);
	
	/**
	 * ֪ͨģ���е����ݱ������
	 * <p> �÷�����Ϊ�����Ч�ʶ�����ģ���ģ��ִ�� {@link MapModel#clear()} ������ʱ��
	 * �ᴥ����֪ͨ������һ�����ش��� {@link #fireRemoved(Object, Object)}��
	 */
	public void fireCleared();

}
