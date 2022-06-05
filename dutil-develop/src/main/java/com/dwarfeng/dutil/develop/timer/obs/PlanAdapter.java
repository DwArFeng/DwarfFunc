package com.dwarfeng.dutil.develop.timer.obs;

/**
 * 计划观察器适配器。
 *
 * @author DwArFeng
 * @since 0.2.0-beta
 */
public abstract class PlanAdapter implements PlanObserver {

    @Override
    public void fireRun(int count, long expectedRumTime, long actualRunTime) {
    }

    @Override
    public void fireFinished(int finishedCount, Throwable throwable) {
    }
}
