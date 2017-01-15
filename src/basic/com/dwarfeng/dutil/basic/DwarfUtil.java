package com.dwarfeng.dutil.basic;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
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
 * @since 0.0.2-beta
 */
public final class DwarfUtil {
	
	public static void main(String[] args){
		CT.setOutputType(OutputType.NO_DATE);
		CT.trace(DwarfUtil.getWelcomeString());
	}
	
	//��ֹ�ⲿʵ����
	private DwarfUtil(){}

	private static final String SF_PATH = "com/dwarfeng/dutil/resource/lang/stringField";
	
	private static final Version version = new DefaultVersion.Builder()
			.type(VersionType.BETA).firstVersion((byte) 0).secondVersion((byte) 0).thirdVersion((byte) 2)
			.buildDate("20170115").buildVersion('B')
			.build();
	
	private static ResourceBundle sf = ResourceBundle.getBundle(SF_PATH,Locale.getDefault(),CT.class.getClassLoader());
	
	/**
	 * ���쳣���ı��ֶ���������Ϊָ�����ԡ�
	 * <p> ��� <code>local</code> Ϊ <code>null</code>����ʹ�� {@link Locale#getDefault()}
	 * @param locale ָ�������ԡ�
	 */
	public static void setLocale(Locale locale){
		if(Objects.isNull(locale)) locale = Locale.getDefault();
		sf =  ResourceBundle.getBundle(SF_PATH,locale,DwarfUtil.class.getClassLoader());
	}
	
	/**
	 * �����쳣�ı��ֶ�����ö�ٷ�����������Ӧ���ı���
	 * <p> �����ڲ��� <code>key</code> Ϊ <code>null</code>���򷵻ؿ��ַ���<code>""</code>��
	 * @param key �쳣�ı��ֶ�����ö�١�
	 * @return ������Ӧ���ı���
	 */
	public static String getStringField(StringFieldKey key){
		if(Objects.isNull(key)) return "";
		return sf.getString(key.toString());
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
	
	private static final String LF_PATH = "resource/lang/labelField";
	
	private static final Map<Locale, ResourceBundle> labelFieldMap = new HashMap<>();
	
	/**
	 * ��ȡָ�����Ի����µı�ǩ�ֶΡ�
	 * <p> �����ڲ��� <code>key</code> Ϊ <code>null</code>���򷵻ؿ��ַ���<code>""</code>��
	 * <p> ��� <code>local</code> Ϊ <code>null</code>����ʹ�� {@link Locale#getDefault()}
	 * @param key ָ���ı�ǩ����
	 * @param locale ָ�������Ի�����
	 * @return ָ����ǩ�������Ի����µı�ǩ�ֶΡ�
	 */
	public static String getLabelField(LabelFieldKey key, Locale locale){
		if(Objects.isNull(key)) return "";
		if(Objects.isNull(locale)) locale = Locale.getDefault();
		
		ResourceBundle rb = labelFieldMap.get(locale);
		//�ӳټ���
		if(Objects.isNull(rb)){
			rb = ResourceBundle.getBundle(LF_PATH, locale, DwarfUtil.class.getClassLoader());
			labelFieldMap.put(locale, rb);
		}
		
		return rb.getString(key.toString());
	}
	
}

