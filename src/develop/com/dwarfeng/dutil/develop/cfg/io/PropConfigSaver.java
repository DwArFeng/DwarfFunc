package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import com.dwarfeng.dutil.basic.io.CT;
import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigReflect;

/**
 * Properties ���ñ�������
 * <p> �����ñ����������������ļ���ʽ���� java �� properties �ļ���ʽ������
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
public class PropConfigSaver extends StreamConfigSaver implements ConfigSaver {
	
	/**
	 * ����һ���µ� Properties ���ñ�������
	 * @param out ָ�����������
	 */
	public PropConfigSaver(OutputStream out) {
		super(out);
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.develop.cfg.io.ConfigSaver#saveConfig(com.dwarfeng.dutil.develop.cfg.ConfigPerformModel)
	 */
	@Override
	public void saveConfig(ConfigReflect configReflect) throws SaveFailedException {
		Properties properties = new Properties();
		for(Map.Entry<ConfigKey, String> entry : configReflect.getCurrentValueMap().entrySet()){
			properties.put(entry.getKey().getName(), entry.getValue());
			CT.trace(entry.getKey());
		}
		try {
			properties.store(out, null);
		} catch (IOException e) {
			SaveFailedException sfe = new SaveFailedException(e.getMessage());
			sfe.setStackTrace(e.getStackTrace());
			throw sfe;
		}
	}

}
