package com.dwarfeng.dfunc.prog.mvc;

import com.dwarfeng.dfunc.prog.MvcProgram;

/**
 * �շ����������վ�㡣
 * <p> �������еĳ����г��򼶷�������ʵ�ϣ��൱��ĳ���û���Լ��ĳ��򼶵ķ�����û�г��򼶵ķ�����ȻҲ�Ͳ���Ҫ��������������ǣ�����{@linkplain MvcProgram}�еļܹ���
 * ����ҪΪ���򷵻�һ��{@linkplain ProgramControlPort}����ˣ�����շ�������վ�����Ϊ��Щû�г��򼶷����ĳ����ṩ�ģ��������վ����ṩһ���������κ�ʵ�ַ�����ʵ�֡�
 * <p> ���ڸ����Ŀ�ľ���Ϊ�˲������κ�ʵ�ַ������̳и��ಢʵ���µķ����ǲ�����ģ���˸������Ϊ���ɼ̳С�
 * @author DwArFeng
 * @since 1.8
 */
public final class EmptyProgramControlPort implements ProgramControlPort {
	
	private final static EmptyProgramControlPort instance = new EmptyProgramControlPort();
	
	/**
	 * ��ȡ�շ����������վ���ʵ����
	 * @return �շ����������վ��ʵ����
	 */
	public static EmptyProgramControlPort getInstance(){return instance;}
	
}


