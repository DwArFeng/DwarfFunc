package com.dwarfeng.dutil.develop.backgr.obs;

import com.dwarfeng.dutil.basic.prog.Observer;
import com.dwarfeng.dutil.develop.backgr.Task;

/**
 * 后台观察器。
 *
 * @author DwArFeng
 * @since 0.3.0-beta
 */
public interface BackgroundObserver extends Observer {

    /**
     * 通知观察器指定的任务被提交。
     *
     * @param task 指定的任务。
     */
    void fireTaskSubmitted(Task task);

    /**
     * 通知观察器指定的任务开始。
     *
     * @param task 指定的任务。
     */
    void fireTaskStarted(Task task);

    /**
     * 通知观察器指定的任务结束。
     *
     * @param task 指定的任务。
     */
    void fireTaskFinished(Task task);

    /**
     * 通知观察器指定的任务被移除。
     *
     * @param task 指定的任务。
     */
    void fireTaskRemoved(Task task);

    /**
     * 通知观察器后台被关闭。
     */
    void fireShutDown();

    /**
     * 通知观察器后台被终结。
     */
    void fireTerminated();
}
