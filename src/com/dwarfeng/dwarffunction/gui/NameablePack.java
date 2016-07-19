package com.dwarfeng.dwarffunction.gui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.dwarfeng.dwarffunction.comp.NameableComparator;
import com.dwarfeng.dwarffunction.interfaces.Nameable;


/**
 *�����ƻ�����
 * ���������д��һ��Nameable���󣬲�����д��<code> toString() </code> ������
 * ʹ����Է���ķ�����JList�ȿؼ��У����ҿ����ڿؼ��ı�ǩ����ʾ<code> getName()</code>�������õ��ı���
 * @see Nameable
 * @author DwArFeng
 * @since 1.7
 */
public class NameablePack{

	/**
	 * ��ָ���Ŀ����ƻ��������޳�ֵΪnull�Ŀ����ƻ����󣬲���ʣ�µĿ����ƻ���������������󣬷�װ�ڶ��������С�
	 * @param nameables ָ���Ŀ����ƻ�����
	 * @return ��װ��Ŀ����ƻ��������顣
	 */
	public static NameablePack[] toPackArray(Nameable[] nameables){
		if(nameables == null) return new NameablePack[0];
		Set<Nameable> set = new HashSet<Nameable>();
		for(Nameable na:nameables){
			if(na != null){
				set.add(na);
			}
		}
		Nameable[] objects = set.toArray(new Nameable[0]);
		Arrays.sort(objects, new NameableComparator());
		NameablePack[] get = new NameablePack[objects.length];
		for(int i = 0 ; i < get.length ; i++){
			get[i] = new NameablePack(objects[i]);
		}
		return get;
	}
	private Nameable nameable;
	
	/**
	 * ����һ������ָ�������ƻ�ʵ���İ���
	 * @param nameable ָ���Ŀ����ƻ�ʵ����
	 * @throws NullPointerException ��ڲ���Ϊnullʱ�׳��쳣��
	 */
	public NameablePack(Nameable nameable){
		if(nameable == null) throw new NullPointerException("�����������Ϊnull");
		this.nameable = nameable;
	}
	
	/**
	 * ���ظ�ʵ���еĿ����ƻ�����
	 * @return ��ʵ���еĿ����ƻ�����
	 */
	public Nameable getNameable(){return this.nameable;}
	
	/**
	 * �жϸÿ����ƻ�����Ŀ������Ƿ���ȡ�
	 * <p>���ҽ���Ŀ������ǿ����ƻ��������࣬�������еĿ����ƻ��������ʵ���еĿ����ƻ��������ʱ�����档
	 * @return �ÿ����ƻ�����Ŀ������Ƿ���ȡ�
	 */
	@Override
	public boolean equals(Object object){
		if(object == this) return true;
		if(object == null) return false;
		if(!(object instanceof NameablePack)) return false;
		NameablePack nameablePack = (NameablePack) object;
		return nameablePack.getNameable().equals(this.getNameable());
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		return this.getNameable().hashCode() * 17;
	}
	
	/**
	 * ��д���������ظÿ����ƻ��������ơ�<p>
	 * ���ʵ���Ŀ����ƻ�����Ϊ<code>null</code>���򷵻ؿ��ı������򷵻�<code>getNameable().getName()</code>
	 * @return �ò�������ơ�
	 */
	@Override
	public String toString(){
		return nameable.getName();
	}

}
