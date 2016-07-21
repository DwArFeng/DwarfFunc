package com.dwarfeng.dwarffunction.io;

import java.io.PrintStream;
import java.util.Calendar;


/**
 * ����̨�������<p>
 * �÷��������ڿ���̨���������ʱ���ʽ����Ϣ���൱��ʹ��System.out�������ǰ��ʱ����ڵ���System.out�����Ϣ��
 * <br> ���಻�ܱ��̳С�
 * @see PrintStream#println()
 * @author ����
 * @since 1.7
 */
public final class CT {
	
	public static void main(String[] args){
		//CT.dateTraceFlag = false;
		CT.trace(123);
	}
	
	/**
	 * ������ߵ������ʽ��
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static enum TraceType{
		/**�����ϵͳʱ��*/
		NO_DATE,
		/**�����Ҫϵͳʱ�䣨ʱ���룩*/
		HALF_DATE,
		/**���������ϵͳʱ��*/
		FULL_DATE;
	}
	
	private static TraceType traceType = TraceType.HALF_DATE;
	
	/**
	 * ����������͡�
	 * @return ������͡�
	 */
	public static TraceType getTraceType() {
		return traceType;
	}
	
	/**
	 * ����������͡�
	 * @param traceType ָ����������͡�
	 */
	public static void setTraceType(TraceType traceType) {
		CT.traceType = traceType;
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�е��ı������ǲ���������ڿ���̨�ϡ�
	 * @param s ������ı���
	 * @return �����ı���Ӧ��Ҫ������ı���
	 */
	public static String toString(String s){
		return getTimePrefix() + s;
	}
	/**
	 * �ڿ���̨�����һ���ı���
	 * @param s ��Ҫ������ı���
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(String s){
		System.out.println(toString(s));
		return toString(s);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�еĲ������������ǲ���������ڿ���̨�ϡ�
	 * @param b ����Ĳ���������
	 * @return ���벼��������Ӧ��Ҫ������ı���
	 */
	public static String toString(boolean b){
		return getTimePrefix() + b;
	}
	/**
	 * �ڿ���̨�����һ������������
	 * @param b ��Ҫ����Ĳ���������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(boolean b){
		System.out.println(toString(b));
		return toString(b);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�е����ͱ��������ǲ���������ڿ���̨�ϡ�
	 * @param i ��������ͱ�����
	 * @return �������ͱ�����Ӧ��Ҫ������ı���
	 */
	public static String toString(int i){
		return getTimePrefix() + i;
	}
	/**
	 * �ڿ���̨�����һ�����ͱ�����
	 * @param i ��Ҫ��������ͱ�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(int i){
		System.out.println(toString(i));
		return toString(i);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�еĵ����ȸ�����������ǲ���������ڿ���̨�ϡ�
	 * @param f ����ĵ����ȸ��������
	 * @return ���뵥���ȸ��������Ӧ��Ҫ������ı���
	 */
	public static String toString(float f){
		return getTimePrefix() + f;
	}
	/**
	 * �ڿ���̨�����һ�������ͱ�����
	 * @param f ��Ҫ����ĸ����ͱ�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(float f){
		System.out.println(toString(f));
		return toString(f);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�е�˫���ȸ�����������ǲ���������ڿ���̨�ϡ�
	 * @param d �����˫���ȸ��������
	 * @return ����˫���ȸ��������Ӧ��Ҫ������ı���
	 */
	public static String toString(double d){
		return getTimePrefix() + d;
	}
	/**
	 * �ڿ���̨�����һ��˫���ȸ��������
	 * @param d ��Ҫ�����˫���ȸ��������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(double d){
		System.out.println(toString(d));
		return toString(d);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�еĳ����ͱ��������ǲ���������ڿ���̨�ϡ�
	 * @param l ����ĳ����ͱ�����
	 * @return ���볤���ͱ�����Ӧ��Ҫ������ı���
	 */
	public static String toString(long l){
		return getTimePrefix() + l;
	}
	/**
	 * �ڿ���̨�����һ�������α�����
	 * @param l ��Ҫ����ĳ����α�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(long l){
		System.out.println(toString(l));
		return toString(l);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�е��ַ����������ǲ���������ڿ���̨�ϡ�
	 * @param c ������ַ�������
	 * @return �����ַ�������Ӧ��Ҫ������ı���
	 */
	public static String toString(char c){
		return getTimePrefix() + c;
	}
	/**
	 * �ڿ���̨�����һ���ַ�������
	 * @param c ��Ҫ������ַ�������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(char c){
		System.out.println(toString(c));
		return toString(c);
	}
	
	/**
	 * ���ؽ�Ҫ����ڿ���̨�еĶ��󣬵��ǲ���������ڿ���̨�ϡ�
	 * @param o ����Ķ���
	 * @return ��������Ӧ��Ҫ������ı���
	 */
	public static String toString(Object o){
		return getTimePrefix() + o;
	}
	/**
	 * �ڿ���̨�����һ������
	 * @param o ��Ҫ����Ķ���
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(Object o){
		System.out.println(toString(o));
		return toString(o);
	}
	
	//���������ʱ�������ʱ�����ʽ��ϵͳʱ��
	private static String getTimePrefix(){
		
		Calendar C;
		
		switch (traceType) {
			case FULL_DATE:
				C = Calendar.getInstance();
				return 
						""+C.get(Calendar.YEAR)+"-"+C.get(Calendar.MONTH)+"-"+C.get(Calendar.DATE)
						+" "+C.get(Calendar.HOUR_OF_DAY)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND) + "\t";
			case HALF_DATE:
				 C = Calendar.getInstance();
				 return 
						 C.get(Calendar.HOUR_OF_DAY)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND) + "\t";
			case NO_DATE:
				return "";
			default :
				return "";
		}
		
	}
	
	
	
	//���ɼ��Ĺ���������
	private CT(){}
}
