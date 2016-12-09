package com.dwarfeng.dutil.develop.cfg;

import java.util.Set;

/**
 * ����ӳ�䡣
 * <p> �ýӿڶ��������õĽṹ��ϵ��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigModel{
	
	/**
	 * ɾ��������ӳ���е�����ӳ�䣨��ѡ��������
	 * <p> �Ӵ�ӳ�����Ƴ�����ӳ���ϵ����ѡ���������˵��÷��غ󣬸�ӳ�佫Ϊ�ա�
	 * @throws UnsupportedOperationException ���ӳ�䲻֧�ִ˲�����
	 */
	public void clear();
	
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
	
	/**
	 * ��ȡ������ӳ�����ڼ��ϡ�
	 * <p> �ü�����ֻ���ģ���ͼ�������еķ������׳� {@link UnsupportedOperationException}��
	 * @return ������ӳ�����ڼ��ϡ�
	 */
	public Set<ConfigEntry> entrySet();
	
	
}
