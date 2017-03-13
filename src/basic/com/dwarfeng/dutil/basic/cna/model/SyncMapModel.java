package com.dwarfeng.dutil.basic.cna.model;

import java.util.concurrent.locks.ReadWriteLock;

import com.dwarfeng.dutil.basic.cna.model.obv.MapObverser;
import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;

/**
 * ͬ��ӳ��ģ��
 * <p>
 * �ṩһ���̰߳�ȫ��ӳ��ģ�ͣ���ģ�͵��̰߳�ȫ����ͬ����д���� {@link ReadWriteLock}��ʵ�ֵġ�
 * ���ڴ󲿷ַ���������ֱ�ӵ��ö����õ����̰߳�ȫ�ķ���������һС������Ҫ�Է��صĶ�����������ģ� ����Ԥ֪�Ĳ�����ʱ������Ҫ��ȡģ���е��������ⲿͬ����
 * ����ʹ�� {@link #keySet()}�������б�����ʵ���������£�
 * 
 * <pre>
 * 
 * static void inspect(SyncListModel&lt;Object, Object&gt; model) {
 * 	model.getLock().readLock().lock();
 * 	try {
 * 		for (Object object : model.keySet()) {
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
public interface SyncMapModel<K, V, O extends MapObverser<K, V>> extends MapModel<K, V, O>, ExternalReadWriteThreadSafe {

}
