package com.dwarfeng.dutil.math.linalge;

import com.dwarfeng.dutil.math.DMath;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 1.8
 */
public interface MatArray extends DMath{

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
	 * @throws IndexOutOfBoundsException ���кų��硣
	 */
	public double valueableAt(int row, int rank);
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public RowVector rowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param rank ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public RankVector rankVectorAt(int rank);
	
	
	
}
