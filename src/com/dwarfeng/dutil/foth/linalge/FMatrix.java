package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.infs.Buildable;
import com.dwarfeng.dutil.foth.algebra.FValue;
import com.dwarfeng.dutil.foth.algebra.FVariableSpace;
import com.dwarfeng.dutil.foth.algebra.QuickFValue;
import com.dwarfeng.dutil.math.AbstractDMath;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class FMatrix extends AbstractDMath implements FMatArray{
	
	/**�����ֵ*/
	protected final FValue[][] vals;
	/**����ı����ռ�*/
	protected final FVariableSpace vs;

	
	/**
	 * ͨ����ά˫���ȸ������鹹�����
	 * @param vals ָ����˫���ȸ������顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�������к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ������л��еĴ�СΪ0��
	 */
	public FMatrix(double[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.FMatrix_1));
		}
		for(double[] ds : vals){
			Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.FMatrix_0));
		}
		
		FValue[][] valueables = new FValue[vals.length][vals[0].length];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; i ++){
				valueables[i][j] = new QuickFValue(vals[i][j]);
			}
		}
		this.vals = valueables;
		this.vs = FVariableSpace.EMPTY;
	}
	
	/**
	 * ͨ��ָ����ֵ�����ά�������ɾ���
	 * @param vals ָ����ֵ�����ά���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�������к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ������л��еĴ�СΪ0��
	 */
	public FMatrix(FValue[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.FMatrix_1));
		}
		for(FValue[] ds : vals){
			ArrayUtil.requireNotContainsNull(ds, DwarfUtil.getStringField(StringFieldKey.FMatrix_0));
		}
		
		FVariableSpace.Builder builder = new FVariableSpace.Builder();
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; i ++){
				builder.add(vals[i][j]);
			}
		}
		
		this.vals = vals;
		this.vs = builder.build();
	}
	
	
	/**
	 * �����˫���ȸ��㹹������
	 * <p> ˫���ȸ��㹹�������ʼ��һ��ָ���л����еĶ�ά˫���ȸ������飬���еĳ�ʼֵΪ0��
	 * <br> ���Ը��������еĶ�ά����ָ����λ�ø�ֵ��
	 * @author DwArFeng
	 * @since 1.8
	 */
	public final static class DoubleBuilder implements Buildable<FMatrix>{
		
		private final FVariableSpace vs = FVariableSpace.EMPTY;
		private final double[][] vals;

		/**
		 * ����һ������ָ�����е�˫���Ⱦ���������
		 * @param row ָ�����С�
		 * @param rank ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public DoubleBuilder(int row, int rank) {
			if(row < 1 || rank < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FMatrix_2));
			}
			this.vals = new double[row][rank];
		}
		
		/**
		 * Ϊָ�����д���λ�ø�ֵ��
		 * @param row ָ�����С�
		 * @param rank ָ�����С�
		 * @param val ָ����ֵ��
		 * @return ����������
		 * @throws IndexOutOfBoundsException ���кų��硣
		 */
		public DoubleBuilder setVal(int row, int rank, double val){
			
			vals[row][rank] = val;
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public FMatrix build() {
			FValue[][] fValues = new FValue[vals.length][vals[0].length];
			
			for(int i = 0 ; i < vals.length ; i ++){
				for(int j = 0 ; j < vals[0].length ; j ++){
					fValues[i][j] = new QuickFValue(vals[i][j]);
				}
			}
			return new FMatrix(fValues, vs);
		}
		
	}
	
	/**
	 * �����ֵ����������
	 * <p> ֵ�����������ʼ��һ��ָ���л����еĶ�άֵ�������飬���еĳ�ʼֵΪ {@link QuickFValue#ZERO}��
	 * <br> ���Ը��������еĶ�ά����ָ����λ�ø�ֵ��
	 * @author DwArFeng
	 * @since 1.8
	 */
	public final static class ValueableBuilder implements Buildable<FMatrix>{
		
		private final FVariableSpace.Builder builder;
		private final FValue[][] vals;

		/**
		 * ����һ������ָ����������ֵ�������������
		 * @param row ָ�����С�
		 * @param rank ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public ValueableBuilder(int row, int rank) {
			if(row < 1 || rank < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FMatrix_2));
			}
			
			builder = new FVariableSpace.Builder();
			this.vals = new FValue[rank][row];
		}
		
		/**
		 * Ϊָ�����д���λ�ø�ֵ��
		 * @param row ָ�����С�
		 * @param rank ָ�����С�
		 * @param val ָ����ֵ��
		 * @return ����������
		 * @throws IndexOutOfBoundsException ���кų��硣
		 */
		public ValueableBuilder setVal(int row, int rank, FValue val){
			
			FValue value = vals[row][rank];
			this.builder.remove(value);
			this.builder.add(val);
			this.vals[row][rank] = val;
			
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public FMatrix build() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
	private FMatrix(FValue[][] vals, FVariableSpace vs) {
		this.vals = vals;
		this.vs = vs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Linalge_Matrix);
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

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfoth.algebra.NumBased#variableSpace()
	 */
	@Override
	public FVariableSpace variableSpace() {
		return vs;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#rows()
	 */
	@Override
	public int rows() {
		return vals.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#ranks()
	 */
	@Override
	public int ranks() {
		return vals[0].length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfoth.linalge.FMatArray#fValueAt(int, int)
	 */
	@Override
	public FValue fValueAt(int row, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRowVector(int)
	 */
	@Override
	public FRowVector fRowVectorAt(int row) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRankVector(int)
	 */
	@Override
	public FRankVector fRankVectorAt(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

}
