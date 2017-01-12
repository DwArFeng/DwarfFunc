package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ƥ��ֵ�������
 * <p> ���ڼ��Ŀ��ֵ�Ƿ�ƥ��ָ����������ʽ��
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public class MatchConfigChecker implements ConfigChecker{
	
	private final String regex;

	/**
	 * ����һ��ƥ�������ַ���ƥ��ֵ�������
	 * <p> ʹ�ø÷��������ļ����ֻ�е� value Ϊ <code>null</code>ʱ�ŷ��� <code>false</code>��
	 */
	public MatchConfigChecker() {
		this("[\\s\\S]*");
	}
	
	/**
	 * ����һ��ӵ��ָ��ƥ����ʽ��ƥ��ֵ�������
	 * @param regex ָ����ƥ����ʽ��������ʽ����
	 */
	public MatchConfigChecker(String regex){
		this.regex = regex;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		if(Objects.isNull(value)) return false;
		return value.matches(regex);
	}

}
