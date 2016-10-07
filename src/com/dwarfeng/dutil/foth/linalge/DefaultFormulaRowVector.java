package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.foth.algebra.FAlgebraUtil;
import com.dwarfeng.dutil.foth.algebra.FVariableSpace;
import com.dwarfeng.dutil.foth.algebra.FormulaValue;
import com.dwarfeng.dutil.foth.algebra.QuickFormulaValue;
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
 * @since 1.8
 */
public class DefaultFormulaRowVector extends AbstractMathObject implements FormulaRowVector{
	
	/**�洢������ֵ������*/
	protected final FormulaValue[] vals;
	/**�������ı����ռ�*/
	protected final FVariableSpace vs;
	
	/**
	 * ����һ����math����������ֵһ�µ��нṹ��������
	 * @param rowVector math���е���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultFormulaRowVector(RowVector rowVector){
		Objects.requireNonNull(rowVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_3));
		
		FormulaValue[] vals = new FormulaValue[rowVector.size()];
		for(int i = 0 ; i < vals.length ; i ++){
			vals[i] = new QuickFormulaValue(rowVector.valueAt(i));
		}
		
		this.vals = vals;
		this.vs = FVariableSpace.EMPTY;
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
		
		this.vals = FAlgebraUtil.toFValues(vals);
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
	public DefaultFormulaRowVector(FormulaValue[] valueables) throws VariableConflictException{
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_0));
		}
		
		this.vals = valueables;
		FVariableSpace.Builder builder = new FVariableSpace.Builder();
		for(FormulaValue valueable : valueables){
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
		for(FormulaValue val : vals){
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
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaLinalgeVector#formulaValueAt(int)
	 */
	@Override
	public FormulaValue formulaValueAt(int index) {
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
		
		FormulaValue vs[] = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(rowVector.formulaValueAt(i));
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
		
		FormulaValue vs[] = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(rowVector.formulaValueAt(i));
		}
		return new DefaultFormulaRowVector(vs);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#mul(com.dwarfeng.dutil.foth.linalge.FormulaColumnVector)
	 */
	@Override
	public FormulaValue mul(FormulaColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_4));
		FormulaLinalgeUtil.requireForMutiply(this, columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_6));
		
		FormulaValue sum = QuickFormulaValue.ZERO;
		for(int i = 0 ; i < vals.length ; i ++){
			FormulaValue v1 = formulaValueAt(i);
			FormulaValue v2 = columnVector.formulaValueAt(i);
			sum = sum.add(v1.mul(v2));
		}
		
		return sum;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaRowVector#scale(com.dwarfeng.dutil.foth.algebra.FormulaValue)
	 */
	@Override
	public FormulaRowVector scale(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaRowVector_7));
		
		FormulaValue[] vs = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = formulaValueAt(i).mul(val);
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
		return new DefaultRowVector(FAlgebraUtil.takeValues(vals));
	}
	
}
