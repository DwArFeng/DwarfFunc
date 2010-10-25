package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FValue;
import com.dwarfeng.dutil.foth.algebra.FNumBased;
import com.dwarfeng.dutil.math.DMath;
import com.dwarfeng.dutil.math.linalge.MatArray;
import com.dwarfeng.dutil.math.linalge.ColVector;
import com.dwarfeng.dutil.math.linalge.RowVector;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 1.8
 */
public interface FMatArray extends DMath, FNumBased, MatArray{
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#valueableAt(int, int)
	 */
	@Override
	public default double valueAt(int row, int column){
		return fValueAt(row, column).value();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rowVectorAt(int)
	 */
	@Override
	public default RowVector rowVectorAt(int row){
		double[] ds = new double[columns()];
		for(int i = 0 ; i < ds.length; i ++){
			ds[i] = valueAt(row, i);
		}
		return new RowVector(ds);	
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#colVectorAt(int)
	 */
	@Override
	public default ColVector colVectorAt(int column) {
		double[] ds = new double[rows()];
		for(int i = 0 ; i < ds.length; i ++){
			ds[i] = valueAt(i, column);
		}
		return new ColVector(ds);	
	}
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param column ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 */
	public FValue fValueAt(int row, int column);
	
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param row ָ���С�
	 * @return ָ���ж�Ӧ����������
	 * @throws IndexOutOfBoundsException ָ�����кų��硣
	 */
	public FRowVector fRowVectorAt(int row);
	/**
	 * ����ָ���ж�Ӧ����������
	 * @param column ָ�����С�
	 * @return ָ����������Ӧ����������
	 * @throws ָ�����кų��硣
	 */
	public FColVector fColVectorAt(int column);
	
	
	
}
