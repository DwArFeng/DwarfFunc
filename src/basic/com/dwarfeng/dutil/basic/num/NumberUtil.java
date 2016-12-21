package com.dwarfeng.dutil.basic.num;

import java.nio.ByteBuffer;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.num.unit.Angle;

/**
 * ����ת���ࡣ
 * <p> �ṩ���õ�����ת�������볣�õ����ݽṹ��byte�����໥ת���ķ�����
 * <p> ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * <p> �����ṩ��λ������صķ�����
 * <br> ��ע�⣬���㷽�������漰�������㣬���Ȼ�������
 * <br> �ð������˲��ֳ��õĻ���ö�٣������ͱ������û��ڳ����ĵ�λ�����л���ʱ�䡣���� {@linkplain Angle}
 * <br> ��ע�⣬��Ȼ���㷽���У�<code>u1</code>��<code>u2</code>�����ò�ͬö���е�
 * �ֶΣ�����������û������ģ��벻Ҫ��������
 * @author DwArFeng
 * @since 1.8
 */
public final class NumberUtil {

	//���ܽ���ʵ����
	private NumberUtil(){}
	
	/**
	 * ��int��������ת��Ϊbyte���顣
	 * @param i ָ����int�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] int2Byte(int i){
		
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
	public static int byte2Int(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.put(TrimToSize(bytes, 4)).flip();
		return buffer.getInt();
	}
	/**
	 * ��long��������ת��Ϊbyte���顣
	 * @param l ָ����long�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] long2Byte(long l){
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
	public static long byte2Long(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.put(TrimToSize(bytes, 8)).flip();
		return buffer.getLong();
	}
	/**
	 * ��float��������ת��Ϊbyte���顣
	 * @param f ָ����float�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] float2Byte(float f){
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
	public static float byte2Float(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.put(TrimToSize(bytes, 4)).flip();
		return buffer.getFloat();
	}
	/**
	 * ��double����ת��Ϊbyte���顣
	 * @param d ָ����double�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] double2Byte(double d){
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
	public static double byte2Double(byte[] bytes){
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.put(TrimToSize(bytes, 8)).flip();
		return buffer.getDouble();
	}
	/**
	 * ��short��������ת��Ϊbyte���顣
	 * @param s ָ����short�������͡�
	 * @return ת�����byte���顣
	 */
	public static byte[] short2Double(short s){
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
	public static short byte2Short(byte[] bytes){
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
	
	/**
	 * ��һ����������ȡ�Ͱ�λ�������byte��ʽ��
	 * @param b ָ������������
	 * @return ��ȡ�Ͱ�λ���byte��ʽ��
	 */
	public static byte cutInt2Byte(int b){
		return (byte) (b & 0xFF);
	}
	

	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(NumberValue val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return (val.doubleValue())/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(float val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(double val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(long val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(short val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(int val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static NumberValue unitTrans(byte val, NumberValue u1, NumberValue u2){
		
		return new NumberValue() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
			 */
			@Override
			public double doubleValue() {
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ����һ�����������е����ֵ��
	 * <p> ����������κβ������򷵻� <code>0</code>��
	 * @param is �������顣
	 * @return ���ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static int max(int... is){
		Objects.requireNonNull(is, DwarfUtil.getStringField(StringFieldKey.NumberUtil_0));
		if(is.length == 0) return 0;
		if(is.length == 1) return is[0];
		if(is.length == 2) return Math.max(is[0], is[1]);
		int max = is[0];
		for(int i = 1 ; i < is.length ; i ++){
			max = Math.max(max, is[i]);
		}
		return max;
	}
	
	/**
	 * ����һ�����������е���Сֵ��
	 * <p> ����������κβ������򷵻� <code>0</code>��
	 * @param is �������顣
	 * @return ��Сֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static int min(int... is){
		Objects.requireNonNull(is, DwarfUtil.getStringField(StringFieldKey.NumberUtil_0));
		if(is.length == 0) return 0;
		if(is.length == 1) return is[0];
		if(is.length == 2) return Math.min(is[0], is[1]);
		int min = is[0];
		for(int i = 1 ; i < is.length ; i ++){
			min = Math.min(min, is[i]);
		}
		return min;
	}
	
	/**
	 * ����һ��˫���ȸ��������е����ֵ��
	 * <p> ����������κβ������򷵻� <code>0</code>��
	 * @param ds ˫���ȸ������顣
	 * @return ���ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static double max(double... ds){
		Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.NumberUtil_1));
		if(ds.length == 0) return 0;
		if(ds.length == 1) return ds[0];
		if(ds.length == 2) return Math.max(ds[0], ds[1]);
		double max = ds[0];
		for(int i = 1 ; i < ds.length ; i ++){
			max = Math.max(max, ds[i]);
		}
		return max;
	}
	
	/**
	 * ����һ��˫���ȸ��������е���Сֵ��
	 * <p> ����������κβ������򷵻� <code>0</code>��
	 * @param ds ˫���ȸ������顣
	 * @return ��Сֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public static double min(double... ds){
		Objects.requireNonNull(ds, DwarfUtil.getStringField(StringFieldKey.NumberUtil_1));
		if(ds.length == 0) return 0;
		if(ds.length == 1) return ds[0];
		if(ds.length == 2) return Math.min(ds[0], ds[1]);
		double min = ds[0];
		for(int i = 1 ; i < ds.length ; i ++){
			min = Math.min(min, ds[i]);
		}
		return min;
	}
	
}
