package com.dwarfeng.dfunc.io;

import java.io.File;
import java.io.FileFilter;

/**
 * ������չ�������ļ�ɸѡ���ļ�ɸѡ����
 * @author DwArFeng
 * @since 1.8
 */
public final class FileExtensionNameFiliter implements FileFilter {

	private String extenstionName;
	
	/**
	 * ����һ������ָ����չ������չ��ɸѡ����
	 * @param extensionName ָ������չ����
	 */
	public FileExtensionNameFiliter(String extensionName) {
		this.extenstionName = extensionName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File file) {
		return file.getName().endsWith(extenstionName);
	}
	
}
