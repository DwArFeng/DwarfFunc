package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

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
public class QuickFormulaValue extends AbstractMathObject implements FormulaValue {

	/**����0*/
	public static final QuickFormulaValue ZERO = new QuickFormulaValue();
	
	/**�����ֵ*/
	protected final double val;
	
	/**
	 * ����һ��ֵΪ0�Ŀ���ֵ����
	 * <p> �ֶ� {@link QuickFormulaValue#ZERO}���ȼ�Ҫ���ڸù��췽����
	 */
	public QuickFormulaValue() {
		this(0);
	}
	
	/**
	 * ����һ������ֵ����
	 * @param val �����ֵ��
	 */
	public QuickFormulaValue(double val) {
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(Objects.isNull(obj)) return false;
		if(obj == this) return true;
		if(! (obj instanceof QuickFormulaValue)) return false;
		QuickFormulaValue formulaValue = (QuickFormulaValue) obj;
		return formulaValue.val == this.val;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(val) * 17;
	}

}
