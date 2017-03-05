package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.cna.model.ListModel;
import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * �б�ģ����������
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ListObverser<E> extends Obverser {
	
	/**
	 * ֪ͨģ����ָ����λ��������ָ����Ԫ�ء�
	 * @param index ָ����λ�á�
	 * @param element ָ����Ԫ�ء�
	 */
	public void fireAdded(int index, E element);
	
	/**
	 * ֪ͨģ����ָ����λ���Ƴ���Ԫ�ء�
	 * @param index ָ����λ�á�
	 * @param element ���Ƴ���Ԫ�ء�
	 */
	public void fireRemoved(int index, E element);
	
	/**
	 * ֪ͨģ����ָ����λ�øı���ָ����Ԫ�ء�
	 * @param index ָ����λ�á�
	 * @param oldElement ָ��λ�ô��ľ�Ԫ�ء�
	 * @param newElement ָ��λ�ô�����Ԫ�ء�
	 */
	public void fireChanged(int index, E oldElement, E newElement);
	
	/**
	 * ֪ͨģ�ͱ���ա�
	 * <p> �÷���Ϊ�����Ч�ʶ�����ģ�����ģ��ִ�� {@link ListModel#clear()} ������ʱ��
	 * �ᴥ����֪ͨ������һ�����ش��� {@link #fireRemoved(int, Object)}��
	 */
	public void fireCleared();

}
