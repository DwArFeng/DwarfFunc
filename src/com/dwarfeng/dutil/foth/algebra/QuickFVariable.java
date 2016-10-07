package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.math.AbstractMathObject;

/**
 * ������
 * <p> ���಻���ܿɱ�������д������е�ֵ���󶼻����ȡֵ����<code>double</code>��
 * ����ʽ�洢��
 * @author DwArFeng
 * @since 1.8
 */
public class QuickFVariable extends AbstractMathObject implements FormulaVariable {
	
	/**������ֵ*/
	protected double val;
	/**����������*/
	protected final String name;
	
	/**
	 * ����һ��Ĭ�ϵģ�ֵΪ0�ı�����
	 * @param name ���������ơ�
	 */
	public QuickFVariable(String name) {
		this(name, 0d);
	}
	
	/**
	 * ����һ��ֵΪָ��ֵ�ӿڵĵ�ǰֵ�ı�����
	 * @param name ���������ơ�
	 * @param valueable ָ����ֵ�ӿڡ�
	 * @throws IllegalArgumentException name����Ϊ <code>null</code>��Ƿ���
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>ʱ�׳��쳣��
	 */
	public QuickFVariable(String name, FormulaValue valueable) {
		if(Objects.isNull(name) || name.equals("")){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.Variable_1));
		}
		Objects.requireNonNull(valueable, DwarfUtil.getStringField(StringFieldKey.Variable_0));
		
		this.name = name;
		this.val = valueable.value();
	}
	
	/**
	 * ����һ��ֵΪָ��ֵ�ı�����
	 * @param name ���������ơ�
	 * @param d ָ����ֵ��
	 * @throws IllegalArgumentException name����Ϊ <code>null</code> ��Ƿ���
	 */
	public QuickFVariable(String name, double d) {
		if(Objects.isNull(name) || name.equals("")){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.Variable_1));
		}
		
		this.name = name;
		this.val = d;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.Valueable#value()
	 */
	@Override
	public double value() {
		return val;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfunc.infs.Nameable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.VariableValue#setValue(double)
	 */
	@Override
	public void setValue(double value) {
		this.val = value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Algebra_Variable);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		return getName();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.algebra.NumBase#getVariableSpace()
	 */
	@Override
	public FVariableSpace variableSpace() {
		return new FVariableSpace.Builder().add(this).build();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append(getMathName())
				.append(" : ")
				.append(getExpression())
				.append(" = ")
				.append(val)
				.toString();
	}

}
