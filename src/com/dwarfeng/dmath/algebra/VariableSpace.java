package com.dwarfeng.dmath.algebra;

import java.util.Arrays;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dfunc.cna.ArrayUtil;
import com.dwarfeng.dfunc.cna.CollectionUtil;
import com.dwarfeng.dfunc.str.NameableComparator;
import com.dwarfeng.dmath.AbstractDMath;
import com.dwarfeng.dmath.Region;

/**
 * �����ռ䡣
 * <p> �����ռ���ָ��һ�� {@link VariableValue} ��ɵĿռ䡣
 * <br> �ÿռ��еĶ����˳�����ֵ�˳�������໥��ͻ�ı������ܽ���ͬ�������ռ䡣
 * <p> ��ν�ı�����ͻ����ָ������ͬ���ƵĲ�ͬ���������ڱ����ؼ��б�����˳���������ֵ�˳������ģ�
 * �������ͬ�����������޷����ı��϶Ա����������𣬴Ӷ��ᵼ�½�һ���Ĵ���
 * <p> �����ռ����ڴ�ű����������ǲ��ɱ�ģ�Ȼ������Щ���������ȡ�����ռ���㷨
 * �Ƕ�̬��ѯ����ӣ�Ϊ�˱���ʱ���ϺͿռ��ϵ��˷ѣ� �ڲ������{@link VariableEntry}�����ṩ�ܹ����иı��
 * �б� 
 * @author DwArFeng
 * @since 1.8
 */
public class VariableSpace extends AbstractDMath implements
Iterable<VariableValue>, Region<VariableValue>{

	/**
	 * �����ؼ�����ڡ�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static final class VariableEntry{
		
		private final Set<VariableValue> set;
		
		/**
		 * ����һ�������ռ����ڡ�
		 */
		public VariableEntry() {
			set = CollectionUtil.nonNullSet(new HashSet<VariableValue>());
		}
		
		/**
		 * ����������һ��������
		 * @param value ָ���ı�����
		 * @return ��ӵı����Ƿ������˸���ڵĸı䡣
		 */
		public boolean add(VariableValue value){
			return set.add(value);
		}
		
		/**
		 * ����������ָ�������ռ��е����б�����
		 * <p> �����ڲ���Ϊ <code>null</code>�Ļ���������κ�Ԫ�ء�
		 * @param space ָ���ı����ռ䡣
		 * @return ��ӵı����ռ��еı������Ƿ������˸���ڵĸı䡣
		 */
		public boolean add(VariableSpace space){
			if(space == null) return false;
			
			boolean flag = false;
			for(VariableValue var : space){
				if(set.add(var)) flag = true;
			}
			
			return flag;
		}
		
	}
	
	private static void checkConlictAndSort(VariableValue[] vars) throws VariableConflictException{
		if(vars.length < 2) return;
		Arrays.sort(vars, new NameableComparator());
		for(int i = 0 ; i < vars.length - 1 ; i ++){
			if(AlgebraUtil.checkConflict(vars[i], vars[i+1])){
				throw new VariableConflictException(vars[i].getName());
			}
		}
	}
	
	protected final VariableValue[] vars;
	
	/**
	 * ͨ��ָ���ı�������ֻ����ָ�������ı����ռ䡣
	 * @param var ָ���ı�����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public VariableSpace(VariableValue var){
		Objects.requireNonNull(var, DwarfFunction.getStringField(StringFiledKey.VariableSpace_2));
		
		this.vars = new VariableValue[]{var};
	}
	
	/**
	 * ����һ���յı����ռ䡣
	 */
	public VariableSpace() {
		this.vars = new VariableValue[0];
	}
	
	/**
	 * ͨ��ָ���ı����鹹��һ�������ռ䡣
	 * @param vars ָ���ı����顣
	 * @throws VariableConflictException ������ͻ�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public VariableSpace(VariableValue[] vars) throws VariableConflictException {
		Objects.requireNonNull(vars, DwarfFunction.getStringField(StringFiledKey.VariableSpace_0));
		checkConlictAndSort(vars);
		this.vars = vars;
	}
	
	/**
	 * ͨ��ָ���ı�������ڹ�������顣
	 * @param entry ָ���ı�������ڡ�
	 * @throws VariableConflictException ������ͻ�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public VariableSpace(VariableEntry entry) throws VariableConflictException {
		Objects.requireNonNull(entry, DwarfFunction.getStringField(StringFiledKey.VariableSpace_1));
		VariableValue[] vars = entry.set.toArray(new VariableValue[0]);
		checkConlictAndSort(vars);
		this.vars = vars;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<VariableValue> iterator() {
		return new VsIterator();
	}
	
	private final class VsIterator implements Iterator<VariableValue>{

		private int i = 0;
		
		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return i < vars.length;
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public VariableValue next() {
			return vars[i++];
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfFunction.getStringField(StringFiledKey.Algebra_VariableSpace);
	}
	
	/**
	 * ���ر����ռ���Ԫ�ص�������
	 * @return �����ռ�Ԫ��������
	 */
	public int size(){
		return vars.length;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getExpression()
	 */
	@Override
	public String getExpression() {
		if(size() == 0) return "��";
		
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		
		try{
			sb.append("[");
			for(VariableValue var : vars){
				formatter.format("%s = %.4f, ", var.getName(), var.value());
			}
			
			sb.delete(sb.length()-2, sb.length()).append("]");
		}finally{
			formatter.close();
		}
		
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.Region#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(VariableValue t) {
		return ArrayUtil.contains(vars, t);
	}

}
