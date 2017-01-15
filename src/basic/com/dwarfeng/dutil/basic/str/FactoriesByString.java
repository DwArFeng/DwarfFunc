package com.dwarfeng.dutil.basic.str;

import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * �ṩһЩʹ��String��Ϊ��ڲ����Ĺ���������
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public final class FactoriesByString {
	
	/**
	 * ͨ��ָ�����ַ�����������/������
	 * <p> ָ�����ַ���������ϱ�׼����/���������ʽ��
	 * @param string ָ�����ַ�����
	 * @return ���ַ��������Ĺ���/������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>
	 * @throws IllegalArgumentException ��ڲ������Ǳ�׼�Ĺ���/���������ʽ��
	 */
	public static Locale newLocale(String string){
		Objects.requireNonNull(string, DwarfUtil.getStringField(StringFieldKey.FactoriesByString_0));
		if(!string.matches("[a-z]+(_[A-Z]+(_[a-zA-Z]+)?)?")){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FactoriesByString_1));
		}
		
		StringTokenizer tokenizer = new StringTokenizer(string, "_");
		String language = tokenizer.hasMoreTokens()? tokenizer.nextToken() : "";
		String country = tokenizer.hasMoreTokens()? tokenizer.nextToken() : "";
		String variant  = tokenizer.hasMoreTokens()? tokenizer.nextToken() : "";
		
		return new Locale(language, country, variant);
	}
	
	//��ֹ�ⲿʵ������
	private FactoriesByString() {}

}
