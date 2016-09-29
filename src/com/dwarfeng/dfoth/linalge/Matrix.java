package com.dwarfeng.dfoth.linalge;

import java.util.Objects;

import com.dwarfeng.dfoth.algebra.QuickFVal;
import com.dwarfeng.dfoth.algebra.FValue;
import com.dwarfeng.dfoth.algebra.VariableSpace;
import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;
import com.dwarfeng.dfunc.cna.ArrayUtil;
import com.dwarfeng.dmath.AbstractDMath;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class Matrix extends AbstractDMath implements MatArray{
	
	/**�����ֵ*/
	protected final FValue[][] vals;
	/**����ı����ռ�*/
	protected final VariableSpace vs;

	
	/**
	 * ͨ����ά˫���ȸ������鹹�����
	 * @param vals ָ����˫���ȸ������顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�������к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ������л��еĴ�СΪ0��
	 */
	public Matrix(double[][] vals) {
		Objects.requireNonNull(vals, DwarfFunction.getStringField(StringFieldKey.Matrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfFunction.getStringField(StringFieldKey.Matrix_1));
		}
		for(double[] ds : vals){
			Objects.requireNonNull(ds, DwarfFunction.getStringField(StringFieldKey.Matrix_0));
		}
		
		FValue[][] valueables = new FValue[vals.length][vals[0].length];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; i ++){
				valueables[i][j] = new QuickFVal(vals[i][j]);
			}
		}
		this.vals = valueables;
		this.vs = VariableSpace.EMPTY;
	}
	
	public Matrix(FValue[][] vals) {
		Objects.requireNonNull(vals, DwarfFunction.getStringField(StringFieldKey.Matrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfFunction.getStringField(StringFieldKey.Matrix_1));
		}
		for(FValue[] ds : vals){
			ArrayUtil.requireNotContainsNull(ds, DwarfFunction.getStringField(StringFieldKey.Matrix_0));
		}
		
		VariableSpace.Builder builder = new VariableSpace.Builder();
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; i ++){
				builder.add(vals[i][j]);
			}
		}
		
		this.vals = vals;
		this.vs = builder.build();
	}
	
//	private Matrix(Valueable[][] vals, VariableSpace vs) {
//		this.vals = vals;
//		this.vs = vs;
//	}
	
//	public final static class DoubleBuilder implements Buildable<Matrix>{
//		
//	}
//	
//	public final static class ValueableBuilder implements Buildable<Matrix>{
//		
//	}
	
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfFunction.getStringField(StringFieldKey.Linalge_Matrix);
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
		return vs;
	}

	@Override
	public int rows() {
		return vals.length;
	}

	@Override
	public int ranks() {
		return vals[0].length;
	}

	@Override
	public FValue getValueable(int row, int rank) {
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
