package com.dwarfeng.dutil.basic.prog;

import java.util.Objects;

/**
 * ӵ��������Ԫ�ؽӿڡ�
 * <p>
 * �ýӿ�ָʾʵ�ִ˽ӿڵ�����һ��ӵ���������ࡣ���������ӵ����ͬ��������
 * ��ô����������ȻӦ����ȣ�������ͨ����ͻ���ԣ�������������಻��ȣ��޷�ͨ����ͻ���ԣ��� ��˵���������ͻ��
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface WithKey<K> {

	/**
	 * ��ȡ��Ԫ�صļ���
	 * 
	 * @return ��Ԫ�صļ���
	 */
	public K getKey();

	/**
	 * ����ָ���Ķ����Ƿ��Ǹ�Ԫ�صļ���
	 * 
	 * @param object
	 *            ָ���Ķ���
	 * @return ָ���Ķ����Ƿ��Ǹ�Ԫ�صļ���
	 */
	public default boolean isKey(Object object) {
		return Objects.equals(getKey(), object);
	}

	/**
	 * ��������ӵ��������Ԫ���Ƿ��ͻ��
	 * <p>
	 * ��ͻ����˼��ָ����Ԫ����ӵ����ͬ��������±��ֲ�һ�£� ���еı����ɾ�������������һ�־���ı��ֲ�һ����
	 * <code> ! this.equals(element)</code>��
	 * 
	 * @param element
	 *            ָ������һ��ӵ��������Ԫ�ء�
	 * @return ����ӵ��������Ԫ���Ƿ��ͻ��
	 */
	public default boolean isConflict(WithKey<K> element) {
		if (Objects.isNull(element))
			return false;
		return Objects.equals(getKey(), element.getKey()) && Objects.equals(this, element);
	}

}
