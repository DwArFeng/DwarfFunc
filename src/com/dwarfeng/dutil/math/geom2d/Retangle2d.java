package com.dwarfeng.dutil.math.geom2d;

import java.util.Objects;

import com.dwarfeng.dutil.math.AbstractDMath;

/**
 * ��άƽ�о��Ρ�
 * <p> �þ�����ɱ�ʾ����ƽ�о��Σ����������ڵı߷ֱ���x���y��ƽ�еľ��Ρ�
 * <br> �����޷���ʾ��б�ľ��Σ���б�ľ��ο�����һ�����������ʾ��
 * @author DwArFeng
 * @since 1.8
 */
public class Retangle2d extends AbstractDMath implements Shape2d{
	
	protected final Point2d point;
	protected final double height;
	protected final double weight;
	
	/**
	 * ����һ��Ĭ�ϵľ��Σ��þ��ε����Ͻǵ�Ϊ(0,0) �Ҹ߶ȺͿ�Ⱦ�Ϊ0��
	 */
	public Retangle2d() {
		this(0, 0, 0, 0);
	}
	
	/**
	 * ����һ������ָ��ԭ�㣬ָ����Ⱥ͸߶ȵľ��Ρ�
	 * @param point ָ����ԭ�㡣
	 * @param weight ָ���Ŀ��
	 * @param heitht ָ���ĸ߶ȡ�
	 */
	public Retangle2d(Point2d point, double weight, double heitht) {
		Objects.requireNonNull(point);
		this.point = point;
		this.height = heitht;
		this.weight = weight;
	}
	
	/**
	 * ����һ������ָ��ԭ�㣬ָ����Ⱥ͸߶ȵľ��Ρ�
	 * @param x ָ��ԭ���x���ꡣ
	 * @param y ָ��ԭ���y���ꡣ
	 * @param weight ָ���Ŀ�ȡ�
	 * @param height ָ���ĸ߶ȡ�
	 */
	public Retangle2d(double x, double y, double weight, double height){
		this.point = new Point2d(x, y);
		this.height = height;
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.geom2d.Shape2d#area()
	 */
	@Override
	public double area() {
		return weight * height;
	}

	@Override
	public boolean contains(Point2d t) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.geom2d.Shape2d#shapeCenter()
	 */
	@Override
	public Point2d shapeCenter() {
		return new Point2d(point.x + weight/2, point.y + height/2);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return "retangle";
	}

	@Override
	public String getExpression() {
		// TODO Auto-generated method stub
		return null;
	}

}
