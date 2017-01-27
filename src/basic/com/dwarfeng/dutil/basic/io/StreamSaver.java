package com.dwarfeng.dutil.basic.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.prog.Saver;

/**
 * ����������
 * <p> ����ʵ�ֵı�������
 * @author  DwArFeng
 * @since 0.0.3-beta
 */
public abstract class StreamSaver<T> implements Closeable, Saver<T> {

	/**�������е������*/
	protected final OutputStream out;
	
	/**
	 * ��ʵ����
	 * @param out ָ�����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public StreamSaver(OutputStream out) {
		Objects.requireNonNull(out, DwarfUtil.getStringField(StringFieldKey.StreamSaver_0));
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
