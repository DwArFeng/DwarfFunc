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
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rowVectorAt(int)
	 */
	@Override
	public DefaultRowVector rowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_2));
		return new DefaultRowVector(vals[row]);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#colVectorAt(int)
	 */
	@Override
	public DefaultColumnVector colVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.DefaultMatrix_3));
		
		double[] valueables = new double[rows()];
		for(int i = 0 ; i < valueables.length ; i ++){
			valueables[i] = vals[i][column];
		}
		return new DefaultColumnVector(valueables);
	}

}
