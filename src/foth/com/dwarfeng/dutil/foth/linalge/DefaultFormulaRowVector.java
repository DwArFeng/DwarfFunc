package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.foth.algebra.FothVariableSpace;
import com.dwarfeng.dutil.foth.algebra.FothAlgebraUtil;
import com.dwarfeng.dutil.foth.algebra.FothValue;
import com.dwarfeng.dutil.foth.algebra.QuickFothValue;
import com.dwarfeng.dutil.foth.algebra.VariableConflictException;
import com.dwarfeng.dutil.math.AbstractMathObject;
import com.dwarfeng.dutil.math.linalge.DefaultRowVector;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;
import com.dwarfeng.dutil.math.linalge.RowVector;

/**
 * ��������
 * <p> �ö�����ܿɱ���󣬴������е�ֵ���󶼻�ֱ�Ӵ洢�����б��������仯�Ļ����ö���Ҳ�ᷢ���仯��
 * <p> �����������鲻һ���ĵط����ڣ����������������0��Ԫ�أ���Ϊ0��Ԫ�ص���������ȫû�����塣
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultFormulaRowVector extends AbstractMathObject implements FormulaRowVector{
	
	/**�洢������ֵ������*/
	protected final FothValue[] vals;
	/**�������ı����ռ�*/
	protected final FothVariableSpace vs;
	
	/**
	 * ����һ����math����������ֵһ�µ��нṹ��������
	 * @param rowVector math���е���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultFormulaRowVector(RowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_3));
		
		FothValue[] vals = new FothValue[rowVector.size()];
		for(int i = 0 ; i < vals.length ; i ++){
			vals[i] = new QuickFothValue(rowVector.valueAt(i));
		}
		
		this.vals = vals;
		this.vs = FothVariableSpace.EMPTY;
	}
	
	/**
	 * ����һ��ӵ��ָ����Ԫ�ص���������
	 * <p> ��ע�⣺�������Ԫ�����������Ч����Ч��ָ��Ԫ�صĸ����������0��
	 * @param vals ָ������Ԫ�ء�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException Ԫ��������Ч��
	 */
	public DefaultFormulaRowVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_1));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_0));
		}
		
		this.vals = FothAlgebraUtil.toFothValues(vals);
		this.vs = FothVariableSpace.EMPTY;
	}
	
	/**
	 * ����һ��ӵ��ָ��ֵ�ӿ�Ԫ�صĵ�ǰֵ��ɵ���������
	 * <p> 	��ע�⣬�˴���ֵ�ӿ�Ԫ�ر�����ȫ��Ч��
	 * @param valueables ָ����ֵ�ӿڡ�
	 * @throws VariableConflictException ������ͻ�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ֵ�ӿ�������Ч�� 
	 */
	public DefaultFormulaRowVector(FothValue[] valueables) throws VariableConflictException{
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_0));
		}
		
		this.vals = valueables;
		FothVariableSpace.Builder builder = new FothVariableSpace.Builder();
		for(FothValue valueable : valueables){
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
		for(FothValue val : vals){
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
	public FothVariableSpace variableSpace() {
		return vs;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaLinalgeVector#fothValueAt(int)
	 */
	@Override
	public FothValue fothValueAt(int index) {
		LinalgeUtil.requireIndexInBound(this, index, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_8));
		return vals[index];
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
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#add(com.dwarfeng.dutil.foth.linalge.FormulaRowVector)
	 */
	@Override
	public FormulaRowVector add(FormulaRowVector rowVector) {
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_3));
		LinalgeUtil.requireSpecificSize(rowVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_5));
		
		FothValue vs[] = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(rowVector.fothValueAt(i));
		}
		return new DefaultFormulaRowVector(vs);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#minus(com.dwarfeng.dutil.foth.linalge.FormulaRowVector)
	 */
	@Override
	public FormulaRowVector minus(FormulaRowVector rowVector) {
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_3));
		LinalgeUtil.requireSpecificSize(rowVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_5));
		
		FothValue vs[] = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(rowVector.fothValueAt(i));
		}
		return new DefaultFormulaRowVector(vs);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#mul(com.dwarfeng.dutil.foth.linalge.FormulaColumnVector)
	 */
	@Override
	public FothValue mul(FormulaColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_4));
		FormulaLinalgeUtil.requireForMutiply(this, columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_6));
		
		FothValue sum = QuickFothValue.ZERO;
		for(int i = 0 ; i < vals.length ; i ++){
			FothValue v1 = fothValueAt(i);
			FothValue v2 = columnVector.fothValueAt(i);
			sum = sum.add(v1.mul(v2));
		}
		
		return sum;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#scale(com.dwarfeng.dutil.foth.algebra.FothValue)
	 */
	@Override
	public FormulaRowVector scale(FothValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_7));
		
		FothValue[] vs = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = fothValueAt(i).mul(val);
		}
		return new DefaultFormulaRowVector(vs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#trans()
	 */
	@Override
	public FormulaColumnVector trans(){
		return new DefalutFormulaColumnVector(vals);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#toRowVector()
	 */
	@Override
	public RowVector toRowVector(){
		return new DefaultRowVector(FothAlgebraUtil.takeValues(vals));
	}
	
}
