package com.dwarfeng.dutil.foth.algebra;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.num.NumberValue;
import com.dwarfeng.dutil.basic.num.QuickNumberValueable;

/**
 * �����������ࡣ
 * <p> �����ṩһЩ�ڴ�������Ҫʹ�õĹ��߷�����
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public final class FothAlgebraUtil {
	
	/**
	 * ��ָ����ֵ��������ת��Ϊ��Ӧ��double ���顣
	 * @param vals ָ����ֵ���顣
	 * @return ת���ɵ�double���顣
	 * @throws NullPointerException �������Ϊ <code>null</code> �������к��� <code>null</code>Ԫ�ء�
	 */
	public static double[] takeValues(FothValue[] vals){
		ArrayUtil.requireNotContainsNull(vals, DwarfUtil.getStringField(StringFieldKey.FOTHALGEBRAUTIL_0));
		double[] dous = new double[vals.length];
		for(int i = 0 ; i < dous.length ; i ++){
			dous[i] = vals[i].value();
		}
		return dous;
	}
	
	/**
	 * ����ֵ�ӿ�ת��Ϊdfunc���еĶ�ֵ̬�ӿڡ�
	 * @param val ָ����ֵ�ӿڡ�
	 * @return ת���ɵĶ�ֵ̬�ӿڡ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static NumberValue toMusValueable(FothValue val){
		return new QuickNumberValueable(val.value());
	}
	
	
	/**
	 * ��˫���ȸ�������ת��Ϊһ��ֵ���顣
	 * @param ds ָ����˫���ȸ������顣
	 * @return ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static FothValue[] toFothValues(double[] ds){
		Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.FOTHALGEBRAUTIL_1));
		
		FothValue[] valueables = new FothValue[ds.length];
		for(int i = 0 ; i < ds.length ; i ++){
			valueables[i] = new QuickFothValue(ds[i]);
		}
		return valueables;
	}
	
	/**
	 * �ж����������Ƿ��ͻ��
	 * <p> �й��ڳ�ͻ�ĸ������� {@link FothVariable}��
	 * @param v1 ��һ��������
	 * @param v2 �ڶ���������
	 * @return ���������Ƿ��ͻ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static boolean checkConflict(FothVariable v1, FothVariable v2){
		Objects.requireNonNull(v1, DwarfUtil.getStringField(StringFieldKey.FOTHALGEBRAUTIL_2));
		Objects.requireNonNull(v2, DwarfUtil.getStringField(StringFieldKey.FOTHALGEBRAUTIL_2));
		
		return v1 != v2 && v1.getName().equals(v2.getName());
	}
	
	//��ֹ�ⲿʵ������
	private FothAlgebraUtil(){}

}
