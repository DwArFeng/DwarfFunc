package com.dwarfeng.dwarffunction;

import java.util.Locale;
import java.util.ResourceBundle;

import com.dwarfeng.dwarffunction.io.CT;
import com.dwarfeng.dwarffunction.program.DefaultVersion;
import com.dwarfeng.dwarffunction.program.Version;
import com.dwarfeng.dwarffunction.program.VersionType;

/**
 * �й���������߰���һЩ���ã���Ҫ���������á�
 * @author DwArFeng
 * @since 1.8
 */
public final class Setting {
	
	private static final String exceptionSfPath = "resource/lang/exceptionSf";
	
	private static final Version version = new DefaultVersion.Productor()
			.type(VersionType.ALPHA).firstVersion((byte) 0).secondVersion((byte) 0).thirdVersion((byte) 0)
			.buildDate("20160721").buildVersion('A')
			.product();
	
	/**
	 * ����������߰��������쳣�ı��ֶε�����ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum ExceptionSfKey{
		
		/**DuplicateIdException���0���ı��ֶ�*/
		DuplicateIdException_0 ,
		/**ToStringComparator���0���ı��ֶ�*/
		ToStringComparator_0,
		/**JAdjustableBorderPanel���0���ı��ֶ�*/
		JAdjustableBorderPanel_0
		
	}
	
	private static ResourceBundle exceptionSf = ResourceBundle.getBundle(exceptionSfPath,Locale.getDefault(),CT.class.getClassLoader());
	
	/**
	 * ���쳣���ı��ֶ���������Ϊָ�����ԡ�
	 * @param locale ָ�������ԡ�
	 */
	public static void setExceptionSfLocale(Locale locale){
		exceptionSf =  ResourceBundle.getBundle(exceptionSfPath,locale,CT.class.getClassLoader());
	}
	
	/**
	 * �����쳣�ı��ֶ�����ö�ٷ�����������Ӧ���ı���
	 * @param key �쳣�ı��ֶ�����ö�١�
	 * @return ������Ӧ���ı���
	 */
	public static String getExceptionString(ExceptionSfKey key){
		try{
			return exceptionSf.getString(key.toString());
		}catch(Exception e){
			return "";
		}
	}
	
	public static Version getVersion(){
		return version;
	}
	
	//���ɼ��Ĺ���������
	private Setting(){}
	
}

