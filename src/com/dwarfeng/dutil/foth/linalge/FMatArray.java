package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FValue;
import com.dwarfeng.dutil.foth.algebra.NumBased;
import com.dwarfeng.dutil.math.DMath;
import com.dwarfeng.dutil.math.linalge.MatArray;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 1.8
 */
public interface FMatArray extends DMath, NumBased, MatArray{
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param rank ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 */
	public FValue fValueAt(int row, int rank);
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public FRowVector fRowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param rank ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws ָ�����кų��硣
	 */
	public FRankVector fRankVectorAt(int rank);
	
	
	
}
