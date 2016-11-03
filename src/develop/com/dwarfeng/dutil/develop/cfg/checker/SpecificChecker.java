package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * �ض��ı��������
 * <p> �������ı�Ϊ�����ض�ֵ�е�һ��ʱ����Ϊ��Ч��
 * @author  DwArFeng
 * @since 1.8
 */
public class SpecificChecker implements ConfigValueChecker{

	private final String[] arr;
	
	/**
	 * �����ض��ı��������
	 * @param arr ָ��ֵ���顣
	 */
	public SpecificChecker(String[] arr) {
		this.arr = arr;
	}
	
	/**
	 * �����ض��ı��������
	 * @param arr ָ���Ķ������飬ȡ����� <code>toString()</code>ֵ��
	 */
	public SpecificChecker(Object[] arr) {
		if(Objects.isNull(arr)){
			this.arr = null;
		}else{
			this.arr = new String[arr.length];
			for(int i = 0 ; i < arr.length ; i ++){
				this.arr[i] = arr[i].toString();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigValueChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		if(Objects.isNull(this.arr)) return false;
		if(ArrayUtil.contains(arr, value)) return true;
		return false;
	}

}
