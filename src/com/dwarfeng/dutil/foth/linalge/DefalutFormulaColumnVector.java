package com.dwarfeng.dutil.foth.linalge;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.foth.algebra.FAlgebraUtil;
import com.dwarfeng.dutil.foth.algebra.FormulaValue;
import com.dwarfeng.dutil.foth.algebra.FVariableSpace;
import com.dwarfeng.dutil.foth.algebra.QuickFValue;
import com.dwarfeng.dutil.foth.algebra.VariableConflictException;
import com.dwarfeng.dutil.math.AbstractMathObject;
import com.dwarfeng.dutil.math.linalge.DefaultColumnVector;
import com.dwarfeng.dutil.math.linalge.LinalgeUtil;

/**
 * ��������
 * <p> �ö�����ܿɱ���󣬴������е�ֵ���󶼻�ֱ�Ӵ洢�����б��������仯�Ļ����ö���Ҳ�ᷢ���仯��
 * <p> �����������鲻һ���ĵط����ڣ����������������0��Ԫ�أ���Ϊ0��Ԫ�ص���������ȫû�����塣
 * @author DwArFeng
 * @since 1.8
 */
public class DefalutFormulaColumnVector extends AbstractMathObject implements FormulaColumnVector{
	
	/**�洢������ֵ������*/
	protected final FormulaValue[] vals;
	/**�������ı����ռ�*/
	protected final FVariableSpace vs;
	
	/**
	 * ����һ����math���е���������ֵһ�µ��нṹ��������
	 * @param colVector math���е���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefalutFormulaColumnVector(DefaultColumnVector colVector) {
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.FColVector_3));
		
		FormulaValue[] vals = new FormulaValue[colVector.rows()];
		for(int i = 0 ; i < vals.length ; i ++){
			vals[i] = new QuickFValue(colVector.valueAt(i, 0));
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
	public DefalutFormulaColumnVector(double[] vals) {
		Objects.requireNonNull(vals, DwarfUtil.getStringField(StringFieldKey.FColVector_1));
		if(vals.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FColVector_0));
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
	public DefalutFormulaColumnVector(FormulaValue[] valueables){
		ArrayUtil.requireNotContainsNull(valueables, DwarfUtil.getStringField(StringFieldKey.FColVector_2));
		if(valueables.length < 1){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FColVector_0));
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
	 * @see com.dwarfeng.dutil.foth.linalge.FMatArray#fValueableAt(int, int)
	 */
	@Override
	public FormulaValue formulaValueAt(int row, int column) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FColVector_6));
		LinalgeUtil.requireColumnInBound(this, column, DwarfUtil.getStringField(StringFieldKey.FColVector_7));
		return vals[row];
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.linalge.MatArray#getRowVector(int)
	 */
	@Override
	public DefaultFormulaRowVector fRowVectorAt(int row) {
		LinalgeUtil.requrieRowInBound(this, row, DwarfUtil.getStringField(StringFieldKey.FColVector_6));
		return new DefaultFormulaRowVector(new FormulaValue[]{vals[row]});
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.foth.linalge.FMatArray#fColVectorAt(int)
	 */
	@Override
	public DefalutFormulaColumnVector fColVectorAt(int column) {
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
	public DefalutFormulaColumnVector add(DefalutFormulaColumnVector colVector){
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.FColVector_3));
		LinalgeUtil.requireSpecificSize(colVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.FColVector_4));

		FormulaValue[] vs = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].add(colVector.vals[i]);
		}
		return new DefalutFormulaColumnVector(vs);
	}
	
	/**
	 * ������������һ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param colVector ָ������������
	 * @return ����ó����µ���������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ����������ߴ粻ƥ�䡣
	 */
	public DefalutFormulaColumnVector minus(DefalutFormulaColumnVector colVector){
		Objects.requireNonNull(colVector, DwarfUtil.getStringField(StringFieldKey.FColVector_3));
		LinalgeUtil.requireSpecificSize(colVector, rows(), columns(), DwarfUtil.getStringField(StringFieldKey.FColVector_4));

		FormulaValue[] vs = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = vals[i].minus(colVector.vals[i]);
		}
		return new DefalutFormulaColumnVector(vs);
	}
	
	/**
	 * ����������ָ����ֵ��ˡ�
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param val ָ����ֵ��
	 * @return ָ����ֵ�����������˵õ�����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefalutFormulaColumnVector scale(FormulaValue val){
		Objects.requireNonNull(val, DwarfUtil.getStringField(StringFieldKey.FColVector_5));
		
		FormulaValue[] vs = new FormulaValue[vals.length];
		for(int i = 0 ; i < vs.length ; i ++){
			vs[i] = formulaValueAt(i, 0).mul(val);
		}
		return new DefalutFormulaColumnVector(vs);
	}
	
	/**
	 * ����������ָ�������������
	 * <p> ע�⣬��������ֵ���㣬���õ��Ľ���ǽṹ�ƻ��Եġ�
	 * @param d ָ����ֵ��
	 * @return ָ����ֵ����������ദ�õ�����������
	 */
	public DefalutFormulaColumnVector scale(double d){
		return scale(new QuickFValue(d));
	}
	
	/**
	 * ���ظ���������ת����������
	 * <p> ��ת�ò������ƻ��ṹ��
	 * @return ת����������
	 */
	public DefaultFormulaRowVector trans(){
		return new DefaultFormulaRowVector(vals);
	}
	
	/**
	 * ����������ת����math�������Ӧ����������
	 * @return math�������Ӧ����������
	 */
	public DefaultColumnVector toColVector(){
		return new DefaultColumnVector(FAlgebraUtil.takeValues(vals));
	}
	
}
