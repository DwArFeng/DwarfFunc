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
import com.dwarfeng.dutil.math.linalge.ColumnVector;
import com.dwarfeng.dutil.math.linalge.DefaultColumnVector;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;

/**
 * ��������
 * <p> �ö�����ܿɱ���󣬴������е�ֵ���󶼻�ֱ�Ӵ洢�����б��������仯�Ļ����ö���Ҳ�ᷢ���仯��
 * <p> �����������鲻һ���ĵط����ڣ�����������������0��Ԫ�أ���Ϊ0��Ԫ�ص���������ȫû�����塣
 * @author DwArFeng
 * @since 1.8
 */
public class DefalutFormulaColumnVector extends AbstractMathObject implements FormulaColumnVector{
	
	/**�洢������ֵ������*/
	protected final FothValue[] vals;
	/**�������ı����ռ�*/
	protected final FothVariableSpace vs;
	
	/**
	 * ����һ����math���е���������ֵһ�µ��нṹ��������
	 * @param columnVector math���е���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefalutFormulaColumnVector(ColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_3));
		
		FothValue[] vals = new FothValue[columnVector.size()];
		for(int i = 0 ; i < vals.length ; i ++){
			vals[i] = new QuickFothValue(columnVector.valueAt(i));
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
	public DefalutFormulaColumnVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_1));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_0));
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
	public DefalutFormulaColumnVector(FothValue[] valueables){
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_0));
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
	 * @see com.dwarfeng.dutil.foth.algebra.NumberBased#variableSpace()
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
		LinalgeUtil.requireIndexInBound(this, index, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_6));
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
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaColumnVector#add(com.dwarfeng.dutil.foth.linalge.FormulaColumnVector)
	 */
	@Override
	public FormulaColumnVector add(FormulaColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_3));
		LinalgeUtil.requireSpecificSize(columnVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_4));

		FothValue[] vs = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(columnVector.fothValueAt(i));
		}
		return new DefalutFormulaColumnVector(vs);
	}

	@Override
	public FormulaColumnVector minus(FormulaColumnVector columnVector) {
		Objects.requireNonNull(columnVector, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_3));
		LinalgeUtil.requireSpecificSize(columnVector, size(), DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_4));

		FothValue[] vs = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(columnVector.fothValueAt(i));
		}
		return new DefalutFormulaColumnVector(vs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaColumnVector#scale(com.dwarfeng.dutil.foth.algebra.FothValue)
	 */
	@Override
	public FormulaColumnVector scale(FothValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.DefaultFormulaColumnVector_5));
		
		FothValue[] vs = new FothValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = fothValueAt(i).mul(val);
		}
		return new DefalutFormulaColumnVector(vs);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaColumnVector#trans()
	 */
	@Override
	public DefaultFormulaRowVector trans(){
		return new DefaultFormulaRowVector(vals);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FormulaColumnVector#toColumnVector()
	 */
	@Override
	public ColumnVector toColumnVector() {
		return new DefaultColumnVector(FothAlgebraUtil.takeValues(vals));
	}
	
}