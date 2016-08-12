package com.dwarfeng.dwarffunction.gui.event;

import java.io.InputStream;

/**
 * ����̨�����¼���
 * <p> ��־�ſ���̨�����룬ÿ���û��ڿ���̨�����루���»س������Ժ󣬿���̨�����ɸ��¼������ҽ����¼��㲥�������Ѿ�ע��
 * ����������
 * <br> ����̨�����¼���¼���µ���Ϣ�������¼���Դ���󣬴����¼�ʱ����ʱ��ص��ı����뱾���¼���ص���������
 * @author DwArFeng
 * @since 1.8
 */
public class ConsoleInputEvent {

	private final Object source;
	private final String inputString;
	private final InputStream inputStream;
	
	/**
	 * ����һ��Ĭ�ϵĿ���̨�����¼�����ʱ�����ָ�����¼�Դ��ָ����������Լ�ָ���������ı���
	 * @param source ָ��������Դ��
	 * @param inputString ָ���������ı���
	 * @param inputStream 
	 */
	public ConsoleInputEvent(Object source, String inputString, InputStream inputStream){
		this.source = source;
		this.inputStream = inputStream;
		this.inputString = inputString;
	}

	/**
	 * ��ȡ�¼���Դ����
	 * @return �¼���Դ����
	 */
	public Object getSource() {
		return source;
	}

	/**
	 * ��ȡ�������¼��йص��ı���
	 * @return �й��ı���
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * ��ȡ�������¼��йص���������
	 * @return �йص���������
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
}