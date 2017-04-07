package com.dwarfeng.dutil.basic.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.num.NumberUtil;

/**
 * 字符串构造输出流。
 * <p> 该输出流将输出的数据存储到字符串构造器中，是输出流与文本的桥梁。
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class StringOutputStream extends OutputStream {
	
	/**字符串构造器*/
	protected final StringBuilder stringBuilder;
	/**字节缓冲*/
	protected final List<Byte> buffer;
	/**指定的字符集合*/
	protected final Charset charset;

	/**
	 * 生成一个默认的字符串构造输出流。
	 */
	public StringOutputStream() {
		this(Charset.defaultCharset());
	}
	
	
	/**
	 * 生成一个字符集合指定，缓冲容量指定的字符串构造输出流。
	 * @param charset 指定的字符集合。
	 * @throws NullPointerException 入口参数charset 为 <code>null</code>。
	 */
	public StringOutputStream(Charset charset){
		Objects.requireNonNull(charset, DwarfUtil.getStringField(StringFieldKey.STRINGOUTPUTSTREAM_0));
		this.charset = charset;
		stringBuilder = new StringBuilder();
		buffer = new ArrayList<Byte>();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int b) throws IOException {
		buffer.add(NumberUtil.cutInt2Byte(b));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[], int, int)
	 */
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		b = Arrays.copyOfRange(b, off, off + len);
		write(b);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
	@Override
	public void write(byte[] b) throws IOException {
		Byte[] bs = ArrayUtil.pack(b);
		buffer.addAll(Arrays.asList(bs));
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.OutputStream#flush()
	 */
	@Override
	public void flush() throws IOException {
		String str = new String(ArrayUtil.unpack(buffer.toArray(new Byte[0])));
		stringBuilder.append(str);
		buffer.clear();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.OutputStream#close()
	 */
	@Override
	public void close() throws IOException {
		flush();
		super.close();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return stringBuilder.toString();
	}

}
