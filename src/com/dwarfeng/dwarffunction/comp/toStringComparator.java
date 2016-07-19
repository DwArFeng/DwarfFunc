package com.dwarfeng.dwarffunction.comp;

import java.util.Comparator;

/**
 * �����toString�Ƚ����������������<code>toString()</code>�����Ƚ����С��
 * @author DwArFeng
 * @since 1.7
 */
public class toStringComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if(o1 == null || o2 == null) throw new NullPointerException("���бȽϵ�o1,o2������Ϊnull");
		return o1.toString().compareTo(o2.toString());
	}

}
