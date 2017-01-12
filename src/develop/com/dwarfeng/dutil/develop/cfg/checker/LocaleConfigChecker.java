package com.dwarfeng.dutil.develop.cfg.checker;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ����/��������ֵ�������
 * <p> ���һ��ֵ�Ƿ���ϱ�׼�Ĺ���/�����淶��
 * @author  DwArFeng
 * @since 0.0.2-beta
 */
public class LocaleConfigChecker implements ConfigChecker {
	
	private final MatchConfigChecker delegate = new MatchConfigChecker("[a-z]+(_[A-Z]+(_[a-zA-Z]+)?)?");

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		return delegate.isValid(value);
	}

}
