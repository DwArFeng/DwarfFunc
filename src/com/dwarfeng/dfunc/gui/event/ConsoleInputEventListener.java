package com.dwarfeng.dfunc.gui.event;

import java.util.EventListener;

/**
 * ����̨�������������
 * @author DwArFeng
 * @since 1.8
 */
public interface ConsoleInputEventListener extends EventListener {
	
	/**
	 * ������̨���������¼�ʱ�����ĵ��ȡ�
	 * @param e ����̨�����¼���
	 */
	public void onConsoleInput(ConsoleInputEvent e);
	
}
