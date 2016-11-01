package com.dwarfeng.dutil.basic.num.unit;

import com.dwarfeng.dutil.basic.num.NumberValue;

/**
 * ʱ��ö�١�
 * @author DwArFeng
 * @since 1.8
 */
public enum Time implements NumberValue{
	
	/**����*/
	NS(86400000000000d),
	/**΢��*/
	US(86400000000d),
	/**����*/
	MS(86400000d),
	/**��*/
	SEC(86400d),
	/**����*/
	MIN(1440d),
	/**Сʱ*/
	HOR(24d),
	/**��*/
	DAY(1d);

	private final double val;
	
	private Time(double val) {
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