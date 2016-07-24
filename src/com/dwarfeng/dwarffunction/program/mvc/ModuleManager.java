package com.dwarfeng.dwarffunction.program.mvc;

/**
 * ģ�͹�������
 * <p> ��������ģ�͵Ĺ�������
 * <br> ģ�͹��������Է���{@linkplain ModuleControlPort}���ö���{@linkplain ControlManager}���ã�������Ҫ��ʱ����ģ���е����ݻ��߲���ģ�͡�
 * @author DwArFeng
 * @since 1.8
 */
public interface ModuleManager<M extends ModuleControlPort, O extends ProgramConstField> {

	/**
	 * ��ȡģ�͹������е�ģ�Ϳ���վ�㡣
	 * @return ģ�͹������е�ģ�Ϳ���վ�㡣
	 */
	public M getModuleControlPort();
	
	/**
	 * ����ģ�͹������еĳ�������
	 * @return ��������
	 */
	public O getProgramConstField();
	
	/**
	 * ����ģ�͹������еĳ�������
	 * @param programConstField ��������
	 */
	public void setProgramConstField(O programConstField);
	
}
