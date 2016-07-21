package com.dwarfeng.dwarffunction.program;

import com.dwarfeng.dwarffunction.interfaces.Nameable;

/**
 * ����г����İ汾���͡�
 * @author DwArFeng
 * @since 1.8
 */
public enum PVersionType implements Nameable{

	/**�ڲ�汾*/
	ALPHA("alpha"),
	/**����汾*/
	BETA("beta"),
	/**�����汾*/
	RELEASE("release"),
	/**Ԥ���汾*/
	SNAPSHOTS("snapshots");
	
	private final String name;
	
	PVersionType(String name){
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
