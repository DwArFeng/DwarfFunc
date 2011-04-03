package com.dwarfeng.dutil.develop.cfg.struct;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;
import com.dwarfeng.dutil.develop.cfg.ExconfigModel;

/**
 * ֵ��������
 * <p>
 * �ý�������Ϊ {@link ExconfigEntry} ��һ���֣�������� {@link ExconfigModel} �У� ������ģ���У�
 * ÿ�����ü�����һ��ֵ���������Ӧ�� ���ڸý�������ʵ�������Ĺ��ܣ� ���Զ�����ģ���ж������ı����໥ת�������ṩ������
 * <p>
 * �ýṹ����һ�� {@link String}ֵ����Ϊָʾ�����ͣ� ʹ�ý��������Խ�����ģ���е���Чֱֵ�ӽ������û�ϣ��ʹ�õ����ͣ�
 * ����ʡȥ�˶�����ģ�ͽ��и��ӵ���д�� ͬʱ���ýṹҲ�����˽�һ������ת��Ϊ�ı��ķ����� ���������û����õ�ǰֵʱ�� ����ֱ�ӽ���ǰֵ����Ϊ����
 * ���������ⲿ�����б�д����ת�����ı��ķ�����
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ValueParser {

	/**
	 * ��һ�� String ����ֵ������ {@link Object} ����
	 * <p>
	 * ע�⣺�÷�����Ӧ���׳��쳣����Ϊ�ھ��� {@link ConfigChecker} ��ɸѡ֮��Ӧ���ܱ�֤����ýӿڵ�ֵ������ȷ����ġ�
	 * 
	 * @param value
	 *            ָ���� String ֵ��
	 * @return �����ɵ� {@link Object} ����
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException
	 *             ָ�����ַ����޷�������
	 */
	public Object parseValue(String value);

	/**
	 * ��һ������������ַ�����
	 * <p>
	 * ����һ�����ü�ͨ��ֻ��Ӧһ���������ͣ� �����ת��ֵ�Ĺ����У� �������Ķ�������Ͳ�������������ʱ�� ���ص��ַ���Ӧ������Ч�ģ�
	 * �����ص��ַ�����Ӧ��ͨ����ֵ������������ģ���ж�Ӧ�����ü���Ӧ��ֵ�������
	 * 
	 * @param object
	 *            ָ���Ķ���
	 * @return ��ָ����������ɵ��ַ�����
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException
	 *             ָ���Ķ����޷�����Ϊ�ַ�����
	 */
	public String parseObject(Object object);

}
