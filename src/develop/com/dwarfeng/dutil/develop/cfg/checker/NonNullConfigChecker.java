package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * �ǿռ������
 * <p> ֻҪ�ı����� <code>null</code>��������Ч�ġ�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class NonNullConfigChecker implements ConfigChecker {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		return Objects.nonNull(value);
	}

}
