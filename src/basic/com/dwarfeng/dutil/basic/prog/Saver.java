package com.dwarfeng.dutil.basic.prog;

import com.dwarfeng.dutil.basic.io.SaveFailedException;

/**
 * ��������
 * <p> ʵ�ָýӿ���ζ�Ÿö����ܽ�ָ�������е���Ϣ��ĳ�ַ�ʽ���д洢��
 * @author  DwArFeng
 * @since 0.0.3-beta
 */
public interface Saver<T> {

	/**
	 * ��ָ���Ķ����Զ����б������ݡ�
	 * @param mutilangModel ָ���Ķ����Զ���
	 * @throws SaveFailedException ����ʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void save(T obj) throws SaveFailedException;
	
}
