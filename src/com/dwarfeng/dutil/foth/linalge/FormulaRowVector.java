package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.foth.algebra.QuickFothValue;
import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.linalge.RowVector;

/**
 * ������ʽ��ʽ����������
 * @author DwArFeng
 * @since 1.8
 */
public interface FormulaRowVector extends MathObject, FormulaLinalgeVector{
	
	/**
	 * �������ļӷ���
	 * <p> ����������ָ������������ӡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param rowVector ָ������������
	 * @return ��ӵõ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public FormulaRowVector add(FormulaRowVector rowVector);
	
	/**
	 * �������ļ�����
	 * <p> ����������ָ���������������
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param rowVector ָ������������
	 * @return ����õ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public FormulaRowVector minus(FormulaRowVector rowVector);
	
	/**
	 * �������ĳ˷���
	 * <p> ����������ָ������������ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param columnVector ָ������������
	 * @return ��˵õ����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException �������Ĵ�С��ƥ�䡣
	 */
	public FothValue mul(FormulaColumnVector columnVector);
	
	/**
	 * ���������������㡣
	 * <p> ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺�������ǽṹ�ƻ��Եģ��µ���������ʧȥ�����������������ԭ���ṹ��
	 * @param val ָ����ֵ��
	 * @return ���ŵõ����µ���������
	 */
	public default FormulaRowVector scale(double val){
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
	public FormulaRowVector scale(FothValue val);
	
	/**
	 * ��������ת�����㡣
	 * <p> ����������ת�á�
	 * <p> ת�ò������ƻ��ṹ��
	 * @return ������ת�õõ����µ���������
	 */
	public FormulaColumnVector trans();
	
	/**
	 * ����������ת��Ϊmath���е���������
	 * @return math���е���������
	 */
	public RowVector toRowVector();
}
