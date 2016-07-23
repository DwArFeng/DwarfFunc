package com.dwarfeng.dwarffunction.program.mvc;

/**
 * ��ͼ��������
 * <p> ��ͼ���������������Ƴ���ı�ʾ��ģ���Ӧ�ð���һ����ͼ����վ�㣬�������վ��Ӧ������ɳ�������ͼ����Ԥ�ڵ����й��ܣ�������ͼ��Ⱦ�����¡����û������ȡ�
 * ��ͼ����վ�ǹ̻�����ͼ�������еġ�
 * <br>��ͼ���������п���վ�����ã��������û��Գ����´�ָ�ָ��ͨ����ͼ���������ܣ�ʱ����ͼ���������Ե��ÿ���վ�е���Ӧ���Ʒ������Գ�����п��ơ�
 * @author DwArFeng
 * @since 1.8
 */
public interface ViewManager<V extends ViewControlPort, C extends ControlPort> {
	
	/**
	 * ��ȡ��ͼ�������е���ͼ����վ�㡣
	 * @return ��ͼ�������е���ͼ����վ�㡣
	 */
	public V getViewControlPort();
	
	/**
	 * ��ø���ͼ���������еĿ�������
	 * @return �ö�����еĿ�������
	 */
	public C getControlPort();
	
	/**
	 * ���ø���ͼ���������еĿ�������
	 * @param controlPort ָ���Ŀ�������
	 */
	public void setControlPort(C controlPort);
	
}
