package com.dwarfeng.dutil.develop.timer.obs;

import com.dwarfeng.dutil.basic.prog.Observer;
import com.dwarfeng.dutil.develop.timer.Plan;

/**
 * 计时器观察器。
 *
 * @author DwArFeng
 * @since 0.2.0-beta
 */
public interface TimerObserver extends Observer {

    /**
     * 通知观察器指定的计划被安排。
     *
     * @param plan 指定的计划。
     */
    void firePlanScheduled(Plan plan);

    /**
     * 通知观察器指定的计划开始。
     *
     * @param plan            指定的计划。
     * @param count           该计划当前的运行次数。
     * @param expectedRumTime 计划运行的理论时间。
     * @param actualRunTime   计划运行的实际时间。
     */
    void firePlanRun(Plan plan, int count, long expectedRumTime, long actualRunTime);

    /**
     * 通知观察器指定的计划结束。
     *
     * @param plan          指定的计划。
     * @param finishedCount 该计划运行完成的次数。
     * @param throwable     本次运行抛出的异常，如没有，则为 <code>null</code>。
     */
    void firePlanFinished(Plan plan, int finishedCount, Throwable throwable);

    /**
     * 通知观察器指定的计划被移除。
     *
     * @param plan 指定的计划。
     */
    void firePlanRemoved(Plan plan);

    /**
     * 通知观察器所有计划被清除。
     */
    void firePlanCleared();

    /**
     * 通知观察器计时器被关闭。
     */
    void fireShutDown();

    /**
     * 通知观察器计时器被终结。
     */
    void fireTerminated();
}
