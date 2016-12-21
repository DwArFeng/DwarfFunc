package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * ����ֵ�������
 * <p> ֻҪ�������ı�ת��Ϊ��д֮�� ��Ϊ <code>TRUE</code> ���� <code>FALSE</code> ����֮һ��
 * ��Ϊ��Ч��
 * @author  DwArFeng
 * @since 1.8
 */
public class BooleanConfigChecker implements ConfigChecker {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		if(Objects.isNull(value)) return false;
		String str = value.toUpperCase();
		if(str.equals("TRUE") || str.equals("FALSE")) return true;
		return false;
	}

}
