package com.dwarfeng.dutil.develop.cfg.io;

import java.io.OutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.io.SaveFailedException;
import com.dwarfeng.dutil.basic.io.StreamSaver;
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
 * @author DwArFeng
 * @since 0.0.3-beta
 */
public class PropConfigSaver extends StreamSaver<CurrentValueContainer> {

	private boolean flag = true;

	/**
	 * ����һ���µ� Properties ���ñ�������
	 * 
	 * @param out
	 *            ָ�����������
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public PropConfigSaver(OutputStream out) {
		super(out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.io.Saver#save(java.lang.Object)
	 */
	@Override
	public void save(CurrentValueContainer container) throws SaveFailedException {
		if (flag) {
			flag = false;
		} else {
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_1));
		}
		Objects.requireNonNull(container, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_0));

		Properties properties = new Properties();
		for (Map.Entry<ConfigKey, String> entry : container.getAllCurrentValue().entrySet()) {
			properties.setProperty(entry.getKey().getName(), entry.getValue());
		}
		try {
			properties.store(out, null);
		} catch (Exception e) {
			throw new SaveFailedException(e.getMessage(), e.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.io.Saver#countinuousSave(java.lang.Object)
	 */
	@Override
	public Set<SaveFailedException> countinuousSave(CurrentValueContainer container) throws IllegalStateException {
		if (flag) {
			flag = false;
		} else {
			throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_1));
		}
		Objects.requireNonNull(container, DwarfUtil.getStringField(StringFieldKey.PropertiesConfigSaver_0));

		final Set<SaveFailedException> exceptions = new HashSet<>();

		Properties properties = new Properties();
		for (Map.Entry<ConfigKey, String> entry : container.getAllCurrentValue().entrySet()) {
			properties.setProperty(entry.getKey().getName(), entry.getValue());
		}
		try {
			properties.store(out, null);
		} catch (Exception e) {
			exceptions.add(new SaveFailedException(e.getMessage(), e.getCause()));
		}

		return exceptions;
	}

}
