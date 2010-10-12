package com.dwarfeng.dfunc.cna;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

public final class ArrayUtil {
	
	/**
	 * �ж��������Ƿ����ĳ��Ԫ�ء�
	 * <p> �÷����ὫĿ�������е�ÿһ�������ó�����Ŀ��������equals�ȶԣ����Ϊtrue ���ͷ���true�����ȫ��Ԫ��Ϊfalse �򷵻�false��
	 * <br>���ڸ÷�������equals����������Щ�������д�÷�������˸ñȶԵĽ�������ڴ��е�λ��Ϊ׼��
	 * <p> ���Ŀ������Ϊ <code>null</code>���򷵻� <code>false</code>
	 * @param objects Ŀ�����顣
	 * @param object Ŀ��Ԫ�ء�
	 * @return Ŀ���������Ƿ���Ŀ��Ԫ�ء�
	 */
	public static boolean contains(Object[] objects,Object object){
		if(Objects.isNull(objects)) return false;
		for(Object o:objects){
			if(o.equals(object)) return true;
		}
		return false;
	}
	/**
	 * �ж�Դ�����Ƿ����Ŀ����������ж���
	 * <p>�÷������Ŀ�������е�ÿһ��Ԫo��ִ��<code>contains(source,o)</code>��ֱ��ȫ����������߷�������һ��o����Դ�����С�
	 * <p> �������Ϊ <code>null</code>����Ĭ����Ϊ������Ԫ�صĿ����顣
	 * @param source Դ���顣
	 * @param target Ŀ�����顣
	 * @return Դ�����Ƿ����Ŀ�������ȫ��Ԫ�ء�
	 * @see ArrayUtil#contains(Object[], Object)
	 */
	public static boolean containsAll(Object[] source,Object[] target){
		if(Objects.isNull(target)) return false;
		for(Object o : target){
			if(!contains(source, o)) return false;
		}
		return true;
	}
	/**
	 * ��һ�������޳��������е�nullԪ�أ����Ѳ���null��Ԫ�ذ���ԭ�е�˳�����������ʽ���ء�
	 * <p> ���Ԫ������Ϊ <code>null</code> �򷵻�һ���յļ��ϡ�
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
	 * <p> ���Ԫ������Ϊ <code>null</code> �򷵻�һ���յļ��ϡ�
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
	
	/**
	 * ��������������ϲ���
	 * <p> �������Ϊ <code>null</code>���򱻵����������κ�Ԫ�ص����顣
	 * �׸����鲻��Ϊ <code>null</code>��
	 * @param first ��һ�����顣
	 * @param rest �ڶ������������顣
	 * @param <T> ����T��
	 * @return �������鰴�Ⱥ�˳��ϲ���õ������顣
	 * @throws NullPointerException ��ڲ��� <code>rest</code>Ϊ <code>null</code>��
	 */
	@SafeVarargs
	public static<T> T[] concat(T[] first,T[]... rest){
		Objects.requireNonNull(first, DwarfFunction.getStringField(StringFiledKey.ArrayUtil_0));
		
		if(Objects.isNull(rest)) return first;
		
		int totalLength = first.length;
		for(T[] array : rest){
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for(T[] array : rest){
			if(Objects.nonNull(array)){
				System.arraycopy(array, 0, result, offset, array.length);
				offset += array.length;
			}
		}
		return result;
	}
	
	private ArrayUtil(){
		//������ʵ������
	}
}
