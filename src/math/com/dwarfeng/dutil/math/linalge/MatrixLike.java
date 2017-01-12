package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * �����ž������Ǿ��������Ľṹ�Ķ���
 * <p> ������ʵ����ӵ�������Ǿ��������ģ�ӵ�����з���Ľṹ�����ֽṹ���ص��ǣ���������������ȷ�ģ����ҿ��Ը���������������ӦΨһһ��ֵ��
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface MatrixLike extends MathObject{
	
	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int rows();
	
	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int columns();
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param column ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 * @throws IndexOutOfBoundsException ���кų��硣
	 */
	public double valueAt(int row, int column);
	
	/**
	 * �þ������е�ת�á�
	 * @return �þ�������ת�õõ��ľ������С�
	 */
	public MatrixLike trans();

}
