package com.dwarfeng.dutil.develop.cfg.gui;

import java.util.List;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * ���ý���ģ�͡�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigGuiModel extends List<ConfigGuiModel.Entry>{

	/**
	 * ���ý���ģ���е���ڡ�
	 * @author  DwArFeng
	 * @since 1.8
	 */
	public interface Entry{
		
		/**
		 * ��ȡ��ڴ������ü���
		 * @return ��ڴ������ü���
		 */
		public ConfigKey getConfigKey();
		
		/**
		 * ��ȡ��ڴ��ĵ�ǰֵ��
		 * @return ��ڴ��ĵ�ǰֵ��
		 */
		public String getCurrentValue();
		
		/**
		 * ��ȡ��ڴ���Ĭ��ֵ��
		 * @return ��ڴ���Ĭ��ֵ��
		 */
		public String getDefaultValue();
		
		/**
		 * ��ȡ��ڴ���ֵ�������
		 * @return ��ڴ���ֵ�������
		 */
		public ConfigValueChecker getConfigValueChecker();
		
	}
	
	/**
	 * ����ģ����ָ����Ŵ�����ڵĵ�ǰֵ�Ƿ���Ч��
	 * @param index ָ������š�
	 * @return ָ����Ŵ���Ԫ���Ƿ���Ч��
	 * @throws �±�Խ�硣
	 */
	public default boolean isValid(int index){
		Entry entry = get(index);
		return entry.getConfigValueChecker().isValid(entry.getCurrentValue());
	}
	
	/**
	 * ����ģ����ָ����Ŵ�����ڵĵ�ǰֵ�Ƿ���Ч��
	 * @param index ָ������š�
	 * @return ָ����Ŵ���Ԫ���Ƿ���Ч��
	 */
	public default boolean nonValid(int index){
		Entry entry = get(index);
		return entry.getConfigValueChecker().nonValid(entry.getCurrentValue());
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
