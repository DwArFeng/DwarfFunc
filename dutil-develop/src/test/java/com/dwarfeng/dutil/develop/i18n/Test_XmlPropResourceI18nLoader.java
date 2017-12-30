package com.dwarfeng.dutil.develop.i18n;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Locale;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.i18n.DelegateI18nHandler;
import com.dwarfeng.dutil.develop.i18n.I18nHandler;
import com.dwarfeng.dutil.develop.i18n.io.XmlPropResourceI18nLoader;

public class Test_XmlPropResourceI18nLoader {

	private static final URL XML_URL = Test_XmlPropResourceI18nLoader.class
			.getResource("/com/dwarfeng/dutil/resources/test/develop/i18n/i18n_resource.xml");
	private static I18nHandler handler = null;
	private static XmlPropResourceI18nLoader loader = null;

	@Before
	public void setUp() throws Exception {
		handler = new DelegateI18nHandler();
		loader = new XmlPropResourceI18nLoader(XML_URL.openStream());
	}

	@Test(expected = LoadFailedException.class)
	public void testLoadException() throws LoadFailedException, IllegalStateException {
		loader.load(handler);
	}

	@Test
	public void testLoad() {
		try {
			loader.load(handler);
		} catch (LoadFailedException | IllegalStateException ignore) {
		}

		assertEquals(2, handler.size());
		assertTrue(handler.containsKey(Locale.CHINA));
		assertTrue(handler.containsKey(Locale.US));
		assertFalse(handler.containsKey(Locale.JAPANESE));
		assertTrue(handler.setCurrentLocale(Locale.CHINA));
		assertEquals("你好", handler.getCurrentI18n().getString("hello"));
		assertTrue(handler.setCurrentLocale(Locale.US));
		assertEquals("hello", handler.getCurrentI18n().getString("hello"));
	}

	@Test(expected = LoadFailedException.class)
	public void testLoad1() throws LoadFailedException, IllegalStateException {
		loader.load(handler);
	}

	@Test
	public void testCountinuousLoad() {
		Set<LoadFailedException> exceptions = loader.countinuousLoad(handler);
		assertEquals(1, exceptions.size());
		assertEquals(3, handler.size());
		assertTrue(handler.containsKey(Locale.CHINA));
		assertTrue(handler.containsKey(Locale.US));
		assertTrue(handler.containsKey(Locale.JAPAN));
		assertTrue(handler.setCurrentLocale(Locale.CHINA));
		assertEquals("你好", handler.getCurrentI18n().getString("hello"));
		assertTrue(handler.setCurrentLocale(Locale.US));
		assertEquals("hello", handler.getCurrentI18n().getString("hello"));
		assertTrue(handler.setCurrentLocale(Locale.JAPAN));
		assertEquals("今日は", handler.getCurrentI18n().getString("hello"));
	}

}
