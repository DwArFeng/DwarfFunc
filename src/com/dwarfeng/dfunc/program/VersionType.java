package com.dwarfeng.dfunc.program;

import com.dwarfeng.dfunc.infs.Nameable;

/**
 * ����г����İ汾���͡�
 * @author DwArFeng
 * @since 1.8
 */
public enum VersionType implements Nameable{

	/**�ڲ�汾*/
	ALPHA("Alpha"),
	/**����汾*/
	BETA("Beta"),
	/**�����汾*/
	RELEASE("Release"),
	/**Ԥ���汾*/
	SNAPSHOTS("Snapshots");
	
	private final String name;
	
	VersionType(String name){
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
