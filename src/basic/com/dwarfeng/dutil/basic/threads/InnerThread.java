package com.dwarfeng.dutil.basic.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dutil.basic.str.Name;

/**
 * �ڲ��߳��ࡣ
 * <p>���������̶��Ϸ�װ�������ڲ������̵߳Ķ���
 * <br>�����ж�����һ���ڲ��̣߳����ҿ��Զ����̵߳������еķ�����
 * <br>�����п��Զ����е��ڲ��̶߳�������������ѭ�����������������������Է����̵߳�״̬���Լ������̱߳���
 * <br>������й��̵߳Ĳ���������Ϊ�̲߳���ȫ�����б�Ҫ����Ҫ���ⲿ����ͬ��������д��
 * @deprecated  <code>java.util.concurrent</code> ����ӵ��Զ�ȴ����ƵĹ����࣬�ù��������Ժ�İ汾�в��ٿ��������Ҳ�Ӧ�ü���ʹ�øù����ࡣ
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public abstract class InnerThread implements Name {
	
	protected Thread t;
	protected boolean runFlag;
	protected boolean isDaemon;
	protected final String name;
	protected final Lock lock;
	protected final Condition condition;
	private boolean runCheck;
	
	/**
	 * ����һ��Ĭ�ϵ��ڲ��߳��ࡣ���ڲ��̲߳����ػ��̣߳����߳���Ϊ�ա�
	 */
	public InnerThread(){
		this(null,false);
	}
	/**
	 * ����һ���ڲ��߳��࣬���ڲ��߳��Ƿ�Ϊ�ػ��߳��ɹ�����ָ����
	 * @param isDaemon ���ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 */
	public InnerThread(boolean isDaemon){
		this(null,isDaemon);
	}
	public InnerThread(String name){
		this(name,false);
	}
	/**
	 * ����һ������ָ�����Ƶ��ڲ��̣߳����߳��Ƿ�Ϊ�ػ��߳��й�����ָ����
	 * @param isDaemon �ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 * @param name ���ڲ��̵߳����֡�
	 */
	public InnerThread(String name,boolean isDaemon){
		this.runFlag = false;
		this.isDaemon = isDaemon;
		this.name = name;
		this.lock = new ReentrantLock();
		this.condition = lock.newCondition();
		this.runCheck = true;
	}
	
	/**
	 * ���ظ��ڲ��߳�����ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 * @return ���ڲ��߳�����ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 */
	public boolean isDaemon(){return this.isDaemon;}
	/**
	 * ָ�����ڲ��߳�����ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 * <p>������ڲ��߳��Ѿ������������߳��ڹرպ����һ�ο����Ż�����Ϊ�����á�
	 * @param isDaemon ���ڲ��߳�����ڲ��߳��Ƿ�Ϊ�ػ��̡߳�
	 */
	public void setDaemon(boolean isDaemon){this.isDaemon = isDaemon;}
	/**
	 * ���ظ��ڲ��߳�����߳��Ƿ�Ϊ��ġ�
	 * @return ���ڲ��߳�����߳��Ƿ�Ϊ��ġ�
	 */
	public boolean isAlive(){
		if(t == null) return false;
		return t.isAlive();
	}
	/**
	 * �����̡߳�
	 * <p>����ڴ�֮ǰ���ڲ��߳��Ѿ�������������δֹͣ����÷�����Ч��
	 * <p>�÷����ᶪ���ɵ��̣߳�ָ���µ��̡߳�
	 */
	public void start(){
		if(isAlive()) return;
		t = createThread();
		runFlag = true;
		runCheck = true;
		t.start();
	}
	/**
	 * ֹͣ�̡߳�
	 * <p>�÷����ᾡ���Ľ�����ǰ���̣߳�������߳��ڵ�ʱ����˯��״̬����÷�����
	 * ���Ի��Ѹ��̣߳����ҽ�������б�־��Ϊ<code>false</code>�����̻߳���ִ�����
	 * һ��ѭ����ֹͣ��
	 * <br>����ڴ�֮ǰ���̻߳�δ��������÷�����Ч��
	 * <br>һ����Ҫ�ڸ����е��ڲ��̵߳��ô˷���������Ҫ����д��
	 * {@link InnerThread#threadStartMethod()}��{@link InnerThread#threadRunMethod()}��{@link InnerThread#threadStopMethod()}
	 * �е��ô˷�����������ܻ�����������
	 */
	public void stop(){
		this.runFlag = false;
		if(t != null) t.interrupt();
	}
	
	/**
	 * ֹͣ�̲߳�������
	 * <p>�÷����᳢�Խ�����ǰ�̣߳������ڸ��̵߳� {@link InnerThread#threadStopMethod()} ֹ֮ͣǰ��һֱ�����÷�����
	 * <br>�����ֹ֮ͣǰ���̻߳�δ��������÷�����Ч��
	 * <br>һ����Ҫ�ڸ����е��ڲ��̵߳��ô˷���������Ҫ����д��
	 * {@link InnerThread#threadStartMethod()}��{@link InnerThread#threadRunMethod()}��{@link InnerThread#threadStopMethod()}
	 * �е��ô˷�����������ܻ�����������
	 */
	public void stopAndBlock(){
		this.stop();
		lock.lock();
		try{
			while(runCheck){
				try {
					condition.await();
				} catch (InterruptedException e) {
					//DO NOTHING
				}
			}
		}finally{
			lock.unlock();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Nameable#getName()
	 */
	@Override
	public String getName(){return this.name;}
	
	/**
	 * �̵߳�����������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>start()</code>����֮�����Ƚ��е��á���
	 * �̵߳��������������ڣ��÷�����������һ�Ρ�
	 */
	protected abstract void threadStartMethod();
	/**
	 * �̵߳�ѭ��������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>start()</code>����֮����ִ����
	 * {@link InnerThread#threadStartMethod()}����֮��ѭ�����á�
	 * <br>�����ڲ��߳���ִ��<code>stop()</code>����֮�󣬻��ڽ����굱ǰ��ѭ���ŷ��������
	 * ��ʱ�ķ���û��ִ�����ʱ��ֹͣѭ�����������ִ�� {@link InnerThread#threadStopMethod()}������
	 */
	protected abstract void threadRunMethod();
	/**
	 * �̵߳�ֹͣ������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>stop()</code>����֮���ڸ��ڲ��߳�ִ����
	 * ֮����Ϊ���һ����ִ�еķ���ִ�С��ó�����������������������ڽ�����ִ��һ�Ρ�
	 */
	protected abstract void threadStopMethod();
	
	
	/*
	 * ����һ���µ��̡߳�
	 */
	private Thread createThread(){
		t = new Thread(new Runnable() {
			
			/*
			 * (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				try{
					//�����߳�
					threadStartMethod();
					while(runFlag){
						//ѭ��ִ��
						threadRunMethod();
					}
					//ֹͣ
					threadStopMethod();
				}finally{
					runCheck = false;
					//��������stopAndBlock()�����������̣߳�������ڣ���
					lock.lock();
					try{
						condition.signalAll();
					}finally{
						lock.unlock();
					}
				}
			}
		});
		if(getName() != null && getName() != "") t.setName(getName());
		t.setDaemon(isDaemon);
		return t;
	}
	
}
