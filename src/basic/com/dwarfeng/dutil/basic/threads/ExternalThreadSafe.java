package com.dwarfeng.dutil.basic.threads;

import java.util.concurrent.locks.Lock;

/**
 * �ⲿ�̰߳�ȫ�ӿڡ�
 * <p> ʵ�ָýӿ���ζ��ʵ�������̰߳�ȫ�ģ������ܹ����ⲿ���ƴ˶����ͬ������
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface ExternalThreadSafe {

	/**
	 * ��ȡ���ⲿ�̰߳�ȫ�����е�ͬ������
	 * @return ���ⲿ�̰߳�ȫ�����е�ͬ������
	 */
	public Lock getLock();
}
