package com.dwarfeng.dutil.basic.threads;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadUtilTest {

    @Test
    public void testUnmodifiableLock_0() {
        ThreadUtil.unmodifiableLock(new ReentrantLock());
    }

    @Test(expected = NullPointerException.class)
    public void testUnmodifiableLock_1() {
        ThreadUtil.unmodifiableLock(null);
    }
}
