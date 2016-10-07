package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * ֵ�ӿڡ�
 * <p> �ýӿ���ζ����ʵ�������ת��Ϊֵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface FormulaValue extends NumberBased{
	
	/**
	 * ���ض����ֵ��
	 * @return �����ֵ��
	 */
	public double value();
	
	/**
	 * ��ָ����ֵ������ӡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������ӵõ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FormulaValue add(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FormulaValue_0));
		return new QuickFormulaValue(val.value() + value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FormulaValue minus(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FormulaValue_0));
		return new QuickFormulaValue(val.value() - value());
	}
	
	/**
	 * ��ָ����ֵ������ˡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������˵õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FormulaValue mul(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FormulaValue_0));
		return new QuickFormulaValue(val.value() * value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws ArithmeticException ��valΪ0���׳��쳣��
	 */
	public default FormulaValue div(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FormulaValue_0));
		return new QuickFormulaValue(val.value() / value());
	}
	
}
