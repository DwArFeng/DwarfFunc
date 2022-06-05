package com.dwarfeng.dutil.develop.backgr.obs;

/**
 * 任务观察器适配器。
 *
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class TaskAdapter implements TaskObserver {

    @Override
    public void fireStarted() {
    }

    @Override
    public void fireFinished() {
    }
}
