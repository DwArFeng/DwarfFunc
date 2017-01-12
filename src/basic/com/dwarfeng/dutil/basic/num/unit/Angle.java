package com.dwarfeng.dutil.basic.num.unit;

import com.dwarfeng.dutil.basic.num.NumberValue;

/**
 * �Ƕ�ö�١�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public enum Angle implements NumberValue{
	
	/**�Ƕ�*/
	DEG(180),
	/**����*/
	RAD(Math.PI),
	/**�ٷֶ�*/
	GRAD(200),
	/**��*/
	MIN(10800),
	/**��*/
	SEC(648000),
	;
	
	
	private final double val;
	
	private Angle(double val){
		this.val = val;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.Valable#value()
	 */
	@Override
	public double doubleValue() {
		return val;
	}
	
}