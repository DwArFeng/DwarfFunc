package com.dwarfeng.dfoth.algebra;

import java.util.Comparator;
import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;

/**
 * ֵ�Ƚ�����
 * <p> �ñȽ����ɱȽ�����ֵ�����ֵ��С��
 * @author DwArFeng
 * @since 1.8
 */
public class ValueableComparator implements Comparator<Valueable> {

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Valueable o1, Valueable o2) {
		Objects.requireNonNull(o1, DwarfFunction.getStringField(StringFieldKey.ValueableComparator_0));
		Objects.requireNonNull(o2, DwarfFunction.getStringField(StringFieldKey.ValueableComparator_0));
		return Double.compare(o1.value(), o2.value());
	}

}
