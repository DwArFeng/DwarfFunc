package com.dwarfeng.dutil.basic.str;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * Ĭ�ϱ�ǩ��
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class DefaultTag implements Tag{

	/**����*/
	protected final String name;
	/**����*/
	protected final String description;
	
	/**
	 * �½�һ������ָ�����ƣ�ָ��������Ĭ�ϱ�ǩ��
	 * @param name ָ�������ơ�
	 * @param description ָ����������
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public DefaultTag(String name, String description) {
		Objects.requireNonNull(name, DwarfUtil.getStringField(StringFieldKey.DefaultTag_0));
		Objects.requireNonNull(name, DwarfUtil.getStringField(StringFieldKey.DefaultTag_1));
		this.name = name;
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.str.Name#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.str.Description#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

}
