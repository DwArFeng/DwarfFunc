package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * �����������Ľӿڡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface RowVector extends MathObject, LinalgeVector{
	
	/**
	 * �������ļӷ���
	 * <p> ����������ָ������������ӡ�
	 * @param rowVector ָ������������
	 * @return ��ӵõ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public RowVector add(RowVector rowVector);
	
	/**
	 * �������ļ�����
	 * <p> ����������ָ���������������
	 * @param rowVector ָ������������
	 * @return ����õ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public RowVector minus(RowVector rowVector);
	
	/**
	 * �������ĳ˷���
	 * <p> ����������ָ������������ˡ�
	 * @param columnVector ָ������������
	 * @return ��˵õ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public double mul(ColumnVector columnVector);
	
	/**
	 * ���������������㡣
	 * <p> ����������ָ����ֵ��ˡ�
	 * @param val ָ����ֵ��
	 * @return ���ŵõ����µ���������
	 */
	public RowVector scale(double val);
	
	/**
	 * ��������ת�����㡣
	 * <p> ����������ת�á�
	 * @return ������ת�õõ����µ���������
	 */
	public ColumnVector trans();
	
}
