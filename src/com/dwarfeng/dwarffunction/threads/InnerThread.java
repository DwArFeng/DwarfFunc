package com.dwarfeng.dwarffunction.threads;

import com.dwarfeng.dwarffunction.interfaces.Nameable;

/**
 * �ڲ��߳��ࡣ
 * <p>���������̶��Ϸ�װ�������ڲ������̵߳Ķ���
 * <br>�����ж�����һ���ڲ��̣߳����ҿ��Զ����̵߳������еķ�����
 * <br>�����п��Զ����е��ڲ��̶߳�������������ѭ�����������������������Է����̵߳�״̬���Լ������̱߳���
 * <br>������й��̵߳Ĳ���������Ϊ�̲߳���ȫ�����б�Ҫ����Ҫ���ⲿ����ͬ��������д��
 * @author DwArFeng
 * @since 1.8
 */
public abstract class InnerThread implements Nameable {
	
	private Thread t;
	private boolean runFlag;
	private boolean isDaemon;
	private String name;
	
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
	public void runThread(){
		if(isAlive()) return;
		t = createThread();
		runFlag = true;
		t.start();
	}
	/**
	 * ֹͣ�̡߳�
	 * <p>�÷����ᾡ���Ľ�����ǰ���̣߳�������߳��ڵ�ʱ����˯��״̬����÷�����
	 * ���Ի��Ѹ��̣߳����ҽ�������б�־��Ϊ<code>false</code>�����̻߳���ִ�����
	 * һ��ѭ����ֹͣ��
	 * <br>����ڴ�֮ǰ���̻߳�δ��������÷�����Ч��
	 */
	public void stopThread(){
		this.runFlag = false;
		if(t != null) t.interrupt();
	}
	/**
	 * ֹͣ�̲߳�������
	 * <p>�÷����᳢�Խ�����ǰ�̣߳������ڸ��߳�ֹ֮ͣǰ��һֱ�����÷�����
	 * <br>�����ֹ֮ͣǰ���̻߳�δ��������÷�����Ч��
	 */
	public void stopThreadAndBlock(){
		this.stopThread();
		while(isAlive());
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Nameable#getName()
	 */
	@Override
	public String getName(){return this.name;}
	
	/**
	 * �̵߳�����������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>runThread()</code>����֮�����Ƚ��е��á���
	 * �̵߳��������������ڣ��÷�����������һ�Ρ�
	 */
	protected abstract void threadStartMethod();
	/**
	 * �̵߳�ѭ��������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>runThread()</code>����֮����ִ����
	 * <code>threadStartMethod()</code>����֮��ѭ�����á�
	 * <br>�����ڲ��߳���ִ��<code>stopThread()</code>����֮�󣬻��ڽ����굱ǰ��ѭ���ŷ��������
	 * ��ʱ�ķ���û��ִ�����ʱ��ֹͣѭ�����������ִ��<code>threadStopMethod()</code>������
	 */
	protected abstract void threadRunMethod();
	/**
	 * �̵߳�ֹͣ������
	 * <p>�÷������ڸ��ڲ��߳���ִ��<code>stopThread()</code>����֮���ڸ��ڲ��߳�ִ����
	 * ֮����Ϊ���һ����ִ�еķ���ִ�С��ó�����������������������ڽ�����ִ��һ�Ρ�
	 */
	protected abstract void threadStopMethod();
	
	private Thread createThread(){
		t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadStartMethod();
				while(runFlag){
					threadRunMethod();
				}
				threadStopMethod();
			}
		});
		if(getName() != null && getName() != "") t.setName(getName());
		t.setDaemon(isDaemon);
		return t;
	}
	
}
