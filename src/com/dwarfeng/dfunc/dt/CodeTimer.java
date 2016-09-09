package com.dwarfeng.dfunc.dt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dfunc.num.UnitTrans;
import com.dwarfeng.dfunc.num.UnitTrans.Time;

/**
 * �����ʱ����
 * <p> �����ʱ�������������ͼ�¼һ�δ��������ʱ��ġ�
 * <p> �����ʱ���еķ����̰߳�ȫ�����Բ����ĵ�����Щ����������������û�����塣
 * <p> �ô����ʱ�����ɱ��̳У���Ϊ������Ϊ�˼̳ж�����Ƶġ�
 * @author DwArFeng
 * @since 1.8
 */
public final class CodeTimer {
	
	/**
	 * ��ʱ����״̬��
	 * @author DwArFeng
	 * @since 1.8
	 */
	private enum TimerStatus{
		/**���ڼ�ʱ*/
		TIMING,
		/**��ʱ����*/
		TIMED
	}

	private TimerStatus status = TimerStatus.TIMED;;
	private long l;
	private final Lock lock = new ReentrantLock();
	
	/**
	 * ����һ�������ʱ����
	 */
	public CodeTimer() {}
	
	/**
	 * ��ʼ��ʱ��
	 */
	public void start(){
		lock.lock();
		try{
			l =  - System.nanoTime();
		}finally{
			this.status = TimerStatus.TIMING;
			lock.unlock();
		}
	}
	
	/**
	 * ֹͣ��ʱ��
	 */
	public void stop(){
		lock.lock();
		try{
			if(status == TimerStatus.TIMED){
				l = 0;
			}else{
				l += System.nanoTime();
			}
		}finally{
			this.status = TimerStatus.TIMED;
			lock.unlock();
		}
	}
	
	/**
	 * ����ʱ����Ϣ�����ϵͳ��Err���С�
	 */
	public void print(){
		switch (status) {
			case TIMING:
				System.err.println(DwarfFunction.getStringField(StringFiledKey.CodeTimer_0));
				break;
			default:
				System.err.printf(
						DwarfFunction.getStringField(StringFiledKey.CodeTimer_1),
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
