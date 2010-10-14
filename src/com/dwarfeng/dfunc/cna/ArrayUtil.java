package com.dwarfeng.dfunc.cna;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

/**
 * �й�������Ĺ��߰���
 * <p> �ð��а������ڶ�������в����ĳ��÷�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * @author DwArFeng
 * @since 1.8
 */
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
	
	/**
	 * �ж������Ƿ��п�Ԫ�ء�
	 * <p> ���ҽ������鱾��Ϊ <code>null</code>�Ҳ������κ� <code>null</code>Ԫ���Ƿ��� <code>true</code>��
	 * @param objs ���жϵ����顣
	 * @return �����Ƿ��п�Ԫ�ء�
	 */
	public static boolean isContainsNull(Object[] objs){
		if(Objects.isNull(objs)) return false;
		for(Object obj: objs){
			if(Objects.isNull(obj)) return false;
		}
		return true;
	}
	
	/**
	 * ȷ��ָ�������鲻�����κ� <code>null</code>Ԫ�أ�����У����׳��쳣��
	 * @param objs ָ�������顣
	 * @throws NullPointerException ָ�����鱾���� <code>null</code>�����к��� <code>null</code>Ԫ��ʱ
	 * �׳����쳣��
	 */
	public static void requireNotContainsNull(Object[] objs) throws NullPointerException{
		Objects.requireNonNull(objs);
		for(Object obj: objs){
			Objects.requireNonNull(obj);
		}
	}
	
	/**
	 * ȷ��ָ�������鲻�����κ� <code>null</code>Ԫ�أ�����У����׳��쳣��
	 * @param objs ָ�������顣
	 * @param message �׳��쳣ʱ����Ϣ��
	 * @throws NullPointerException ָ�����鱾���� <code>null</code>�����к��� <code>null</code>Ԫ��ʱ
	 * �׳�����ϢΪָ���ַ������쳣��
	 */
	public static void requireNotContainsNull(Object[] objs, String message) throws NullPointerException{
		Objects.requireNonNull(objs, message);
		for(Object obj: objs){
			Objects.requireNonNull(obj, message);
		}
	}
	
	/**
	 * ��Byte��������
	 * @param target ָ����Byte���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static byte[] unpack(Byte[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Byte[0]);
		
		byte[] bytes = new byte[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			bytes[i] = target[i];
		}
		return bytes;
	}
	
	/**
	 * ��Short��������
	 * @param target ָ����Short���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static short[] unpack(Short[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Short[0]);
		
		short[] shorts = new short[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			shorts[i] = target[i];
		}
		return shorts;
	}
	
	/**
	 * ��Integer��������
	 * @param target ָ����Integer���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static int[] unpack(Integer[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Integer[0]);

		int[] ints = new int[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			ints[i] = target[i];
		}
		return ints;
	}
	
	/**
	 * ��Float��������
	 * @param target ָ����Float���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static float[] unpack(Float[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Float[0]);

		float[] floats = new float[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			floats[i] = target[i];
		}
		return floats;
	}
	
	/**
	 * ��Long��������
	 * @param target ָ����Long���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static long[] unpack(Long[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Long[0]);

		long[] longs = new long[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			longs[i] = target[i];
		}
		return longs;
	}
	
	/**
	 * ��Character������в����
	 * @param target ָ����Character���顣
	 * @return �����õ��Ļ������顣
	 */
	public static char[] unpack(Character[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Character[0]);

		char[] charss = new char[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			charss[i] = target[i];
		}
		return charss;
	}
	
	/**
	 * ��Boolean������в����
	 * @param target ָ����Boolean���顣
	 * @return �����õ��Ļ������顣
	 */
	public static boolean[] unpack(Boolean[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		target = getNotNull(target, new Boolean[0]);

		boolean[] booleans = new boolean[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			booleans[i] = target[i];
		}
		return booleans;
	}
	
	/**
	 * ��byte������д����
	 * @param target ָ����byte���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Byte[] pack(byte[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Byte[] bytes = new Byte[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			bytes[i] = target[i];
		}
		return bytes;
	}
	
	/**
	 * ��short������д����
	 * @param target ָ����short���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Short[] pack(short[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Short[] shorts = new Short[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			shorts[i] = target[i];
		}
		return shorts;
	}
	
	/**
	 * ��int������д����
	 * @param target ָ����int���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Integer[] pack(int[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Integer[] integers = new Integer[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			integers[i] = target[i];
		}
		return integers;
	}
	
	/**
	 * ��long������д����
	 * @param target ָ����long���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Long[] pack(long[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Long[] longs = new Long[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			longs[i] = target[i];
		}
		return longs;
	}
	
	/**
	 * ��float������д����
	 * @param target ָ����float���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Float[] Pack(float[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Float[] floats = new Float[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			floats[i] = target[i];
		}
		return floats;
	}
	
	/**
	 * ��double������д����
	 * @param target ָ����double���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Double[] Pack(double[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Double[] doubles = new Double[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			doubles[i] = target[i];
		}
		return doubles;
	}
	
	/**
	 * ��char������д����
	 * @param target ָ����char���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Character[] Pack(char[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Character[] characters = new Character[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			characters[i] = target[i];
		}
		return characters;
	}
	
	/**
	 * ��boolean������д����
	 * @param target ָ����boolean���顣
	 * @return �����õ��ķ�����顣
	 */
	public static Boolean[] Pack(boolean[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackUtil_0));
		
		Boolean[] booleans = new Boolean[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			booleans[i] = target[i];
		}
		return booleans;
	}

	
	private ArrayUtil(){
		//������ʵ������
	}
}
