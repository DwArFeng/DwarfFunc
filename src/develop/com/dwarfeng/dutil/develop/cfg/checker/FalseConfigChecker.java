package com.dwarfeng.dutil.develop.cfg.checker;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * �������ֵ�������
 * <p> ������ֵ��������������ֵ�������� <code>false</code>��
 * ����һ�������û�û�ж�������ֵ�����ʱ��Ĭ�ϵ�����ֵ��������Ա�����ֲ���Ҫ�� {@link NullPointerException}��
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
