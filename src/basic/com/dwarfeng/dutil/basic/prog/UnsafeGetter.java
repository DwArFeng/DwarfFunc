package com.dwarfeng.dutil.basic.prog;

/**
 * ����ȫ Getter��
 * <p>
 * ����ȫ <code>Getter</code> �ܹ�����ȫ���ṩ��һ��<code>T</code>���͵Ķ����ṩ�������ܻ��׳��쳣��
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface UnsafeGetter<T> {

	/**
	 * ��ȡ Getter �еĶ�Ϸ��
	 * 
	 * @return Getter �еĶ���
	 * @throws ProcessException
	 *             �����쳣��
	 */
	public T get() throws ProcessException;

}
