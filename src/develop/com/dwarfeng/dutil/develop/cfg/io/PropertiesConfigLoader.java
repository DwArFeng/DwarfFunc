package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;

/**
 * Properties ���ö�ȡ����
 * <p> �����ö�ȡ���������ȡ���ļ���ʽ���� java �� properties �ļ���ʽ������
 * <blockquote>
 * 		<code>
 * 			# ע��...<br>
 * 			Config_0 = TURE<br>
 * 			Config_1 = FALSE<br>
 * 			Config_2 = 12.450
 * 		</code>
 * </blockquote>
 * ���� �Ⱥ���ߵ��Ǽ����Ⱥ��ұߵ���ֵ��
 * @author  DwArFeng
 * @since 1.8
 */
public class PropertiesConfigLoader extends StreamConfigLoader implements ConfigLoader {

	/**
	 * ����һ���µ� Properties ���ö�ȡ����
	 * @param in ָ������������
	 */
	public PropertiesConfigLoader(InputStream in){
		super(in);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.io.ConfigLoader#loadConfig()
	 */
	@Override
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException {
		Properties properties = new Properties();
		try{
			properties.load(in);
			Map<ConfigKey, String> configMap = new HashMap<ConfigKey, String>();
			for(String str : properties.stringPropertyNames()){
				configMap.put(new ConfigKey(str), properties.getProperty(str));
			}
			return configMap;
			
		}catch (IOException e) {
			LoadFailedException lfe = new LoadFailedException(e.getMessage(), e.getCause());
			lfe.setStackTrace(e.getStackTrace());
			throw lfe;
		}
	}
	
}
