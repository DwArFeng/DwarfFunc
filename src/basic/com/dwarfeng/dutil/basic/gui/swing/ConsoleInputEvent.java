package com.dwarfeng.dutil.basic.gui.swing;

import java.io.InputStream;

/**
 * ����̨�����¼���
 * <p> ��־�ſ���̨�����룬ÿ���û��ڿ���̨�����루���»س������Ժ󣬿���̨�����ɸ��¼������ҽ����¼��㲥�������Ѿ�ע��
 * ����������
 * <br> ����̨�����¼���¼���µ���Ϣ�������¼���Դ���󣬴����¼�ʱ����ʱ��ص��ı����뱾���¼���ص���������
 * @deprecated ���� {@link JConsole} �Ĺ�ʱ������Ҳһ����ʱ��
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class ConsoleInputEvent {

	private final Object source;
	private final String inputString;
	private final InputStream inputStream;
	
	/**
	 * ����һ��Ĭ�ϵĿ���̨�����¼�����ʱ�����ָ�����¼�Դ��ָ����������Լ�ָ���������ı���
	 * @param source ָ��������Դ��
	 * @param inputString ָ���������ı���
	 * @param inputStream ָ������������
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
	 * <p> ��ͨ������£����ı��Ľ�β�л��з��������Ҫû�л��з����ı�����ʹ��
	 * {@linkplain ConsoleInputEvent#getNlInputString()}������
	 * @return �й��ı���
	 */
	public String getInputString() {
		return inputString;
	}
	
	/**
	 * ����ȥ��β�����з����ı���
	 * @return ȥ��β�����з����ı���
	 */
	public String getNlInputString(){
		if(inputString.endsWith("\n")){
			return inputString.substring(0, inputString.length() - 1);
		}else{
			return inputString;
		}
	}

	/**
	 * ��ȡ�������¼��йص���������
	 * @return �йص���������
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
	
	
}