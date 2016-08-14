package com.dwarfeng.dwarffunction.program.mvc;

/**
 * ���ƹ�������
 * <p> ����ά������Ŀ��Ʋ㡣
 * <br> ���ƹ�����������һ��{@linkplain ControlPort} ������{@linkplain ViewManager}���ã�������ͼ�Ϳ��Ը����û��´���������ʵ���ִ��{@linkplain ControlPort}
 * �еķ�����
 * <br> �������������{@linkplain ViewManager}�е�{@linkplain ViewControlPort}���ã��������������ʱ���Զ���ͼ�´�ָ���������ͼ���µȵȡ�
 * <br> �������������{@linkplain ModuleManager }�е�{@linkplain ModuleControlPort}���ã��������������ʱ���Ը��Ļ��߷�������ģ�͡�
 * <br> �������������{@linkplain ProgramManager}�е�{@linkplain ProgramControlPort}���ã��������������ʱ���Ե��ó��򼶷�����
 * @author DwArFeng
 * @since 1.8
 */
public interface ControlManager<P extends ProgramControlPort, M extends ModuleControlPort, V extends ViewControlPort, C extends ControlPort> {
	
	/**
	 * ��ÿ��ƹ������еĿ���վ�㡣
	 * @return ����վ�㡣
	 */
	public C getControlPort();
	
	/**
	 * ��ÿ��ƹ������е�ģ�Ϳ���վ�㡣
	 * @return ģ�Ϳ���վ�㡣
	 */
	public M getModuleControlPort();
	
	/**
	 * ���ÿ��ƹ������е�ģ�Ϳ���վ�㡣
	 * @param moduleControlPort ָ����ģ�Ϳ���վ�㡣
	 */
	public void setModuleControlPort(M moduleControlPort);
	
	/**
	 * ���ؿ��ƹ������е���ͼ����վ�㡣
	 * @return ��ͼ����վ�㡣
	 */
	public V getViewControlPort();
	
	/**
	 * ���ÿ��ƹ������е���ͼ����վ�㡣
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
	 * @param programControlPort ָ���ĳ������վ�㡣
	 */
	public void setProgramControlPort(P programControlPort);

}
