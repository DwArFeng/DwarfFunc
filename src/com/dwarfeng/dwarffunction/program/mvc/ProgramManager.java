package com.dwarfeng.dwarffunction.program.mvc;

import com.dwarfeng.dwarffunction.program.MvcProgram;

/**
 * �����������
 * <p>���������������������򼶵ķ�������Ƶģ�������Щ����ӵ�к�̨�߳��Լ���Ӧ�ķ��������ֹ��ܼȲ�������ʾ�㣬Ҳ������ģ�Ͳ㣬
 * ���ǳ��򼶵ķ�����
 * <br> ���������������еĳ��򶼾��г��򼶵ķ�����������Щû�г��򼶷����ĳ�����˵��<code>program.mvc</code>���ṩ��
 * һ���������κη����ĳ����������
 * @author DwArFeng
 * @since 1.8
 */
public interface ProgramManager<P extends ProgramControlPort, A extends ProgramAttrSet> {

	/**
	 * ��ȡ����������еĳ������վ�㡣
	 * @return �������վ�㡣
	 */
	public P getProgramControlPort();
	
	/**
	 * ��ȡ����ĳ������ϡ�
	 *  <p> �÷�����{@linkplain MvcProgram}�ĳ�ʼ���������ã��뱣֤����������ط�����Ҫ���ô˷�����
	 * @return ���򼶳������ϡ�
	 */
	public A getProgramAttrSet();
	
}
