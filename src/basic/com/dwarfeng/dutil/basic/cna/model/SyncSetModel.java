package com.dwarfeng.dutil.basic.cna.model;

import java.util.concurrent.locks.ReadWriteLock;

import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;
import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;

/**
 * ͬ������ģ��
 * <p>
 * �ṩһ���̰߳�ȫ�ļ���ģ�ͣ���ģ�͵��̰߳�ȫ����ͬ����д���� {@link ReadWriteLock}��ʵ�ֵġ�
 * ���ڴ󲿷ַ���������ֱ�ӵ��ö����õ����̰߳�ȫ�ķ���������һС������Ҫ�Է��صĶ�����������ģ� ����Ԥ֪�Ĳ�����ʱ������Ҫ��ȡģ���е��������ⲿͬ����
 * ����ʹ�� {@link #iterator()}�������б�����ʵ���������£�
 * 
 * <pre>
 * 
 * static void inspect(SyncListModel&lt;Object&gt; model) {
 * 	model.getLock().readLock().lock();
 * 	try {
 * 		for (Object object : model) {
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
public interface SyncSetModel<E, O extends SetObverser<E>> extends SetModel<E, O>, ExternalReadWriteThreadSafe {

}
