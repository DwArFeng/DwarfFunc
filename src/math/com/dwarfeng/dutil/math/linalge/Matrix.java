package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * ����ӿڡ�
 * <p> ʵ�ָýӿھ���ζ�Ÿö�����һ������
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface Matrix extends MathObject, MatrixLike{

	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public RowVector rowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param column ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public ColumnVector columnVectorAt(int column);
	
	/**
	 * ����ļӷ���
	 * <p> �þ�����ָ���ľ�����ӡ�
	 * @param matrix ָ���ľ���
	 * @return ��ӵõ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ����������ˡ�
	 */
	public Matrix add(Matrix matrix);
	
	/**
	 * ����ļ�����
	 * <p> �þ�����ָ�����������
	 * @param matrix ָ���ľ���
	 * @return ����õ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ�������������
	 */
	public Matrix minus(Matrix matrix);
	
	/**
	 * ����ĳ˷���
	 * <p> �þ�����ָ���ľ�����ˡ�
	 * @param matrix ָ���ľ���
	 * @return ��˵õ����µľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �þ�����ָ�������������
	 */
	public Matrix mul(Matrix matrix);
	
	/**
	 * ������������㡣
	 * <p>�þ�����ָ����ֵ��ˡ�
	 * @param val ָ����ֵ��
	 * @return ���ź�õ����µľ���
	 */
	public Matrix scale(double val);
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#trans()
	 */
	@Override
	public Matrix trans();
	
}
