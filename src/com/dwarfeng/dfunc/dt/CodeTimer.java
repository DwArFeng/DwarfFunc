package com.dwarfeng.dfunc.dt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

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
				System.err.println(
						DwarfFunction.getStringField(StringFiledKey.CodeTimer_1) + ((long)l/1000000) + 
						DwarfFunction.getStringField(StringFiledKey.CodeTimer_2)
				);
				break;
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
