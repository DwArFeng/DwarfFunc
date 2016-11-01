package com.dwarfeng.dutil.basic.threads;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.str.Tag;

/**
 * ��ǩ��������
 * <p> �ù������ {@link Runnable} �� {@link Tag} ���з�װ��ʹ��һ�������ж���ӵ�����ƺ�������
 * @author DwArFeng
 * @since 1.8
 */
public class TagRunnable implements Runnable, Tag{
	
	/**�ڲ�Runnable*/
	protected final Runnable runnable;
	/**�ڲ�Tag*/
	protected final Tag tag;
	
	/**
	 * ����һ��Ĭ�ϵ���������
	 * @param runnable ָ����<code>Runnable</code>�������Բ���Ϊnull��
	 * @throws NullPointerException ��<code>runnable</code>����Ϊnullʱ�׳����쳣��
	 */
	public TagRunnable(Runnable runnable, Tag tag){
		Objects.requireNonNull(runnable, DwarfUtil.getStringField(StringFieldKey.TagRunner_0));
		Objects.requireNonNull(tag, DwarfUtil.getStringField(StringFieldKey.TagRunner_1));
		this.runnable = runnable;
		this.tag = tag;
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
		return tag.getDescription();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {
		return tag.getName();
	}

}
