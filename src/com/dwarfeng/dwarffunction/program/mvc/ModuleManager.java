package com.dwarfeng.dwarffunction.program.mvc;

/**
 * ģ�͹�������
 * <p> ��������ģ�͵Ĺ�������
 * <br> ģ�͹��������Է���{@linkplain ModuleControlPort}���ö���{@linkplain ControlManager}���ã�������Ҫ��ʱ����ģ���е����ݻ��߲���ģ�͡�
 * @author DwArFeng
 * @since 1.8
 */
public interface ModuleManager<M extends ModuleControlPort> {

	/**
	 * ��ȡģ�͹������е�ģ�Ϳ���վ�㡣
	 * @return ģ�͹������е�ģ�Ϳ���վ�㡣
	 */
	public M getModuleControlPort();
	
}
