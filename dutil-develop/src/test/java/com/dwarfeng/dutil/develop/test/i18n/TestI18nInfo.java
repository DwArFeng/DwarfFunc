package com.dwarfeng.dutil.develop.test.i18n;

import java.util.Locale;

import com.dwarfeng.dutil.develop.i18n.I18n;
import com.dwarfeng.dutil.develop.i18n.I18nInfo;

class TestI18nInfo implements I18nInfo {

	public static final TestI18nInfo CHINESE = new TestI18nInfo(Locale.CHINA, "简体中文", new I18n() {

		@Override
		public String getStringOrDefault(String key, String defaultString) {
			if (key.equals("hello")) {
				return "你好";
			} else {
				return defaultString;
			}
		}

		@Override
		public String getString(String key) {
			if (key.equals("hello")) {
				return "你好";
			} else {
				return null;
			}
		}
	});
	public static final TestI18nInfo ENGLISH = new TestI18nInfo(Locale.ENGLISH, "English", new I18n() {

		@Override
		public String getStringOrDefault(String key, String defaultString) {
			if (key.equals("hello")) {
				return "hello";
			} else {
				return defaultString;
			}
		}

		@Override
		public String getString(String key) {
			if (key.equals("hello")) {
				return "hello";
			} else {
				return null;
			}
		}

	});
	public static final TestI18nInfo JAPANESE = new TestI18nInfo(Locale.JAPANESE, "日本語", new I18n() {

		@Override
		public String getStringOrDefault(String key, String defaultString) {
			if (key.equals("hello")) {
				return "今日は";
			} else {
				return defaultString;
			}
		}

		@Override
		public String getString(String key) {
			if (key.equals("hello")) {
				return "今日は";
			} else {
				return null;
			}
		}
	});

	public static final TestI18nInfo DEFAULT = new TestI18nInfo(null, "日本語", new I18n() {

		@Override
		public String getStringOrDefault(String key, String defaultString) {
			if (key.equals("hello")) {
				return "你好";
			} else {
				return defaultString;
			}
		}

		@Override
		public String getString(String key) {
			if (key.equals("hello")) {
				return "你好";
			} else {
				return null;
			}
		}
	});

	private final Locale key;
	private final String name;
	private final I18n i18n;

	public TestI18nInfo(Locale key, String name, I18n i18n) {
		this.key = key;
		this.name = name;
		this.i18n = i18n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.WithKey#getKey()
	 */
	@Override
	public Locale getKey() {
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.str.Name#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.i18n.I18nInfo#newI18n()
	 */
	@Override
	public I18n newI18n() throws Exception {
		return i18n;
	}

}
