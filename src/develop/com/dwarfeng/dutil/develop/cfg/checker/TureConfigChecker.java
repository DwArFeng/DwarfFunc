package com.dwarfeng.dutil.develop.cfg.checker;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ����ʽ����ֵ�������
 * <p> �ü������һ�������е�һ��ֵ�ļ��㷵�� <code>true</code>�����仰˵��
 * ������ֵ���������һ��ֵ��
 * @author  DwArFeng
 * @since 1.8
 */
public class TureConfigChecker implements ConfigChecker{

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		return true;
	}

}
