package com.dwarfeng.dutil.foth.algebra;

/**
 * ������ͻ�쳣��
 * <p> ���쳣ָʾ������ͻ����ν������ͻ�Ķ��壬��ο� {@link FothVariableSpace}��
 * @author DwArFeng
 * @since 1.8
 */
public class VariableConflictException extends RuntimeException {

	private static final long serialVersionUID = 4578575180130763488L;

	/**
	 * ����һ��������ͻ�쳣��
	 */
	public VariableConflictException() {}

	/**
	 * ����һ������ָ�������ı��ı�����ͻ�쳣��
	 * @param message ָ���������ı���
	 */
	public VariableConflictException(String message) {
		super(message);
	}
	
}
