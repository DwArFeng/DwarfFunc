package com.dwarfeng.dfoth.algebra;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;
import com.dwarfeng.dmath.algebra.Valueable;

/**
 * ֵ�ӿڡ�
 * <p> �ýӿ���ζ����ʵ�������ת��Ϊֵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface FValue extends NumBased, Valueable {
	
	/**
	 * ��ָ����ֵ������ӡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������ӵõ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FValue add(FValue val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFieldKey.FVal_0));
		return new QuickFVal(val.value() + value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FValue minus(FValue val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFieldKey.FVal_0));
		return new QuickFVal(val.value() - value());
	}
	
	/**
	 * ��ָ����ֵ������ˡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������˵õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FValue mul(FValue val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFieldKey.FVal_0));
		return new QuickFVal(val.value() * value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws ArithmeticException ��valΪ0���׳��쳣��
	 */
	public default FValue div(FValue val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFieldKey.FVal_0));
		return new QuickFVal(val.value() / value());
	}
	
}
