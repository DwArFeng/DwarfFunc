package com.dwarfeng.dutil.foth.algebra;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * ����ֵ�ࡣ
 * <p> ����� {@link FormulaValue}�ӿڽ�������򵥵�ʵ�֡�
 * <p> ���಻���ܿɱ�������д������е�ֵ���󶼻����ȡֵ����<code>double</code>��
 * ����ʽ�洢��
 * @author DwArFeng
 * @since 1.8
 */
public class QuickFValue extends AbstractMathObject implements FormulaValue {

	/**����0*/
	public static final QuickFValue ZERO = new QuickFValue();
	
	/**�����ֵ*/
	protected final double val;
	
	/**
	 * ����һ��ֵΪ0�Ŀ���ֵ����
	 * <p> �ֶ� {@link QuickFValue#ZERO}���ȼ�Ҫ���ڸù��췽����
	 */
	public QuickFValue() {
		this(0);
	}
	
	/**
	 * ����һ������ֵ����
	 * @param val �����ֵ��
	 */
	public QuickFValue(double val) {
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
		return DwarfUtil.getStringField(StringFieldKey.Algebra_RealNumber);
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
	public FVariableSpace variableSpace() {
		return FVariableSpace.EMPTY;
	}

}
