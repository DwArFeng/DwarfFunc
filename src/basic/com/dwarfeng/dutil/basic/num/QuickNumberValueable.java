package com.dwarfeng.dutil.basic.num;


/**
 * ���ٶ�ֵ̬�ӿڡ�
 * <p> �����ǶԶ�ֵ̬�ӿ���򵥡����ٵ�ʵ�֡�
 * @author DwArFeng
 * @since 1.8
 */
public class QuickNumberValueable implements NumberValue {

	public static final QuickNumberValueable ZERO = new QuickNumberValueable();
	
	/**�ö�ֵ̨�ӿڵ�ֵ*/
	protected final double val;
	
	/**
	 * ����һ����СΪ0�Ŀ���ֵ�ӿڡ�
	 * <p> �ù��������������ȶ�С�ھ�̬�ֶ� {@link QuickNumberValueable#ZERO}��
	 */
	public QuickNumberValueable() {
		this(0);
	}
	
	/**
	 * ����һ������ָ��ֵ�Ŀ��ٶ�ֵ̬�ӿڶ���
	 * @param val ָ����ֵ��
	 */
	public QuickNumberValueable(double val) {
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
		if(!(obj instanceof QuickNumberValueable)) return false;
		QuickNumberValueable v = (QuickNumberValueable) obj;
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
		return String.valueOf(val);
	}
}
