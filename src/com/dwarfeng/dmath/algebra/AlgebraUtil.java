package com.dwarfeng.dmath.algebra;

import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.StringFiledKey;
import com.dwarfeng.dfunc.cna.ArrayUtil;

/**
 * �����������ࡣ
 * <p> �����ṩһЩ�ڴ�������Ҫʹ�õĹ��߷�����
 * @author DwArFeng
 * @since 1.8
 */
public final class AlgebraUtil {
	
	/**
	 * ��ָ����ֵ��������ת��Ϊ��Ӧ��double ���顣
	 * @param vals ָ����ֵ���顣
	 * @return ת���ɵ�double���顣
	 * @throws NullPointerException �������Ϊ <code>null</code> �������к��� <code>null</code>Ԫ�ء�
	 */
	public static double[] takeValues(Valueable[] vals){
		ArrayUtil.requireNotContainsNull(vals, DwarfFunction.getStringField(StringFiledKey.AlgebraUtil_0));
		double[] dous = new double[vals.length];
		for(int i = 0 ; i < dous.length ; i ++){
			dous[i] = vals[i].value();
		}
		return dous;
	}
	
	
	/**
	 * ��˫���ȸ�������ת��Ϊһ��ֵ���顣
	 * @param ds ָ����˫���ȸ������顣
	 * @return ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static Valueable[] toValueables(double[] ds){
		Objects.requireNonNull(ds, DwarfFunction.getStringField(StringFiledKey.AlgebraUtil_1));
		
		Valueable[] valueables = new Valueable[ds.length];
		for(int i = 0 ; i < ds.length ; i ++){
			valueables[i] = new QuickValueable(ds[i]);
		}
		return valueables;
	}
	
	/**
	 * �ж����������Ƿ��ͻ��
	 * <p> �й��ڳ�ͻ�ĸ������� {@link VariableValue}��
	 * @param v1 ��һ��������
	 * @param v2 �ڶ���������
	 * @return ���������Ƿ��ͻ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkConflict(VariableValue v1, VariableValue v2){
		Objects.requireNonNull(v1, DwarfFunction.getStringField(StringFiledKey.AlgebraUtil_2));
		Objects.requireNonNull(v2, DwarfFunction.getStringField(StringFiledKey.AlgebraUtil_2));
		
		return v1 != v2 && v1.getName().equals(v2.getName());
	}
	
	private static final VariableSpace EMPTYS_VARIABLE_SPACE = new VariableSpace.Builder().build();
	
	/**
	 * ��ȡһ���յı����ռ䡣
	 * @return ��ȡһ���յı����ؼ���
	 */
	public static VariableSpace emptyVariableSpace(){
		return EMPTYS_VARIABLE_SPACE;
	}
	
	//��ֹ�ⲿʵ������
	private AlgebraUtil(){}

}
