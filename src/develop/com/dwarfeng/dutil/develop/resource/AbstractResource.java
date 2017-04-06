package com.dwarfeng.dutil.develop.resource;

/**
 * ������Դ��
 * <p> ��Դ�ӿڵĳ���ʵ�֡�
 * @author DwArFeng
 * @since 0.1.1-beta
 */
public abstract class AbstractResource implements Resource{

	private final String key;
	
	
	/**
	 * ����һ������ָ����ֵ�ĳ�����Դ��
	 * @param key ָ���ļ�ֵ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractResource(String key) {
		//TODO �ж���ڲ�������Ϊ null��
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.prog.WithKey#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}

}
