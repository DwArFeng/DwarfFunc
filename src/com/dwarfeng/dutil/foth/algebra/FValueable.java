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
public interface FValueable extends FNumBased{
	
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
	public default FValueable add(FValueable val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FValue_0));
		return new QuickFValue(val.value() + value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FValueable minus(FValueable val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FValue_0));
		return new QuickFValue(val.value() - value());
	}
	
	/**
	 * ��ָ����ֵ������ˡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������˵õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default FValueable mul(FValueable val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FValue_0));
		return new QuickFValue(val.value() * value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws ArithmeticException ��valΪ0���׳��쳣��
	 */
	public default FValueable div(FValueable val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FValue_0));
		return new QuickFValue(val.value() / value());
	}
	
}
