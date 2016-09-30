package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.foth.algebra.FAlgebraUtil;
import com.dwarfeng.dutil.foth.algebra.FValueable;
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
public class FRowVector extends AbstractDMath implements FMatArray{
	
	/**�洢������ֵ������*/
	protected final FValueable[] vals;
	/**�������ı����ռ�*/
	protected final FVariableSpace vs;
	
	/**
	 * ����һ��ӵ��ָ����Ԫ�ص���������
	 * <p> ��ע�⣺�������Ԫ�����������Ч����Ч��ָ��Ԫ�صĸ����������0��
	 * @param vals ָ������Ԫ�ء�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException Ԫ��������Ч��
	 */
	public FRowVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FRowVector_1));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FRowVector_0));
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
	public FRowVector(FValueable[] valueables) throws VariableConflictException{
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.FRowVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FRowVector_0));
		}
		
		this.vals = valueables;
		FVariableSpace.Builder builder = new FVariableSpace.Builder();
		for(FValueable valueable : valueables){
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
		for(FValueable val : vals){
			sb		.append(val.getExpression())
					.append(", ");
		}
		sb.delete(sb.length()-2, sb.length()).append("]");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Linalge_RowVector);
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
	 * @see com.dwarfeng.dmath.linalge.MatArray#ranks()
	 */
	@Override
	public int ranks() {
		return vals.length;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#rows()
	 */
	@Override
	public int rows() {
		return 1;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getValueable(int, int)
	 */
	@Override
	public FValueable fValueableAt(int row, int rank) {
		LinalgeUtil.requrieRowInBound(this, row);
		LinalgeUtil.requireRankInBound(this, rank);
		return vals[rank];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRowVector(int)
	 */
	@Override
	public FRowVector fRowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRankVector(int)
	 */
	@Override
	public FRankVector fRankVectorAt(int rank) {
		LinalgeUtil.requrieRowInBound(this, rank);
		return new FRankVector(new FValueable[]{vals[rank]});
	}
	
	/**
	 * ������������һ����������ӡ�
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param rowVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ĳߴ粻ƥ�䡣
	 */
	public FRowVector add(FRowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.FRowVector_3));
		LinalgeUtil.requireSpecificSize(rowVector, rows(), ranks(), DwarfUtil.getStringField(StringFieldKey.FRowVector_5));
		
		FValueable vs[] = new FValueable[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(rowVector.vals[i]);
		}
		return new FRowVector(vs);
	}
	
	/**
	 * ������������һ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param rowVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ĳߴ粻ƥ�䡣
	 */
	public FRowVector minus(FRowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.FRowVector_3));
		LinalgeUtil.requireSpecificSize(rowVector, rows(), ranks(), DwarfUtil.getStringField(StringFieldKey.FRowVector_5));
		
		FValueable vs[] = new FValueable[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(rowVector.vals[i]);
		}
		return new FRowVector(vs);
	}
	
	/**
	 * ����������ָ������������ˡ�
	 * <p> ע�⣺����������Ҫ�ܹ������������ˣ���������������Ҫ�����������������ȡ�
	 * <p> ע�⣺��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param rankVector ָ���ص���������
	 * @return �����õ���ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ָ�������������������������ˡ�
	 */
	public FValueable mul(FRankVector rankVector){
		Objects.requireNonNull(rankVector, DwarfUtil.getStringField(StringFieldKey.FRowVector_4));
		LinalgeUtil.requireForMutiply(this, rankVector, DwarfUtil.getStringField(StringFieldKey.FRowVector_6));
		
		FValueable sum = QuickFValue.ZERO;
		for(int i = 0 ; i < ranks() ; i ++){
			FValueable v1 = this.fValueableAt(0, i);
			FValueable v2 = rankVector.fValueableAt(i, 0);
			sum = sum.add(v1.mul(v2));
		}
		
		return sum;
	}
	
	/**
	 * ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param val ָ����ֵ��
	 * @return ָ����ֵ�����������˵õ�����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public FRowVector mul(FValueable val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FRowVector_7));
		
		FValueable[] vs = new FValueable[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = fValueableAt(1, i).mul(val);
		}
		return new FRowVector(vs);
	}
	
	/**
	 * ����������ָ����ֵ��ˡ�
	 * <p> ע�⣺��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param d ָ����ֵ��
	 * @return ָ����ֵ�����������˵õ�����������
	 */
	public FRowVector mul(double d){
		return mul(new QuickFValue(d));
	}
	
	/**
	 * ���ظ���������ת����������
	 * <p> ��ת�ò������ƻ��ṹ��
	 * @return ת����������
	 */
	public FRankVector trans(){
		return new FRankVector(vals);
	}
	
}
