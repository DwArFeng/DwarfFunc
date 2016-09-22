package com.dwarfeng.dmath.algebra;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dmath.AbstractDMath;

/**
 * ����ֵ�ࡣ
 * <p> ����� {@link Valueable}�ӿڽ�������򵥵�ʵ�֡�
 * @author DwArFeng
 * @since 1.8
 */
public class DQuickValueable extends AbstractDMath implements Valueable {

	/**�����ֵ*/
	protected final double val;
	
	/**
	 * ����һ��ֵΪ0�Ŀ���ֵ����
	 */
	public DQuickValueable() {
		this(0);
	}
	
	/**
	 * ����һ������ֵ����
	 * @param val �����ֵ��
	 */
	public DQuickValueable(double val) {
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

}
