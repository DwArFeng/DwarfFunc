package com.dwarfeng.dutil.basic;

import java.util.Locale;
import java.util.ResourceBundle;

import com.dwarfeng.dutil.basic.io.CT;
import com.dwarfeng.dutil.basic.io.CT.OutputType;
import com.dwarfeng.dutil.basic.prog.DefaultVersion;
import com.dwarfeng.dutil.basic.prog.Version;
import com.dwarfeng.dutil.basic.prog.VersionType;

/**
 * DwarfUtil���߰������ࡣ
 * <p>������DwarfUtil���߰�����������Ϣ�ࡣ�ù��߰��еĸ��ָ�����Ϣ����汾��Ϣ����������������л�ã�
 * ͬʱ���ù��߰������ð�������Ҳͨ������ķ��������á�
 * 
 * <p>�ð��ǹ��߰������еķ�����Ϊ��̬���������ڸð������ʣ��ð��������ⲿʵ������������̳С�
 * 
 * <p> �ð��еķ��������̲߳���ȫ�ģ������Ҫ���̵߳��øð��еķ�������ʹ���ⲿͬ�����롣
 * @author DwArFeng
 * @since 1.8
 */
public final class DwarfUtil {
	
	public static void main(String[] args){
		CT.setOutputType(OutputType.NO_DATE);
		CT.trace(DwarfUtil.getWelcomeString());
	}
	
	private static final String sfPath = "resource/lang/stringField";
	
	private static final Version version = new DefaultVersion.Builder()
			.type(VersionType.ALPHA).firstVersion((byte) 0).secondVersion((byte) 3).thirdVersion((byte) 0)
			.buildDate("20161101").buildVersion('A')
			.build();
	
	private static ResourceBundle sf = ResourceBundle.getBundle(sfPath,Locale.getDefault(),CT.class.getClassLoader());
	
	/**
	 * ���쳣���ı��ֶ���������Ϊָ�����ԡ�
	 * @param locale ָ�������ԡ�
	 */
	public static void setLocale(Locale locale){
		sf =  ResourceBundle.getBundle(sfPath,locale,CT.class.getClassLoader());
	}
	
	/**
	 * �����쳣�ı��ֶ�����ö�ٷ�����������Ӧ���ı���
	 * @param key �쳣�ı��ֶ�����ö�١�
	 * @return ������Ӧ���ı���
	 */
	public static String getStringField(StringFieldKey key){
		try{
			return sf.getString(key.toString());
		}catch(Exception e){
			return "";
		}
	}
	
	/**
	 * ���ظù��߰��İ汾��
	 * @return �ù��߰��İ汾��
	 */
	public static Version getVersion(){
		return version;
	}
	
	/**
	 * ���ظð��Ļ�ӭ�ı���
	 * @return �ð��Ļ�ӭ 
	 */
	public static String getWelcomeString(){
		return getStringField(StringFieldKey.WelcomeString) + getVersion().getLongName();
	}
	
	//��ֹ�ⲿʵ����
	private DwarfUtil(){}
	
}

