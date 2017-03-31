package com.dwarfeng.dutil.develop.backgr.obv;

import com.dwarfeng.dutil.basic.prog.Obverser;
import com.dwarfeng.dutil.develop.backgr.Task;

/**
 * ��̨�۲�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface BackgroundObverser extends Obverser {

	/**
	 * ֪ͨ�۲���ָ���������ύ��
	 * 
	 * @param task
	 *            ָ��������
	 */
	public void fireTaskSubmitted(Task task);

	/**
	 * ֪ͨ�۲���ָ��������ʼ��
	 * 
	 * @param task
	 *            ָ��������
	 */
	public void fireTaskStarted(Task task);

	/**
	 * ֪ͨ�۲���ָ�������������
	 * 
	 * @param task
	 *            ָ��������
	 */
	public void fireTaskFinished(Task task);

	/**
	 * ֪ͨ�۲���ָ���������Ƴ���
	 * 
	 * @param task
	 *            ָ��������
	 */
	public void fireTaskRemoved(Task task);

	/**
	 * ֪ͨ�۲�����̨���رա�
	 */
	public void fireShutDown();

}
