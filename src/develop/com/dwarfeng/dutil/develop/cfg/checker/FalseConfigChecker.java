package com.dwarfeng.dutil.develop.cfg.checker;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * �������ֵ�������
 * <p> ������ֵ��������������ֵ�������� <code>false</code>�����仰˵��
 * ������ֵ������ܾ�һ��ֵ��
 * @author  DwArFeng
 * @since 1.8
 */
public class FalseConfigChecker implements ConfigChecker {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		return false;
	}

}