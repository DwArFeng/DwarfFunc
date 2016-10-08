package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.foth.algebra.NumberBased;
import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.linalge.LinalgeVector;

/**
 * ������ʽ�������ӿڡ�
 * <p> �ýӿڴ����ű�����ʽ������һ��ӿڡ�
 * <p> ����<code>Vector</code>�Ǹ����õ����֣�Ϊ������������е�<code>Vector</code>����ʹ��<code>FormulaLinalgeVector</code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface FormulaLinalgeVector extends MathObject, LinalgeVector, NumberBased{

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.LinalgeVector#valueAt(int)
	 */
	@Override
	public default double valueAt(int index){
		return fothValueAt(index).value();
	}
	
	/**
	 * ����ָ����Ŵ���ֵ��
	 * @param index ָ�������С�
	 * @return ָ�������д���Ӧ��ֵ��
	 * @throws IndexOutOfBoundsException ���кų��硣
	 */
	public FothValue fothValueAt(int index);
}
