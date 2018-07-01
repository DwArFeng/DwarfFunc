package com.dwarfeng.dutil.develop.setting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dwarfeng.dutil.develop.setting.info.LocaleSettingInfo;

public class TestLocaleSettingInfo {

	private final static String VALUE_INIT = "zh_CN";
	private final static String VALUE_OTHER = "en_US";
	private final static String VALUE_INVALID = "com.dwarfeng";

	private final static Object VALUE_PARSE_INIT = Locale.SIMPLIFIED_CHINESE;
	private final static Object VALUE_PARSE_OTHER = Locale.US;
	private final static Object VALUE_PARSE_INVALID = 114514;

	private static SettingInfo info;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		info = new LocaleSettingInfo(VALUE_INIT);
	}

	@After
	public void tearDown() throws Exception {
		info = null;
	}

	@Test
	public final void testHashCode() {
		SettingInfo other = new LocaleSettingInfo(VALUE_INIT);
		assertEquals(info.hashCode(), other.hashCode());
		other = new LocaleSettingInfo(VALUE_OTHER);
		assertNotEquals(info.hashCode(), other.hashCode());
	}

	@Test
	public final void testEqualsObject() {
		SettingInfo other = new LocaleSettingInfo(VALUE_INIT);
		assertTrue(info.equals(other));
		other = new LocaleSettingInfo(VALUE_OTHER);
		assertFalse(info.equals(other));
	}

	@Test
	public final void testIsValid() {
		assertFalse(info.isValid(null));
		assertFalse(info.isValid(VALUE_INVALID));
		assertTrue(info.isValid(VALUE_INIT));
		assertTrue(info.isValid(VALUE_OTHER));
	}

	@Test
	public final void testNonValid() {
		assertTrue(info.nonValid(null));
		assertTrue(info.nonValid(VALUE_INVALID));
		assertFalse(info.nonValid(VALUE_INIT));
		assertFalse(info.nonValid(VALUE_OTHER));
	}

	@Test
	public final void testParseValue() {
		assertEquals(VALUE_PARSE_INIT, info.parseValue(VALUE_INIT));
		assertEquals(VALUE_PARSE_OTHER, info.parseValue(VALUE_OTHER));
		assertEquals(null, info.parseValue(null));
		assertEquals(null, info.parseValue(VALUE_INVALID));
	}

	@Test
	public final void testParseValueExtra() {
		Locale locale;
		locale = new Locale("zh", "", "");
		assertEquals("zh", info.parseObject(locale));
		locale = new Locale("zh", "", "gz");
		assertEquals("zh__gz", info.parseObject(locale));
		locale = new Locale("zh", "CN", "");
		assertEquals("zh_CN", info.parseObject(locale));
		locale = new Locale("zh", "CN", "gz");
		assertEquals("zh_CN_gz", info.parseObject(locale));
	}

	@Test
	public final void testParseObject() {
		assertEquals(VALUE_INIT, info.parseObject(VALUE_PARSE_INIT));
		assertEquals(VALUE_OTHER, info.parseObject(VALUE_PARSE_OTHER));
		assertEquals(null, info.parseObject(null));
		assertEquals(null, info.parseObject(VALUE_PARSE_INVALID));
	}

	@Test
	public final void testGetDefaultValue() {
		assertEquals(VALUE_INIT, info.getDefaultValue());
	}

	@Test
	public final void testCheckDefaultValue() {
		new LocaleSettingInfo(VALUE_INIT);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testCheckDefaultValueException() {
		new LocaleSettingInfo(VALUE_INVALID);
		fail("没有抛出异常");
	}

}
