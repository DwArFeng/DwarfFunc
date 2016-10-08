package com.dwarfeng.dutil.basic.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

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
		Objects.requireNonNull(string, DwarfUtil.getStringField(StringFieldKey.StringInputStream_0));
		Objects.requireNonNull(charset, DwarfUtil.getStringField(StringFieldKey.StringInputStream_1));
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
