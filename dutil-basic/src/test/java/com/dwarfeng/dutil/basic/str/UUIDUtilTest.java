package com.dwarfeng.dutil.basic.str;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UUIDUtilTest {

    @Test
    public void testToDenseString() {
        for (int i = 0; i < 5; i++) {
            String denseString = UUIDUtil.toDenseString(UUID.randomUUID());
            assertEquals(22, denseString.length());
        }
    }
}
