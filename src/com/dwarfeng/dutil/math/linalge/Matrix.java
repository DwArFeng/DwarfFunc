package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * ����ӿڡ�
 * <p> ʵ�ָýӿھ���ζ�Ÿö�����һ������
 * @author DwArFeng
 * @since 1.8
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
	public ColumnVector colVectorAt(int column);
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public Matrix add(Matrix matrix);
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public Matrix minus(Matrix matrix);
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public Matrix mul(Matrix matrix);
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	public Matrix scale(double val);
	
	/**
	 * 
	 * @return
	 */
	public Matrix trans();
	
}
