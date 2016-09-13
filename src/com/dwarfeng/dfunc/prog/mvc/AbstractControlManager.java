package com.dwarfeng.dfunc.prog.mvc;

import com.dwarfeng.dfunc.prog.MvcProgram;

/**
 * ������ƹ������� 
 * <p>�����ṩ���ƹ����������ʵ�֡� 
 * <br>��Ҫע����ǣ���Ҫ��֮��Ĵ�����ʹ���������κ�set������set������ר��Ϊ{@linkplain MvcProgram}׼��
 * �ģ�����֮�⣬�κδ��붼��Ӧ������ʹ��set������
 * @author DwArFeng
 * @since 1.8
 */
public abstract class AbstractControlManager<P extends ProgramControlPort, M extends ModelControlPort, 
V extends ViewControlPort, C extends ControlPort, A extends ProgramAttrSet> 
implements ControlManager<P, M, V, C, A> {

	@Override
	public abstract C getControlPort();

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#getModelControlPort()
	 */
	@Override
	public M getModelControlPort() {return modelControlPort;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#setModelControlPort(com.dwarfeng.dwarffunction.program.mvc.ModelControlPort)
	 */
	@Override
	public void setModelControlPort(M modelControlPort) {this.modelControlPort = modelControlPort;}
	/**
	 * �ö����ģ�Ϳ���վ��
	 */
	protected M modelControlPort;

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#getViewControlPort()
	 */
	@Override
	public V getViewControlPort() {return viewControlPort;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#setViewControlPort(com.dwarfeng.dwarffunction.program.mvc.ViewControlPort)
	 */
	@Override
	public void setViewControlPort(V viewControlPort) {this.viewControlPort = viewControlPort;}
	/**
	 * �ö������ͼ����վ��
	 */
	protected V viewControlPort;

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#getProgramControlPort()
	 */
	@Override
	public P getProgramControlPort() {return programControlPort;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#setProgramControlPort(com.dwarfeng.dwarffunction.program.mvc.ProgramControlPort)
	 */
	@Override
	public void setProgramControlPort(P programControlPort) {this.programControlPort = programControlPort;}
	/**
	 * �ö���ĳ������վ��
	 */
	protected P programControlPort;
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#getProgramAttrSet()
	 */
	@Override
	public A getProgramAttrSet() {return programAttrSet;}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.mvc.ControlManager#setProgramAttrSet(com.dwarfeng.dwarffunction.program.mvc.ProgramAttrSet)
	 */
	@Override
	public void setProgramAttrSet(A programAttrSet) {this.programAttrSet = programAttrSet;}
	/**
	 * �ö���ĳ��������ϡ�
	 */
	protected A programAttrSet;

}
