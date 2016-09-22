package com.dwarfeng.dfunc;

import java.util.Locale;
import java.util.ResourceBundle;

import com.dwarfeng.dfunc.io.CT;
import com.dwarfeng.dfunc.io.CT.OutputType;
import com.dwarfeng.dfunc.prog.DefaultVersion;
import com.dwarfeng.dfunc.prog.Version;
import com.dwarfeng.dfunc.prog.VersionType;

/**
 * �й���������߰���һЩ���ã���Ҫ���������á�
 * @author DwArFeng
 * @since 1.8
 */
public final class DwarfFunction {
	
	public static void main(String[] args){
		DwarfFunction.setLocale(Locale.US);
		CT.setOutputType(OutputType.NO_DATE);
		CT.trace(DwarfFunction.getWelcomeString());
	}
	
	private static final String exceptionSfPath = "lang/stringField";
	
	private static final Version version = new DefaultVersion.Productor()
			.type(VersionType.ALPHA).firstVersion((byte) 0).secondVersion((byte) 1).thirdVersion((byte) 0)
			.buildDate("20160919").buildVersion('A')
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
		/**MvcProgram���3���ı��ֶ�*/
		MvcProgram_3,
		/**CycledBuffer���0���ı��ֶ�*/
		CycledBuffer_0,
		/**ArrayPackUtil���0���ı��ֶ�*/
		ArrayPackUtil_0,
		/**CodeTimer���0���ı��ֶ�*/
		CodeTimer_0,
		/**CodeTimer���1���ı��ֶ�*/
		CodeTimer_1,
		/**EventListenerWeakSet���0���ı��ֶ�*/
		EventListenerWeakSet_0,
		/**MuaListModel���0���ı��ֶ�*/
		MuaListModel_0,
		/**StringBuilderOutputStream���0���ı��ֶ�*/
		StringOutputStream_0,
		/**StringBuilderInputStream���0���ı��ֶ�*/
		StringInputStream_0,
		/**StringBuilderInputStream���0���ı��ֶ�*/
		StringInputStream_1,
		/**ArrayUtil���0���ı��ֶ�*/
		ArrayUtil_0,
		/**AlgebraUtill���0���ı��ֶ�*/
		AlgebraUtil_0,
		/**Algebra��RealNumber�ֶ�*/
		Algebra_RealNumber,
		/**CollectionUtil���0���ı��ֶ�*/
		CollectionUtil_0,
		/**CollectionUtil���1���ı��ֶ�*/
		CollectionUtil_1,
		/**CollectionUtil���2���ı��ֶ�*/
		CollectionUtil_2,
		/**CollectionUtil���3���ı��ֶ�*/
		CollectionUtil_3,
		/**CollectionUtil���4���ı��ֶ�*/
		CollectionUtil_4,
		/**CollectionUtil���5���ı��ֶ�*/
		CollectionUtil_5,
		/**CollectionUtil���6���ı��ֶ�*/
		CollectionUtil_6,
		/**CollectionUtil���7���ı��ֶ�*/
		CollectionUtil_7,
		/**CollectionUtil���8���ı��ֶ�*/
		CollectionUtil_8,
		/**NameableComparator���0���ı��ֶ�*/
		NameableComparator_0,
		/**ValueableComparator���0���ı��ֶ�*/
		ValueableComparator_0,
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

