package com.dwarfeng.dwarffunction.str;

import java.util.Iterator;

/**
 * ����ѭ���ı����塣
 * <p> �û�����һ����С�̶������鹹�ɣ�����������У����Դ��һϵ�еĵ����ı�����������С�����ڹ��������������á�
 * �����������ı��������ﵽ���������������ʱ������洢���ı���ʼ���ǡ����ֻ��������Ա�ĳЩ��Ҫ������������ı���ȴ
 * ����ı�������һ�������ĵط�ʹ�ã��������̨��
 * <br>���ı��������̲߳���ȫ��������Ҫ�̰߳�ȫ�ĳ�����ʹ���ⲿͬ����
 * @author DwArFeng
 * @since 1.8
 */
public class CycledSingleLineStringBuffer implements Iterable<String>{
	
	/**����������С��ָ��ʱ��Ĭ�ϵĻ�������С*/
	private static final int DEFAULT_CAPACITY = 1023;
	
	private final int capacity;
	
	/**��������ǰ���*/
	private int ind0;
	/**�������ĺ����*/
	private int ind1;

	/**
	 * ����һ��Ĭ�ϵĵ���ѭ���ı����塣
	 * <br> �������Ĵ�СΪĬ��ֵ��
	 */
	public CycledSingleLineStringBuffer() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * ����һ��Ĭ�ϵĵ��л����ı����塣
	 * @param capacity
	 */
	public CycledSingleLineStringBuffer(int capacity){
		this.capacity = capacity;
	}

	
	
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
