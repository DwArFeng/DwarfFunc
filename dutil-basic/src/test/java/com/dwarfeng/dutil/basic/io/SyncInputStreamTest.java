package com.dwarfeng.dutil.basic.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SyncInputStreamTest {

    private final static String TEXT = "0123456";

    private static StringInputStream in;
    private static SyncInputStream syncIn;

    @Before
    public void setUp() {
        in = new StringInputStream(TEXT);
        syncIn = new SyncInputStream(in);
    }

    @After
    public void tearDown() {
        try {
            syncIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            syncIn = null;
            in = null;
        }
    }

    @Test
    public final void testRead() throws IOException {
        byte[] bs = new byte[1];
        bs[0] = (byte) syncIn.read();
        String str = new String(bs);
        assertEquals("0", str);
    }

    @Test
    public final void testReadByteArray() throws IOException {
        byte[] bs = new byte[4];
        syncIn.read(bs);
        String str = new String(bs);
        assertEquals("0123", str);
    }

    @Test
    public final void testReadByteArrayIntInt() throws IOException {
        byte[] bs = new byte[4];
        syncIn.read(bs, 0, 3);
        assertEquals(0, bs[3]);
        bs[3] = "3".getBytes()[0];
        String str = new String(bs);
        assertEquals("0123", str);
    }

    @Test
    public final void testSkip() throws IOException {
        syncIn.skip(3);
        byte[] bs = new byte[4];
        syncIn.read(bs);
        String str = new String(bs);
        assertEquals("3456", str);
    }

    @Test
    public final void testAvailable() throws IOException {
        assertEquals(7, syncIn.available());
    }

    @Test(expected = IOException.class)
    public final void testMarkAndReset() throws IOException {
        try {
            syncIn.skip(3);
            syncIn.mark(0);

            byte[] bs = new byte[4];
            syncIn.read(bs);
            String str = new String(bs);
            assertEquals("3456", str);
        } catch (IOException e) {
            fail("在意外的地方发生异常。");
        }
        syncIn.reset();
    }

    @Test
    public final void testMarkSupported() {
        assertTrue(syncIn.markSupported());
    }

    @Test
    public final void testGetLock() {
        assertNotNull(syncIn.getLock());
    }
}
