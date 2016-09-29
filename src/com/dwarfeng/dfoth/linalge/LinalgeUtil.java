package com.dwarfeng.dfoth.linalge;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;

/**
 * �й������Դ����Ĺ��߰���
 * <p> �ð��а������ڶ����Դ������в����ĳ��÷�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 1.8
 */
public final class LinalgeUtil {

	
	/**
	 * ����������������Ƿ��ܹ���ˡ�
	 * <p> �����������п�����˵�ǰ��������ǰ�ߵ��������ں��ߵ�������
	 * @param m1 ��һ���������С�
	 * @param m2 �ڶ����������С�
	 * @return �������������ܷ���ˣ�<code>true</code>Ϊ������ˡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkForMutiply(FMatArray m1, FMatArray m2){
		Objects.requireNonNull(m1, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		
		return m1.rows() == m2.ranks();
	}
	
	/**
	 * Ҫ�����������ܹ���ˡ�
	 * <p> ���������������ˣ����׳� {@link IllegalArgumentException}��
	 * @param m1 ����1��
	 * @param m2 ����2��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ���������޷���ˡ�
	 */
	public static void requireForMutiply(FMatArray m1, FMatArray m2){
		Objects.requireNonNull(m1, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		
		if(m1.rows() != m2.ranks()) throw new IllegalArgumentException();
	}
	
	/**
	 * Ҫ�����������ܹ���ˡ�
	 * <p> ���������������ˣ����׳�����ָ�������ı��� {@link IllegalArgumentException}��
	 * @param m1 ����1��
	 * @param m2 ����2��
	 * @param message ָ���������ı���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ���������޷���ˡ�
	 */
	public static void requireForMutiply(FMatArray m1, FMatArray m2, String message){
		Objects.requireNonNull(m1, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_0));
		
		if(m1.rows() != m2.ranks()) throw new IllegalArgumentException(message);
	}
	
	/**
	 * Ҫ���������ض��Ĵ�С��
	 * <p> �÷������жϾ����Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳� {@link IllegalArgumentException}��
	 * @param mat ָ���ľ���
	 * @param row ָ����������
	 * @param rank ָ����������
	 * @throws NullPointerException ��ڲ���<code>mat</code>Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ���ľ���������������Ҫ��
	 */
	public static void requireSpecificSize(FMatArray mat, int row, int rank){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));
		
		if(mat.rows() != row || mat.ranks() != rank){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Ҫ���������ض��Ĵ�С��
	 * <p> �÷������жϾ����Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳�����ָ�������ı��� {@link IllegalArgumentException}��
	 * @param mat ָ���ľ���
	 * @param row ָ����������
	 * @param rank ָ����������
	 * @param message ָ���������ı���
	 * @throws NullPointerException ��ڲ���<code>mat</code>Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ���ľ���������������Ҫ��
	 */
	public static void requireSpecificSize(FMatArray mat, int row, int rank, String message){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));
		
		if(mat.rows() != row || mat.ranks() != rank){
			throw new IllegalArgumentException(message);
		}
	}
	
	
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param row �кš�
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requrieRowInBound(FMatArray mat, int row){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));

		if(row < 0 || row >= mat.rows()){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳�����ָ�������ı��� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param row �кš�
	 * @param message ָ���������ı���
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requrieRowInBound(FMatArray mat, int row, String message){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));

		if(row < 0 || row >= mat.rows()){
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param rank �кš�
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requireRankInBound(FMatArray mat, int rank){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));

		if(rank < 0 || rank >= mat.ranks()){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳�����ָ�������ı��� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param rank �кš�
	 * @param message ָ���������ı���
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requireRankInBound(FMatArray mat, int rank, String message){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFieldKey.LinalgeUtil_1));

		if(rank < 0 || rank >= mat.ranks()){
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	//��ֹ�ⲿʵ������
	private LinalgeUtil() {}

}
