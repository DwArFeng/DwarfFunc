package com.dwarfeng.dutil.basic.prog;

/**
 * ӵ��������Ԫ�ؽӿڡ�
 * <p> �ýӿ�ָʾʵ�ִ˽ӿڵ�����һ��ӵ���������ࡣ���������ӵ����ͬ��������
 * ��ô����������ȻӦ����ȣ�������ͨ����ͻ���ԣ�������������಻��ȣ��޷�ͨ����ͻ���ԣ���
 * ��˵���������ͻ��
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ElementWithKey<K> {
	
	/**
	 * ��ȡ��Ԫ�صļ���
	 * @return ��Ԫ�صļ���
	 */
	public K getKey();
	
	/**
	 * ����ָ���Ķ����Ƿ��Ǹ�Ԫ�صļ���
	 * @param object ָ���Ķ���
	 * @return ָ���Ķ����Ƿ��Ǹ�Ԫ�صļ���
	 */
	public boolean testKey(Object object);
	
	/**
	 * ��������ӵ��������Ԫ���Ƿ��ͻ��
	 * <p> ��ͻ����˼��ָ����Ԫ����ӵ����ͬ��������±��ֲ�һ�£�
	 * ���еı����ɾ�������������һ�־���ı��ֲ�һ���� <code> ! this.equals(element)</code>��
	 * @param element ָ������һ��ӵ��������Ԫ�ء�
	 * @return ����ӵ��������Ԫ���Ƿ��ͻ��
	 */
	public boolean isConflict(ElementWithKey<K> element);

}
