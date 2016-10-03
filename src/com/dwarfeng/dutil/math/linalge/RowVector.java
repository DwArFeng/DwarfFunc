package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.math.AbstractDMath;

/**
 * ��������
 * @author DwArFeng
 * @since 1.8
 */
public class RowVector extends AbstractDMath implements MatArray{

	/**�洢������ֵ������*/
	protected final double[] vals;
	
	/**
	 * ����һ��ֵΪָ���������������
	 * @param vals ָ����ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����Ĵ�СС��1��
	 */
	public RowVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.RowVector_0));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.RowVector_1));
		}
		
		this.vals = vals;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rows()
	 */
	@Override
	public int rows() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#columns()
	 */
	@Override
	public int columns() {
		return vals.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#valueableAt(int, int)
	 */
	@Override
	public double valueableAt(int row, int column) {
		LinalgeUtil.requrieRowInBound(this, row);
		LinalgeUtil.requireColumnInBound(this, column);
		return vals[column];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#rowVectorAt(int)
	 */
	@Override
	public RowVector rowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#colVectorAt(int)
	 */
	@Override
	public ColVector colVectorAt(int column) {
		LinalgeUtil.requrieRowInBound(this, column);
		return new ColVector(new double[]{vals[column]});
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Linalge_RowVector);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(double val : vals){
			sb		.append(val)
					.append(", ");
		}
		sb.delete(sb.length()-2, sb.length()).append("]");
		return sb.toString();
	}
	
	/**
	 * ������������һ����������ӡ�
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param rowVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ĳߴ粻ƥ�䡣
	 */
	public RowVector add(RowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.RowVector_2));
		LinalgeUtil.requireSpecificSize(rowVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.RowVector_3));
		
		double[] vs = new double[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i] + rowVector.vals[i];
		}
		return new RowVector(vs);
	}
	
	/**
	 * ������������һ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param rowVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ĳߴ粻ƥ�䡣
	 */
	public RowVector minus(RowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.RowVector_2));
		LinalgeUtil.requireSpecificSize(rowVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.RowVector_3));
		
		double[] vs = new double[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i] - rowVector.vals[i];
		}
		return new RowVector(vs);
	}
	
	/**
	 * ����������ָ������������ˡ�
	 * <p> ע�⣺����������Ҫ�ܹ������������ˣ���������������Ҫ�����������������ȡ�
	 * <p> ע�⣺��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param colVector ָ���ص���������
	 * @return �����õ���ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ�������������������������ˡ�
	 */
	public double mul(ColVector colVector){
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.RowVector_4));
		LinalgeUtil.requireForMutiply(this, colVector, DwarfUtil.getStringField(StringFieldKey.RowVector_5));
		
		double sum = 0;
		for(int i = 0 ; i < columns() ; i ++){
			double v1 = this.valueableAt(0, i);
			double v2 = colVector.valueableAt(i, 0);
			sum = sum + (v1 *v2);
		}
		
		return sum;
	}
	
	/**
	 * ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param d ָ����ֵ��
	 * @return ָ����ֵ�����������˵õ�����������
	 */
	public RowVector mul(double d){
		double[] ds = new double[vals.length];
		for(int i = 0 ; i  < ds.length ; i ++){
			ds[i] = vals[i] * d;
		}
		return new RowVector(ds);
	}
	
	/**
	 * ���ظ���������ת����������
	 * <p> ��ת�ò������ƻ��ṹ��
	 * @return ת����������
	 */
	public ColVector trans(){
		return new ColVector(vals);
	}
}
