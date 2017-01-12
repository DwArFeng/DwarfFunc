package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * �й������Դ����Ĺ��߰���
 * <p> �ð��а������ڶ����Դ������в����ĳ��÷�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 0.0.2-beta
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
	public static boolean checkForMutiply(MatrixLike m1, MatrixLike m2){
		Objects.requireNonNull(m1, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		
		return m1.rows() == m2.columns();
	}
	
	/**
	 * Ҫ�����������ܹ���ˡ�
	 * <p> ���������������ˣ����׳� {@link IllegalArgumentException}��
	 * @param m1 ����1��
	 * @param m2 ����2��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ���������޷���ˡ�
	 */
	public static void requireForMutiply(MatrixLike m1, MatrixLike m2){
		Objects.requireNonNull(m1, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		
		if(m1.rows() != m2.columns()) throw new IllegalArgumentException();
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
	public static void requireForMutiply(MatrixLike m1, MatrixLike m2, String message){
		Objects.requireNonNull(m1, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_0));
		
		if(m1.rows() != m2.columns()) throw new IllegalArgumentException(message);
	}
	
	/**
	 * ���ָ�������������������Ƿ��ܹ���ˡ�
	 * @param rowVector ָ������������
	 * @param columnVector ָ������������
	 * @return ָ������������ָ�����������Ƿ��ܹ���ˡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkForMutiply(RowVector rowVector, ColumnVector columnVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_2));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_3));
		
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
	public static void requireForMutiply(RowVector rowVector, ColumnVector columnVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_2));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_3));
		
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
	public static void requireForMutiply(RowVector rowVector, ColumnVector columnVector, String message){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_2));
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_3));
		
		if(rowVector.size() != columnVector.size()){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Ҫ���������ض��Ĵ�С��
	 * <p> �÷������жϾ����Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳� {@link IllegalArgumentException}��
	 * @param mat ָ���ľ���
	 * @param row ָ����������
	 * @param column ָ����������
	 * @throws NullPointerException ��ڲ���<code>mat</code>Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ���ľ���������������Ҫ��
	 */
	public static void requireSpecificSize(MatrixLike mat, int row, int column){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));
		
		if(mat.rows() != row || mat.columns() != column){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Ҫ���������ض��Ĵ�С��
	 * <p> �÷������жϾ����Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳�����ָ�������ı��� {@link IllegalArgumentException}��
	 * @param mat ָ���ľ���
	 * @param row ָ����������
	 * @param column ָ����������
	 * @param message ָ���������ı���
	 * @throws NullPointerException ��ڲ���<code>mat</code>Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ���ľ���������������Ҫ��
	 */
	public static void requireSpecificSize(MatrixLike mat, int row, int column, String message){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));
		
		if(mat.rows() != row || mat.columns() != column){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Ҫ��ָ�������������ض��Ĵ�С��
	 * 	 * <p> �÷������ж������Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳� {@link IllegalArgumentException}��
	 * @param vector ָ����������
	 * @param size ָ���Ĵ�С��
	 * @throws IllegalArgumentException ָ���������������ض��Ĵ�С��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static void requireSpecificSize(LinalgeVector vector, int size){
		Objects.requireNonNull(vector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_4));
		
		if(vector.size() != size){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Ҫ��ָ�������������ض��Ĵ�С��
	 * <p> �÷������ж������Ƿ�����ض��Ĵ�С��
	 * ������ǣ����׳�����ָ�������ı��� {@link IllegalArgumentException}��
	 * @param vector ָ����������
	 * @param size ָ���Ĵ�С��
	 * @param message ָ���������ı���
	 * @throws IllegalArgumentException ָ���������������ض��Ĵ�С��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static void requireSpecificSize(LinalgeVector vector, int size, String message){
		Objects.requireNonNull(vector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_4));

		if(vector.size() != size){
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
	public static void requireRowInBound(MatrixLike mat, int row){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));

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
	public static void requireRowInBound(MatrixLike mat, int row, String message){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));

		if(row < 0 || row >= mat.rows()){
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param column �кš�
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requireColumnInBound(MatrixLike mat, int column){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));

		if(column < 0 || column >= mat.columns()){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Ҫ����������û��Խ�硣
	 * <p> ���Խ�磬���׳�����ָ�������ı��� {@link IndexOutOfBoundsException}
	 * @param mat ָ���ľ���
	 * @param column �кš�
	 * @param message ָ���������ı���
	 * @throws NullPointerException ָ���ľ���Ϊ <code>null</code>��
	 * @throws IndexOutOfBoundsException ָ�����к�Խ�硣
	 */
	public static void requireColumnInBound(MatrixLike mat, int column, String message){
		Objects.requireNonNull(mat, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_1));

		if(column < 0 || column >= mat.columns()){
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	/**
	 * Ҫ��ָ�����û��Խ�硣
	 * <p> ���Խ�磬���׳� {@link IndexOutOfBoundsException}
	 * @param vector ָ���ľ���
	 * @param index ָ������š�
	 * @throws IndexOutOfBoundsException ָ�������Խ�硣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static void requireIndexInBound(LinalgeVector vector, int index){
		Objects.requireNonNull(vector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_4));
		
		if(index <0 || index >= vector.size()){
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Ҫ��ָ�����û��Խ�硣
	 * <p> ���Խ�磬���׳�����ָ�������ı��� {@link IndexOutOfBoundsException}
	 * @param vector ָ���ľ���
	 * @param index ָ������š�
	 * @param message ָ���������ı���
	 * @throws IndexOutOfBoundsException ָ�������Խ�硣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static void requireIndexInBound(LinalgeVector vector, int index, String message){
		Objects.requireNonNull(vector, DwarfUtil.getStringField(StringFieldKey.LinalgeUtil_4));
		
		if(index <0 || index >= vector.size()){
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	//��ֹ�ⲿʵ������
	private LinalgeUtil() {}

}
