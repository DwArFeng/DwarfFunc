package com.dwarfeng.dwarffunction.numerical;

import java.nio.ByteBuffer;

/**
 * ����ת���ࡣ�ṩ���õ����ݽṹ��byte�����໥ת���ķ�����
 * @author DwArFeng
 * @since 1.8
 */
public final class NumberTransform {

	/**
	 * ��int��������ת��Ϊbyte���顣
	 * @param i ָ����int�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] Int2Byte(int i){
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(i);
		return buffer.array();
	}
	/**
	 * ��ָ����byte����ת��Ϊint�������͡�
	 * <p>ָ����byte���齫���Զ��ı��ü�����ӵ�4λ��
	 * @param bytes ָ����byte���顣
	 * @return ת�����int�������͡�
	 */
	public static int Byte2Int(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.put(TrimToSize(bytes, 4)).flip();
		return buffer.getInt();
	}
	/**
	 * ��long��������ת��Ϊbyte���顣
	 * @param l ָ����long�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] Long2Byte(long l){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.putLong(l);
		return buffer.array();
	}
	/**
	 * ��byte����ת��Ϊlong�������͡�
	 * <p>ָ����byte���齫���Զ����ü�����ӵ�8λ��
	 * @param bytes ָ����byte���顣
	 * @return ת�����long�������͡�
	 */
	public static long Byte2Long(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.put(TrimToSize(bytes, 8)).flip();
		return buffer.getLong();
	}
	/**
	 * ��float��������ת��Ϊbyte���顣
	 * @param f ָ����float�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] Float2Byte(float f){
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putFloat(f);
		return buffer.array();
	}
	/**
	 * ��byte����ת��Ϊfloat�������͡�
	 * <p>ָ����byte���齫���Զ����ü�����ӵ�4λ��
	 * @param bytes ָ����byte���顣
	 * @return ת�����float�������͡�
	 */
	public static float Byte2Float(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.put(TrimToSize(bytes, 4)).flip();
		return buffer.getFloat();
	}
	/**
	 * ��double����ת��Ϊbyte���顣
	 * @param d ָ����double�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] Double2Byte(double d){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.putDouble(d);
		return buffer.array();
	}
	/**
	 * ��byte����ת��Ϊdouble�������͡�
	 * <p>ָ����byte���齫���Զ����ü�����ӵ�8λ��
	 * @param bytes ָ����byte���顣
	 * @return ת�����double�������͡�
	 */
	public static double Byte2Double(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.put(TrimToSize(bytes, 8)).flip();
		return buffer.getDouble();
	}
	/**
	 * ��short��������ת��Ϊbyte���顣
	 * @param s ָ����short�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] Short2Double(short s){
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.putShort(s);
		return buffer.array();
	}
	/**
	 * ��byte����ת��Ϊshort�������͡�
	 * <p>ָ����byte���齫���Զ��ı��ü�����ӵ�2λ��
	 * @param bytes ָ����byte���顣
	 * @return ת�����short�������͡�
	 */
	public static short Byte2Short(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.put(TrimToSize(bytes, 2)).flip();
		return buffer.getShort();
	}
	
	/**
	 * ��byte������вü�����ָ����λ����
	 * ��������λ������ָ����λ��������вü�����������λ������ָ����λ��������в�0��
	 * @param bytes ָ�������顣
	 * @param length ��Ҫ�ü����ĳ��ȡ�
	 * @return �ü�������顣
	 */
	private static byte[] TrimToSize(byte[] bytes,int length){
		//����������ü�����ĳ�������Ϊ����ĳ��ȡ�
		if(bytes.length == length) return bytes;
		byte[] target = new byte[length];
		if(bytes.length > length){
			for(int i = 0 ; i < length ; i ++){
				target[i] = bytes[i];
			}
			return target;
		}else{
			for(int i = 0 ; i < bytes.length ; i ++){
				target[i] = bytes[i];
			}
			for(int i = bytes.length ; i < length ; i++){
				target[i] = 0;
			}
			return target;
		}
	}
	
	//���ܽ���ʵ����
	private NumberTransform(){}
	
}
