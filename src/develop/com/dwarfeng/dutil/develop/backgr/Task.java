package com.dwarfeng.dutil.develop.backgr;

import java.util.concurrent.TimeUnit;

import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;
import com.dwarfeng.dutil.develop.backgr.obv.TaskObverser;

/**
 * ����ӿڡ�
 * <p>
 * ����ӿ����ڶ���һ�����񣬸�����������ں�̨��ִ�С�
 * 
 * <p>
 * �������Ҫ������ {@link #run()} ʵ�֣���Ҫע����ǣ�<b>ֻ�а��չ涨��Ҫ��ȥʵ�� <code>run</code>
 * ��������̨���п��ܻ���������</b>�� ��Ϊ�еĺ�̨������Щ�����ж������Ƿ�ʼ�ͽ��������������Ҫ��Ļ���
 * �����̨����Ϊ���ǲ���Ԥ�ϵģ������ᵼ�º�̨��Զ�޷�����ֹ�����������޷����Ƴ���
 * 
 * <p>
 * ����ӿڵĳ���ʵ�� {@link AbstractTask} ��ȫ���չ����д�� <code>run</code>������������������£�
 * �û�ֻ��Ҫ�̳иó�����������ȷ��ʵ�ָýӿڣ�������Ҫ�Ըýӿ�ֱ�ӽ���ʵ�֡�
 * 
 * <p>
 * ���һ��Ҫֱ��ʵ�ָýӿڣ�Ӧ��ע����ǣ�<code>run</code>���������еĿ�ʼ��һ��Ҫ֪ͨ���еĹ۲����������Ѿ���ʼ���У�
 * ���������н�����ʱ��һ��Ҫ֪ͨ���еĹ۲��������Ѿ��������С���� <code>run</code>�����еĴ����п��ܻ��׳��κ��쳣��
 * ��ôһ��Ҫ�������Ƶ��쳣�жϻ��ƣ�ֻҪ�׳��쳣����Ҫֹͣ��һ���Ķ���������Ҫʹ
 * <code>getException</code>�������ص��쳣�����׳�������쳣��
 * 
 * @see AbstractTask
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface Task<O extends TaskObverser> extends Runnable, ExternalReadWriteThreadSafe, ObverserSet<O> {

	/**
	 * ��ȡ�����Ƿ��Ѿ���ʼִ�С�
	 * 
	 * @return
	 */
	public boolean isStarted();

	/**
	 * �����Ƿ�ִ����ϡ�
	 * 
	 * @return �Ƿ�ִ����ϡ�
	 */
	public boolean isFinish();

	/**
	 * ��ȡ������쳣��
	 * <p>
	 * ���û���쳣���򷵻� <code>null</code>��
	 * 
	 * @return ������쳣�����û�У��򷵻� <code>null</code>��
	 */
	public Exception getException();

	/**
	 * �ȴ��ù���ִ����ϡ�
	 * <p>
	 * ���ø÷������̻߳��ڹ���ִ�����֮ǰһֱ������
	 * 
	 * @throws InterruptedException
	 *             �߳��ڵȴ���ʱ���жϡ�
	 */
	public void awaitFinish() throws InterruptedException;

	/**
	 * ���������̣߳�ֱ������ִ����ϻ�����ʱ�䳬��ָ��ʱ�䡣
	 * 
	 * @param timeout
	 *            ָ����ʱ����ֵ��
	 * @param unit
	 *            ָ����ʱ�䵥λ��
	 * @throws InterruptedException
	 *             �߳���������ʱ���жϡ�
	 */
	public boolean awaitFinish(long timeout, TimeUnit unit) throws InterruptedException;

}
