package com.dwarfeng.dmath.linalge;

import com.dwarfeng.dmath.AbstractDMath;
import com.dwarfeng.dmath.algebra.Valueable;
import com.dwarfeng.dmath.algebra.VariableSpace;
import com.dwarfeng.dmath.algebra.VariableValue;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class Matrix extends AbstractDMath implements MatArray{
	
	public final Valueable[][] vals;

	public Matrix(double[][] vals) {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VariableSpace getVariableSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(VariableValue t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canModify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int rows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ranks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Valueable getValueable(int row, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowVector getRowVector(int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RankVector getRankVector(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

}
