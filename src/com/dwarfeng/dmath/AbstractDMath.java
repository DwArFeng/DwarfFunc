package com.dwarfeng.dmath;

/**
 * ��ѧ��������ࡣ
 * <p> ������������ѧ����ĳ����࣬��������������ѧ����Ӧ�þ��еĳ��󷽷���
 * @author DwArFeng
 * @since 1.8
 */
public abstract class AbstractDMath {

	/**
	 * ���ظö�������ѧ�е����ơ�
	 * @return �ö�������ѧ�е����ơ�
	 */
	public abstract String getMathName();
	
	/**
	 * ���ظö���ı��ʽ��
	 * <p> ���ʽӦ���ڵ��еĻ����Ͼ���������ѧ�ϵ���ʽ��
	 * @return ����ı��ʽ��
	 */
	public abstract String getExpression();
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getMathName())
				.append(" : ")
				.append(getExpression())
				.toString();
	}
	
}
