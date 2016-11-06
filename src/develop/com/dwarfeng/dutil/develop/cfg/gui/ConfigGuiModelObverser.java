package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.gui.ConfigGuiModel.Entry;

/**
 * ���ý���ģ�͹۲�����
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigGuiModelObverser {

	/**
	 * ֪ͨ��ͼģ�����Ԫ�ء�
	 * @param index ���Ԫ�ص���š�
	 * @param entry ��ӵ�Ԫ�ء�
	 */
	public void fireEntryAdded(int index, Entry entry);
	
	/**
	 * ֪ͨ��ͼģ�͸���Ԫ�ء�
	 * @param index Ԫ�ظ��ķ�����λ�á�
	 * @param entry �µ�Ԫ�ء�
	 */
	public void fireEntryChanged(int index, Entry entry);
	
	/**
	 * ֪ͨ��ͼģ���Ƴ�Ԫ�ء�
	 * @param index Ԫ���Ƴ���λ�á�
	 */
	public void fireEntryRemoved(int index);
	
	/**
	 * ֪ͨ��ͼģ�����Ԫ�ء�
	 */
	public void fireEntryCleared();
	
}
