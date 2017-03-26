package com.dwarfeng.dutil.test.basic.cna.model;

import java.util.Objects;

import com.dwarfeng.dutil.basic.prog.WithKey;

public class TestWithKey implements WithKey<String> {

	public static final TestWithKey ELE_1 = new TestWithKey("A", "1");
	public static final TestWithKey ELE_2 = new TestWithKey("B", "2");
	public static final TestWithKey ELE_3 = new TestWithKey("C", "3");
	public static final TestWithKey ELE_4 = new TestWithKey("D", "4");
	public static final TestWithKey ELE_5 = new TestWithKey("E", "5");
	public static final TestWithKey ELE_6 = new TestWithKey("F", "6");
	public static final TestWithKey ELE_7 = new TestWithKey("G", "7");
	public static final TestWithKey ELE_8 = new TestWithKey("H", "8");

	public static final TestWithKey FAIL_ELE = new TestWithKey("A", "5");

	private final String key;
	private final String value;

	private TestWithKey(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.WithKey#getKey()
	 */
	@Override
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.prog.WithKey#isConflict(com.dwarfeng.dutil.basic
	 * .prog.WithKey)
	 */
	@Override
	public boolean isConflict(WithKey<String> element) {
		if (Objects.isNull(element))
			return false;
		if (!element.getKey().equals(key))
			return false;
		return !Objects.equals(element, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof TestWithKey))
			return false;
		TestWithKey that = (TestWithKey) obj;
		return that.key.equals(this.key) && that.value.equals(this.value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return key.hashCode() * 17 + value.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestWithKey [key=" + key + ", value=" + value + "]";
	}

}
