package com.dwarfeng.dutil.basic.cna.model.obv;

import com.dwarfeng.dutil.basic.cna.model.SetModel;
import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ����ģ�͹۲�����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface SetObverser<E> extends Obverser {
	
	/**
	 * ֪ͨģ����ָ����Ԫ�ر���ӡ�
	 * @param element ָ����Ԫ�ء�
	 */
	public void fireAdded(E element);
	
	/**
	 * ֪ͨģ����ָ����Ԫ�ر��Ƴ���
	 * @param element ָ����Ԫ�ء�
	 */
	public void fireRemoved(E element);
	
	/**
	 * ֪ͨģ��������Ԫ�ر������
	 * <p> �÷�����Ϊ���Ż�Ч�ʶ�����ģ���ˣ���ģ��ִ�� {@link SetModel#clear()}��ʱ��
	 * ����ø÷�������֪ͨ�������� һ�����ص��� {@link #fireRemoved(Object)}��
	 */
	public void fireCleared();

}
