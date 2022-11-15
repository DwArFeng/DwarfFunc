package com.dwarfeng.dutil.basic.num;

import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayUtilTest {

    @Test
    public void testReadOnlyArray() {
        String[] strs = new String[]{"1", "2", "3"};
        strs = ArrayUtil.readOnlyArray(strs, string -> string);
        assertArrayEquals(new String[]{"1", "2", "3"}, strs);
    }
}
