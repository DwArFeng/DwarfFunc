package com.dwarfeng.dutil.basic.prog;

import com.dwarfeng.dutil.basic.str.Name;

/**
 * ����г����İ汾���͡�
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public enum VersionType implements Name{

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
