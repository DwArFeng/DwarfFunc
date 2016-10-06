package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * ��������
 * @author DwArFeng
 * @since 1.8
 */
public class DefaultColumnVector extends AbstractMathObject implements ColumnVector{

	/**�洢��������ֵ������*/
	protected final double[] vals;
	
	/**
	 * ����һ��ֵΪָ���������������
	 * @param vals ָ����ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����Ĵ�СС��1��
	 */
	public DefaultColumnVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_0));
		if(vals.length ==0){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_1));
		}
		
		this.vals = vals;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Linalge_ColVector);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(double val : vals){
			sb		.append(val)
					.append(", ");
		}
		sb		.delete(sb.length()-2, sb.length())
				.append("]")
				.append("T");
		return sb.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.LinalgeVector#size()
	 */
	@Override
	public int size() {
		return vals.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.LinalgeVector#valueAt(int)
	 */
	@Override
	public double valueAt(int index) {
		LinalgeUtil.requireIndexInBound(this, index, DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_4));
		
		return vals[index];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.ColumnVector#add(com.dwarfeng.dutil.math.linalge.ColumnVector)
	 */
	@Override
	public ColumnVector add(ColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_2));
		LinalgeUtil.requireSpecificSize(columnVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_3));

		double[] vs = new double[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i] + columnVector.valueAt(i);
		}
		return new DefaultColumnVector(vs);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.ColumnVector#minus(com.dwarfeng.dutil.math.linalge.ColumnVector)
	 */
	@Override
	public ColumnVector minus(ColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_2));
		LinalgeUtil.requireSpecificSize(columnVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultColumnVector_3));

		double[] vs = new double[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i] - columnVector.valueAt(i);
		}
		return new DefaultColumnVector(vs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.ColumnVector#scale(double)
	 */
	@Override
	public ColumnVector scale(double d){
		double[] vs = new double[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i] * d;
		}
		return new DefaultColumnVector(vs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.ColumnVector#trans()
	 */
	@Override
	public RowVector trans(){
		return new DefaultRowVector(vals);
	}

}
