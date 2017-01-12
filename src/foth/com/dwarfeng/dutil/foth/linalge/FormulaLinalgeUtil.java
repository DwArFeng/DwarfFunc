package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * �й��ڽṹ�������Դ����Ĺ��߰���
 * <p> �ð��а������ڶ����Դ������в����ĳ��÷�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public final class FormulaLinalgeUtil {
	
	/**
	 * ���ָ�������������������Ƿ��ܹ���ˡ�
	 * @param rowVector ָ������������
	 * @param columnVector ָ������������
	 * @return ָ������������ָ�����������Ƿ��ܹ���ˡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkForMutiply(FormulaRowVector rowVector, FormulaColumnVector columnVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_0));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_1));
		
		return rowVector.size() == columnVector.size();
	}
	
	/**
	 * Ҫ��ָ������������ָ�����������ܹ���ˡ�
	 * <p> �����������������������ˣ����׳� {@link IllegalArgumentException}��
	 * @param rowVector ָ������������
	 * @param columnVector ָ������������
	 * @throws IllegalArgumentException ָ������������������������ˡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static void requireForMutiply(FormulaRowVector rowVector, FormulaColumnVector columnVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_0));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_1));
		
		if(rowVector.size() != columnVector.size()){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Ҫ��ָ������������ָ�����������ܹ���ˡ�
	 * <p> �����������������������ˣ����׳�����ָ�������ı��� {@link IllegalArgumentException}��
	 * @param rowVector ָ������������
	 * @param columnVector ָ������������
	 * @param message ָ���������ı���
	 * @throws IllegalArgumentException ָ�������������������������ʱ�׳����쳣��
	 * @throws NullPointerException ��ڲ���Ϊ  <code>null</code>��
	 */
	public static void requireForMutiply(FormulaRowVector rowVector, FormulaColumnVector columnVector, String message){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_0));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.FormulaLinalgeUtil_1));
		
		if(rowVector.size() != columnVector.size()){
			throw new IllegalArgumentException(message);
		}
	}

	//�������ⲿʵ����
	private FormulaLinalgeUtil() {}
}
