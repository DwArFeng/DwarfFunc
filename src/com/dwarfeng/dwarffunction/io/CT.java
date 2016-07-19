package com.dwarfeng.dwarffunction.io;

import java.io.PrintStream;
import java.util.Calendar;


/**
 * ����̨�������<p>
 * �÷��������ڿ���̨���������ʱ���ʽ����Ϣ���൱��ʹ��System.out�������ǰ��ʱ����ڵ���System.out�����Ϣ��
 * @see PrintStream#println()
 * @author ����
 * @since 1.7
 */
public final class CT {
	
	//����̨���ǰ���Ƿ����ϵͳʱ��ı�־
	private static boolean dateTraceFlag = true;
	//����̨�����ʽѡ���־
	private static boolean dataFullFormatFlag = false;
	
	/**
	 * 
	 * @return
	 */
	public static boolean isDateTraceFlag() {
		return dateTraceFlag;
	}
	
	/**
	 * 
	 * @param dateTraceFlag
	 */
	public static void setDateTraceFlag(boolean dateTraceFlag) {
		CT.dateTraceFlag = dateTraceFlag;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isDataFullFormatFlag() {
		return dataFullFormatFlag;
	}
	
	/**
	 * 
	 * @param dataFullFormatFlag
	 */
	public static void setDataFullFormatFlag(boolean dataFullFormatFlag) {
		CT.dataFullFormatFlag = dataFullFormatFlag;
	}
	
	//������ת��Ϊʱ������ı�
	public static String timeFormat(long second){
		long remain = second;
		byte sec;
		byte minute;
		byte hour;
		long day;
		
		sec = (byte) (remain%60);
		remain /= 60;
		minute = (byte) (remain%60);
		remain /= 60;
		hour = (byte) (remain%24);
		day = remain/24;
		
		return day+"Day\t"+hour+":"+minute + ":" + sec;
		
	}
	/**
	 * �ڿ���̨�����һ���ı���
	 * @param s ��Ҫ������ı���
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(String s){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+s;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ������������
	 * @param b ��Ҫ����Ĳ���������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(boolean b){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+b;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ�����ͱ�����
	 * @param i ��Ҫ��������ͱ�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(int i){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+i;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ�������ͱ�����
	 * @param f ��Ҫ����ĸ����ͱ�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(float f){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+f;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ��˫���ȸ��������
	 * @param d ��Ҫ�����˫���ȸ��������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(double d){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+d;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ�������α�����
	 * @param l ��Ҫ����ĳ����α�����
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(long l){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+l;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ���ַ�������
	 * @param c ��Ҫ������ַ�������
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(char c){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+c;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	/**
	 * �ڿ���̨�����һ������
	 * @param o ��Ҫ����Ķ���
	 * @return ��ӡ�ڿ���̨�е��ı����ԡ�
	 */
	public static String trace(Object o){
		String Str =traceCurrentTime(isDataFullFormatFlag())+"  \t"+o;
		if(isDateTraceFlag()) System.out.println(Str);
		return Str;
	}
	
	//���������ʱ�������ʱ�����ʽ��ϵͳʱ��
	private static String traceCurrentTime(Boolean isFullFormat){
		Calendar C = Calendar.getInstance();
		String S = isFullFormat?
				""+C.get(Calendar.YEAR)+"-"+C.get(Calendar.MONTH)+"-"+C.get(Calendar.DATE)
				+" "+C.get(Calendar.HOUR_OF_DAY)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND)
				:C.get(Calendar.HOUR_OF_DAY)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
		return S;
	}
	//���ɼ��Ĺ���������
	private CT(){}
}
