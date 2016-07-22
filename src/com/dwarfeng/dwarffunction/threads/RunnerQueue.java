package com.dwarfeng.dwarffunction.threads;

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
public class RunnerQueue extends InnerThread {

	/**�̵߳�����*/
	private final static String THREAD_NAME = "RunnerQueue";
	
	/**Runnable ����*/
	private static Queue<Runnable> queue;
	/**�߳�ͬ����*/
	private static Lock threadLock;
	/**�߳�״̬*/
	private static Condition threadCondition;
	/**���ж�д��*/
	private static ReadWriteLock queueLock;
	
	/**
	 * ����һ���µ����ж��С�
	 */
	public RunnerQueue(){
		super(THREAD_NAME);
		queue = new ArrayDeque<Runnable>();
		threadLock = new ReentrantLock();
		threadCondition = threadLock.newCondition();
		queueLock = new ReentrantReadWriteLock();
	}
	
	/**
	 * ��ά�����������һ���µ�Runnable��
	 * @param runnable ָ����Runnable��
	 */
	public void invoke(Runnable runnable){
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
	 * ����е�ĩβ���ָ����Runnable��
	 * @param runnable ָ����Runnable��
	 */
	private void offer(Runnable runnable){
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
