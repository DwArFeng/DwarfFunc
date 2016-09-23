package com.dwarfeng.dmath.algebra;

/**
 * ������ͻ�쳣��
 * <p> ���쳣ָʾ������ͻ����ν������ͻ�Ķ��壬��ο� {@link VariableSpace}��
 * @author DwArFeng
 * @since 1.8
 */
public class VariableConflictException extends Exception {

	private static final long serialVersionUID = 4578575180130763488L;

	public VariableConflictException() {}

	public VariableConflictException(String message) {
		super(message);
	}

	public VariableConflictException(Throwable cause) {
		super(cause);
	}

	public VariableConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	public VariableConflictException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
