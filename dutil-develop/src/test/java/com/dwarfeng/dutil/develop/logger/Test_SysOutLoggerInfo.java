package com.dwarfeng.dutil.develop.logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_SysOutLoggerInfo {

	private static SysOutLoggerInfo info1;
	private static SysOutLoggerInfo info2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		info1 = new SysOutLoggerInfo("info1", true);
		info2 = new SysOutLoggerInfo("info2", false);
	}

	@After
	public void tearDown() throws Exception {
		info1 = null;
		info2 = null;
	}

	@Test
	public final void testNewLogger() throws Exception {
		SysOutLogger logger1 = (SysOutLogger) info1.newLogger();
		SysOutLogger logger2 = (SysOutLogger) info2.newLogger();
		assertTrue(logger1.isAutoUpdate());
		assertFalse(logger2.isAutoUpdate());
	}

	@Test
	public final void testIsAutoUpdate() {
		assertTrue(info1.isAutoUpdate());
		assertFalse(info2.isAutoUpdate());
	}

}
