package com.dwarfeng.dutil.basic.prog.mvc;

import com.dwarfeng.dutil.basic.prog.MvcProgram;

/**
 * ���ƹ�������
 * <p> ����ά������Ŀ��Ʋ㡣
 * <br> ���ƹ�����������һ��{@linkplain ControlPort} ������{@linkplain ViewManager}���ã�������ͼ�Ϳ��Ը����û��´���������ʵ���ִ��{@linkplain ControlPort}
 * �еķ�����
 * <br> �������������{@linkplain ViewManager}�е�{@linkplain ViewControlPort}���ã��������������ʱ���Զ���ͼ�´�ָ���������ͼ���µȵȡ�
 * <br> �������������{@linkplain ModelManager }�е�{@linkplain ModelControlPort}���ã��������������ʱ���Ը��Ļ��߷�������ģ�͡�
 * <br> �������������{@linkplain ProgramManager}�е�{@linkplain ProgramControlPort}���ã��������������ʱ���Ե��ó��򼶷�����
 * @author DwArFeng
 * @since 1.8
 */
public interface ControlManager<P extends ProgramControlPort, M extends ModelControlPort, 
V extends ViewControlPort, C extends ControlPort, A extends ProgramAttrSet> {
	
	/**
	 * ��ÿ��ƹ������еĿ���վ�㡣
	 * @return ����վ�㡣
	 */
	public C getControlPort();
	
	/**
	 * ��ÿ��ƹ������е�ģ�Ϳ���վ�㡣
	 * @return ģ�Ϳ���վ�㡣
	 */
	public M getModelControlPort();
	
	/**
	 * ���ÿ��ƹ������е�ģ�Ϳ���վ�㡣
	 * <p> �÷�����{@linkplain MvcProgram}�ĳ�ʼ���������ã��뱣֤����������ط�����Ҫ���ô˷�����
	 * @param modelControlPort ָ����ģ�Ϳ���վ�㡣
	 */
	public void setModelControlPort(M modelControlPort);
	
	/**
	 * ���ؿ��ƹ������е���ͼ����վ�㡣
	 * @return ��ͼ����վ�㡣
	 */
	public V getViewControlPort();
	
	/**
	 * ���ÿ��ƹ������е���ͼ����վ�㡣
	 *  <p> �÷�����{@linkplain MvcProgram}�ĳ�ʼ���������ã��뱣֤����������ط�����Ҫ���ô˷�����
	 * @param viewControlPort ָ������ͼ����վ�㡣
	 */
	public void setViewControlPort(V viewControlPort);
	
	/**
	 * ���ؿ��ƹ������еĳ������վ�㡣
	 * @return �������վ�㡣
	 */
	public P getProgramControlPort();
	
	/**
	 * ���ÿ��ƹ������еĳ������վ�㡣
	 *  <p> �÷�����{@linkplain MvcProgram}�ĳ�ʼ���������ã��뱣֤����������ط�����Ҫ���ô˷�����
	 * @param programControlPort ָ���ĳ������վ�㡣
	 */
	public void setProgramControlPort(P programControlPort);
	
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
