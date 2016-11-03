package com.dwarfeng.dutil.develop.cfg;

import java.util.Map;

/**
 * ����վ�㡣
 * <p>����վ����������ӳ����ϵ�ĺ��ģ�����ӳ����ϵ������ӳ���ڸýӿ���ʵ�֡�
 * <p> ����վ��̳� {@link Map} �ӿڣ�����ӳ��ı༭���������ƣ���һ��ӳ���޷����κα䶯��������վ�㲻�ṩ�κ��п������
 * ��һ��ӳ���޸ĵķ������ڶ���ӳ����ɶ��������ü���ֵ�����޸ģ������޷������ü�������ɾ�������κ���ͼ��ɾ���ü�����Ϊ����
 * �׳� {@link UnsupportedOperationException}��
 * <p> ������վ������ڷ��� {@link ConfigUtil#newConfigPort(Map)} �еõ�Ĭ��ʵ�֡�
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigPort extends Map<ConfigKey, String>{

	/**
	 * ������վ��������ָ�����ü���ӳ��ֵ��
	 * <p> ����ӳ�������������վ��ĵ�һ��ӳ����ʱ����ָ����ֵ����Ϊ�ڶ���ӳ�������ü���ֵ��
	 * ��������κζ�����ֱ�ӷ��� <code>null</code>��
	 * <p> ��ֵ���ɹ������ú󣬲�����ֵ�Ƿ����ֵ��ȣ����ᴥ�����ù۲����Թ۲������֪ͨ��
	 * @param key ָ�������ü���
	 * @param value ָ����ֵ��
	 */
	@Override
	public String put(ConfigKey key, String value);
	
	/**
	 * ע�����ù۲�����
	 * @param obverser ���ù۲�����
	 * @return �Ƿ�ɹ�ע�ᡣ
	 */
	public boolean addObverser(ConfigObverser obverser);
	
	/**
	 * �Ƴ����ù۲�����
	 * @param obverser �۲�����
	 * @return �Ƿ�ɹ��Ƴ���
	 */
	public boolean removeObverser(ConfigObverser obverser);
	
	/**
	 * ������ù۲�����
	 */
	public void clearObverser();
	
	/**
	 * �ж�ӳ�����Ƿ����е�ֵ����Ч��
	 * @return �Ƿ����е�ֵ����Ч��
	 */
	public boolean isAllValueValid();
	
	/**
	 * ��ȡָ�����ü��е�Ĭ��ֵ��
	 * @param configKey ָ�������ü���
	 * @return ָ�����ü��е�Ĭ��ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public String getDefaultValue(ConfigKey configKey);
	
	/**
	 * ��ȡ��Чֵ��
	 * <p> �÷����ж϶�Ӧ�����ü�ֵ�Ƿ���Ч�������Ч���򷵻����ü�ֵ��
	 * ���򷵻�Ԥ���Ĭ��ֵ��
	 * <p> �����ڲ����е����ü������б��У��򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ��Чֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public String getValidValue(ConfigKey configKey);
	
	/**
	 * ��ѯָ�����ü���ֵ�Ƿ���Ч�Ŀ�ݷ�����
	 * @param configKey ָ�������ü���
	 * @return  ָ�������ü���ֵ�Ƿ���Ч��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean isValid(ConfigKey configKey);
	
	/**
	 * ��ѯָ�����ü���ֵ�Ƿ���Ч�Ŀ�ݷ�����
	 * @param configKey ָ�������ü���
	 * @return  ָ�������ü���ֵ�Ƿ���Ч��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean nonValid(ConfigKey configKey);
	
}
