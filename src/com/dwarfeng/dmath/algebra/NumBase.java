package com.dwarfeng.dmath.algebra;

import com.dwarfeng.dmath.DMath;
import com.dwarfeng.dmath.MayChange;
import com.dwarfeng.dmath.Region;

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
public interface NumBase extends DMath, Region<VariableValue>, MayChange{
	
	/**
	 * ����һ������ı����ռ䡣
	 * <p> ע�⣺����ز�Ҫ�ô˷������� <code>null</code>�����һ����������û���κα����Ļ����뷵�ؿռ���
	 * �� {@link AlgebraUtil#emptyVariableSpace()}��
	 * @return ����ı����ռ䡣
	 */
	public VariableSpace getVariableSpace();
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.MayChange#canModify()
	 */
	@Override
	public default boolean canModify(){
		return getVariableSpace().size() == 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.Region#contains(java.lang.Object)
	 */
	@Override
	public default boolean contains(VariableValue t){
		return getVariableSpace().contains(t);
	}

}
