package com.dwarfeng.dutil.develop.cfg.gui;

import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigReflect;

import java.util.List;

import javax.naming.OperationNotSupportedException;

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
	 * ��ȡ��ģ���������ü����յ���˳����ɵ��б�
	 * <p> ���б��ǲ��ɸ��ĵģ�������༭�������׳� {@link OperationNotSupportedException}��
	 * @return ���ü��б�
	 */
	public List<ConfigKey> getConfigKeyList();
	
	/**
	 * ��ȡ��ģ����������ֵ��������յ���˳����ɵ��б�
	 * <p> ���б��ǲ��ɸ��ĵģ�������༭�������׳� {@link OperationNotSupportedException}��
	 * @return ����ֵ������б�
	 */
	public List<ConfigChecker> getConfigCheckerList();
	
	/**
	 * ��ȡ��ģ������Ĭ��ֵ���յ���˳����ɵ��б�
	 * <p> ���б��ǲ��ɸ��ĵģ�������༭�������׳� {@link OperationNotSupportedException}��
	 * @return Ĭ��ֵ�б�
	 */
	public List<String> getDefaultValueList();
	
	/**
	 * ��ȡ��ģ�����ɵ�ǰֵ���յ���˳����ɵ��б�
	 * <p> ���б��ǲ��ɸ��ĵģ�������༭�������׳� {@link OperationNotSupportedException}��
	 * @return
	 */
	public List<String> getCurrentValueList();
	
	/**
	 * ��ģ���е�ָ��λ�����һ���������������ݡ�
	 * @param index ָ����λ�á�
	 * @param configKey ָ�������ü���
	 * @param checker ָ��������ֵ�������
	 * @param defaultValue ָ����Ĭ��ֵ������Ϊ <code>null</code>����
	 * @param currentValue ָ���ĵ�ǰֵ������Ϊ <code>null</code>����
	 * @return �ò����Ƿ�ı���ģ�͡�
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean add(int index, ConfigKey configKey, ConfigChecker checker, String defaultValue, String currentValue);
	
	/**
	 * �Ƴ�ָ��λ�õ��������ݡ�
	 * @param index ָ����λ�á�
	 * @return �ò����Ƿ�ı���ģ�͡�
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 */
	public boolean remove(int index);
	
	/**
	 * ���ģ�͡�
	 */
	public void clear();
	
}
