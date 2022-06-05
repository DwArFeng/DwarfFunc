package com.dwarfeng.dutil.develop.backgr.obs;

import com.dwarfeng.dutil.basic.prog.Observer;

/**
 * 任务观察器。
 *
 * @author DwArFeng
 * @since 0.3.0-beta
 */
public interface TaskObserver extends Observer {

    /**
     * 通知观察器任务已经开始执行。
     */
    void fireStarted();

    /**
     * 通知任务已经结束执行。
     */
    void fireFinished();
}
