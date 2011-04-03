package com.dwarfeng.dutil.develop.cfg.parser;

import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * ������ֵ��������
 *  <p> �ý������������� <code>int</code> ����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class IntegerValueParser implements ValueParser {

	private int radix;

	/**
	 * ����һ��ʮ���Ƶ�������ֵ��������
	 */
	public IntegerValueParser() {
		this(10);
	}

	/**
	 * ����һ������Ϊָ��ֵ��������ֵ��������
	 * 
	 * @param radix
	 *            ָ���Ľ��ơ�
	 */
	public IntegerValueParser(int radix) {
		// TODO �ж� radix �Ƿ�Խ�硣
		this.radix = radix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.struct.ValueParser#parseValue(java.lang.
	 * String)
	 */
	@Override
	public Object parseValue(String value) {
		return Integer.parseInt(value, radix);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.struct.ValueParser#parseObject(java.lang.
	 * Object)
	 */
	@Override
	public String parseObject(Object object) {
		return Integer.toString((int) object, radix);
	}

}
