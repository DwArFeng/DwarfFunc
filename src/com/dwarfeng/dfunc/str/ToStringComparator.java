package com.dwarfeng.dfunc.str;

import java.util.Comparator;
import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

/**
 * �����toString�Ƚ����������������<code>toString()</code>�����Ƚ����С��
 * @author DwArFeng
 * @since 1.7
 */
public final class ToStringComparator<T> implements Comparator<T> {

	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T o1, T o2) {
		Objects.requireNonNull(o1, DwarfFunction.getStringField(StringFiledKey.ToStringComparator_0));
		Objects.requireNonNull(o2, DwarfFunction.getStringField(StringFiledKey.ToStringComparator_0));
		return o1.toString().compareTo(o2.toString());
	}

}
