package com.dwarfeng.dmath.algebra;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dmath.AbstractDMath;

/**
 * ����ֵ�ࡣ
 * <p> ����� {@link Valueable}�ӿڽ�������򵥵�ʵ�֡�
 * <p> ���಻���ܿɱ�������д������е�ֵ���󶼻����ȡֵ����<code>double</code>��
 * ����ʽ�洢��
 * @author DwArFeng
 * @since 1.8
 */
public class QuickValueable extends AbstractDMath implements Valueable {

	/**����0*/
	public static final QuickValueable ZERO = new QuickValueable();
	
	/**�����ֵ*/
	protected final double val;
	
	/**
	 * ����һ��ֵΪ0�Ŀ���ֵ����
	 * <p> �ֶ� {@link QuickValueable#ZERO}���ȼ�Ҫ���ڸù��췽����
	 */
	public QuickValueable() {
		this(0);
	}
	
	/**
	 * ����һ������ֵ����
	 * @param val �����ֵ��
	 */
	public QuickValueable(double val) {
		this.val = val;
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
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfFunction.getStringField(StringFiledKey.Algebra_RealNumber);
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
		return AlgebraUtil.emptyVariableSpace();
	}

}
