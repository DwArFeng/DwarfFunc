package com.dwarfeng.dutil.basic.cna;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayUtilTest {

    @Test
    public final void testEmpty() {
        String[] empty = ArrayUtil.empty(String.class);
        assertEquals(0, empty.length);
    }

    @Test
    public final void testGetNonNullArrayOfT() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"},
                ArrayUtil.getNonNull(new String[]{"1", "2", "3", "4", "5"}));
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, ArrayUtil
                .getNonNull(new String[]{null, null, "1", null, null, "2", "3", null, "4", "5", null, null}));
        assertArrayEquals(new String[]{}, ArrayUtil.getNonNull(new String[]{}));
        assertArrayEquals(new String[]{}, ArrayUtil.getNonNull(new String[]{null, null, null}));
    }
}
