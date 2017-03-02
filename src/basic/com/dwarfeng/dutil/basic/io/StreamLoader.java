package com.dwarfeng.dutil.basic.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * ���Ƕ�ȡ����
 * <p> ����ʵ�ֵĶ�ȡ����
 * @author DwArFeng
 * @since 0.0.3-beta
 */
public abstract class StreamLoader<T> implements Closeable, Loader<T>{
	
	/**��������*/
	protected final InputStream in;

	/**
	 * ��ʵ����
	 * @param in ָ������������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public StreamLoader(InputStream in) {
		Objects.requireNonNull(in, DwarfUtil.getStringField(StringFieldKey.StreamLoader_0));
		this.in = in;
	}

	/*
	 * (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close() throws IOException {
		this.in.close();
	}

}
