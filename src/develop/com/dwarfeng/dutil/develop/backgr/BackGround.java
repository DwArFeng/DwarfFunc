package com.dwarfeng.dutil.develop.backgr;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;
import com.dwarfeng.dutil.develop.backgr.obv.BackGroundObverser;
import com.dwarfeng.dutil.develop.backgr.obv.TaskObverser;

/**
 * ��̨�ӿڡ�
 * <p>
 * ��̨���ڴ����������ύ������ͨ����������̨ӵ���Լ����̣߳���˺�̨�ķ������������ǰ̨�ķ���ͬ��ִ�С�
 * �������ں�̨�Ķ��߳����ʣ����еĺ�̨�����̰߳�ȫ�ģ�����ʵ�����ⲿ��д��ȫ�ӿڡ�
 * 
 * <p>
 * ��ͬ�ĺ�̨�������ύ�������в�ͬ�Ĺ��򣬱��磺 �еĺ�̨������ύ���Ⱥ��ϵһһ���б��ύ������ �еĺ�̨�Ὺ�ٲ�ͬ���߳�ͬʱִ�в�ͬ������
 * �������ύ��ʱ����ù�����������á�
 * 
 * <p>
 * Ӧ��Ϊ�ú�̨�ṩһ����������������ʱ�����̨���Ѿ���ɵ����������������񱻱�������ɶ����С�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface BackGround<O extends BackGroundObverser> extends ExternalReadWriteThreadSafe, ObverserSet<O> {

	/**
	 * ���̨���ύָ��������
	 * <p>
	 * ֻ�з� <code>null</code> �һ�δ��ʼ������ſ��ύ�ɹ���
	 * 
	 * @param task
	 *            ָ��������
	 * @return �������Ƿ��ύ��
	 */
	public boolean submit(Task<? extends TaskObverser> task);

	/**
	 * ���̨���ύָ�� <code>collection</code> �е���������
	 * 
	 * <p>
	 * ֻ�з� <code>null</code> �һ�δ��ʼ������ſ��ύ�ɹ��� TODO
	 * 
	 * @param c
	 *            ָ����<code>collection</code>��
	 * @return �������һ�������ύ���򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean submitAll(Collection<? extends Task<? extends TaskObverser>> c);

	/**
	 * ����˺�̨�ѹرգ��򷵻� <code>true</code>��
	 * 
	 * @return �ú�̨�Ƿ��Ѿ��رա�
	 */
	public boolean isShutdown();

	/**
	 * ����رպ�������������ɣ��򷵻� <code>true</code>��ע�⣬�������ȵ��� <code>shutdown</code> ��
	 * <code>shutdownNow</code>������ <code>isTerminated</code> ����Ϊ true��
	 * 
	 * @return ����رպ�������������ɣ��򷵻� <code>true</code>��
	 */
	public boolean isTerminated();

	/**
	 * ���������̣߳�ֱ���ú�̨�رա�
	 * 
	 * @throws InterruptedException
	 *             �߳�������ʱ������߳��жϡ�
	 */
	public void awaitTermination() throws InterruptedException;

	/**
	 * ���������̣߳�ֱ���ú�̨�رջ�����������ָ����ʱ�䡣
	 * 
	 * @param timeout
	 *            ָ����ʱ���С��
	 * @param unit
	 *            ָ����ʱ�䵥λ��
	 * @return ����÷��������ڳ�ʱ�����صģ��򷵻� <code>false</code>�����򷵻� <code>true</code>��
	 * @throws InterruptedException
	 *             �߳�������ʱ������߳��жϡ�
	 */
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

	/**
	 * ��ȡ�ɺ�̨�����е�������ɵļ��ϡ�
	 * <p>
	 * �ü�����ֻ���ġ�
	 * 
	 * @return �ɺ�̨�е�����������ɵļ��ϡ�
	 */
	public Set<Task<? extends TaskObverser>> tasks();

	/**
	 * ��ȡ�ɺ�̨�������Ѿ���ɵ�������ɵ��������С�
	 * <p>
	 * �ö����ɺ�̨�������Ѿ���ɵ�������ɣ��ڶ�����ǰ����������������ɵ����� <br>
	 * ���������п��Ե����Ƴ�������ȡ��������������Ӷ����б��Ƴ���ȡ������ӵ������б��Ƴ�ʱ��
	 * ����ͬʱҲ�ᷴӳ����̨�ϣ�����ЩԪ��Ҳ��Ӻ�̨�б�ȡ����<br>
	 * �ö��н�ֹʹ����ӷ�����
	 * 
	 * @return �ɺ�̨�������Ѿ���ɵ�������ɵ��������С�
	 */
	public BlockingQueue<Task<? extends TaskObverser>> finishedQueue();

}
