package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Properties;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigModel;

/**
 * Properties ���ñ�������
 * <p>
 * �����ñ����������������ļ���ʽ���� java �� properties �ļ���ʽ������ <blockquote> <code>
 * 			# ע��...<br>
 * 			Config_0 = TURE<br>
 * 			Config_1 = FALSE<br>
 * 			Config_2 = 12.450
 * 		</code> </blockquote> ���� �Ⱥ���ߵ��Ǽ����Ⱥ��ұߵ���ֵ��
 * 
 * @deprecated ������ {@link PropConfigSaver} ���档
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class PropertiesConfigSaver extends StreamConfigSaver implements ConfigSaver {

	/**
	 * ����һ���µ� Properties ���ñ�������
	 * 
	 * @param out
	 *            ָ�����������
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public PropertiesConfigSaver(OutputStream out) {
		super(out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.io.ConfigSaver#saveConfig(com.dwarfeng.
	 * dutil.develop.cfg.ConfigModel)
	 */
	@Override
	@Deprecated
	public void saveConfig(ConfigModel configModel) throws SaveFailedException {
		Objects.requireNonNull(configModel, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_0));

		Properties properties = new Properties();
		for (ConfigKey configKey : configModel.keySet()) {
			properties.setProperty(configKey.getName(), configModel.getCurrentValue(configKey));
		}
		try {
			properties.store(out, null);
		} catch (IOException e) {
			SaveFailedException sfe = new SaveFailedException(e.getMessage(), e.getCause());
			sfe.setStackTrace(e.getStackTrace());
			throw sfe;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.cfg.io.ConfigSaver#save(com.dwarfeng.dutil.
	 * develop.cfg.ConfigModel)
	 */
	@Override
	public void save(ConfigModel configModel) throws SaveFailedException {
		saveConfig(configModel);
	}

}
