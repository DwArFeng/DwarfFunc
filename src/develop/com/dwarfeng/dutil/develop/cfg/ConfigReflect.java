package com.dwarfeng.dutil.develop.cfg;

/**
 * ����ӳ�䡣
 * <p> �ýӿڶ��������õĽṹ��ϵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigReflect {
	
	/**
	 * ɾ��������ӳ���е�����ӳ�䣨��ѡ��������
	 * <p> �Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ���������˵��÷��غ󣬸�ӳ�佫Ϊ�ա�
	 * @throws UnsupportedOperationException ���ӳ�䲻֧�ִ˲�����
	 */
	public void clear();
	
	/**
	 * ��ȡ������ӳ���е�ָ�������ü���Ӧ���������ԡ�
	 * <p> ��������ü�����ӳ���У��򷵻�  <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ���ü���Ӧ������ֵ��
	 */
	public ConfigProperties get(ConfigKey configKey);
	
	/**
	 * �����ӳ��δ������-ֵӳ���ϵ���򷵻� <code>true</code>��
	 * @return �����ӳ��δ������-ֵӳ���ϵ���򷵻� <code>true</code>��
	 */
	public boolean isEmpty();
	
	/**
	 * ����վ�������ü���������
	 * @return ���ü���������
	 */
	public int size();
	
}
