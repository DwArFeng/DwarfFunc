package com.dwarfeng.dutil.basic.prog;

/**
 * ����������Ľṹ��ӵ��һ����<code>T</code>�Ĺ��췽����
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface Buildable<T> {

	/**
	 * �����µ�Tʵ����
	 * @return �µ�ʵ����
	 */
	public T build();
}
