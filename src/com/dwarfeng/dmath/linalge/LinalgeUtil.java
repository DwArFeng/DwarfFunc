package com.dwarfeng.dmath.linalge;

import java.util.Formatter;
import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

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
	 * @return �������������ܷ���ˡ�
	 */
	public static boolean checkForMutiply(MatArray m1, MatArray m2){
		Objects.requireNonNull(m1, DwarfFunction.getStringField(StringFiledKey.LinalgeUtil_0));
		Objects.requireNonNull(m2, DwarfFunction.getStringField(StringFiledKey.LinalgeUtil_0));
		
		return m1.rows() == m2.ranks();
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
	public static void requireSpecificSize(MatArray mat, int row, int rank){
		Objects.requireNonNull(mat, DwarfFunction.getStringField(StringFiledKey.LinalgeUtil_1));
		
		if(mat.rows() != row || mat.ranks() != rank){
			StringBuilder sb = new StringBuilder();
			Formatter formatter = new Formatter(sb);
			try{
				formatter.format(DwarfFunction.getStringField(
						StringFiledKey.LinalgeUtil_2),
						row, rank, mat.rows(), mat.ranks()
				);
			}finally{
				formatter.close();
			}
			throw new IllegalArgumentException(sb.toString());
		}
	}
	
	//��ֹ�ⲿʵ������
	private LinalgeUtil() {}

}
