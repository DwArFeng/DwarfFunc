package com.dwarfeng.dfunc.infs;

import com.dwarfeng.dmath.algebra.Valueable;

/**
 * ��ֵ̬�ӿڡ�
 * <p> �ýӿ���ζ��ʵ�����ܹ�ת��Ϊĳ��ֵ�����ҿ��Խ���ֵ���κ�һ�ֻ����������ͷ��ء�
 * @author DwArFeng
 * @since 1.8
 */
public interface MusValueable extends Valueable{
	
	/**
	 * ���ظ�ֵ��double��ʽ��
	 * @return ��ֵ��double��ʽ��
	 */
	public default double doubleValue(){
		return value();
	}
	
	/**
	 * ���ظ�ֵ��float��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��float��ʽ��
	 */
	public default float floatValue(){
		return (float)value();
	}
	
	/**
	 * ���ظ�ֵ��long��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��long��ʽ��
	 */
	public default long longValue(){
		return (long)value();
	}
	
	/**
	 * ���ظ�ֵ��int��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��int��ʽ��
	 */
	public default int intValue(){
		return (int)value();
	}
	
	/**
	 * ���ظ�ֵ��short��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��short��ʽ��
	 */
	public default short shortValue(){
		return (short)value();
	}
	
	/**
	 * ���ظ�ֵ��byte��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��byte��ʽ��
	 */
	public default byte byteValue(){
		return (byte)value();
	}
}
