package com.dwarfeng.func.util;

import java.util.Collection;
import java.util.Vector;

public class ArraysFunc {
	
	/**
	 * �ж��������Ƿ����ĳ��Ԫ�ء�
	 * <p> �÷����ὫĿ�������е�ÿһ�������ó�����Ŀ��������equals�ȶԣ����Ϊtrue ���ͷ���true�����ȫ��Ԫ��Ϊfalse �򷵻�false��
	 * <br>���ڸ÷�������equals����������Щ�������д�÷�������˸ñȶԵĽ�������ڴ��е�λ��Ϊ׼��
	 * @param objects Ŀ�����顣
	 * @param object Ŀ��Ԫ�ء�
	 * @return Ŀ���������Ƿ���Ŀ��Ԫ�ء�
	 */
	public static boolean contains(Object[] objects,Object object){
		for(Object o:objects){
			if(o.equals(object)) return true;
		}
		return false;
	}
	/**
	 * �ж�Դ�����Ƿ����Ŀ����������ж���
	 * <p>�÷������Ŀ�������е�ÿһ��Ԫo��ִ��<code>contains(source,o)</code>��ֱ��ȫ����������߷�������һ��o����Դ�����С�
	 * @param source Դ���顣
	 * @param target Ŀ�����顣
	 * @return Դ�����Ƿ����Ŀ�������ȫ��Ԫ�ء�
	 * @see ArraysFunc#contains(Object[], Object)
	 */
	public static boolean containsAll(Object[] source,Object[] target){
		for(Object o : target){
			if(!contains(source, o)) return false;
		}
		return true;
	}
	/**
	 * ��һ�������޳��������е�nullԪ�أ����Ѳ���null��Ԫ�ذ���ԭ�е�˳�����������ʽ���ء�
	 * @param objects Ԫ�����顣
	 * @param t ���ص��������ͣ�����<code> new Object[0]</code>��
	 * @param <T> ����T
	 * @return ���ص����鷺�͡�
	 */
	public static <T> T[] getNotNull(Object[] objects,T[] t){
		Collection<Object> col = new Vector<Object>();
		if(objects != null){
			for(Object o:objects){ if(o != null) col.add(o);}
		}
		return col.toArray(t);
	}
	/**
	 * ��һ�������޳��������е�nullԪ�أ����Ѳ���null��Ԫ�ذ���ԭ�е�˳���Լ��ϵ���ʽ���ء�
	 * @param object Ԫ�����顣
	 * @param <T> ����T
	 * @return ���صļ��ϡ�
	 */
	public static <T> Collection<T> getNotNull(T[] object){
		Collection<T> col = new Vector<T>();
		if(object != null){
			for(T o:object){ if(o != null) col.add(o);}
		}
		return col;
	}
}
