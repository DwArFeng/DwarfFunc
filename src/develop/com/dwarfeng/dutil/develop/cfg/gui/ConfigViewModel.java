package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigReflect;
import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ������ͼģ�͡�
 * <p> ��ģ��ƫ����ͼ��������֪�ĵ���˳�򣬿���ע��������ͼ����������
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigViewModel extends ConfigReflect, ObverserSet<ConfigViewObverser>{
	
	
	
	/**
	 * ����ģ����ָ����Ŵ�����ڵĵ�ǰֵ�Ƿ���Ч��
	 * @param index ָ������š�
	 * @return ָ����Ŵ���Ԫ���Ƿ���Ч��
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public default boolean isValid(int index){
		return getConfigChecker(index).isValid(getCurrentValue(index));
	}
	
	/**
	 * ����ģ����ָ����Ŵ�����ڵĵ�ǰֵ�Ƿ���Ч��
	 * @param index ָ������š�
	 * @return ָ����Ŵ���Ԫ���Ƿ���Ч��
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public default boolean nonValid(int index){
		return getConfigChecker(index).nonValid(getCurrentValue(index));
	}
	
	/**
	 * ���ø�ģ����ָ����Ŵ��ĵ�ǰֵ��
	 * @param index ָ������š�
	 * @param value �µĵ�ǰֵ��
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public void setValue(int index, String value);
	
	/**
	 * ����ָ����Ŵ���ǰֵΪĬ��ֵ��
	 * @param index ָ������š�
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public default void resetValue(int index){
		setValue(index, getDefaultValue(index));
	}
	
}
