package com.dwarfeng.dfunc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ��IO�ӿ��йص�һЩ���ܡ�
 * @author DwArFeng
 * @since 1.8
 */
public final class IOFunction {
	
	/**
	 * ���ݴ��ͷ�����
	 * <p>��һ���������е��������ݴ��ݸ�һ���������
	 * @param in ָ������������
	 * @param out ָ�����������
	 * @param bufferSize ָ���Ļ���Ĵ�С��
	 * @throws IOException �������޷���ȡ�������޷�д��ʱ�׳����쳣��
	 */
	public static  void trans(InputStream in,OutputStream out,int bufferSize) throws IOException{
		if(in == null || out == null) throw new NullPointerException("InputStream or OutputStream can't be null");
		BufferedInputStream bin = new BufferedInputStream(in,bufferSize);
		BufferedOutputStream bout = new BufferedOutputStream(out,bufferSize);
		byte[] buffer = new byte[bufferSize];
		int i = 0;
		while(( i = bin.read(buffer,0,buffer.length))>= 0){
			bout.write(buffer, 0, i);
			bout.flush();
		}
	}
	
	//��ֹ�ⲿ����ʵ����
	private IOFunction(){}
}
