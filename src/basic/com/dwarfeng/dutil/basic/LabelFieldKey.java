package com.dwarfeng.dutil.basic;

import com.dwarfeng.dutil.basic.str.DefaultName;
import com.dwarfeng.dutil.basic.str.Name;

/**
 * ������߰�ʹ�õı�ǩ�ı��ֶΡ�
 * <p>
 * �� {@link StringFieldKey} ��ͬ���ǣ���ǩ�ı��ֶ����п�����Ҫ�����л����Եġ�
 * <p>
 * ��ö���Ƕ���ʹ�õģ�������Ҫ�����Ƿ��س���������Ҫ�ı�ǩ�ı��ֶΡ� <br>
 * �벻Ҫ���ⲿ�����е��ô˰���ö�٣���Ϊ�ð���Ҫ�Ƕ���ʹ�ã��䱾����֤�����ԡ�
 * <p>
 * <b>ע�⣺</b> �ð�����Ƶ�ʱ�򲻿��Ǽ����ԣ������������ϼ��ݵĸĶ�ʱ������û�������ڱ����־��˵����
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public enum LabelFieldKey implements Name {

	/** JExconsole���0���ı��ֶ� */
	JEXCONSOLE_0(new DefaultName("JExconsole.label.0")),
	/** JExconsole���1���ı��ֶ� */
	JEXCONSOLE_1(new DefaultName("JExconsole.label.1")),
	/** JExconsole���2���ı��ֶ� */
	JEXCONSOLE_2(new DefaultName("JExconsole.label.2")),

	;

	private final Name name;

	private LabelFieldKey(Name name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.str.Name#getName()
	 */
	@Override
	public String getName() {
		return name.getName();
	}

}
