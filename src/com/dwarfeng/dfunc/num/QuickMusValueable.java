package com.dwarfeng.dfunc.num;

import com.dwarfeng.dfunc.infs.MusValueable;

/**
 * ���ٶ�ֵ̬�ӿڡ�
 * <p> �����ǶԶ�ֵ̬�ӿ���򵥡����ٵ�ʵ�֡�
 * @author DwArFeng
 * @since 1.8
 */
public class QuickMusValueable implements MusValueable {

	public static final QuickMusValueable ZERO = new QuickMusValueable();
	
	/**�ö�ֵ̨�ӿڵ�ֵ*/
	protected final double val;
	
	/**
	 * ����һ����СΪ0�Ŀ���ֵ�ӿڡ�
	 * <p> �ù��������������ȶ�С�ھ�̬�ֶ� {@link QuickMusValueable#ZERO}��
	 */
	public QuickMusValueable() {
		this(0);
	}
	
	/**
	 * ����һ������ָ��ֵ�Ŀ��ٶ�ֵ̬�ӿڶ���
	 * @param val ָ����ֵ��
	 */
	public QuickMusValueable(double val) {
		this.val = val;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfunc.infs.MusValueable#doubleValue()
	 */
	@Override
	public double doubleValue() {
		return val;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		if(!(obj instanceof QuickMusValueable)) return false;
		QuickMusValueable v = (QuickMusValueable) obj;
		return v.val == val;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(val) * 17;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return val + "";
	}
}
