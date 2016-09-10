package com.dwarfeng.dfunc.cna;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

/**
 * �ṩ������������ķ���Ͳ��������
 * <p> �ù�����ʹ����<code>Java5</code>���ϵĻ��������Զ�����ļ�������˲��ʺ�����<code>Java5</code>
 * ��ǰ�İ汾��
 * @author DwArFeng
 * @since 1.8
 */
public final class ArrayPackFunction {
	
	/**
	 * ��Byte��������
	 * @param target ָ����Byte���顣
	 * @return �����õ��Ļ����������顣
	 */
	public static byte[] unpack(Byte[] target){
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
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
		
		if(target == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.ArrayPackFunction_0));
		
		Boolean[] booleans = new Boolean[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			booleans[i] = target[i];
		}
		return booleans;
	}

	private ArrayPackFunction() {
		// ��ֹ�ð���ʵ����
	}

}
