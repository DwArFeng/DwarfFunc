package com.dwarfeng.dfunc.infs;

/**
 * ����������Ľṹ��ӵ��һ����<code>T</code>�Ĺ��췽����
 * @author DwArFeng
 * @since 1.8
 */
public interface Buildable<T> {

	/**
	 * �����µ�Tʵ����
	 * @return �µ�ʵ����
	 */
	public T build();
}
