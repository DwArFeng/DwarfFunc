package com.dwarfeng.dwarffunction.comp;

import java.util.Comparator;

import com.dwarfeng.dwarffunction.Setting;
import com.dwarfeng.dwarffunction.Setting.ExceptionSfKey;

/**
 * �����toString�Ƚ����������������<code>toString()</code>�����Ƚ����С��
 * @author DwArFeng
 * @since 1.7
 */
public final class ToStringComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if(o1 == null || o2 == null) throw new NullPointerException(Setting.getExceptionString(ExceptionSfKey.ToStringComparator_0));
		return o1.toString().compareTo(o2.toString());
	}

}