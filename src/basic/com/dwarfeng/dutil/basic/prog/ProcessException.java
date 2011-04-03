package com.dwarfeng.dutil.basic.prog;

/**
 * ����ʧ���쳣��
 * <p>
 * ���쳣��ʾĳ�������Ĵ�������У���������ĳ���쳣�������̳��ִ��� �޷��������С����쳣��һ��������ת�쳣��ͨ�����ԣ�ʹ�ø��쳣��
 * {@link #getCause()}�������Ի�ù����з����������쳣��
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class ProcessException extends Exception {

	private static final long serialVersionUID = -7882535182191168599L;

	public ProcessException() {
		super();
	}

	public ProcessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessException(String message) {
		super(message);
	}

	public ProcessException(Throwable cause) {
		super(cause);
	}

}
