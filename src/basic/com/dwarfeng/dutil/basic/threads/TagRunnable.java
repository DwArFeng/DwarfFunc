package com.dwarfeng.dutil.basic.threads;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.str.Tag;

/**
 * ��ǩ��������
 * <p> �ù������ {@link Runnable} �� {@link Tag} ���з�װ��ʹ��һ�������ж���ӵ�����ƺ�������
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class TagRunnable implements Runnable, Tag{
	
	/**�ڲ�Runnable*/
	protected final Runnable runnable;
	/**�ڲ�Tag*/
	protected final Tag tag;
	
	/**
	 * ����һ���µı�ǩ��������
	 * @param runnable ָ���Ŀ����ж���
	 * @param tag ָ���ı�ǩ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
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
