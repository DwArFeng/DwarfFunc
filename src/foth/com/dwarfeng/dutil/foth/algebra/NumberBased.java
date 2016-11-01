package com.dwarfeng.dutil.foth.algebra;

import com.dwarfeng.dutil.foth.DFoth;
import com.dwarfeng.dutil.math.MathObject;
import com.dwarfeng.dutil.math.Region;

/**
 * �����ӿڡ�
 * <p> ʵ�ָýӿڵ��඼��������Ϊ�����ģ����������йؼ��Ե������ֶΣ��ı���Щ���ֵĻ����
 * ����������޸ġ�
 * <br> ���е� {@link FothValue} ���������ģ���Ϊ�������տ��Է���ĳ����ֵ������ {@link FothValue}
 * �Ķ���Ҳ�п����������ģ����������Ȼ�����Ծ����һ�����ִ��棬���Ǹı����е���ֵ��Ծ���
 * ��ɱ��ʵ�Ӱ�죬�����Ҳ�������ġ�
 * @author DwArFeng
 * @since 1.8
 */
public interface NumberBased extends MathObject, Region<FothVariable>, DFoth{
	
	/**
	 * ����һ������ı����ռ䡣
	 * <p> ע�⣺����ز�Ҫ�ô˷������� <code>null</code>�����һ����������û���κα����Ļ����뷵�ؿռ���
	 * �� {@link FothVariableSpace#EMPTY}��
	 * @return ����ı����ռ䡣
	 */
	public FothVariableSpace variableSpace();
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.MayChange#canModify()
	 */
	@Override
	public default boolean canModify(){
		return variableSpace().size() == 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.Region#contains(java.lang.Object)
	 */
	@Override
	public default boolean contains(FothVariable t){
		return variableSpace().contains(t);
	}

}
