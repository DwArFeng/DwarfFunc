package com.dwarfeng.dwarffunction;

import java.util.Locale;
import java.util.ResourceBundle;

import com.dwarfeng.dwarffunction.io.CT;
import com.dwarfeng.dwarffunction.io.CT.OutputType;
import com.dwarfeng.dwarffunction.program.DefaultVersion;
import com.dwarfeng.dwarffunction.program.Version;
import com.dwarfeng.dwarffunction.program.VersionType;

/**
 * �й���������߰���һЩ���ã���Ҫ���������á�
 * @author DwArFeng
 * @since 1.8
 */
public final class DwarfFunction {
	
	public static void main(String[] args){
		CT.setOutputType(OutputType.NO_DATE);
		CT.trace(DwarfFunction.getWelcomeString());
	}
	
	private static final String exceptionSfPath = "resource/lang/stringField";
	
	private static final Version version = new DefaultVersion.Productor()
			.type(VersionType.ALPHA).firstVersion((byte) 0).secondVersion((byte) 0).thirdVersion((byte) 3)
			.buildDate("20160803").buildVersion('A')
			.product();
	
	/**
	 * ����������߰��������쳣�ı��ֶε�����ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum StringFiledKey{
		
		/**��ӭ�ı��ֶ�*/
		WelcomeString,
		/**DuplicateIdException���0���ı��ֶ�*/
		DuplicateIdException_0 ,
		/**ToStringComparator���0���ı��ֶ�*/
		ToStringComparator_0,
		/**JAdjustableBorderPanel���0���ı��ֶ�*/
		JAdjustableBorderPanel_0,
		/**NadeRuner���0���ı��ֶ�*/
		NadeRuner_0,
		/**MvcProgram���0���ı��ֶ�*/
		MvcProgram_0,
		/**MvcProgram���1���ı��ֶ�*/
		MvcProgram_1,
		/**MvcProgram���2���ı��ֶ�*/
		MvcProgram_2,
		/**CycledBuffer���0���ı��ֶ�*/
		CycledBuffer_0
		
	}
	
	private static ResourceBundle exceptionSf = ResourceBundle.getBundle(exceptionSfPath,Locale.getDefault(),CT.class.getClassLoader());
	
	/**
	 * ���쳣���ı��ֶ���������Ϊָ�����ԡ�
	 * @param locale ָ�������ԡ�
	 */
	public static void setLocale(Locale locale){
		exceptionSf =  ResourceBundle.getBundle(exceptionSfPath,locale,CT.class.getClassLoader());
	}
	
	/**
	 * �����쳣�ı��ֶ�����ö�ٷ�����������Ӧ���ı���
	 * @param key �쳣�ı��ֶ�����ö�١�
	 * @return ������Ӧ���ı���
	 */
	public static String getStringField(StringFiledKey key){
		try{
			return exceptionSf.getString(key.toString());
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
	
	public static String getWelcomeString(){
		return getStringField(StringFiledKey.WelcomeString) + getVersion().getLongName();
	}
	
	//���ɼ��Ĺ���������
	private DwarfFunction(){}
	
}

