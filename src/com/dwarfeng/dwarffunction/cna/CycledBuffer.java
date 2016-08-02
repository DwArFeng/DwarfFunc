package com.dwarfeng.dwarffunction.cna;

import java.util.Iterator;
import java.util.Scanner;

import com.dwarfeng.dwarffunction.DwarfFunction;
import com.dwarfeng.dwarffunction.DwarfFunction.StringFiledKey;
import com.dwarfeng.dwarffunction.io.CT;
import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

/**
 * ѭ�����塣
 * <p> �û�����Լ�¼һ�������ĵ����ݣ������������û�ָ��������Ĵ�С�ɹ���������ָ����
 * <br> ����������¼���������뻺�����Ĵ�Сһ��ʱ���ټ�¼�µ�����ʱ����ɵ����ݽ��ᱻ���������Ǹû���������Ϊѭ�������ԭ��
 * <p> �û������̲߳���ȫ�����Ҫ�����̰߳�ȫ�ĳ��ϣ���ʹ���ⲿͬ�������ң�����̳е�{@linkplain Iterable}�ӿں�
 * <code>Collection Framework</code>һ���������ڵ�����ͬʱ���������屾��ʱ������ʧ�ܣ�ȴ�޷���<code>Collection Framework</code>����
 * ����ʧ�ܣ���ˣ�������ڴ����дʱ��֤��ʹ�õ��������ڼ��ڣ���Ҫ�Ի�������������޸ġ�
 * @author DwArFeng
 * @since 1.8
 */
public class CycledBuffer<T> implements Iterable<T> {

	/**����������С��ָ��ʱ��Ĭ�ϵĻ�������С*/
	private static final int DEFAULT_CAPACITY = 1024;
	
	private final Object[] objs;
	
	/**��ɵ�Ԫ�����ڵ�����*/
	private int index = 0;
	/**��ЧԪ�ظ����ļ�¼*/
	private int count = 0;
	
