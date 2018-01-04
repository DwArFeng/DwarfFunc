package com.dwarfeng.dutil.develop.cfg;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dwarfeng.dutil.develop.cfg.checker.DoubleConfigChecker;

public class Test_DoubleConfigChecker {

	private static DoubleConfigChecker checker0;
	private static DoubleConfigChecker checker1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		checker0 = new DoubleConfigChecker();
		checker1 = new DoubleConfigChecker(-100, +100);
	}

	@After
	public void tearDown() throws Exception {
		checker0 = null;
		checker1 = null;
	}

	@Test
	public final void testIsValid0() {
		assertTrue(checker0.isValid("0"));
		assertTrue(checker0.isValid("-1"));
		assertTrue(checker0.isValid("1"));
		assertTrue(checker0.isValid("-128"));
		assertTrue(checker0.isValid("127"));
		assertFalse(checker0.isValid("A"));
		assertFalse(checker0.isValid("0xFF"));
		assertTrue(checker0.isValid("-129"));
		assertTrue(checker0.isValid("0.0"));
		assertTrue(checker0.isValid("1.234"));
		assertTrue(checker0.isValid("128"));
		assertTrue(checker0.isValid("128.1"));
		assertTrue(checker0.isValid("-128"));
		assertTrue(checker0.isValid("-.1"));
		assertTrue(checker0.isValid("-.12345"));
		assertTrue(checker0.isValid("+1.123"));
		assertTrue(checker0.isValid("-.254"));
		assertFalse(checker0.isValid("+."));
		assertFalse(checker0.isValid("1.1.1"));
		assertFalse(checker0.isValid("-9987.126.15"));
		assertFalse(checker0.isValid("-100."));
	}

	@Test
	public final void testIsValid1() {
		assertTrue(checker1.isValid("0"));
		assertTrue(checker1.isValid("-1"));
		assertTrue(checker1.isValid("1"));
		assertFalse(checker1.isValid("-128"));
		assertFalse(checker1.isValid("127"));
		assertFalse(checker1.isValid("A"));
		assertFalse(checker1.isValid("0xFF"));
		assertFalse(checker1.isValid("-129"));
		assertTrue(checker1.isValid("0.0"));
		assertTrue(checker1.isValid("1.234"));
		assertFalse(checker1.isValid("128"));
		assertFalse(checker1.isValid("128.1"));
		assertFalse(checker1.isValid("-128"));
		assertTrue(checker1.isValid("-.1"));
		assertTrue(checker1.isValid("-.12345"));
		assertTrue(checker1.isValid("+1.123"));
		assertTrue(checker1.isValid("-.254"));
		assertFalse(checker1.isValid("+."));
		assertFalse(checker1.isValid("1.1.1"));
		assertFalse(checker1.isValid("-9987.126.15"));
		assertTrue(checker1.isValid("-100"));
		assertTrue(checker1.isValid("+100.00"));
	}

}
