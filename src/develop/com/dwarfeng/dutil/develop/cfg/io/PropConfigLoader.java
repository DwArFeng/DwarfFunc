package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigUtil;

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
public class PropConfigLoader extends StreamConfigLoader implements ConfigLoader {

	/**
	 * ����һ���µ� Properties ���ö�ȡ����
	 * @param in ָ������������
	 */
	public PropConfigLoader(InputStream in) throws IOException {
		super(in);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.io.ConfigLoader#loadConfig()
	 */
	@Override
	public Map<ConfigKey, String> loadConfig() throws LoadFailedException {
		Properties properties = new Properties();
		try {
			properties.load(this.in);
		} catch (IOException e) {
			LoadFailedException lfe = new LoadFailedException(e.getMessage());
			lfe.setStackTrace(e.getStackTrace());
			throw lfe;
		}
		Map<ConfigKey, String> map = new LinkedHashMap<>();
		for(Entry<Object, Object> entry : properties.entrySet()){
			ConfigKey key = new ConfigKey(entry.getKey().toString());
			String value = entry.getValue().toString();
			map.put(key, value);
		}
		return map;
	}
	
}
