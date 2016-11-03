package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * �������������
 * <p> ����ı���ת����һ��������������Ч��������Ч��
 * @author  DwArFeng
 * @since 1.8
 */
public class PositiveIntegerChecker implements ConfigValueChecker {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigValueChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		if(Objects.isNull(value)) return false;
		return value.matches("[0-9]+");
	}

}
