package com.dwarfeng.dutil.develop.cfg;

import com.dwarfeng.dutil.basic.str.Name;

/**
 * ���ü���
 * <p> �ýӿ�������ӳ����ϵ�µļ������ڱ�ʶ��ͬ�������ֶΡ�
 * ͬʱ���ü�Ҳ�ṩ����ֵ�ļ��鹦�ܣ��������ü������һ��ֵ�Ƿ��ʺϸü���
 * <p> ����Ψһ��ʶ���Ǽ��������̳����ƽӿڣ����뷵��һ����Զ���ܱ仯�Ҳ���Ϊ <code>null</code> �ļ�����
 * ����������ж��������Ƿ���ȵ����ݡ�
 * <p> ͨ����˵��һ�������е����ü���һ���ģ���ö����ʵ�ָýӿ��Զ�����Щ���������ġ�
 * <p> ע�⣺��ͬ���Ƶ����ü�һ��Ҫ��ȣ����б�Ҫ������д {@link Object#equals(Object)}�� {@link Object#hashCode()} ����
 * ����֤��һ�� ���� ��{@link ConfigUtil#equals(ConfigKey, ConfigKey)} �� {@link ConfigUtil#hashCode(ConfigKey)}�еķ���������д�� 
 * 
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigKey extends Name{
	
	/**
	 * ��ȡ�����ü�������ֵ�������
	 * @return ����ֵ�������
	 */
	public ConfigValueChecker getValueChecker();
	
}
