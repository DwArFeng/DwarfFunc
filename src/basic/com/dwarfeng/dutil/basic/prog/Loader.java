package com.dwarfeng.dutil.basic.prog;

import com.dwarfeng.dutil.basic.io.LoadFailedException;

/**
 * ��ȡ����
 * <p> ʵ�ָýӿ���ζ�Ÿö����ܹ���ĳЩ���ݼ��ص�ָ���Ķ����С�
 * @author  DwArFeng
 * @since 0.0.3-beta
 */
public interface Loader<T> {

	/**
	 * ��ָ���Ķ����ж�ȡ���ݡ�
	 * @param loggerModel ָ���Ķ���
	 * @throws LoadFailedException ��ȡʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void load(T obj) throws LoadFailedException;
	
}
