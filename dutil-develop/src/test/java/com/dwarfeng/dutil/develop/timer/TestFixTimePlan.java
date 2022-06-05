package com.dwarfeng.dutil.develop.timer;

import com.dwarfeng.dutil.basic.io.CT;
import com.dwarfeng.dutil.develop.timer.plan.FixedTimePlan;

class TestFixTimePlan extends FixedTimePlan {

    public TestFixTimePlan() {
        this(100l);
    }

    public TestFixTimePlan(long period) {
        super(period, 0);
    }

    @Override
    protected void todo() throws Exception {
        CT.trace("Timer tools is testing: count = " + (getFinishedCount() + 1));
    }
}
