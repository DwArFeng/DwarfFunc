package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * ���ñ�������
 * <p> ���ڱ���ָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigSaver {
	
	/**
	 * ����ָ�������á�
	 * <p> ���ñ���������������ñ���ģ�͵�����ͨ��һ�����������б��棬ͨ�����������Ὣ��ͬ�����ñ���ģ���е����ñ�����һ���ļ��
	 * <br> �磺
	 * <code>
	 * 	<pre>
	 * public void mutiSave(ConfigSaver saver, ConfigReflect[] crs) throws SaveFailedException{
	 * 	for(ConfigReflect cr : crs){
	 * 		saver.saveConfig(cr);
	 * 	}
	 * }
	 * 	</pre>
	 * </code>
	 * ��Ҫע����ǣ����Ҫ��������ñ���ģ�͵�����ͨ��һ���������洢������뱣֤���е����ñ���ģ�Ͳ�������ͬ�����ü���
	 * �����������ü��ĸ��ǡ�
	 * @param configReflect ָ��������ӳ�䡣
	 * @throws IOException IO�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void saveConfig(ConfigModel configReflect) throws SaveFailedException;

}
