package com.dwarfeng.dutil.develop.cfg;

import java.util.concurrent.locks.ReadWriteLock;

import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;

/**
 * ͬ������ģ�͡�
 * <p>
 * �ṩһ���̰߳�ȫ�ļ�ֵ����ģ�ͣ���ģ�͵��̰߳�ȫ����ͬ����д���� {@link ReadWriteLock}��ʵ�ֵġ�
 * ���ڴ󲿷ַ���������ֱ�ӵ��ö����õ����̰߳�ȫ�ķ���������һС������Ҫ�Է��صĶ�����������ģ�����Ԥ֪�Ĳ�����ʱ������Ҫ��ȡģ���е��������ⲿͬ����
 * ����ʹ�� {@link #keySet()}�������б�����ʵ���������£�
 * 
 * <pre>
 * 
 * static void inspect(SyncconfigModel model) {
 * 	model.getLock().readLock().lock();
 * 	try {
 * 		for (ConfigKey key : model.keySet()) {
 * 			// Do Something
 * 		}
 * 	} finally {
 * 		model.getLock().readLock().unLock();
 * 	}
 * }
 * </pre>
 * <p>
 * ��ģ�����̰߳�ȫ�ġ�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface SyncConfigModel extends ConfigModel, ExternalReadWriteThreadSafe {

}
