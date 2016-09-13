package com.dwarfeng.dfunc.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

/**
 * �ַ�����������
 * <p> ����������ָ�����ַ����ж������ݡ�
 * @author DwArFeng
 * @since 1.8
 */
public class StringInputStream extends InputStream {

	private final byte[] bytes;
	private int index = 0;
	
	/**
	 * ����һ������ָ���ַ������ַ�����������
	 * @param string ָ�����ַ�����
	 * @throws NullPointerException ��ڲ��� <code>string</code>Ϊ <code>null</code>��
	 */
	public StringInputStream(String string) {
		this(string, Charset.defaultCharset());
	}
	
	/**
	 * ����һ������ָ���ַ����ģ�ʹ��ָ���ַ������ַ�����������
	 * @param string ָ�����ַ�����
	 * @param charset ָ�����ַ�����
	 * @throws NullPointerException ��ڲ��� <code>string</code>Ϊ <code>null</code>��
	 * @throws NullPointerException ��ڲ��� <code>charset</code> Ϊ <code>null</code>��
	 */
	public StringInputStream(String string, Charset charset){
		Objects.requireNonNull(string, DwarfFunction.getStringField(StringFiledKey.StringInputStream_0));
		Objects.requireNonNull(charset, DwarfFunction.getStringField(StringFiledKey.StringInputStream_1));
		this.bytes = string.getBytes(charset);
	}

	/*
	 * (non-Javadoc)
	 * @see java.io.InputStream#read()
	 */
	@Override
	public int read() throws IOException {
		if(index >= bytes.length){
			return -1;
		}
		return bytes[index ++];
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.InputStream#reset()
	 */
	@Override
	public synchronized void reset() throws IOException {
		index = 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.InputStream#available()
	 */
	@Override
	public int available() throws IOException {
		return bytes.length;
	}

}
