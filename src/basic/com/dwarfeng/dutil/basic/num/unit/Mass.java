package com.dwarfeng.dutil.basic.num.unit;

import com.dwarfeng.dutil.basic.num.NumberValue;

/**
 * ����ö�١�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public enum Mass implements NumberValue{
	
	/**��*/
	T(1d),
	/**ǧ��*/
	KG(1000d),
	/**��*/
	G(1000000d),
	/**����*/
	MG(1000000000d),
	/**��˾*/
	OZ(35273.96194958d),
	/**��*/
	LB(2204.62262185d),
	/**����*/
	DR(564383.39119329d)
	;

	private final double val;
	
	private Mass(double val) {
		this.val = val;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.Valable#value()
	 */
	@Override
	public double doubleValue() {
		return this.val;
	}

}