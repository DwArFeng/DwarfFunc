package com.dwarfeng.dfunc.prog.mvc;

import com.dwarfeng.dfunc.prog.MvcProgram;

/**
 * ������ͼ�������� 
 * <p>�����ṩ��ͼ�����������ʵ�֡� 
 * <br>��Ҫע����ǣ���Ҫ��֮��Ĵ�����ʹ���������κ�set������set������ר��Ϊ{@linkplain MvcProgram}׼��
 * �ģ�����֮�⣬�κδ��붼��Ӧ������ʹ��set������
 * @author DwArFeng
 * @since 1.8
 */
public abstract class AbstractViewManager<V extends ViewControlPort, C extends ControlPort, A extends ProgramAttrSet>
implements ViewManager<V, C, A>{

	@Override
	public abstract V getViewControlPort();

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ViewManager#getControlPort()
	 */
	@Override
	public C getControlPort() {return controlPort;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ViewManager#setControlPort(com.dwarfeng.dwarffunction.program.mvc.ControlPort)
	 */
	@Override
	public void setControlPort(C controlPort) {this.controlPort = controlPort;}
	/**
	 * �ö���Ŀ���վ��
	 */
	protected C controlPort;

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ViewManager#getProgramAttrSet()
	 */
	@Override
	public A getProgramAttrSet() {return programAttrSet;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ViewManager#setProgramAttrSet(com.dwarfeng.dwarffunction.program.mvc.ProgramAttrSet)
	 */
	@Override
	public void setProgramAttrSet(A programAttrSet) {this.programAttrSet = programAttrSet;}
	/**
	 * �ö���ĳ��������ϡ�
	 */
	protected A programAttrSet;

}
