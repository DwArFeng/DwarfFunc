package com.dwarfeng.dutil.develop.cfg.io;

import java.util.Map;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;

/**
 * ���ö�ȡ����
 * <p> ���ڶ�ȡָ�������á�
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigLoader {
	
	/**
	 * ��ȡָ�������á�
	 * <p> ���ö�ȡ����ȡ���ĵ�ǰֵӳ�����ͬʱ���ø��������վ�㣬ÿ������վ����ԡ���ȡ���衱��
	 * �ֱ��ȡ�����Լ������ü���
	 * <br>�磺
	 * <pre>
	 * <code>
	 * public void mutiLoad(ConfigLoader loader, ConfigReflect[] crs){
	 * 	Map<ConfigKey, String> map = loader.loadConfig();
	 * 	for(ConfigReflect cr : crs){
	 * 		cr.setAll(map);
	 * 	}
	 * }
	 * </code>
	 * </pre>
	 * @return ָ�����õĵ�ǰֵӳ�䡣
	 * @throws LoadFailedException ��ȡ�쳣��
	 */
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException;

}
