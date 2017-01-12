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
import com.dwarfeng.dutil.basic.prog.Buildable;
import com.dwarfeng.dutil.basic.str.NameableComparator;
import com.dwarfeng.dutil.math.AbstractMathObject;
import com.dwarfeng.dutil.math.Region;

/**
 * �����ռ䡣
 * <p> �����ռ���ָ��һ�� {@link FothVariable} ��ɵĿռ䡣
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
 * @since 0.0.2-beta
 */
public class FothVariableSpace extends AbstractMathObject implements
Iterable<FothVariable>, Region<FothVariable>{

	/**�յı�������*/
	public static final FothVariableSpace EMPTY = new Builder().build();
	/**�ռ����ֶ�*/
	public static final String EMPTY_SPACE_NAME = "��";
	
	/**
	 * �����ռ�Ĺ�������
	 * @author DwArFeng
	 * @since 0.0.2-beta
	 */
	public static class Builder implements Buildable<FothVariableSpace>{

		private final Set<FothVariable> set;
		
		/**
		 * ����һ�������ռ乹������
		 */
		public Builder() {
			this.set = CollectionUtil.nonNullSet(new HashSet<FothVariable>());
		}
		
		/**
		 * ������ռ�Ĺ����������ָ���Ŀɱ����
		 * @param var ָ���ı�����
		 * @return ����������
		 * @throws VariableConflictException ����ӵ�Ԫ���빹�����е�����һ��Ԫ�س�ͻ��
		 * @throws NullPointerException ��ڲ���Ϊ <code>null</code> ʱ�׳��쳣��
		 */
		public Builder add(FothVariable var){
			for(FothVariable vv : set){
				if(FothAlgebraUtil.checkConflict(vv, var)){
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
		public Builder add(FothVariableSpace variableSpace){
			for(FothVariable vv : variableSpace){
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
		public Builder add(FothValue valueable){
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
		public Builder remove(FothVariableSpace variableSpace){
			if(Objects.nonNull(variableSpace)){
				for(FothVariable var : variableSpace){
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
		public Builder remove(FothValue val){
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
		public FothVariableSpace build() {
			FothVariable[] vars = set.toArray(new FothVariable[0]);
			Arrays.sort(vars, new NameableComparator());
			return new FothVariableSpace(vars);
		}
		
	}
	
	protected final FothVariable[] vars;
	
	private FothVariableSpace(FothVariable[] vars){
		this.vars = vars;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<FothVariable> iterator() {
		return new VsIterator();
	}
	
	private final class VsIterator implements Iterator<FothVariable>{

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
		public FothVariable next() {
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
		if(size() == 0) return EMPTY_SPACE_NAME;
		
		StringBuilder sb = new StringBuilder();
		//��Ϊ���ӵ� StringBuilder ���� Closeable������˲���Ҫ�رո�ʽ������
		@SuppressWarnings("resource")
		Formatter formatter = new Formatter(sb);
		sb.append("[");
		for(FothVariable var : vars){
			formatter.format("%s = %.4f, ", var.getName(), var.value());
		}
		sb.delete(sb.length()-2, sb.length()).append("]");
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dmath.Region#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(FothVariable t) {
		return ArrayUtil.contains(vars, t);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(Objects.isNull(obj)) return false;
		if(obj == this) return true;
		if(! (obj instanceof FothVariableSpace)) return false;
		FothVariableSpace variableSpace = (FothVariableSpace) obj;
		for(int i = 0 ; i < vars.length ; i ++){
			if(!vars[i].equals(variableSpace.vars[i])) return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Arrays.hashCode(vars) + 17;
	}
	
	
	/**
	 * �������ռ��е�ÿ��������ֵ��
	 * @param vals ֵ���顣
	 * @throws IllegalArgumentException ��������С������ռ��еı���������һ�¡�
	 */
	public void setValue(double[] vals){
		if(vals.length != vars.length){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FothValue_0));
		}
		for(int i = 0 ; i < vars.length ; i ++){
			vars[i].setValue(vals[i]);
		}
	}
	
	/**
	 * �������ռ��е�ÿ��������ֵ��
	 * @param vals ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�����к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ��������С������ռ��еı���������һ�¡�
	 */
	public void setValue(FothValue[] vals){
		ArrayUtil.requireNotContainsNull(vals, DwarfUtil.getStringField(StringFieldKey.FothVariableSpace_1));
		if(vals.length != vars.length){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FothVariableSpace_0));
		}
		for(int i = 0 ; i < vars.length ; i ++){
			vars[i].setValue(vals[i]);
		}
	}
	
	/**
	 * �����ռ��е�ÿ������ƫ�ơ�
	 * @param vals ֵ���顣
	 * @throws IllegalArgumentException ��������С������ռ��еı���������һ�¡�
	 */
	public void offset(double[] vals){
		if(vals.length != vars.length){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FothValue_0));
		}
		for(int i = 0 ; i < vars.length ; i ++){
			vars[i].offset(vals[i]);
		}
	}
	
	/**
	 * �����ռ��е�ÿ������ƫ�ơ�
	 * @param vals ֵ���顣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�����к��� <code>null</code>Ԫ�ء�
	 * @throws IllegalArgumentException ��������С������ռ��еı���������һ�¡�
	 */
	public void offset(FothValue[] vals){
		ArrayUtil.requireNotContainsNull(vals, DwarfUtil.getStringField(StringFieldKey.FothVariableSpace_1));
		if(vals.length != vars.length){
			throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.FothVariableSpace_0));
		}
		for(int i = 0 ; i < vars.length ; i ++){
			vars[i].offset(vals[i]);
		}
	}
}
