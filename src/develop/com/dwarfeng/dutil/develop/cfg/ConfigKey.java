package com.dwarfeng.dutil.develop.cfg;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.str.Name;

/**
 * ���ü���
 * <p> ���ü���һ�� {@link Name}���󣬷�װһ���ַ�����
 * @author DwArFeng
 * @since 1.8
 */
public class ConfigKey implements Name{

	/**���ü�������*/
	protected final String name;
	
	/**
	 * �µ����ü���
	 * @param name ָ�������ơ�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public ConfigKey(String name) {
		Objects.requireNonNull(name, DwarfUtil.getStringField(StringFieldKey.ConfigKey_0));
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dutil.basic.str.Name#getName()
	 */
	@Override
	public final String getName() {
		return this.name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(Objects.isNull(obj)) return false;
		if(obj == this) return true;
		if(! (obj instanceof ConfigKey)) return false;
		ConfigKey configKey = (ConfigKey) obj;
		return this.name.equals(configKey.name);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode() * 17;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
				.append("ConfigKey [name = ")
				.append(name)
				.append("]")
				.toString();
	}
}
