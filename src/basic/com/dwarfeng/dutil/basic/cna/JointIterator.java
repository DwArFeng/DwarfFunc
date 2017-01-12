package com.dwarfeng.dutil.basic.cna;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.prog.Buildable;

/**
 * ���ӵ��������������Ӷ������ {@link Iterator} �� {@link Iterator}��
 * <p> �õ��������Ӷ������������Щ�����ӵĵ�������˳�����С������ӵ������ĵ���˳���ǣ����ȶ����ж����ĵ������еĵ�һ��
 * �е�Ԫ�ؽ��е���������һ����������û�и����Ԫ��ʱ�����������ڶ�����������Ԫ�أ��Դ����ƣ�ֱ�����е������е�Ԫ��
 * ����ɵ�����
 * <p> ������������ <code>null</code>Ԫ�أ�����ڹ�������ʹ�� <code>null</code>Ԫ�ؽ��й��죬��ᱻ�����ľܾ���
 * <p> Ϊ�˷�ֹǱ�ڵĶ���Ⱦ������Ĺ��췽ʽ�ɹ�������ɡ�
 * <p> ���ֻ�Ǻϲ��������������� {@link CollectionUtil}�ṩ�˱�ݷ�������鿴 {@link CollectionUtil#contactIterator(Iterator, Iterator)}��
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public class JointIterator<T> implements Iterator<T> {
	
	public static class Builder<T> implements Buildable<JointIterator<T>>{

		private final List<Iterator<T>> iteratorList = CollectionUtil.nonNullList(new ArrayList<Iterator<T>>());
		
		/**
		 * �����������һ����������
		 * <p> �õ�����λ�ڹ������е���󷽣�ֱ���µĵ���������ӡ�
		 * @param iterator ָ���Ŀɵ�������
		 * @return ����������
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
		 */
		public Builder<T> append(Iterator<T> iterator){
			Objects.requireNonNull(iterator, DwarfUtil.getStringField(StringFieldKey.JointIterator_0));
			iteratorList.add(iterator);
			return this;
		}
		
		/**
		 * �����������һ���ɵ�������
		 * @param iterable ָ���Ŀɵ�������
		 * @return ����������
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
		 */
		public Builder<T> append(Iterable<T> iterable){
			Objects.requireNonNull(iterable, DwarfUtil.getStringField(StringFieldKey.JointIterator_1));
			iteratorList.add(iterable.iterator());
			return this;
		}
		
		/**
		 * �����������һ�����顣
		 * <p> �����齫ת��Ϊ��������ӽ��������У������˳��������˳��һ�¡�
		 * @param array ָ�������顣
		 * @return ����������
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
		 */
		public Builder<T> append(T[] array){
			Objects.requireNonNull(array, DwarfUtil.getStringField(StringFieldKey.JointIterator_2));
			iteratorList.add(ArrayUtil.array2Iterable(array).iterator());
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dutil.basic.prog.Buildable#build()
		 */
		@Override
		public JointIterator<T> build() {
			return new JointIterator<>(iteratorList);
		}
		
	}

	/**��Ŷ������������б�*/
	protected final List<Iterator<T>> iteratorList;
	/**���ڼ�¼��ǰ����λ�õı���*/
	protected int index = 0;
	
	private JointIterator(List<Iterator<T>> iteratorList) {
		this.iteratorList = iteratorList;
	}
	
	private boolean hasNextBehind(int index){
		for(int i = index ; i < iteratorList.size() ; i ++){
			if(iteratorList.get(i).hasNext()) return true;
		}
		return false;
	}
	
	private int getNextIndexBehind(int index){
		for(int i = index ; i < iteratorList.size() ; i ++){
			if(iteratorList.get(i).hasNext()) return i;
		}
		throw new IllegalArgumentException();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		Iterator<T> currentIterator = iteratorList.get(index);
		if(currentIterator.hasNext()) {
			return true;
		}else{
			if(hasNextBehind(index)){
				this.index = getNextIndexBehind(index);
				return true;
			}else{
				this.index = iteratorList.size() - 1;
				return false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
		Iterator<T> currentIterator = iteratorList.get(index);
		return currentIterator.next();
	}

}
