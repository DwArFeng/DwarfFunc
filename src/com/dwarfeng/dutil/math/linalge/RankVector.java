package com.dwarfeng.dutil.math.linalge;

import java.util.Objects;

import com.dwarfeng.dfoth.algebra.FValue;
import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFieldKey;
import com.dwarfeng.dmath.AbstractDMath;

/**
 * ��������
 * @author DwArFeng
 * @since 1.8
 */
public class RankVector extends AbstractDMath implements MatArray{

	/**�洢��������ֵ������*/
	protected final double[] vals;
	
	/**
	 * ����һ��ֵΪָ���������������
	 * @param vals ָ����ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public RankVector(double[] vals) {
		Objects.requireNonNull(vals, )
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
		return 1;
	}

	@Override
	public double valueableAt(int row, int rank) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RowVector rowVectorAt(int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RankVector rankVectorAt(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfFunction.getStringField(StringFieldKey.Linalge_RankVector);
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

}
