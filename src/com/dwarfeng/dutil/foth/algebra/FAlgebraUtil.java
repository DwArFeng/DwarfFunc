package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.num.MusValueable;
import com.dwarfeng.dutil.basic.num.QuickMusValueable;

/**
 * �����������ࡣ
 * <p> �����ṩһЩ�ڴ�������Ҫʹ�õĹ��߷�����
 * @author DwArFeng
 * @since 1.8
 */
public final class FAlgebraUtil {
	
	/**
	 * ��ָ����ֵ��������ת��Ϊ��Ӧ��double ���顣
	 * @param vals ָ����ֵ���顣
	 * @return ת���ɵ�double���顣
	 * @throws NullPointerException �������Ϊ <code>null</code> �������к��� <code>null</code>Ԫ�ء�
	 */
	public static double[] takeValues(FValue[] vals){
		ArrayUtil.requireNotContainsNull(vals, DwarfUtil.getStringField(StringFieldKey.FAlgebraUtil_0));
		double[] dous = new double[vals.length];
		for(int i = 0 ; i < dous.length ; i ++){
			dous[i] = vals[i].value();
		}
		return dous;
	}
	
	/**
	 * ����ֵ�ӿ�ת��Ϊdfunc���еĶ�ֵ̬�ӿڡ�
	 * @return ת���ɵĶ�ֵ̬�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static MusValueable toMusValueable(FValue val){
		return new QuickMusValueable(val.value());
	}
	
	
	/**
	 * ��˫���ȸ�������ת��Ϊһ��ֵ���顣
	 * @param ds ָ����˫���ȸ������顣
	 * @return ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static FValue[] toValueables(double[] ds){
		Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.FAlgebraUtil_1));
		
		FValue[] valueables = new FValue[ds.length];
		for(int i = 0 ; i < ds.length ; i ++){
			valueables[i] = new QuickFValue(ds[i]);
		}
		return valueables;
	}
	
	/**
	 * �ж����������Ƿ��ͻ��
	 * <p> �й��ڳ�ͻ�ĸ������� {@link FVariable}��
	 * @param v1 ��һ��������
	 * @param v2 �ڶ���������
	 * @return ���������Ƿ��ͻ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkConflict(FVariable v1, FVariable v2){
		Objects.requireNonNull(v1, DwarfUtil.getStringField(StringFieldKey.FAlgebraUtil_2));
		Objects.requireNonNull(v2, DwarfUtil.getStringField(StringFieldKey.FAlgebraUtil_2));
		
		return v1 != v2 && v1.getName().equals(v2.getName());
	}
	
	//��ֹ�ⲿʵ������
	private FAlgebraUtil(){}

}
