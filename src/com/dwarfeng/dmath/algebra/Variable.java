package com.dwarfeng.dmath.algebra;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dmath.AbstractDMath;

/**
 * ������
 * <p> ���಻���ܿɱ�������д������е�ֵ���󶼻����ȡֵ����<code>double</code>��
 * ����ʽ�洢��
 * @author DwArFeng
 * @since 1.8
 */
public class Variable extends AbstractDMath implements VariableValue {
	
	/**������ֵ*/
	protected double val;
	/**����������*/
	protected final String name;
	
	/**
	 * ����һ��Ĭ�ϵģ�ֵΪ0�ı�����
	 */
	public Variable(String name) {
		this(name, 0d);
	}
	
	/**
	 * ����һ��ֵΪָ��ֵ�ӿڵĵ�ǰֵ�ı�����
	 * @param valueable
	 * @throws IllegalArgumentException name����Ϊ <code>null</code>��Ƿ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>ʱ�׳��쳣��
	 */
	public Variable(String name, Valueable valueable) {
		if(Objects.isNull(name) || name.equals("")){
			throw new IllegalArgumentException(DwarfFunction.getStringField(StringFiledKey.Variable_1));
		}
		Objects.requireNonNull(valueable, DwarfFunction.getStringField(StringFiledKey.Variable_0));
		
		this.name = name;
		this.val = valueable.value();
	}
	
	/**
	 * ����һ��ֵΪָ��ֵ�ı�����
	 * @param d ָ����ֵ��
	 * @throws IllegalArgumentException name����Ϊ <code>null</code> ��Ƿ���
	 */
	public Variable(String name, double d) {
		if(Objects.isNull(name) || name.equals("")){
			throw new IllegalArgumentException(DwarfFunction.getStringField(StringFiledKey.Variable_1));
		}
		
		this.name = name;
		this.val = d;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.Valueable#value()
	 */
	@Override
	public double value() {
		return val;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfunc.infs.Nameable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.VariableValue#setValue(double)
	 */
	@Override
	public void setValue(double value) {
		this.val = value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfFunction.getStringField(StringFiledKey.Algebra_Variable);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		return new StringBuilder().append(val).toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.NumBase#getVariableSpace()
	 */
	@Override
	public VariableSpace getVariableSpace() {
		return new VariableSpace(this);
	}

}
