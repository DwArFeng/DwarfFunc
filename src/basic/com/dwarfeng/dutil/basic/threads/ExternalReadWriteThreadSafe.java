package com.dwarfeng.dutil.basic.threads;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * �ⲿ��д�̰߳�ȫ�ӿڡ�
 * <p> ʵ�ָýӿ���ζ��ʵ�������̰߳�ȫ�ģ������ܹ����ⲿ���ƴ˶����ͬ����д����
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public interface ExternalReadWriteThreadSafe {
	
	/**
	 * ��ȡ���ⲿ��д�̰߳�ȫ�����е�ͬ����д����
	 * @return ���ⲿ�̰߳�ȫ�����е�ͬ����д����
	 */
	public ReadWriteLock getLock();

}
