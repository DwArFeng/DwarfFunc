package com.dwarfeng.dutil.math;

/**
 * dmath�������ӿڡ�
 * <p> dmath�е������ӽӿڶ��̳иýӿڣ��ýӿ���dmath�������нӿڵĸ���ӿڣ�
 * {@link AbstractMathObject} �Ǹýӿڵĳ���ʵ�֣�Ҳ����˵�����е�dmath���еĶ��󶼼̳�����ӿڣ�������еĶ��󶼾������������
 * @author DwArFeng
 * @since 1.8
 */
public interface MathObject {
	
	/**
	 * ���ظö�������ѧ�е����ơ�
	 * @return �ö�������ѧ�е����ơ�
	 */
	public String getMathName();
	
	/**
	 * ���ظö���ı��ʽ��
	 * <p> ���ʽӦ���ڵ��еĻ����Ͼ���������ѧ�ϵ���ʽ��
	 * @return ����ı��ʽ��
	 */
	public String getExpression();

}
