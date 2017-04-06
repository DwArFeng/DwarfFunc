package com.dwarfeng.dutil.develop.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.dwarfeng.dutil.basic.prog.WithKey;

/**
 * ������ʹ�õ���Դ��
 * @author DwArFeng
 * @since 0.0.1-alpha
 */
public interface Resource extends WithKey<String>{

	/**
	 * ����Դ����������
	 * @return ��Դ����������
	 * @throws IOException IO�쳣��
	 */
	public InputStream openInputStream() throws IOException;
	
	/**
	 * ����Դ���������
	 * @return ��Դ���������
	 * @throws IOException IO�쳣��
	 */
	public OutputStream openOutputStream() throws IOException;
	
	/**
	 * ���ļ���Դ�û���Ĭ�ϵ���Դ��
	 * @throws IOException IO�쳣��
	 */
	public void reset() throws IOException;
	
}
