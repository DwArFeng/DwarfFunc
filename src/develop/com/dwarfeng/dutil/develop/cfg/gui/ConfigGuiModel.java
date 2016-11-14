package com.dwarfeng.dutil.develop.cfg.gui;

import java.util.HashMap;
import java.util.Map;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ���ý���ģ�͡�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigGuiModel{

	/**
	 * ��ȡָ����Ŵ������ü���
	 * @param index ָ������š�
	 * @return ָ����Ŵ������ü���
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public ConfigKey getConfigKey(int index);
	
	/**
	 * ��ȡָ����Ŵ��ĵ�ǰֵ��
	 * @param index ָ������š�
	 * @return ָ����Ŵ��ĵ�ǰֵ��
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public String getCurrentValue(int index);
	
	/**
	 * ��ȡָ����Ŵ���Ĭ��ֵ��
	 * @param index ָ������š�
	 * @return ָ����Ŵ���Ĭ��ֵ��
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public String getDefaultValue(int index);
	
	/**
	 * ��ȡָ����Ŵ���ֵ�������
	 * @param index ָ������š�
	 * @return ָ����Ŵ���ֵ�������
	 * @throws IndexOutOfBoundsException ���Խ�硣
	 */
	public ConfigChecker getConfigChecker(int index);
	
	/**
	 * ���ظ�ģ���е�����������
	 * @return ����������
	 */
	public int size();
	
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
	
	/**
	 * ��ȡ����ģ���еĵ�ǰֵӳ�䡣
	 * <p> ��ӳ�䲻�������ü���ģ���е�˳�������˳���ǲ�ȷ���ġ�
	 * @return ��ǰֵӳ�䡣
	 */
	public default Map<ConfigKey, String> getCurrentValueMap(){
		Map<ConfigKey, String> currentValueMap = new HashMap<ConfigKey, String>();
		for(int i = 0 ; i < size() ; i ++){
			currentValueMap.put(getConfigKey(i), getCurrentValue(i));
		}
		return currentValueMap;
	}
	
	/**
	 * ���ӹ۲�����
	 * @param obverser ָ�������ý���۲�����
	 * @return �Ƿ����ӳɹ���
	 */
	public boolean addObverser(ConfigGuiModelObverser obverser);
	
	/**
	 * �Ƴ��۲�����
	 * @param obverser ָ�������ý���۲�����
	 * @return �Ƿ��Ƴ��ɹ���
	 */
	public boolean removeObverser(ConfigGuiModelObverser obverser);
	
	/**
	 * ������й۲�����
	 */
	public void clearObverser();
	
}
