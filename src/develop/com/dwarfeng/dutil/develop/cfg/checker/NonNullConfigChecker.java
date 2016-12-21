package com.dwarfeng.dutil.develop.cfg.checker;

import java.util.Objects;

import com.dwarfeng.dutil.develop.cfg.ConfigChecker;

/**
 * 非空检查器。
 * <p> 只要文本不是 <code>null</code>，就是有效的。
 * @author  DwArFeng
 * @since 1.8
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
