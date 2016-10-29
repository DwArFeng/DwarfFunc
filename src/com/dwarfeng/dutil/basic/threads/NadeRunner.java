package com.dwarfeng.dutil.basic.threads;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.str.Description;
import com.dwarfeng.dutil.basic.str.Name;

/**
 * ������������������
 * <p> �ù������һ��<code>Runnable</code>�����ṩ��װ��������������ֺ������ķ�����
 * @author DwArFeng
 * @since 1.8
 */
public class NadeRunner implements Runnable,Name,Description{
	
	private final Runnable runnable;
	private final String name;
	private final String describe;
	
	/**
	 * ����һ��Ĭ�ϵ���������
	 * @param runnable ָ����<code>Runnable</code>�������Բ���Ϊnull��
	 * @throws NullPointerException ��<code>runnable</code>����Ϊnullʱ�׳����쳣��
	 */
	public NadeRunner(Runnable runnable){
		this(runnable,"","");
	}
	
	/**
	 * ����һ������ָ�����Ƶ���������
	 * @param runnable ָ����<code>Runnable</code>�������Բ���Ϊnull��
	 * @param name ָ�������ơ�
	 * @throws NullPointerException ��<code>runnable</code>����Ϊnullʱ�׳����쳣��
	 */
	 public NadeRunner(Runnable runnable,String name){
		 this(runnable,name,"");
	 }
	 
	/**
	 * ����һ������ָ�����ƣ�ָ����������������
	 * @param runnable ָ����<code>Runnable</code>�������Բ���Ϊnull��
	 * @param name ָ�������ơ�
	 * @param describe ָ��������
	 * @throws NullPointerException ��<code>runnable</code>����Ϊnullʱ�׳����쳣��
	 */
	public NadeRunner(Runnable runnable,String name,String describe) {
		if(runnable == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.NadeRuner_0));
		this.runnable = runnable;
		this.name = name;
		this.describe = describe;
	}
	
	/*
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		runnable.run();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Describeable#getDescribe()
	 */
	@Override
	public String getDescription() {
		return this.name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {
		return this.describe;
	}

}
