package com.dwarfeng.dmath.linalge;

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
		return m1.rows() == m2.ranks();
	}
	
	//��ֹ�ⲿʵ������
	private LinalgeUtil() {}

}
