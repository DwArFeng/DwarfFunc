package com.dwarfeng.dwarffunction.program.mvc;

import com.dwarfeng.dwarffunction.program.MvcProgram;

/**
 * ģ�͹�������
 * <p> ��������ģ�͵Ĺ�������
 * <br> ģ�͹��������Է���{@linkplain ModuleControlPort}���ö���{@linkplain ControlManager}���ã�������Ҫ��ʱ����ģ���е����ݻ��߲���ģ�͡�
 * @author DwArFeng
 * @since 1.8
 */
public interface ModuleManager<M extends ModuleControlPort, A extends ProgramAttrSet> {

	/**
	 * ��ȡģ�͹������е�ģ�Ϳ���վ�㡣
	 * @return ģ�͹������е�ģ�Ϳ���վ�㡣
	 */
	public M getModuleControlPort();
	
	/**
	 * ����ģ�͹������еĳ�������
	 * @return ��������
	 */
	public A getProgramAttrSet();
	
	/**
	 * ����ģ�͹������еĳ�������
	 *  <p> �÷�����{@linkplain MvcProgram}�ĳ�ʼ���������ã��뱣֤����������ط�����Ҫ���ô˷�����
	 * @param programAttrSet ��������
	 */
	public void setProgramAttrSet(A programAttrSet);
	
}
