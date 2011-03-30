package com.dwarfeng.dutil.develop.backgr.obv;

import com.dwarfeng.dutil.basic.prog.Obverser;
import com.dwarfeng.dutil.develop.backgr.Task;

/**
 * ��̨�۲�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface BackGroundObverser extends Obverser {

	/**
	 * ֪ͨ�۲���ָ���������ύ��
	 * @param task ָ��������
	 */
	public void fireTaskSubmitted(Task<? extends TaskObverser> task);
	
	/**
	 * ֪ͨ�۲���ָ��������ʼ��
	 * @param task ָ��������
	 */
	public void fireTaskStarted(Task<? extends TaskObverser> task);

	public void fireTaskFinished(Task<? extends TaskObverser> task);

	public void fireTaskRemoved(Task<? extends TaskObverser> task);
	
	public void fireShutDown();
	
}
