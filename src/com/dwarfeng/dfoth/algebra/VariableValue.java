package com.dwarfeng.dfoth.algebra;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;
import com.dwarfeng.dfunc.infs.Nameable;
import com.dwarfeng.dmath.DMath;

/**
 * ���������ݽӿڡ�
 * <p> ʵ�ָýӿ���ζ��ʵ�����ǿ��Ա�ʾ�����ģ����ң���������Ա�ֱ�Ӹ��ģ����͵����Ӿ����Ա�������
 * <br> ���ڿ���ֱ�Ӹ�ֵ�Ķ���ʮ�����⣬��ʮ�������ã���ˣ��ýӿڼ̳� {@link Nameable}�ӿڣ���ÿ������
 * ֱ�Ӹ�ֵ�Ķ��󶼾���һ�����Ʊ�ʶ������ѧ�У����ֶ��������һ����x��y��z �ȡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface VariableValue extends DMath, Valueable, Nameable{

	/**
	 * ���øýӿڵ���ֵ��
	 * @param value �ýӿڵ���ֵ��
	 */
	public void setValue(double value);
	
	/**
	 * ���øýӿڵ���ֵΪָ��ֵ�ӿڵĵ�ǰֵ��
	 * @param valueable ָ����ֵ�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default void setValue(Valueable valueable){
		Objects.requireNonNull(valueable, DwarfFunction.getStringField(StringFieldKey.VariableValue_0));
		setValue(valueable.value());
	}
	
	/**
	 * ƫ�Ƶ�ǰֵ��
	 * <p> �ڵ�ǰֵ�Ļ���������ָ����ֵ��
	 * @param d ָ����ֵ��
	 */
	public default void offset(double d){
		setValue(value() + d);
	}
	
	/**
	 * ƫ�Ƶ�ǰֵ��
	 * <p> �ڵ�ǰ����������ָ��ֵ�ӿ��еĵ�ǰֵ��
	 * @param valueable ָ����ֵ�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default void offset(Valueable valueable){
		Objects.requireNonNull(valueable, DwarfFunction.getStringField(StringFieldKey.VariableValue_0));
		setValue(value() + valueable.value());
	}
	
}
