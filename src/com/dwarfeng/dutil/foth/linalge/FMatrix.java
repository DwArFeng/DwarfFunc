package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.infs.Buildable;
import com.dwarfeng.dutil.foth.algebra.FormulaValue;
import com.dwarfeng.dutil.foth.algebra.FVariableSpace;
import com.dwarfeng.dutil.foth.algebra.QuickFValue;
import com.dwarfeng.dutil.math.AbstractMathObject;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class FMatrix extends AbstractMathObject implements FormulaMatrixLike{
	
	/**�����ֵ*/
	protected final FormulaValue[][] vals;
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
		
		FormulaValue[][] valueables = new FormulaValue[vals.length][vals[0].length];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; j ++){
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
	public FMatrix(FormulaValue[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.FMatrix_1));
		}
		for(FormulaValue[] ds : vals){
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
		 * @param column ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public DoubleBuilder(int row, int column) {
			if(row < 1 || column < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FMatrix_1));
			}
			this.vals = new double[row][column];
		}
		
		/**
		 * Ϊָ�����д���λ�ø�ֵ��
		 * @param row ָ�����С�
		 * @param column ָ�����С�
		 * @param val ָ����ֵ��
		 * @return ����������
		 * @throws IndexOutOfBoundsException ���кų��硣
		 */
		public DoubleBuilder setVal(int row, int column, double val){
			if(row < 1 || row >= vals.length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.FMatrix_3));
			}
			if(column < 1 || column >= vals[0].length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.FMatrix_4));
			}
			
			vals[row][column] = val;
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public FMatrix build() {
			FormulaValue[][] fValues = new FormulaValue[vals.length][vals[0].length];
			
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
	public final static class FValueBuilder implements Buildable<FMatrix>{
		
		private final FVariableSpace.Builder builder;
		private final FormulaValue[][] vals;

		/**
		 * ����һ������ָ����������ֵ�������������
		 * @param row ָ�����С�
		 * @param column ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public FValueBuilder(int row, int column) {
			if(row < 1 || column < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FMatrix_1));
			}
			
			builder = new FVariableSpace.Builder();
			this.vals = new FormulaValue[column][row];
			
			for(int i = 0 ; i < vals.length ; i ++){
				for(int j = 0 ; j < vals[0].length ; j ++){
					vals[i][j] = QuickFValue.ZERO;
				}
			}
		}
		
		/**
		 * Ϊָ�����д���λ�ø�ֵ��
		 * @param row ָ�����С�
		 * @param column ָ�����С�
		 * @param val ָ����ֵ��
		 * @return ����������
		 * @throws IndexOutOfBoundsException ���кų��硣
		 * @throws NullPointerException ��ڲ��� <code>val</code>Ϊ <code>null</code>��
		 */
		public FValueBuilder setVal(int row, int column, FormulaValue val){
			Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FMatrix_2));
			if(row < 1 || row >= vals.length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.FMatrix_3));
			}
			if(column < 1 || column >= vals[0].length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.FMatrix_4));
			}
			
			FormulaValue value = vals[row][column];
			this.builder.remove(value);
			this.builder.add(val);
			this.vals[row][column] = val;
			
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public FMatrix build() {
			return new FMatrix(vals, builder.build());
		}
		
	}
	
	
	private FMatrix(FormulaValue[][] vals, FVariableSpace vs) {
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
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0 ; i < rows() ; i ++){
			sb		.append(fRowVectorAt(i).getExpression())
					.append(", ");
		}
		sb.delete(sb.length()-2, sb.length()).append("]");
		return sb.toString();
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
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#columns()
	 */
	@Override
	public int columns() {
		return vals[0].length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfoth.linalge.FMatArray#fValueAt(int, int)
	 */
	@Override
	public FormulaValue formulaValueAt(int row, int column) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FMatrix_3));
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.FMatrix_4));
		return vals[row][column];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRowVector(int)
	 */
	@Override
	public DefaultFormulaRowVector fRowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FMatrix_3));
		return new DefaultFormulaRowVector(vals[row]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FMatArray#fColVectorAt(int)
	 */
	@Override
	public DefalutFormulaColumnVector fColVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.FMatrix_4));
		
		FormulaValue[] valueables = new FormulaValue[rows()];
		for(int i = 0 ; i < valueables.length ; i ++){
			valueables[i] = vals[i][column];
		}
		return new DefalutFormulaColumnVector(valueables);
	}
	
	

}
