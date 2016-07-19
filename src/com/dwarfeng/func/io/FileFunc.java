package com.dwarfeng.func.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ʵ���ļ��������ࡣ
 * <p>ʵ�ֵ��ļ�����ĿǰΪ���ơ�
 * @author DwArFeng
 * @since 1.8
 */
public class FileFunc {

	
	/**
	 * ��һ���ļ����Ƶ���һ���ļ���
	 * @param source ��Ҫ���Ƶ�Դ�ļ���
	 * @param target ��Ҫ���Ƶ���Ŀ���ļ���
	 * @throws IOException ���ƹ�����IO�����쳣���׳����쳣��
	 */
	public static void FileCopy(File source,File target) throws IOException{
		//���target�����ڣ��򴴽�target�Լ���Ŀ¼���б�Ҫ�Ļ�����
		createFileIfNotExists(target);
		//����2MB�Ļ����С
		int bufferSize = 2097152;
		int length = 0;
		//�������������
		FileInputStream in = new FileInputStream(source);
		FileOutputStream out = new FileOutputStream(target);
		//��ȡͨ��
		FileChannel inC = in.getChannel();
		FileChannel outC = out.getChannel();
		//�����ֽڻ���
		ByteBuffer buffer = null;
		while(true){
			//�ж����
			if(inC.position() == inC.size()){
				in.close();
				out.close();
				inC.close();
				outC.close();
				return;
			}
			//�����ֽڻ���
			length = (int) (inC.size() - inC.position() < bufferSize ? inC.size() - inC.position():bufferSize);
			buffer = ByteBuffer.allocateDirect(length);
			//��������
			inC.read(buffer);
			buffer.flip();
			outC.write(buffer);
		}
	}
	/**
	 * �ļ�/�ļ��е�ɾ��������
	 * <p> �÷������Ŀ���ļ�����ɾ�������Ŀ���ļ��Ǳ�׼�ļ��Ļ�����ɾ�����ļ���
	 * <br> ���Ŀ���ļ����ļ��еĻ������ɾ�����ļ��У������ļ����е������ļ������ļ��С����ļ����е��ļ��ȵȣ���
	 * @param file Ŀ���ļ����ļ��С�
	 * @return �ļ����ļ����Ƿ�ɾ����
	 */
	public static boolean deleteFile(File file){
		if(file.isDirectory()){
			String[] children = file.list();
			//�ݹ�ɾ����Ŀ¼����Ŀ¼�ļ�
			for(int i = 0 ; i < children.length ; i ++){
				boolean success = deleteFile(new File(file,children[i]));
				if(!success) return false;
			}
		}
		//Ŀ¼��ʱΪ�գ�����ɾ��
		return file.delete();
	}
	/**
	 * ���ָ�����ļ������ڣ������½��ļ��ķ�����
	 * <p> �÷����ڽ����ļ�ʱ���Ὣ���Ŀ¼һͬ������������и�Ŀ¼�Ļ�����
	 * @param file ָ�����ļ���
	 * @throws IOException �ļ��޷���������ͨ�Ŵ���ʱ�׳����쳣��
	 */
	public static void createFileIfNotExists(File file) throws IOException{
		//����ļ����ڣ���ʲô��Ҳ������
		if(file.exists()) return;
		File parentFile = file.getParentFile();
		if(parentFile != null && !parentFile.exists()) parentFile.mkdirs();
		file.createNewFile();
	}
	
	//������ʵ����
	private FileFunc() {}

}
