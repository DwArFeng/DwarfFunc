package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.infs.Nameable;
import com.dwarfeng.dutil.math.MathObject;

/**
 * �����ӿڡ�
 * <p> ʵ�ָýӿ���ζ��ʵ�����ǿ��Ա�ʾ�����ģ����ң���������Ա�ֱ�Ӹ��ģ����͵����Ӿ��� {@link QuickFothVariable}����
 * <br> ���ڿ���ֱ�Ӹ�ֵ�Ķ���ʮ�����⣬��ʮ�������ã���ˣ��ýӿڼ̳� {@link Nameable}�ӿڣ���ÿ������
 * ֱ�Ӹ�ֵ�Ķ��󶼾���һ�����Ʊ�ʶ������ѧ�У����ֶ��������һ����x��y��z �ȡ�
 * @author DwArFeng
 * @since 1.8
 */
public interface FothVariable extends MathObject, FothValue, Nameable{

	/**
	 * ���øýӿڵ���ֵ��
	 * @param value �ýӿڵ���ֵ��
	 */
	public void setValue(double value);
	
	/**
	 * ���øýӿڵ���ֵΪָ��ֵ�ӿڵĵ�ǰֵ��
	 * @param val ָ����ֵ�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default void setValue(FothValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FothVariable_0));
		setValue(val.value());
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
	 * @param val ָ����ֵ�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public default void offset(FothValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FothVariable_0));
		setValue(value() + val.value());
	}
	
}
