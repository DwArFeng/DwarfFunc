package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;

import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigPort;

/**
 * ���ñ�������
 * <p> ���ڱ���ָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigSaver {
	
	/**
	 * ����ָ�������á�
	 * <p> ���ñ����������������վ�������ͨ��һ�����������б��棬ͨ�����������Ὣ��ͬ������վ���е����ñ�����һ���ļ��
	 * <br> �磺
	 * <code>
	 * 	<pre>
	 * public void mutiSave(ConfigSaver saver, ConfigPort[] cps) throws SaveFailedException{
	 * 	for(ConfigPort cp : cps){
	 * 		saver.saveConfig(cp);
	 * 	}
	 * }
	 * 	</pre>
	 * </code>
	 * ��Ҫע����ǣ����Ҫ���������վ�������ͨ��һ���������洢������뱣֤���е�����վ�㲻������ͬ�����ü���
	 * �����������ü��ĸ��ǡ�
	 * @param configPort ָ�������á�
	 * @throws IOException IO�쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public void saveConfig(ConfigPort configPort) throws SaveFailedException;

}
