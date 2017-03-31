package com.dwarfeng.dutil.develop.backgr;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe;
import com.dwarfeng.dutil.develop.backgr.obv.BackgroundObverser;

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
 * ���ύ��������ɺ󣬺�̨���������������Ƴ�������������Զ��ġ�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface Background<O extends BackgroundObverser> extends ExternalReadWriteThreadSafe, ObverserSet<O> {

	/**
	 * ���̨���ύָ��������
	 * <p>
	 * ֻ�з� <code>null</code> �һ�δ��ʼ������ſ��ύ�ɹ���
	 * 
	 * <p>
	 * ��ͼ�����ڹرյĺ�̨���ύ������׳��쳣��
	 * 
	 * @param task
	 *            ָ��������
	 * @return �������Ƿ��ύ��
	 * @throws IllegalStateException
	 *             ��ͼ�����ڹرյĺ�̨���ύ����
	 */
	public boolean submit(Task task);

	/**
	 * ���̨���ύָ�� <code>collection</code> �е���������
	 * 
	 * <p>
	 * ֻ�з� <code>null</code> �һ�δ��ʼ������ſ��ύ�ɹ��� TODO
	 * 
	 * <p>
	 * ��ͼ�����ڹرյĺ�̨���ύ������׳��쳣��
	 * 
	 * @param c
	 *            ָ����<code>collection</code>��
	 * @return �������һ�������ύ���򷵻� <code>true</code>��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalStateException
	 *             ��ͼ�����ڹرյĺ�̨���ύ����
	 */
	public boolean submitAll(Collection<? extends Task> c);

	/**
	 * �رպ�̨��
	 * <p>
	 * ����̨�ر�ʱ����̨��ܾ������������ύ�����ύ����������Ӱ�졣 <o> �����ύ����������ִ����Ϻ󣬺�̨��ᱻ�սᡣ
	 */
	public void shutdown();

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
	public Set<Task> tasks();

}
