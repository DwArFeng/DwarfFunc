package com.dwarfeng.dwarffunction.cna;

/**
 * �ṩ������������ķ���Ͳ��������
 * <p> �ù�����ʹ����<code>Java5</code>���ϵĻ��������Զ�����ļ�������˲��ʺ�����<code>Java5</code>
 * ��ǰ�İ汾��
 * @author DwArFeng
 * @since 1.8
 */
public class ArrayPackFunction {
	
	/**
	 * ��Byte��������
	 * @param target ָ����Byte���顣
	 * @return �����õ��Ļ������͡�
	 */
	public static byte[] unpack(Byte[] target){
		
		if(target == null) throw new NullPointerException();
		
		byte[] bytes = new byte[target.length];
		for(int i = 0 ; i < target.length ; i ++){
			bytes[i] = target[i];
		}
		return bytes;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static short[] unpack(Short[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static int[] unpack(Integer[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static float[] unpack(Float[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static long[] unpack(Long[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static char[] unpack(Character[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static boolean[] unpack(Boolean[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Byte[] pack(byte[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Short[] pack(short[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Integer[] pack(int[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Long[] Pack(long[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Float[] Pack(float[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Double[] Pack(double[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Character[] Pack(char[] target){
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param target
	 * @return
	 */
	public static Boolean[] Pack(boolean[] target){
		//TODO
		return null;
	}

	private ArrayPackFunction() {
		// ��ֹ�ð���ʵ����
	}

}
