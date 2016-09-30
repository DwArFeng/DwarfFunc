package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.FValueable;
import com.dwarfeng.dutil.foth.algebra.FNumBased;
import com.dwarfeng.dutil.math.DMath;
import com.dwarfeng.dutil.math.linalge.MatArray;
import com.dwarfeng.dutil.math.linalge.RankVector;
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
	public default double valueableAt(int row, int rank){
		return fValueableAt(row, rank).value();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rowVectorAt(int)
	 */
	@Override
	public default RowVector rowVectorAt(int row){
		double[] ds = new double[ranks()];
		for(int i = 0 ; i < ds.length; i ++){
			ds[i] = valueableAt(row, i);
		}
		return new RowVector(ds);	
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rankVectorAt(int)
	 */
	@Override
	public default RankVector rankVectorAt(int rank) {
		double[] ds = new double[rows()];
		for(int i = 0 ; i < ds.length; i ++){
			ds[i] = valueableAt(i, rank);
		}
		return new RankVector(ds);	
	}
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param rank ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 */
	public FValueable fValueableAt(int row, int rank);
	
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
