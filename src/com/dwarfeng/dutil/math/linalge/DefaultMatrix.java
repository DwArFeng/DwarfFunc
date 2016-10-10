package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.infs.Buildable;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * �����ࡣ
 * <p> ������Ա�ʾ���Դ����еľ���
 * @author DwArFeng
 * @since 1.8
 */
public class DefaultMatrix extends AbstractMathObject implements Matrix{
	
	/**�����ֵ*/
	protected final double[][] vals;
	
	/**
	 * ͨ����ά˫���ȸ������鹹�����
	 * @param vals ָ���Ķ�ά˫���ȸ������顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultMatrix(double[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_0));
		if(vals.length == 0 || vals[0].length == 0){
			throw new IllegalAccessError(DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_1));
		}
		
		this.vals = vals;
	}
	
	/**
	 * ����Ĺ�������
	 * <p> ���������ʼ��һ��ָ���л����еĶ�ά˫���ȸ������飬���еĳ�ʼֵΪ0��
	 * <br> ���Ը��������еĶ�ά����ָ����λ�ø�ֵ��
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static final class Builder implements Buildable<DefaultMatrix>{
		
		private final double[][] vals;

		/**
		 * ����һ��ӵ��ָ�������������Ĺ�������
		 * @param row ָ����������
		 * @param column ָ����������
		 * @throws IllegalArgumentException ����������С��1��
		 */
		public Builder(int row, int column) {
			if(row < 1 || column < 1){
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_1));
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
		public Builder setVal(int row, int column, double val){
			if(row < 1 || row >= vals.length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_2));
			}
			if(column < 1 || column >= vals[0].length){
				throw new IndexOutOfBoundsException(DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_3));
			}
			
			vals[row][column] = val;
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.basic.infs.Buildable#build()
		 */
		@Override
		public DefaultMatrix build() {
			return new DefaultMatrix(vals);
		}
		
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
			sb		.append(rowVectorAt(i).getExpression())
					.append(", ");
		}
		sb.delete(sb.length()-2, sb.length()).append("]");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#rowVectorAt(int)
	 */
	@Override
	public DefaultRowVector rowVectorAt(int row) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_2));
		return new DefaultRowVector(vals[row]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#columnVectorAt(int)
	 */
	@Override
	public DefaultColumnVector columnVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_3));
		
		double[] valueables = new double[rows()];
		for(int i = 0 ; i < valueables.length ; i ++){
			valueables[i] = vals[i][column];
		}
		return new DefaultColumnVector(valueables);
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
	 * @see com.dwarfeng.dutil.math.linalge.MatrixLike#valueAt(int, int)
	 */
	@Override
	public double valueAt(int row, int column) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_2));
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_3));
		return vals[row][column];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#add(com.dwarfeng.dutil.math.linalge.Matrix)
	 */
	@Override
	public Matrix add(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_4));
		
		double ds[][] = new double[rows()][columns()];
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j] + matrix.valueAt(i, j);
			}
		}
		return new DefaultMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#minus(com.dwarfeng.dutil.math.linalge.Matrix)
	 */
	@Override
	public Matrix minus(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_4));
		
		double ds[][] = new double[rows()][columns()];
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j] - matrix.valueAt(i, j);
			}
		}
		return new DefaultMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#mul(com.dwarfeng.dutil.math.linalge.Matrix)
	 */
	@Override
	public Matrix mul(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_5));
		LinalgeUtil.requireForMutiply(this, matrix,  DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_4));
		
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
		
		return new DefaultMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#scale(double)
	 */
	@Override
	public Matrix scale(double val) {
		double[][] ds = new double[rows()][columns()];
		
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[i][j] * val;
			}
		}
		
		return new DefaultMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.Matrix#trans()
	 */
	@Override
	public Matrix trans() {
		double[][] ds = new double[columns()][rows()];
		
		for(int i = 0 ; i < ds.length ; i ++){
			for(int j = 0 ; j < ds[0].length ; j ++){
				ds[i][j] = vals[j][i];
			}
		}
		
		return new DefaultMatrix(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(Objects.isNull(obj)) return false;
		if(obj == this) return true;
		if(! (obj instanceof DefaultMatrix)) return false;
		DefaultMatrix matrix = (DefaultMatrix) obj;
		for(int i = 0 ; i < this.rows() ; i ++){
			for(int j = 0 ; j < this.columns() ; j ++){
				if(this.valueAt(i, j) != matrix.valueAt(i, j)) return false;
			}
		}
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		for(int i = 0 ; i < vals.length ; i ++){
			for(int j = 0 ; j < vals[0].length ; j ++){
				hash += Double.hashCode(vals[i][j]) + 17;
				hash *= 17;
			}
		}
		return hash;
	}
}
