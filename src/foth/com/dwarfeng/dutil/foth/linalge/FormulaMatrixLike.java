package com.dwarfeng.dutil.foth.linalge;

import com.dwarfeng.dutil.foth.algebra.NumberBased;
import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.linalge.MatrixLike;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface FormulaMatrixLike extends MathObject, NumberBased, MatrixLike{
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#valueableAt(int, int)
	 */
	@Override
	public default double valueAt(int row, int column){
		return fothValueAt(row, column).value();
	}
	
	/**
	 * ����ָ�������г�����Ӧ��Ԫ�ء�
	 * @param row ָ�����С�
	 * @param column ָ�����С�
	 * @return ָ�������д���Ӧ��Ԫ�ء�
	 */
	public FothValue fothValueAt(int row, int column);
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#trans()
	 */
	@Override
	public FormulaMatrixLike trans();
	
}
