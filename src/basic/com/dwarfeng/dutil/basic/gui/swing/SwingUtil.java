package com.dwarfeng.dutil.basic.gui.swing;

import java.util.Locale;
import java.util.Objects;

import javax.swing.JFileChooser;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * swing���߰���
 * <p> �ð��а������ڶ�swing������в����ĳ��÷�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public final class SwingUtil {

	//��ֹ�ⲿʵ������
	private SwingUtil() {}

	/**
	 * ����ָ�����ļ�ѡ���������Ի�����
	 * <p> ������� <code>locale</code>Ϊ <code>null</code>��
	 * @param fileChooser ָ�����ļ�ѡ������
	 * @param locale ָ�������Ի�����
	 * @throws NullPointerException ��ڲ��� <code>fileChooser</code> Ϊ <code>null</code>��
	 */
	public static void setJFileChooserLocal(JFileChooser fileChooser, Locale locale){
		Objects.requireNonNull(fileChooser, DwarfUtil.getStringField(StringFieldKey.SwingUtil_0));
		fileChooser.setLocale(locale);
		fileChooser.updateUI();
	}
	
}
