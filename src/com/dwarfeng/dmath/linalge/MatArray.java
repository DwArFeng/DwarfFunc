package com.dwarfeng.dmath.linalge;

import com.dwarfeng.dmath.DMath;
import com.dwarfeng.dmath.algebra.NumBase;
import com.dwarfeng.dmath.algebra.Valueable;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 1.8
 */
public interface MatArray extends DMath, NumBase{

	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int rows();
	
	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int ranks();
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param rank ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 */
	public Valueable getValueable(int row, int rank);
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public RowVector getRowVector(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param rank ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws ָ�����кų��硣
	 */
	public RankVector getRankVector(int rank);
	
	
	
}
