package com.dwarfeng.dfunc.prog.mvc;

import com.dwarfeng.dfunc.prog.MvcProgram;

/**
 * ����ģ�͹������� 
 * <p>�����ṩģ�͹����������ʵ�֡� 
 * <br>��Ҫע����ǣ���Ҫ��֮��Ĵ�����ʹ���������κ�set������set������ר��Ϊ{@linkplain MvcProgram}׼��
 * �ģ�����֮�⣬�κδ��붼��Ӧ������ʹ��set������
 * @author DwArFeng
 * @since 1.8
 */
public abstract class AbstractModuleManager<M extends ModuleControlPort, A extends ProgramAttrSet> 
implements ModuleManager<M, A> {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModuleManager#getModuleControlPort()
	 */
	@Override
	public abstract M getModuleControlPort();

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModuleManager#getProgramAttrSet()
	 */
	@Override
	public A getProgramAttrSet() {return programAttrSet;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModuleManager#setProgramAttrSet(com.dwarfeng.dwarffunction.program.mvc.ProgramAttrSet)
	 */
	@Override
	public void setProgramAttrSet(A programAttrSet) {this.programAttrSet = programAttrSet;}
	/**
	 * �ö���ĳ��������ϡ�
	 */
	protected A programAttrSet;

}
