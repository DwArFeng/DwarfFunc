package com.dwarfeng.dmath.geom2d;

import com.dwarfeng.dmath.DMath;

/**
 * �ɷ���任����
 * <p> ��ʾһ��������Խ��з���任��
 * @author DwArFeng
 * @since 1.8
 */
public interface AffineTransformable<T extends Shape2d> extends DMath{

	/**
	 * ��ʾ�������<code>from</code>����ϵ����任��<code>to</code>����ϵ��õ���ͼ�Ρ�
	 * @param from ԭʼ���ꡣ
	 * @param to Ŀ�����ꡣ
	 * @return �任��õ���ͼ�Ρ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public T transform(Coordinate2d from, Coordinate2d to);
	
}