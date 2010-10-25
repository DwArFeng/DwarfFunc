package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.infs.Nameable;
import com.dwarfeng.dutil.math.DMath;

/**
 * �����ӿڡ�
 * <p> ʵ�ָýӿ���ζ��ʵ�����ǿ��Ա�ʾ�����ģ����ң���������Ա�ֱ�Ӹ��ģ����͵����Ӿ��� {@link QuickFVariable}����
 * <br> ���ڿ���ֱ�Ӹ�ֵ�Ķ���ʮ�����⣬��ʮ�������ã���ˣ��ýӿڼ̳� {@link Nameable}�ӿڣ���ÿ������
 * ֱ�Ӹ�ֵ�Ķ��󶼾���һ�����Ʊ�ʶ������ѧ�У����ֶ��������һ����x��y��z �ȡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface FVariable extends DMath, FValue, Nameable{

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
	public default void setValue(FValue valueable){
		Objects.requireNonNull(valueable, DwarfUtil.getStringField(StringFieldKey.FVariable_0));
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
	public default void offset(FValue valueable){
		Objects.requireNonNull(valueable, DwarfUtil.getStringField(StringFieldKey.FVariable_0));
		setValue(value() + valueable.value());
	}
	
}
