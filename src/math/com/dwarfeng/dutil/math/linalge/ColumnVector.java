package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * �����������Ľӿڡ�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface ColumnVector extends MathObject, LinalgeVector{
	
	/**
	 * �������ļӷ���
	 * <p> ����������ָ������������ӡ�
	 * @param columnVector  ָ������������
	 * @return ��ӵõ�����������
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public ColumnVector add(ColumnVector columnVector);
	
	/**
	 * �������ļ�����
	 * <p> ����������ָ���������������
	 * @param columnVector  ָ������������
	 * @return ����õ�����������
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public ColumnVector minus(ColumnVector columnVector);
	
	/**
	 * ���������������㡣
	 * <p> ����������ָ����ֵ��ˡ�
	 * @param val ָ����ֵ��
	 * @return ���ŵõ����µ���������
	 */
	public ColumnVector scale(double val);
	
	/**
	 * ��������ת�����㡣
	 * <p> ����������ת�á�
	 * @return ������ת�õõ����µ���������
	 */
	public RowVector trans();

}
