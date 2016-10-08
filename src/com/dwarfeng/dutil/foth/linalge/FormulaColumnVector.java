package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.foth.algebra.QuickFothValue;
import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.linalge.ColumnVector;

/**
 * ������ʽ��ʽ����������
 * @author DwArFeng
 * @since 1.8
 */
public interface FormulaColumnVector extends MathObject, FormulaLinalgeVector{
	
	/**
	 * �������ļӷ���
	 * <p> ����������ָ������������ӡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param columnVector  ָ������������
	 * @return ��ӵõ�����������
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public FormulaColumnVector add(FormulaColumnVector columnVector);
	
	/**
	 * �������ļ�����
	 * <p> ����������ָ���������������
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param columnVector  ָ������������
	 * @return ����õ�����������
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public FormulaColumnVector minus(FormulaColumnVector columnVector);
	
	/**
	 * ���������������㡣
	 * <p> ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param val ָ����ֵ��
	 * @return ���ŵõ����µ���������
	 */
	public default FormulaColumnVector scale(double val){
		return scale(new QuickFothValue(val));
	}
	
	/**
	 * ���������������㡣
	 * <p> ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param val ָ����ֵ��
	 * @return ���ŵõ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public FormulaColumnVector scale(FothValue val);
	
	/**
	 * ��������ת�����㡣
	 * <p> ����������ת�á�
	 * <p> ת�ò������ƻ��ṹ��
	 * @return ������ת�õõ����µ���������
	 */
	public FormulaRowVector trans();

	/**
	 * ����������ת��Ϊmath���е���������
	 * @return math���е���������
	 */
	public ColumnVector toColumnVector();
}
