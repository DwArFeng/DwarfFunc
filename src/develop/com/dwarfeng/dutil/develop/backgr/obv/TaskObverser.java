package com.dwarfeng.dutil.develop.backgr.obv;

import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ����۲�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface TaskObverser extends Obverser {

	/**
	 * ֪ͨ�۲��������Ѿ���ʼִ�С�
	 */
	public void fireStarted();

	/**
	 * ֪ͨ�����Ѿ�����ִ�С�
	 */
	public void fireFinished();

}
