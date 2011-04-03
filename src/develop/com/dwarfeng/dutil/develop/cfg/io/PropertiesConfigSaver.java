package com.dwarfeng.dutil.develop.cfg.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.CurrentValueContainer;

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
	 * dutil.develop.cfg.io.CurrentValueContainer)
	 */
	@Override
	@Deprecated
	public void saveConfig(CurrentValueContainer container) throws SaveFailedException {
		Objects.requireNonNull(container, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_0));

		Properties properties = new Properties();
		for (Map.Entry<ConfigKey, String> entry : container.getAllCurrentValue().entrySet()) {
			properties.setProperty(entry.getKey().getName(), entry.getValue());
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
	 * develop.cfg.io.CurrentValueContainer)
	 */
	@Override
	public void save(CurrentValueContainer container) throws SaveFailedException {
		saveConfig(container);
	}

}
