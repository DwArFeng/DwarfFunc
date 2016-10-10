package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.MathObject;

/**
 * �����ӿڡ�
 * <p> �ýӿڴ�����������һ��ӿڡ�
 * <p> ����<code>Vector</code>�Ǹ����õ����֣�Ϊ������������е�<code>Vector</code>����ʹ��<code>LinalgeVector</code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface LinalgeVector extends MathObject{

	/**
	 * ���ظ�������ά�ȡ�
	 * @return ������ά�ȡ�
	 */
	public int size();
	
	/**
	 * ����ָ����Ŵ���ֵ��
	 * @param index ָ�������С�
	 * @return ָ�������д���Ӧ��ֵ��
	 * @throws IndexOutOfBoundsException ���кų��硣
	 */
	public double valueAt(int index);
	
}
