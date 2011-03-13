package com.dwarfeng.dutil.develop.cfg.io;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.io.LoadFailedException;
import com.dwarfeng.dutil.basic.io.StreamLoader;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.CurrentValueContainer;

/**
 * Properties ���ö�ȡ����
 * <p>
 * �����ö�ȡ���������ȡ���ļ���ʽ���� java �� properties �ļ���ʽ������ <blockquote> <code>
 * 			# ע��...<br>
 * 			Config_0 = TURE<br>
 * 			Config_1 = FALSE<br>
 * 			Config_2 = 12.450
 * 		</code> </blockquote> ���� �Ⱥ���ߵ��Ǽ����Ⱥ��ұߵ���ֵ��
 * 
 * @author DwArFeng
 * @since 0.0.3-beta
 */
public class PropConfigLoader extends StreamLoader<CurrentValueContainer> {

	private boolean flag = true;

	/**
	 * ����һ���µ� Properties ���ö�ȡ����
	 * 
	 * @param in
	 *            ָ������������
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public PropConfigLoader(InputStream in) {
		super(in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.io.Loader#load(java.lang.Object)
	 */
	@Override
	public void load(CurrentValueContainer container) throws LoadFailedException {
		if (flag) {
			flag = false;
		} else {
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.PropertiesConfigLoader_1));
		}
		Objects.requireNonNull(container, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigLoader_0));

		Properties properties = new Properties();
		try {
			properties.load(in);
			Map<ConfigKey, String> configMap = new HashMap<ConfigKey, String>();
			for (String str : properties.stringPropertyNames()) {
				configMap.put(new ConfigKey(str), properties.getProperty(str));
			}
			container.setAllCurrentValue(configMap);

		} catch (Exception e) {
			throw new LoadFailedException(e.getMessage(), e.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.io.Loader#countinuousLoad(java.lang.Object)
	 */
	@Override
	public Set<LoadFailedException> countinuousLoad(CurrentValueContainer container) throws IllegalStateException {
		if (flag) {
			flag = false;
		} else {
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.PropertiesConfigLoader_1));
		}
		Objects.requireNonNull(container, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigLoader_0));

		final Set<LoadFailedException> exceptions = new HashSet<>();

		Properties properties = new Properties();
		try {
			properties.load(in);
			Map<ConfigKey, String> configMap = new HashMap<ConfigKey, String>();
			for (String str : properties.stringPropertyNames()) {
				configMap.put(new ConfigKey(str), properties.getProperty(str));
			}
			container.setAllCurrentValue(configMap);

		} catch (Exception e) {
			exceptions.add(new LoadFailedException(e.getMessage(), e.getCause()));
		}

		return exceptions;
	}

}
