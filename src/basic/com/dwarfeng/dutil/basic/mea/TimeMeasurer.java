package com.dwarfeng.dutil.basic.mea;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.num.NumberUtil;
import com.dwarfeng.dutil.basic.num.NumberValue;
import com.dwarfeng.dutil.basic.num.unit.Time;

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
		STOPED
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
	 * ��ȡ��ʱ���Ƿ�δ������
	 * @return ��ʱ���Ƿ�δ������
	 */
	public boolean isNotStart(){
		return status == Status.NOTSTART;
	}
	
	/**
	 * ��ȡ��ʱ���Ƿ����ڼ�ʱ��
	 * @return ��ʱ���Ƿ����ڼ�ʱ��
	 */
	public boolean isTiming(){
		return status == Status.TIMING;
	}
	
	/**
	 * ��ȡ��ʱ���Ƿ��Ѿ�ֹͣ��ʱ��
	 * @return ��ʱ���Ƿ��Ѿ�ֹͣ��ʱ��
	 */
	public boolean isStoped(){
		return status == Status.STOPED;
	}
	
	/**
	 * ��ʼ��ʱ��
	 * @throws IllegalStateException ��ʱ���Ѿ���ʼ��ʱ�����Ѿ���ʱ������
	 */
	public void start(){
		lock.lock();
		try{
			if(!isNotStart()){
				throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_0));
			}
			l =  - System.nanoTime();
			this.status = Status.TIMING;
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 * ֹͣ��ʱ��
	 * @throws IllegalStateException ��ʱ����δ��ʼ��ʱ�����Ѿ���ʱ������
	 */
	public void stop(){
		lock.lock();
		try{
			if(!isTiming()){
				throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_1));
			}
			l += System.nanoTime();
			this.status = Status.STOPED;
		}finally{
			lock.unlock();
		}
	}
	
	/**
	 * ��ȡ�ü�ʱ����ʱ�䣬������Ϊ��λ��
	 * @return �ô����ʱ����ʱ�䡣
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public long getTimeNs(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return l;
	}
	
	/**
	 * ��ȡ�ü�ʱ����ʱ�䣬�Ժ���Ϊ��λ������Ԫ��Ϊ������
	 * @return �ô����ʱ����ʱ�䡣
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public long getTimeMs(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return l/1000000;
	}
	
	/**
	 * ��ȡ�ü�ʱ����ʱ�䣬����Ϊ��λ������Ԫ��Ϊ������
	 * @return �ô����ʱ����ʱ�䡣
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public long getTimeSec(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return l/1000000000;
	}
	
	/**
	 * ��ȡ�ü�ʱ����ʱ�䣬��ָ���ĵ�ЧȨ��Ϊ��Ϊ��λ������˫���ȸ���ֵ��
	 * <p> ��ЧȨ�ص�ȡֵ����Ϊ�� <code> 86400000000000 / x ������ x Ϊ1ָ���ĵ�λ��Ӧ�ĺ������� </code>
	 * <br> �й���ʱ�䵥λ������� {@link Time}�����а����˴󲿷ֳ��õ�ʱ�䵥λ��
	 * @param valueable ָ���ĵ�λ�ĵ�ЧȨ�ء�
	 * @return �ô����ʱ����ʱ�䡣
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public double getTime(NumberValue valueable){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return NumberUtil.unitTrans(l, Time.NS, valueable).doubleValue();
	}
	
	/**
	 * ���ؼ�ʱ��Ԥ��ļ�ʱ�ĸ�ʽ���ַ�������λΪ���롣
	 * @return Ԥ��ĸ�ʽ���ַ�����
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public String formatStringNs(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return String.format(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_3), getTimeNs());
	}
	
	/**
	 * ���ؼ�ʱ��Ԥ��ļ�ʱ�ĸ�ʽ���ַ�������λΪ���롣
	 * @return Ԥ��ĸ�ʽ���ַ�����
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public String formatStringMs(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return String.format(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_4), getTimeMs());
	}
	
	/**
	 * ���ؼ�ʱ��Ԥ��ļ�ʱ�ĸ�ʽ���ַ�������λΪ�롣
	 * @return Ԥ��ĸ�ʽ���ַ�����
	 * @throws IllegalStateException ��ʱ����δ��ʱ������
	 */
	public String formatStringSec(){
		if(! isStoped()){
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_2));
		}
		return String.format(DwarfUtil.getStringField(StringFieldKey.TimeMeasurer_5), getTimeSec());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append("TimeMeasure [status = ")
				.append(status.toString())
				.append(", l = ")
				.append(l)
				.append("]")
				.toString();
	}
	
}
