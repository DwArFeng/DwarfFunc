package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.foth.algebra.FAlgebraUtil;
import com.dwarfeng.dutil.foth.algebra.FValue;
import com.dwarfeng.dutil.foth.algebra.FVariableSpace;
import com.dwarfeng.dutil.foth.algebra.QuickFValue;
import com.dwarfeng.dutil.foth.algebra.VariableConflictException;
import com.dwarfeng.dutil.math.AbstractDMath;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;

/**
 * ��������
 * <p> �ö�����ܿɱ���󣬴������е�ֵ���󶼻�ֱ�Ӵ洢�����б��������仯�Ļ����ö���Ҳ�ᷢ���仯��
 * <p> �����������鲻һ���ĵط����ڣ����������������0��Ԫ�أ���Ϊ0��Ԫ�ص���������ȫû�����塣
 * @author DwArFeng
 * @since 1.8
 */
public class FColVector extends AbstractDMath implements FMatArray{
	
	protected final FValue[] vals;
	protected final FVariableSpace vs;
	
	/**
	 * ����һ��ӵ��ָ����Ԫ�ص���������
	 * <p> ��ע�⣺�������Ԫ�����������Ч����Ч��ָ��Ԫ�صĸ����������0��
	 * @param vals ָ������Ԫ�ء�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException Ԫ��������Ч��
	 */
	public FColVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FColVector_1));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FColVector_0));
		}
		
		this.vals = FAlgebraUtil.toValueables(vals);
		this.vs = FVariableSpace.EMPTY;
	}
	
	/**
	 * ����һ��ӵ��ָ��ֵ�ӿ�Ԫ�صĵ�ǰֵ��ɵ���������
	 * <p> 	��ע�⣬�˴���ֵ�ӿ�Ԫ�ر�����ȫ��Ч��
	 * @param valueables ָ����ֵ�ӿڡ�
	 * @throws VariableConflictException ������ͻ�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ֵ�ӿ�������Ч�� 
	 */
	public FColVector(FValue[] valueables){
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.FColVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FColVector_0));
		}
		
		this.vals = valueables;
		FVariableSpace.Builder builder = new FVariableSpace.Builder();
		for(FValue valueable : valueables){
			builder.add(valueable.variableSpace());
		}
		this.vs = builder.build();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(FValue val : vals){
			sb		.append(val.getExpression())
					.append(", ");
		}
		sb		.delete(sb.length()-2, sb.length())
				.append("]")
				.append("T");
		return sb.toString();
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
	 * @see com.dwarfeng.dmath.algebra.NumBase#getVariableSpace()
	 */
	@Override
	public FVariableSpace variableSpace() {
		return vs;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.math.linalge.MatArray#columns()
	 */
	@Override
	public int columns() {
		return 1;
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
	 * @see com.dwarfeng.dutil.foth.linalge.FMatArray#fValueableAt(int, int)
	 */
	@Override
	public FValue fValueAt(int row, int column) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FColVector_6));
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.FColVector_7));
		return vals[row];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRowVector(int)
	 */
	@Override
	public FRowVector fRowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FColVector_6));
		return new FRowVector(new FValue[]{vals[row]});
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FMatArray#fColVectorAt(int)
	 */
	@Override
	public FColVector fColVectorAt(int column) {
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.FColVector_7));
		return this;
	}
	
	/**
	 * ������������һ����������ӡ�
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param colVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ߴ粻ƥ�䡣
	 */
	public FColVector add(FColVector colVector){
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.FColVector_3));
		LinalgeUtil.requireSpecificSize(colVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.FColVector_4));

		FValue[] vs = new FValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(colVector.vals[i]);
		}
		return new FColVector(vs);
	}
	
	/**
	 * ������������һ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param colVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ߴ粻ƥ�䡣
	 */
	public FColVector minus(FColVector colVector){
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.FColVector_3));
		LinalgeUtil.requireSpecificSize(colVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.FColVector_4));

		FValue[] vs = new FValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(colVector.vals[i]);
		}
		return new FColVector(vs);
	}
	
	/**
	 * ����������ָ����ֵ��ˡ�
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param val ָ����ֵ��
	 * @return ָ����ֵ�����������˵õ�����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public FColVector scale(FValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FColVector_5));
		
		FValue[] vs = new FValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = fValueAt(i, 0).mul(val);
		}
		return new FColVector(vs);
	}
	
	/**
	 * ����������ָ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param d ָ����ֵ��
	 * @return ָ����ֵ����������ദ�õ�����������
	 */
	public FColVector scale(double d){
		return scale(new QuickFValue(d));
	}
	
	/**
	 * ���ظ���������ת����������
	 * <p> ��ת�ò������ƻ��ṹ��
	 * @return ת����������
	 */
	public FRowVector trans(){
		return new FRowVector(vals);
	}
	
}
