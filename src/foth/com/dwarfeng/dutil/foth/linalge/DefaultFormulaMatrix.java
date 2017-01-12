package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.prog.Buildable;
import com.dwarfeng.dutil.foth.algebra.FothVariableSpace;
import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.foth.algebra.QuickFothValue;
import com.dwarfeng.dutil.math.AbstractMathObject;
import com.dwarfeng.dutil.math.linalge.DefaultMatrix;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;
import com.dwarfeng.dutil.math.linalge.Matrix;

/**
 * �����ࡣ
 * <p> {@link FormulaMatrix}��Ĭ��ʵ�֡�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultFormulaMatrix extends AbstractMathObject implements FormulaMatrix{
	
	/**�����ֵ*/
	protected final FothValue[][] vals;
	/**����ı����ռ�*/
	protected final FothVariableSpace vs;

	/**
	 * ͨ��math���еľ�����þ���
	 * @param matrix math���еľ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ���ľ�����л���С��1��
	 */
	public DefaultFormulaMatrix(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_5));
		if(matrix.rows() < 1 || matrix.columns() < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_1));
		}
		
		FothValue[][] vals = new FothValue[matrix.rows()][matrix.columns()];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[0].length ; j ++){
				vals[i][j] =new QuickFothValue( matrix.valueAt(i, j));
			}
		}
		
		this.vals = vals;
		this.vs = FothVariableSpace.EMPTY;
	}
	
	/**
	 * ͨ����ά˫���ȸ������鹹�����
	 * @param vals ָ����˫���ȸ������顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�������к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ������л��еĴ�СΪ0��
	 */
	public DefaultFormulaMatrix(double[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_1));
		}
		for(double[] ds : vals){
			Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_0));
		}
		
		FothValue[][] valueables = new FothValue[vals.length][vals[0].length];
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[i].length ; j ++){
				valueables[i][j] = new QuickFothValue(vals[i][j]);
			}
		}
		this.vals = valueables;
		this.vs = FothVariableSpace.EMPTY;
	}
	
	/**
	 * ͨ��ָ����ֵ�����ά�������ɾ���
	 * @param vals ָ����ֵ�����ά���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�������к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ������л��еĴ�СΪ0��
	 */
	public DefaultFormulaMatrix(FothValue[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_1));
		}
		for(FothValue[] ds : vals){
			ArrayUtil.requireNotContainsNull(ds, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_0));
		}
		
		FothVariableSpace.Builder builder = new FothVariableSpace.Builder();
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
	 * @since 0.0.2-beta
	 */
	public final static class DoubleBuilder implements Buildable<DefaultFormulaMatrix>{
		
		private final FothVariableSpace vs = FothVariableSpace.EMPTY;
		private final double[][] vals;

		/**
		 * ����һ������ָ�����е�˫���Ⱦ���������
		 * @param row ָ�����С�
		 * @param column ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public DoubleBuilder(int row, int column) {
			if(row < 1 || column < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_1));
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
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_3));
			}
			if(column < 1 || column >= vals[0].length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_4));
			}
			
			vals[row][column] = val;
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public DefaultFormulaMatrix build() {
			FothValue[][] fValues = new FothValue[vals.length][vals[0].length];
			
			for(int i = 0 ; i < vals.length ; i ++){
				for(int j = 0 ; j < vals[0].length ; j ++){
					fValues[i][j] = new QuickFothValue(vals[i][j]);
				}
			}
			return new DefaultFormulaMatrix(fValues, vs);
		}
		
	}
	
	/**
	 * �����ֵ����������
	 * <p> ֵ�����������ʼ��һ��ָ���л����еĶ�άֵ�������飬���еĳ�ʼֵΪ {@link QuickFothValue#ZERO}��
	 * <br> ���Ը��������еĶ�ά����ָ����λ�ø�ֵ��
	 * @author DwArFeng
	 * @since 0.0.2-beta
	 */
	public final static class FValueBuilder implements Buildable<DefaultFormulaMatrix>{
		
		private final FothVariableSpace.Builder builder;
		private final FothValue[][] vals;

		/**
		 * ����һ������ָ����������ֵ�������������
		 * @param row ָ�����С�
		 * @param column ָ�����С�
		 * @throws IllegalArgumentException ָ�����л�����С��1��
		 */
		public FValueBuilder(int row, int column) {
			if(row < 1 || column < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_1));
			}
			
			builder = new FothVariableSpace.Builder();
			this.vals = new FothValue[column][row];
			
			for(int i = 0 ; i < vals.length ; i ++){
				for(int j = 0 ; j < vals[0].length ; j ++){
					vals[i][j] = QuickFothValue.ZERO;
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
		public FValueBuilder setVal(int row, int column, FothValue val){
			Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_2));
			if(row < 1 || row >= vals.length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_3));
			}
			if(column < 1 || column >= vals[0].length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_4));
			}
			
			FothValue value = vals[row][column];
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
		public DefaultFormulaMatrix build() {
			return new DefaultFormulaMatrix(vals, builder.build());
		}
		
	}
	
	
	private DefaultFormulaMatrix(FothValue[][] vals, FothVariableSpace vs) {
		this.vals = vals;
		this.vs = vs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.AbstractMathObject#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Linalge_Matrix);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.AbstractMathObject#getExpression()
	 */
	@Override
	public String getExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0 ; i < rows() ; i ++){
			sb		.append(formulaRowVectorAt(i).getExpression())
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
	public FothVariableSpace variableSpace() {
		return vs;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#rows()
	 */
	@Override
	public int rows() {
		return vals.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#columns()
	 */
	@Override
	public int columns() {
		return vals[0].length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrixLike#fothValueAt(int, int)
	 */
	@Override
	public FothValue fothValueAt(int row, int column) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_3));
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_4));
		return vals[row][column];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#formulaRowVectorAt(int)
	 */
	@Override
	public DefaultFormulaRowVector formulaRowVectorAt(int row) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_3));
		return new DefaultFormulaRowVector(vals[row]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#formulaColumnVectorAt(int)
	 */
	@Override
	public DefalutFormulaColumnVector formulaColumnVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_4));
		
		FothValue[] valueables = new FothValue[rows()];
		for(int i = 0 ; i < valueables.length ; i ++){
			valueables[i] = vals[i][column];
		}
		return new DefalutFormulaColumnVector(valueables);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#add(com.dwarfeng.dutil.foth.linalge.FormulaMatrix)
	 */
	public FormulaMatrix add(FormulaMatrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_6));
		
		double ds[][] = new double[rows()][columns()];
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j].value() + matrix.valueAt(i, j);
			}
		}
		return new DefaultFormulaMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#minus(com.dwarfeng.dutil.foth.linalge.FormulaMatrix)
	 */
	@Override
	public FormulaMatrix minus(FormulaMatrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_6));
		
		double ds[][] = new double[rows()][columns()];
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j].value() - matrix.valueAt(i, j);
			}
		}
		return new DefaultFormulaMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#mul(com.dwarfeng.dutil.foth.linalge.FormulaMatrix)
	 */
	@Override
	public FormulaMatrix mul(FormulaMatrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_5));
		LinalgeUtil.requireForMutiply(this, matrix, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaMatrix_6));
		
		double ds[][] = new double[rows()][matrix.columns()];
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				double sum = 0;
				for(int k = 0 ; k < columns() ; k ++){
					sum += valueAt(i, k) * matrix.valueAt(k, j);
				}
				ds[i][j] = sum;
			}
		}
		
		return new DefaultFormulaMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#scale(double)
	 */
	@Override
	public FormulaMatrix scale(double val) {
		double[][] ds = new double[rows()][columns()];
		
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j].value() * val;
			}
		}
		
		return new DefaultFormulaMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#trans()
	 */
	@Override
	public FormulaMatrix trans() {
		double[][] ds = new double[columns()][rows()];
		
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[j][i].value();
			}
		}
		
		return new DefaultFormulaMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaMatrix#toMatrix()
	 */
	@Override
	public Matrix toMatrix() {
		double[][] ds = new double[rows()][columns()];
		
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j].value();
			}
		}
		
		return new DefaultMatrix(ds);
	}

}
