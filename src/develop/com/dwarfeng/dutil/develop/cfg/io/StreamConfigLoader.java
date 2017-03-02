package com.dwarfeng.dutil.develop.cfg.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.io.StreamLoader;

/**
 * �����ö�ȡ����
 * @deprecated ������ {@link StreamLoader} �����
 * <p> ʹ��������ʵ�ֵ����ö�ȡ����
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public abstract class StreamConfigLoader implements ConfigLoader, Closeable{

	/**������*/
	protected final InputStream in;
	
	/**
	 * ���������ö�ȡ����
	 * @param in ָ������������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public StreamConfigLoader(InputStream in) {
		Objects.requireNonNull(in, DwarfUtil.getStringField(StringFieldKey.StreamConfigLoader_0));
		this.in = in;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close() throws IOException {
		in.close();
	}

}
