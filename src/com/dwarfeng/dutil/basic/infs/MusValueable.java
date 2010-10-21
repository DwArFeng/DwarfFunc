package com.dwarfeng.dutil.basic.infs;


/**
 * ��ֵ̬�ӿڡ�
 * <p> �ýӿ���ζ��ʵ�����ܹ�ת��Ϊĳ��ֵ�����ҿ��Խ���ֵ���κ�һ�ֻ����������ͷ��ء�
 * @author DwArFeng
 * @since 1.8
 */
public interface MusValueable{
	
	/**
	 * ���ظ�ֵ��double��ʽ��
	 * @return ��ֵ��double��ʽ��
	 */
	public double doubleValue();
	
	/**
	 * ���ظ�ֵ��float��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��float��ʽ��
	 */
	public default float floatValue(){
		return (float)doubleValue();
	}
	
	/**
	 * ���ظ�ֵ��long��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��long��ʽ��
	 */
	public default long longValue(){
		return (long)doubleValue();
	}
	
	/**
	 * ���ظ�ֵ��int��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��int��ʽ��
	 */
	public default int intValue(){
		return (int)doubleValue();
	}
	
	/**
	 * ���ظ�ֵ��short��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��short��ʽ��
	 */
	public default short shortValue(){
		return (short)doubleValue();
	}
	
	/**
	 * ���ظ�ֵ��byte��ʽ��
	 * <p>ע�⣬��Ĭ�Ϸ�����ǿ��ת��ʱ��������ʧ���������
	 * @return ��ֵ��byte��ʽ��
	 */
	public default byte byteValue(){
		return (byte)doubleValue();
	}
}
