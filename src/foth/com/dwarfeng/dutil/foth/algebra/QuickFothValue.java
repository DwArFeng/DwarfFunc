package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * ����ֵ�ࡣ
 * <p> ����� {@link FothValue}�ӿڽ�������򵥵�ʵ�֡�
 * <p> ���಻���ܿɱ�������д������е�ֵ���󶼻����ȡֵ����<code>double</code>��
 * ����ʽ�洢��
 * @author DwArFeng
 * @since 1.8
 */
public class QuickFothValue extends AbstractMathObject implements FothValue {

	/**����0*/
	public static final QuickFothValue ZERO = new QuickFothValue();
	
	/**�����ֵ*/
	protected final double val;
	
	/**
	 * ����һ��ֵΪ0�Ŀ���ֵ����
	 * <p> �ֶ� {@link QuickFothValue#ZERO}���ȼ�Ҫ���ڸù��췽����
	 */
	public QuickFothValue() {
		this(0);
	}
	
	/**
	 * ����һ������ֵ����
	 * @param val �����ֵ��
	 */
	public QuickFothValue(double val) {
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
	public FothVariableSpace variableSpace() {
		return FothVariableSpace.EMPTY;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(Objects.isNull(obj)) return false;
		if(obj == this) return true;
		if(! (obj instanceof QuickFothValue)) return false;
		QuickFothValue fothValue = (QuickFothValue) obj;
		return fothValue.val == this.val;
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
