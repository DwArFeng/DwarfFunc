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
public abstract class AbstractModelManager<M extends ModelControlPort, A extends ProgramAttrSet> 
implements ModelManager<M, A> {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModelManager#getModelControlPort()
	 */
	@Override
	public abstract M getModelControlPort();

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModelManager#getProgramAttrSet()
	 */
	@Override
	public A getProgramAttrSet() {return programAttrSet;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ModelManager#setProgramAttrSet(com.dwarfeng.dwarffunction.program.mvc.ProgramAttrSet)
	 */
	@Override
	public void setProgramAttrSet(A programAttrSet) {this.programAttrSet = programAttrSet;}
	/**
	 * �ö���ĳ��������ϡ�
	 */
	protected A programAttrSet;

}
