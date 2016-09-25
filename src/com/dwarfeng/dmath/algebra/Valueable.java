package com.dwarfeng.dmath.algebra;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dfunc.infs.MusValueable;
import com.dwarfeng.dfunc.num.QuickMusValueable;

/**
 * ֵ�ӿڡ�
 * <p> �ýӿ���ζ����ʵ�������ת��Ϊֵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface Valueable extends NumBase {

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
	public default Valueable add(Valueable val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFiledKey.Valueable_0));
		return new QuickValueable(val.value() + value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default Valueable minus(Valueable val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFiledKey.Valueable_0));
		return new QuickValueable(val.value() - value());
	}
	
	/**
	 * ��ָ����ֵ������ˡ�
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ������˵õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default Valueable mul(Valueable val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFiledKey.Valueable_0));
		return new QuickValueable(val.value() * value());
	}
	
	/**
	 * ��ָ����ֵ���������
	 * <p> ע�⣬��������ֵ���㣬����õ��Ľ��ֻ����ֵ����������������Ķ���Ľṹ��
	 * @param val ָ����ֵ����
	 * @return ��ֵ������ָ��ֵ��������õ���ֵ����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws ArithmeticException ��valΪ0���׳��쳣��
	 */
	public default Valueable div(Valueable val){
		Objects.requireNonNull(val, DwarfFunction.getStringField(StringFiledKey.Valueable_0));
		return new QuickValueable(val.value() / value());
	}
	
	/**
	 * ����ֵ�ӿ�ת��Ϊdfunc���еĶ�ֵ̬�ӿڡ�
	 * @return ת���ɵĶ�ֵ̬�ӿڡ�
	 */
	public default MusValueable toMusValueable(){
		return new QuickMusValueable(value());
	}
	
}
