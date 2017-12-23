package com.dwarfeng.dutil.develop.logger.obv;

import com.dwarfeng.dutil.develop.logger.Logger;
import com.dwarfeng.dutil.develop.logger.LoggerInfo;

/**
 * 记录器观察器适配器。
 * 
 * @author DwArFeng
 * @since 0.2.0-beta
 */
public abstract class LoggerAdapter implements LoggerObverser {

	@Override
	public void fireAdded(LoggerInfo loggerInfo) {
	}

	@Override
	public void fireCleared() {
	}

	@Override
	public void fireLoggerUnused(String key, LoggerInfo loggerInfo, Logger logger) {
	}

	@Override
	public void fireLoggerUnusedAll() {
	}

	@Override
	public void fireLoggerUsed(String key, LoggerInfo loggerInfo, Logger logger) {
	}

	@Override
	public void fireLoggerUsedAll() {
	}

	@Override
	public void fireRemoved(LoggerInfo loggerInfo) {
	}

}
