package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
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
public class PropConfigLoader extends StreamConfigLoader implements ConfigLoader {

	/**
	 * ����һ���µ� Properties ���ö�ȡ����
	 * @param in ָ������������
	 */
	public PropConfigLoader(InputStream in) throws IOException {
		super(in);
	}
	
}
