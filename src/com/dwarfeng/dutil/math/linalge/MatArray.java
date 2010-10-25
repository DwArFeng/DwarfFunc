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
	public int columns();
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param column ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 * @throws IndexOutOfBoundsException ���кų��硣
	 */
	public double valueAt(int row, int column);
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public RowVector rowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param column ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public ColVector colVectorAt(int column);
	
	
	
}
