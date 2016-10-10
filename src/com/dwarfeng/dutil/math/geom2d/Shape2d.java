package com.dwarfeng.dutil.math.geom2d;

import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.Region;

/**
 * ��ʾһ����άͼ�Ρ�
 * @author DwArFeng
 * @since 1.8
 */
public interface Shape2d extends Region<Point2d>, MathObject{

	/**
	 * ����ͼ�ε������
	 * @return ͼ�ε������
	 */
	public double area();
	
	/**
	 * �ж�ָ���ĵ��Ƿ���ͼ���С�
	 * @param x ָ�����x���ꡣ
	 * @param y ָ�����y���ꡣ
	 * @return ָ���ĵ��Ƿ���ͼ���С�
	 */
	public default boolean contains(double x, double y){
		return contains(new Point2d(x, y));
	}
	
	/**
	 * �ж�ָ���ĵ��Ƿ���ͼ���С�
	 * @param t ָ���ĵ㡣
	 * @return ָ���ĵ��Ƿ���ͼ���С�
	 */
	@Override
	public boolean contains(Point2d t);
	
	/**
	 * ����ͼ�ε����ġ�
	 * @return ͼ�ε����ġ�
	 */
	public Point2d shapeCenter();
	
	
	
}
