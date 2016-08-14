package com.dwarfeng.dwarffunction.str;

import com.dwarfeng.dwarffunction.cna.CycledBuffer;

/**
 * ����ѭ���ı����塣
 * <p> �û�����һ����С�̶������鹹�ɣ�����������У����Դ��һϵ�еĵ����ı�����������С�����ڹ��������������á�
 * �����������ı��������ﵽ���������������ʱ������洢���ı���ʼ���ǡ����ֻ��������Ա�ĳЩ��Ҫ������������ı���ȴ
 * ����ı�������һ�������ĵط�ʹ�ã��������̨��
 * <br>������з���{@linkplain CycledSlsBuffer#add(String)}�����Խ�һ���ı�׷�ӵ�����֮�У�����ֵ��ע����ǣ����ڸ�
 * �����ǵ����ı����壬��׷�ӵ�<code>String</code>������һ�������ַ�������˸÷�����������˴������׷�ӵ��Ƕ��е����ֵĻ�
 * ����������Ƚ�����ַ����Է��з��ָ�����ν��ָ�õĵ����ı����뻺�塣
 * <br>��û�����׷���ı�ʱ��������һ���ı��ǻ��з��Ļ����Ὣ����ı��Ļ��з�ȥ��֮������ӵ�����֮�У�������з�
 * �������м��λ�ã����ַ������Էָ
 * <br>���ı��������̲߳���ȫ��������Ҫ�̰߳�ȫ�ĳ�����ʹ���ⲿͬ����
 * @author DwArFeng
 * @since 1.8
 */
public class CycledSlsBuffer extends CycledBuffer<String>{
	
	/**����������С��ָ��ʱ��Ĭ�ϵĻ�������С*/
	private static final int DEFAULT_CAPACITY = 3000;
	
	/**
	 * ����һ�������СΪĬ��ֵ�ĵ����ı�ѭ�����塣
	 */
	public CycledSlsBuffer(){
		this(DEFAULT_CAPACITY);
	}
	/**
	 * ����һ����������Ϊָ��ֵ����������Ϊָ������ĵ����ı�ѭ�����塣
	 * @param capacity ָ���Ļ���������
	 * @throws IllegalArgumentException ��<code>capacity</code>��������ʱ�׳��쳣��
	 */
	public CycledSlsBuffer(int capacity){
		super(capacity,IteratorDirection.POSITIVE);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.cna.CycledBuffer#append(java.lang.Object)
	 */
	@Override
	public String add(String s){
		if(s.endsWith("\n")){
			s = s.substring(0, s.length()-1);
		}
		String[] strs = s.split("\\n");
		for(String str:strs){
			super.add(str);
		}
		return s;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(String str:this){
			sb.append(str + "\n");
		}
		return sb.toString();
	}
	
}
