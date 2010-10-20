package com.dwarfeng.dmath.linalge;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;
import com.dwarfeng.dfunc.cna.ArrayUtil;
import com.dwarfeng.dfunc.infs.Buildable;
import com.dwarfeng.dmath.AbstractDMath;
import com.dwarfeng.dmath.algebra.QuickValueable;
import com.dwarfeng.dmath.algebra.Valueable;
import com.dwarfeng.dmath.algebra.VariableSpace;
import com.dwarfeng.dmath.algebra.VariableValue;
import com.dwarfeng.dmath.algebra.VariableSpace.Builder;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class Matrix extends AbstractDMath implements MatArray{
	
	/**�����ֵ*/
	protected final Valueable[][] vals;
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
		
		Valueable[][] valueables = new Valueable[vals.length][vals[0].length];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; i ++){
				valueables[i][j] = new QuickValueable(vals[i][j]);
			}
		}
		this.vals = valueables;
		this.vs = VariableSpace.EMPTY;
	}
	
	public Matrix(Valueable[][] vals) {
		Objects.requireNonNull(vals, DwarfFunction.getStringField(StringFieldKey.Matrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfFunction.getStringField(StringFieldKey.Matrix_1));
		}
		for(Valueable[] ds : vals){
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
