package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigValueChecker;

/**
 * �ǿռ������
 * <p> ֻҪ�ı����� <code>null</code>��������Ч�ġ�
 * @author  DwArFeng
 * @since 1.8
 */
public class NonNullChecker implements ConfigValueChecker {

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.ConfigValueChecker#isValid(java.lang.String)
	 */
	@Override
	public boolean isValid(String value) {
		return Objects.nonNull(value);
	}

}
