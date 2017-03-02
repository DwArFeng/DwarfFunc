package com.dwarfeng.dutil.develop.cfg.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

import com.dwarfeng.dutil.basic.io.StreamSaver;

/**
 * �����ñ�������
 * @deprecated ������ {@link StreamSaver} �����
 * <p> �������ʵ�ֵ����ñ�������
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public abstract class StreamConfigSaver implements ConfigSaver, Closeable{

	/**�����*/
	protected OutputStream out;
	
	/**
	 * ���������ñ�������
	 * @param out ָ�����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public StreamConfigSaver(OutputStream out) {
		this.out = out;
	}

	/*
	 * (non-Javadoc)
	 * @see java.io.Closeable#close()
	 */
	@Override
	public void close() throws IOException {
		out.close();
	}

}
