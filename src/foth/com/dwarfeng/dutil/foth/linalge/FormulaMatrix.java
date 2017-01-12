package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.linalge.Matrix;

/**
 * ������ʽ�ṹ�ľ����ࡣ
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface FormulaMatrix extends MathObject, FormulaMatrixLike{
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µľ���ʧȥ��������ľ����ԭ���ṹ��
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public FormulaRowVector formulaRowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param column ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public FormulaColumnVector formulaColumnVectorAt(int column);
	
	/**
	 * ����ļӷ���
	 * <p> �þ�����ָ���ľ�����ӡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µľ���ʧȥ��������ľ����ԭ���ṹ��
	 * @param matrix ָ���ľ���
	 * @return ��ӵõ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ����������ˡ�
	 */
	public FormulaMatrix add(FormulaMatrix matrix);
	
	/**
	 * ����ļ�����
	 * <p> �þ�����ָ�����������
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µľ���ʧȥ��������ľ����ԭ���ṹ��
	 * @param matrix ָ���ľ���
	 * @return ����õ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ�������������
	 */
	public FormulaMatrix minus(FormulaMatrix matrix);
	
	/**
	 * ����ĳ˷���
	 * <p> �þ�����ָ���ľ�����ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µľ���ʧȥ��������ľ����ԭ���ṹ��
	 * @param matrix ָ���ľ���
	 * @return ��˵õ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ�������������
	 */
	public FormulaMatrix mul(FormulaMatrix matrix);
	
	/**
	 * ������������㡣
	 * <p>�þ�����ָ����ֵ��ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µľ���ʧȥ��������ľ����ԭ���ṹ��
	 * @param val ָ����ֵ��
	 * @return ���ź�õ����µľ���
	 */
	public FormulaMatrix scale(double val);
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#trans()
	 */
	@Override
	public FormulaMatrix trans();
	
	/**
	 * ���þ���ת��Ϊmath���еľ���
	 * <p> ת�ò������ƻ��ṹ��
	 * @return math���еľ���
	 */
	public Matrix toMatrix();
	
}
