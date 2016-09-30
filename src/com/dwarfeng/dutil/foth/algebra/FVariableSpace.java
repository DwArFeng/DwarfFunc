package com.dwarfeng.dutil.foth.algebra;

import java.util.Arrays;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.cna.CollectionUtil;
import com.dwarfeng.dutil.basic.infs.Buildable;
import com.dwarfeng.dutil.basic.str.NameableComparator;
import com.dwarfeng.dutil.math.AbstractDMath;
import com.dwarfeng.dutil.math.Region;

/**
 * �����ռ䡣
 * <p> �����ռ���ָ��һ�� {@link FVariable} ��ɵĿռ䡣
 * <br> �ÿռ��еĶ����˳�����ֵ�˳�������໥��ͻ�ı������ܽ���ͬ�������ռ䡣
 * <p> ��ν�ı�����ͻ����ָ������ͬ���ƵĲ�ͬ���������ڱ����ؼ��б�����˳���������ֵ�˳������ģ�
 * �������ͬ�����������޷����ı��϶Ա����������𣬴Ӷ��ᵼ�½�һ���Ĵ���
 * <br> ���ڱ����ռ�����ܾ�������ͻ�����Ա����ռ���Ա�֤���еı������ǲ���ͬ�ģ�����һ�������ռ��е�����һ��
 * ��������һ������equals����ȣ�ͬʱ��ͬ������ֻ�����һ�Ρ�
 * <p> �����ռ�Ĺ������ǲ��ɼ��ģ���������ռ���Ҫ�ñ����ռ�Ĺ���������ɡ������ռ�Ľṹ�ǲ��ɸ��ĵģ�
 * ��Ȼ�����ռ��еı������������±���ֵ�����Ǳ����ռ��еı������������ӻ��Ƴ���
 * �ڱ����ռ�Ĺ����������ӻ��Ƴ�Ԫ���п��ܻ��׳� {@link VariableConflictException}���������༭��ɺ󣬼���
 * ���� {@link Builder#build()}��������������ռ䡣
 * <p>���������ռ���ȵ�ǰ�����������������ռ������Ԫ�ؾ���ȡ�
 * @author DwArFeng
 * @since 1.8
 */
public class FVariableSpace extends AbstractDMath implements
Iterable<FVariable>, Region<FVariable>{

	/**�յı�������*/
	public static final FVariableSpace EMPTY = new Builder().build();
	
	/**
	 * �����ռ�Ĺ�������
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static class Builder implements Buildable<FVariableSpace>{

		private final Set<FVariable> set;
		
		/**
		 * ����һ�������ռ乹������
		 */
		public Builder() {
			this.set = CollectionUtil.nonNullSet(new HashSet<FVariable>());
		}
		
		/**
		 * ������ռ�Ĺ����������ָ���Ŀɱ����
		 * @param var ָ���ı�����
		 * @return ����������
		 * @throws VariableConflictException ����ӵ�Ԫ���빹�����е�����һ��Ԫ�س�ͻ��
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code> ʱ�׳��쳣��
		 */
		public Builder add(FVariable var){
			for(FVariable vv : set){
				if(FAlgebraUtil.checkConflict(vv, var)){
					throw new VariableConflictException(vv.getName());
				}
			}
			set.add(var);
			return this;
		}
		
		/**
		 * ������ռ�Ĺ����������һ�������ռ��е����б�����
		 * @param variableSpace ָ���ı����ռ䡣
		 * @return ����������
		 * @throws VariableConflictException ����ӵ�Ԫ���빹�����е�����һ��Ԫ�س�ͻ��
		 * @throws NullPointerException �����Ԫ��Ϊ <code>null</code>ʱ�׳��쳣��
		 */
		public Builder add(FVariableSpace variableSpace){
			for(FVariable vv : variableSpace){
				add(vv);
			}
			return this;
		}
		
		/**
		 * ������ؼ��Ĺ����������һ��ֵ�����е����б�����
		 * @param valueable ָ����ֵ����
		 * @return ����������
		 * @throws VariableConflictException ��ֵ�����еı����빹�����е�����һ��������ͻ��
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code> ����ֵ�����еı����ռ�Ϊ <code>null</code>��
		 */
		public Builder add(FValueable valueable){
			add(valueable.variableSpace());
			return this;
		}
		
		/**
		 * �ڱ����ռ��Ƴ�ָ���Ķ���
		 * @param o ָ���Ķ���
		 * @return ����������
		 */
		public Builder remove(Object o){
			set.remove(o);
			return this;
		}
		
		/**
		 * �ڱ����ռ����Ƴ�ָ�������ռ��е����б�����
		 * <p> ��ڲ���Ϊ <code>null</code> �����Ƴ��κ�Ԫ�ء�
		 * @param variableSpace ָ���ı����ռ䡣
		 * @return ����������
		 */
		public Builder remove(FVariableSpace variableSpace){
			if(Objects.nonNull(variableSpace)){
				for(FVariable var : variableSpace){
					remove(var);
				}				
			}
			return this;
		}
		
		/**
		 * �Ƴ�ָ��ֵ�����еı����ռ��е����б�����
		 * <p> ��ڲ���Ϊ <code>null</code> �����Ƴ��κ�Ԫ�ء�
		 * @param val ָ����ֵ����
		 * @return ����������
		 */
		public Builder remove(FValueable val){
			if(Objects.nonNull(val)){
				remove(val.variableSpace());			
			}
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Buildable#build()
		 */
		@Override
		public FVariableSpace build() {
			FVariable[] vars = set.toArray(new FVariable[0]);
			Arrays.sort(vars, new NameableComparator());
			return new FVariableSpace(vars);
		}
		
	}
	
	protected final FVariable[] vars;
	
	private FVariableSpace(FVariable[] vars){
		this.vars = vars;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<FVariable> iterator() {
		return new VsIterator();
	}
	
	private final class VsIterator implements Iterator<FVariable>{

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
		public FVariable next() {
			return vars[i++];
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.AbstractDMath#getMathName()
	 */
	@Override
	public String getMathName() {
		return DwarfUtil.getStringField(StringFieldKey.Algebra_VariableSpace);
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
			for(FVariable var : vars){
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
	public boolean contains(FVariable t) {
		return ArrayUtil.contains(vars, t);
	}

}
