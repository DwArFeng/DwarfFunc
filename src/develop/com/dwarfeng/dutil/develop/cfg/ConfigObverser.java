package com.dwarfeng.dutil.develop.cfg;

import com.dwarfeng.dutil.basic.prog.Obverser;

/**
 * ���ù۲�����
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigObverser extends Obverser{

	/**
	 * �����ü��еĵ�ǰֵ�����仯��ʱ��ִ�иõ��ȡ�
	 * @param configKey ָ�������ü���
	 * @param oldValue ���ü��ľ�ֵ��
	 * @param newValue ���ü�����ֵ��
	 */
	public void configChanged(ConfigKey configKey, String oldValue, String newValue);
	
}
