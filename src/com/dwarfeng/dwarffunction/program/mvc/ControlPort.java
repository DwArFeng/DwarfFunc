package com.dwarfeng.dwarffunction.program.mvc;

/**
 * ����վ��
 * <p> ����վ����ͨ���ƶ���{@linkplain ControlManager}��ȡ���ö�������Ӧ��{@linkplain ViewManager}�г������á�
 * <br> {@linkplain ViewManager} ���Խ����ܵ����û�ָ��ݵ������У���ʵ�ֿ��Ʒ�����
 * <br> ��Ȼÿ������Ŀ���վ��Ŀ��Ʒ����Ƕ��ֶ����ģ����ǻ�������ͬ�ĵط�������ÿ������Ҫ�����͹رյȵȡ�
 * ����վ���ж�����ÿ�����򶼱���ʵ�ֵķ�����
 * @author DwArFeng
 * @since 1.8
 */
public interface ControlPort {
	
	/**
	 * ��������ķ�����
	 * <br> �÷�����������������
	 * <br> ����������������������������ĳ���������ִ��<code>main</code>����ʱ���Ѿ��������ˣ������������ָ��
	 * ���������ʾ����ʾ����Ļ�ϣ��Լ�һЩ�����ĵ��ȹ��̡�
	 */
	public void startProgram();
	
	/**
	 * �رճ���ķ�����
	 * <br> �÷���Ӧ����ֹ�������һ�е��ȣ��Ƿ�ִ��<code>exit</code>�����������졣
	 */
	public void endProgram();

}
