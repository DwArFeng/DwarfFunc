package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.ExceptionStringKey;
import com.dwarfeng.dutil.basic.prog.Buildable;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * 矩阵类。
 * <p>
 * 该类可以表示线性代数中的矩阵。
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultMatrix extends AbstractMathObject implements Matrix {

	/** 矩阵的值 */
	protected final double[][] vals;

	/**
	 * 通过二维双精度浮点数组构造矩阵。
	 * 
	 * @param vals
	 *            指定的二维双精度浮点数组。
	 * @throws NullPointerException
	 *             入口参数为 <code>null</code>。
	 */
	public DefaultMatrix(double[][] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_0));
		if (vals.length == 0 || vals[0].length == 0) {
			throw new IllegalAccessError(DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_1));
		}

		this.vals = vals;
	}

	/**
	 * 矩阵的构造器。
	 * <p>
	 * 构造器会初始化一个指定行或者列的二维双精度浮点数组，其中的初始值为0。 <br>
	 * 可以给构造器中的二维数组指定的位置赋值。
	 * 
	 * @author DwArFeng
	 * @since 0.0.2-beta
	 */
	public static final class Builder implements Buildable<DefaultMatrix> {

		private final double[][] vals;

		/**
		 * 生成一个拥有指定行数和列数的构造器。
		 * 
		 * @param row
		 *            指定的行数。
		 * @param column
		 *            指定的列数。
		 * @throws IllegalArgumentException
		 *             行数或列数小于1。
		 */
		public Builder(int row, int column) {
			if (row < 1 || column < 1) {
				throw new IllegalArgumentException(DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_1));
			}
			this.vals = new double[row][column];
		}

		/**
		 * 为指定行列处的位置赋值。
		 * 
		 * @param row
		 *            指定的行。
		 * @param column
		 *            指定的列。
		 * @param val
		 *            指定的值。
		 * @return 构造器自身。
		 * @throws IndexOutOfBoundsException
		 *             行列号超界。
		 */
		public Builder setVal(int row, int column, double val) {
			if (row < 1 || row >= vals.length) {
				throw new IndexOutOfBoundsException(DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_2));
			}
			if (column < 1 || column >= vals[0].length) {
				throw new IndexOutOfBoundsException(DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_3));
			}

			vals[row][column] = val;
			return this;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public DefaultMatrix build() {
			return new DefaultMatrix(vals);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getExecptionString(ExceptionStringKey.Linalge_Matrix);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < rows(); i++) {
			sb.append(rowVectorAt(i).getExpression()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append("]");
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DefaultRowVector rowVectorAt(int row) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_2));
		return new DefaultRowVector(vals[row]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DefaultColumnVector columnVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column,
				DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_3));

		double[] valueables = new double[rows()];
		for (int i = 0; i < valueables.length; i++) {
			valueables[i] = vals[i][column];
		}
		return new DefaultColumnVector(valueables);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int rows() {
		return vals.length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int columns() {
		return vals[0].length;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double valueAt(int row, int column) {
		LinalgeUtil.requireRowInBound(this, row, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_2));
		LinalgeUtil.requireColumnInBound(this, column,
				DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_3));
		return vals[row][column];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix add(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(),
				DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_4));

		double ds[][] = new double[rows()][columns()];
		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < ds[0].length; j++) {
				ds[i][j] = vals[i][j] + matrix.valueAt(i, j);
			}
		}
		return new DefaultMatrix(ds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix minus(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_5));
		LinalgeUtil.requireSpecificSize(matrix, rows(), columns(),
				DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_4));

		double ds[][] = new double[rows()][columns()];
		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < ds[0].length; j++) {
				ds[i][j] = vals[i][j] - matrix.valueAt(i, j);
			}
		}
		return new DefaultMatrix(ds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix mul(Matrix matrix) {
		Objects.requireNonNull(matrix, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_5));
		LinalgeUtil.requireForMutiply(this, matrix, DwarfUtil.getExecptionString(ExceptionStringKey.DefaultMatrix_4));

		double ds[][] = new double[rows()][matrix.columns()];
		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < ds[0].length; j++) {
				double sum = 0;
				for (int k = 0; k < columns(); k++) {
					sum += valueAt(i, k) * matrix.valueAt(k, j);
				}
				ds[i][j] = sum;
			}
		}

		return new DefaultMatrix(ds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix scale(double val) {
		double[][] ds = new double[rows()][columns()];

		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < ds[0].length; j++) {
				ds[i][j] = vals[i][j] * val;
			}
		}

		return new DefaultMatrix(ds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix trans() {
		double[][] ds = new double[columns()][rows()];

		for (int i = 0; i < ds.length; i++) {
			for (int j = 0; j < ds[0].length; j++) {
				ds[i][j] = vals[j][i];
			}
		}

		return new DefaultMatrix(ds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (Objects.isNull(obj))
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof DefaultMatrix))
			return false;
		DefaultMatrix matrix = (DefaultMatrix) obj;
		for (int i = 0; i < this.rows(); i++) {
			for (int j = 0; j < this.columns(); j++) {
				if (this.valueAt(i, j) != matrix.valueAt(i, j))
					return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals[0].length; j++) {
				hash += Double.hashCode(vals[i][j]) + 17;
				hash *= 17;
			}
		}
		return hash;
	}
}
