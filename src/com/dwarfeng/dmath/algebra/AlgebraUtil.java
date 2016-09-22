package com.dwarfeng.dmath.algebra;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
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
	public static double[] takeValue(Valueable[] vals){
		ArrayUtil.requireNotNull(vals, DwarfFunction.getStringField(StringFiledKey.AlgebraUtil_0));
		double[] dous = new double[vals.length];
		for(int i = 0 ; i < dous.length ; i ++){
			dous[i] = vals[i].value();
		}
		return dous;
	}
	
	//��ֹ�ⲿʵ������
	private AlgebraUtil(){}

}
