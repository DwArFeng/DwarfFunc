package com.dwarfeng.dutil.basic.threads;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ���ж��С�
 * <p> ������һ���������к�̨�����Ĺ����ࡣ������ṩ�ķ����������俪�ٵ�һ����̨�߳��а���FIFO��˳������
 * ָ����<code>Runnable</code>���С��߳���<code>Runnable</code>����ȫ�����н���֮����ͣ����
 * ��������µ����к��������С�
 * @author DwArFeng
 * @since 1.8
 */
public class RunnerQueue<T extends Runnable> extends InnerThread {

	/**�̵߳�����*/
	private final static String THREAD_NAME = "RunnerQueue";
	
	/**Runnable ����*/
	private Queue<T> queue;
	/**�߳�ͬ����*/
	private Lock threadLock;
	/**�߳�״̬*/
	private Condition threadCondition;
	/**���ж�д��*/
	private ReadWriteLock queueLock;
	
	/**
	 * ����һ��Ĭ�ϵ����ж��У������ػ��̡߳�
	 */
	public RunnerQueue(){
		this(false);
	}
	
	/**
	 * ����һ��ָ���Ƿ�Ϊ�ػ��̵߳����ж��С�
	 * @param isDaemon �Ƿ�Ϊ�ػ��̡߳�
	 */
	public RunnerQueue(boolean isDaemon){
		super(THREAD_NAME,isDaemon);
		queue = new ArrayDeque<T>();
		threadLock = new ReentrantLock();
		threadCondition = threadLock.newCondition();
		queueLock = new ReentrantReadWriteLock();
	}
	
	/**
	 * ��ά�����������һ���µ�Runnable��
	 * @param runnable ָ����Runnable��
	 */
	public void invoke(T runnable){
		boolean flag = getQueueSize() == 0;
		offer(runnable);
		if(flag){
			threadLock.lock();
			try{
				threadCondition.signalAll();
			}finally{
				threadLock.unlock();
			}
		}
	}
	
	/**
	 * ��ȡ���еĳ��ȡ�
	 * @return ���еĳ��ȡ�
	 */
	public int getQueueSize(){
		queueLock.readLock().lock();
		try{
			return queue.size();
		}finally{
			queueLock.readLock().unlock();
		}
	}
	
	/**
	 * ��ȡ��ִ�еĶ��С�
	 * @return �ȴ�ִ�еĶ��С�
	 */
	public Queue<T> getWaitingQueue(){
		queueLock.readLock().lock();
		try{
			return new ArrayDeque<T>(this.queue);
		}finally{
			queueLock.readLock().unlock();
		}
	}
	
	/**
	 * ����е�ĩβ���ָ����Runnable��
	 * @param runnable ָ����Runnable��
	 */
	private void offer(T runnable){
		queueLock.writeLock().lock();
		try{
			queue.offer(runnable);
		}finally{
			queueLock.writeLock().unlock();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.threads.InnerThread#threadStartMethod()
	 */
	@Override
	protected void threadStartMethod(){}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.threads.InnerThread#threadRunMethod()
	 */
	@Override
	protected void threadRunMethod() {
		threadLock.lock();
		try{
			while(!hasMoreRunnable()){
				threadCondition.await();
			}
			Runnable runnable = peek();
			try{
				runnable.run();
			}catch(Exception e){
				e.printStackTrace();
			}
			poll();
		}catch(InterruptedException e){
			//do nothing
		}finally{
			threadLock.unlock();
		}
	}
	
	/**
	 * �������л���û�и����Runnable
	 * @return ��û�и����Runnable
	 */
	private boolean hasMoreRunnable(){
		queueLock.readLock().lock();
		try{
			return queue.size() > 0;
		}finally{
			queueLock.readLock().unlock();
		}
	}
	
	/**
	 * ��ȡ�����Ƴ�λ�ڶ�����λ��Runnable��
	 * @return ������λ��Runnable��
	 */
	private Runnable peek(){
		queueLock.readLock().lock();
		try{
			return queue.peek();
		}finally{
			queueLock.readLock().unlock();
		}
	}
	
	/**
	 * ��ȡ���Ƴ�λ�ڶ�����λ��Runnable��
	 * @return ������λ��Runnable��
	 */
	private Runnable poll(){
		queueLock.writeLock().lock();
		try{
			return queue.poll();
		}finally{
			queueLock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.threads.InnerThread#threadStopMethod()
	 */
	@Override
	protected void threadStopMethod() {}

}