	/**
	 * ѭ�������������ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum IteratorDirection{
		/**�����ɾɵ��£�����*/
		POSITIVE,
		/**�������µ��ͣ�����*/
		NEGATIVE 
	}
	private IteratorDirection direction = IteratorDirection.POSITIVE;
	
	/**
	 * �ڲ�Iterator�࣬��������������塣
	 * @author DwArFeng
	 * @since 1.8
	 */
	private final class Pite implements Iterator<T>{

		/**��ɵ�Ԫ�����ڵ�����*/
		private int index;
		/**Ԫ�صĸ���*/
		private int count;
		
		/**
		 * ����һ��ָ����Iterator�ࡣ
		 * @param index ���Ԫ�����ڵ�������
		 * @param count ��ЧԪ�ظ����ļ�¼��
		 */
		public Pite(int index,int count) {
			this.index = index;
			this.count = count;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			count --;
			//��������objsֻ�ܴ��T���͵�Ԫ�أ���˴˴�ת�����Ͱ�ȫ��
			@SuppressWarnings("unchecked")
			T t = (T) objs[index];
			index = pRoll(index);
			return t;
		}
		
	}
	
	/**
	 * �ڲ�Iterator�࣬��������������塣
	 * @author DwArFeng
	 * @since 1.8
	 */
	private final class Nite implements Iterator<T>{
		
		/**���µ�Ԫ�����ڵ�����*/
		private int index;
		/**Ԫ�صĸ���*/
		private int count;

		/**
		 * ����һ��ָ����Iterator�ࡣ
		 * @param index ����Ԫ�����ڵ�������
		 * @param count ��ЧԪ�ظ����ļ�¼��
		 */
		public Nite(int index, int count) {
			this.index = index;
			this.count = count;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			count --;
			//��������objsֻ�ܴ��T���͵�Ԫ�أ���˴˴�ת�����Ͱ�ȫ��
			@SuppressWarnings("unchecked")
			T t = (T) objs[index];
			index = nRoll(index);
			return t;
		}
		
	}
	/**
	 * ����һ�������СΪĬ��ֵ��ѭ�����塣
	 */
	public CycledBuffer() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * ����һ����СΪָ��ֵ��ѭ�����塣
	 * @param capacity ָ���Ĵ�С��
	 * @throws IllegalArgumentException ��<code>capacity</code>��������ʱ�׳��쳣��
	 */
	public CycledBuffer(int capacity){
		this(capacity,IteratorDirection.POSITIVE);
	}
	
	/**
	 * ����һ����СΪָ��ֵ����������Ϊָ�������ѭ�����塣
	 * @param capacity ָ���Ĵ�С��
	 * @param direction ָ���ı�������
	 * @throws IllegalArgumentException ��<code>capacity</code>��������ʱ�׳��쳣��
	 */
	public CycledBuffer(int capacity, IteratorDirection direction){
		if(capacity <= 0) throw new IllegalArgumentException(DwarfFunction.getStringField(StringFiledKey.CycledBuffer_0));
		this.objs = new Object[capacity];
		this.direction = direction;
	}
	
	/**
	 * ��ȡ��ѭ�������������
	 * @return ��ѭ�������������
	 */
	public int getCapacity(){
		return objs.length - 1;
	}
	
	/**
	 * ���ظ�ѭ������ı�������
	 * @return ѭ������ı�������
	 */
	public IteratorDirection getDirection() {
		return direction;
	}

	/**
	 * ���ø�ѭ������ı�������
	 * @param direction ָ���ı�������
	 */
	public void setDirection(IteratorDirection direction) {
		this.direction = direction;
	}

	/**
	 * �ڻ�����������λ������һ��Ԫ�أ���������Ϊ���ǵ���ĳ����Ԫ�أ��������Ԫ�ط��ء�
	 * @param t ָ����Ԫ�ء�
	 * @return ���صľ�Ԫ�أ����û�У��򷵻�<code>null</code>��
	 */
	public T append(T t){
		int i = pRolls(index, count);
		//��������objsֻ�ܴ��T���͵�Ԫ�أ���˴˴�ת�����Ͱ�ȫ��
		@SuppressWarnings("unchecked")
		T temp = (T) objs[i];
		objs[i] = t;
		if(count == objs.length){
			index = pRoll(index);
		}else{
			count += 1;
		}
		return temp;
	}
	
	/**
	 * ��ָ�����������������
	 * @param i ָ����������
	 * @return ��������������ص�ֵ��
	 */
	private int pRoll(int i){
		if(++i >= objs.length){
			i = 0;
		}
		return i;
	}
	
	/**
	 * ��ָ���������������
	 * @param i ָ����������
	 * @return ��������������ص�ֵ��
	 */
	private int nRoll(int i){
		if(--i < 0){
			i = objs.length - 1;
		}
		return i;
	}
	
	/**
	 * ��ָ���������������һ���ľ��롣
	 * @param i ָ����������
	 * @param val ָ���ľ��롣
	 * @return ��������������ص�ֵ��
	 */
	private int pRolls(int i, int val){
		i += val;
		while(i >= objs.length){
			i -= objs.length;
		}
		return i;
	}
	
	/**
	 * ��ָ���������������һ���ľ��롣
	 * @param i ָ����������
	 * @param val ָ���ľ��롣
	 * @return ��������������ص�ֵ��
	 */
	public int nRolls(int i, int val){
		i -= val;
		while(i < 0){
			i += objs.length;
		}
		return i;
	}
	
	public static void main(String[] args){
		CycledBuffer<String> cb = new CycledBuffer<String>(5,IteratorDirection.NEGATIVE);
		Scanner sc = new Scanner(System.in);
		while(true){
			cb.append(sc.nextLine());
			StringBuilder sb = new StringBuilder();
			for(String str : cb){
				sb.append(str);
			}
			CT.trace(sb.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		switch(direction){
			case NEGATIVE:
				return new Nite(pRolls(index, count-1), count);
			default:
				return new Pite(index, count);
		}
	}

}
