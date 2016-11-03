package com.dwarfeng.dutil.develop.cfg.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * 流配置读取器。
 * <p> 使用输入流实现的配置读取器。
 * @author  DwArFeng
 * @since 1.8
 */
public abstract class StreamConfigLoader implements ConfigLoader, Closeable{

	/**输入流*/
	protected final InputStream in;
	
	/**
	 * 生成流配置读取器。
	 * @param in 指定的输入流。
	 * @throws NullPointerException 入口参数为 <code>null</code>。
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
