package com.dwarfeng.dmath.algebra;

import com.dwarfeng.dmath.DMath;

/**
 * �����ӿڡ�
 * <p> ʵ�ָýӿڵ��඼��������Ϊ�����ģ����������йؼ��Ե������ֶΣ��ı���Щ���ֵĻ����
 * ����������޸ġ�
 * <br> ���е� {@link Valueable} ���������ģ���Ϊ�������տ��Է���ĳ����ֵ������ {@link Valueable}
 * �Ķ���Ҳ�п����������ģ����������Ȼ�����Ծ����һ�����ִ��棬���Ǹı����е���ֵ��Ծ���
 * ��ɱ��ʵ�Ӱ�죬�����Ҳ�������ġ�
 * @author DwArFeng
 * @since 1.8
 */
public interface NumBase extends DMath{
	
	/**
	 * ����һ������ı����ռ䡣
	 * @return ����ı����ռ䡣
	 */
	public VariableSpace getVariableSpace();
	
	/**
	 * �ж�������������ǲ���һ��������
	 * <p> ��ν�ĳ�������ָ�������ı����ռ�Ԫ������Ϊ0��Ҳ�������в����пɱ������
	 * @return ���������Ƿ���һ��������
	 */
	public default boolean isConstant(){
		return getVariableSpace().size() == 0;
	}
	
	

}
