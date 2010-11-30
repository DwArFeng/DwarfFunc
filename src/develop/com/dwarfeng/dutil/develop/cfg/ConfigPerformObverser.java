package com.dwarfeng.dutil.develop.cfg;

import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ���ù۲�����
 * <p> �ù۲��������ڡ����֡�����˼�Ǹù۲��������õĵ�ǰֵ�Ƚ����У�
 * ����ǰֵӳ�䷢���޸�ʱ���ù۲����ܹ��������嵽ĳһ�ֶΡ��ɵĵ�ǰֵ���µĵ�ǰֵ������Ӧ��
 * ����Ӧ����ƫ���ڹ��̡�
 * <p> ͨ���������е�һ���֣����������У����ö��ǿ����ڳ����б��޸ĵġ������еĺܴ�һ������Ҫ��
 * �����޸ĺ�������Ч��֪ͨ�ض������ü�ֵ���޸ģ����ҵ�����Ӧ�ķ�������������ù۲��������á�
 * <p> ���ù۲�����Ҫ���ⲿ�ṩ�ù۲����Ƿ��ĳ��ֵ����Ȥ��������������Ȥ�ļ�ֵ��������ʱ���ͻ�Թ۲�������֪ͨ��
 * ����������ı��ֵ�Ǹù۲���������Ȥ�ģ���ʲôҲ������
 * 
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigPerformObverser extends Obverser{
	
	/**
	 * ֪ͨĿ��ָ�������÷����˸ı䡣
	 * @param configKey ָ�������ü���
	 * @param oldValue ���ü��ľ�ֵ��
	 * @param newValue ���ü�����ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void fireValueChanged(ConfigKey configKey, String oldValue, String newValue);
	
}
