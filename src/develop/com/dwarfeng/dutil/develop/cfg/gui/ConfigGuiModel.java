package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * ���ý���ģ�͡�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigGuiModel {

	/**
	 * ����ģ����ָ����Ŵ���Ĭ��ֵ��
	 * @param index ָ������š�
	 * @return ģ����ָ����Ŵ���Ĭ��ֵ��
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public String getDefaultValueAt(int index);
	
	/**
	 * ����ģ����ָ����ų��ĵ�ǰֵ��
	 * @param index ָ������š�
	 * @return ģ����ָ����Ŵ��ĵ�ǰֵ��
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public String getCurrentValueAt(int index);
	
	/**
	 * ����ģ����ָ����Ŵ�������ֵ�������
	 * @param index ָ������š�
	 * @return ģ����ָ����Ŵ�������ֵ�������
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public ConfigValueChecker getConfigValueCheckerAt(int index);
	
	/**
	 * ����ģ����ָ����Ŵ������ü���
	 * @param index ָ������š�
	 * @return ģ����ָ����Ŵ������ü���
	 * @throws IndexOutOfBoundsException �±�Խ�硣
	 */
	public ConfigKey getConfigKeyAt(int index);
	
	
	
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
