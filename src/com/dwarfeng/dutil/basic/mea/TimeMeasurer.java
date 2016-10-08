package com.dwarfeng.dutil.basic.mea;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.num.UnitTrans;
import com.dwarfeng.dutil.basic.num.UnitTrans.Time;

/**
 * ��ʱ����
 * <p> �ü�ʱ����������ʵ�е����������������һ�����޵�ʱ�䡣
 * <br> �ü�ʱ��ӵ�� {@link #start()} �� {@link #stop()}�����������������Ƽ�ʱ����ʼ��ʱ�ͽ�����ʱ���ڲ�ͬ��ʱ�����
 * ���������������ܼ�¼����������������ʱ��֮��Ӷ���¼���ʱ�䡣
 * <br> ��ʱ���ĵ�λ�����룬�ڲ�ͬƽ̨�ϣ����ȿ��ܻ���΢��Щ������ֻ�ܵ������Եļ�ʱ����ʹ�ã����ң��ü�ʱ��
 * ���ܵ�ϵͳʱ��ĸı���ɵ�Ӱ�졣
 * <br> ���ڳ����α����Ĵ洢���ƣ��ü�ʱ��ֻ���ṩ��Լ292��ļ�ʱ���ȡ�
 * <p> �ü�ʱ���̰߳�ȫ������ͨ���κ�һ���߳����������ұ��κ�һ���߳���ֹ������������Σ�������ʱ��ֻ������һ�β���
 * �����ֻ��ֹͣһ�Ρ���Ҳ����˵�����ʱ����һ���Եģ�һ�μ�ʱ֮����Ҫ�µ�ʵ��������һ�μ�ʱ��
 * @author DwArFeng
 * @since 1.8
 */
public final class TimeMeasurer {
	
	/**
	 * ��ʱ����״̬��
	 * @author DwArFeng
	 * @since 1.8
	 */
	protected enum Status{
		/**û������*/
		NOTSTART,
		/**���ڼ�ʱ*/
		TIMING,
		/**��ʱ����*/
		TIMED
	}

	/**��ʱ����״̬*/
	protected Status status = Status.NOTSTART;
	/**ʱ��ͳ��(����)*/
	private long l;
	/**ͬ����*/
	protected final Lock lock = new ReentrantLock();
	
	/**
	 * ����һ�������ʱ����
	 */
	public TimeMeasurer() {}
	
	/**
	 * ��ȡ�ü�ʱ���ļ�ʱ״̬��
	 * @return �ü�ʱ���ļ�ʱ״̬��
	 */
	protected Status getStatus(){
		return this.status;
	}
	
	/**
	 * ��ȡ��ʱ���Ƿ��Ѿ������ˡ�
	 * @return ��ʱ���Ƿ��Ѿ�������
	 */
	public boolean isStarted(){
		if(status == Status.NOTSTART) return false;
		return true;
	}
	
	/**
	 * ��ʼ��ʱ��
	 */
	public void start(){
		lock.lock();
		try{
			l =  - System.nanoTime();
		}finally{
			this.status = Status.TIMING;
			lock.unlock();
		}
	}
	
	/**
	 * ֹͣ��ʱ��
	 */
	public void stop(){
		lock.lock();
		try{
			if(status == Status.TIMED){
				l = 0;
			}else{
				l += System.nanoTime();
			}
		}finally{
			this.status = Status.TIMED;
			lock.unlock();
		}
	}
	
	/**
	 * ����ʱ����Ϣ�����ϵͳ��Err���С�
	 */
	public void print(){
		switch (status) {
			case TIMING:
				System.err.println(DwarfUtil.getStringField(StringFieldKey.CodeTimer_0));
				break;
			default:
				System.err.printf(
						DwarfUtil.getStringField(StringFieldKey.CodeTimer_1),
						UnitTrans.trans(l, Time.NS, Time.MS).doubleValue()
				);
				break;
		}
	}
	
	/**
	 * ��ȡ�ô����ʱ����ʱ�䣬������Ϊ��λ��
	 * @return �ô����ʱ����ʱ�䡣
	 */
	public long getTime(){
		switch (status) {
			case TIMING:
				return 0;
			default:
				return l;
		}
	}
	
	/**
	 * ��ȡ�ô����ʱ����ʱ�䣬��ָ����ʱ��Ϊ��λ��
	 * @param type ʱ�䵥λ��
	 * @return �����ʱ����ʱ�䡣
	 */
	public double getTime(Time type){
		switch (status) {
			case TIMING:
				return 0;
			default:
				return UnitTrans.trans(l, Time.NS, type).doubleValue();
		}
	}
	
	/**
	 * ֹͣ��ʱ���ҰѼ�ʱ��Ϣ�����
	 */
	public void stopAndPrint(){
		stop();
		print();
	}
	
}
