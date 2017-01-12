package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * �����������
 * <p> ���ָ����ֵ���������Ҵ���ָ���ķ�Χ֮�ڣ����ܹ�ͨ��ֵ�������
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public class IntegerConfigChecker implements ConfigChecker {

	private final int minValue;
	private final int maxValue;

	/**
	 * ����һ�������������
	 * <p> ��ָ���� value ֵ�������ĸ�ʽ����� value ֵ��Ч��
	 */
	public IntegerConfigChecker() {
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * ����һ������ָ�����ֵ����Сֵ�������������
	 * <p> ��ָ���� value ֵ�������ĸ�ʽ�Ҹ������������ֵ����Сֵ֮�䣨���������ֵ����Сֵ��ȣ���
	 * ��� value ֵ��Ч��
	 * @param minValue ��Сֵ��
	 * @param maxValue ���ֵ��
	 */
	public IntegerConfigChecker(int minValue, int maxValue) {
		this.maxValue = maxValue;
		this.minValue = minValue;
	}
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		if(Objects.isNull(value)) return false;
		if(! value.matches("-*[0-9]+")) return false;
		try{
			int i = Integer.parseInt(value);
			return minValue <= i && i <= maxValue;
		}catch (NumberFormatException e) {
			return false;
		}
	}

}
