package com.dwarfeng.dwarffunction.program;

/**
 * ����г����İ汾���͡�
 * @author DwArFeng
 * @since 1.8
 */
public enum VersionType {

	/**�ڲ�汾*/
	ALPHA("alpha"),
	/**����汾*/
	BETA("beta"),
	/**�����汾*/
	RELEASE("release"),
	/**Ԥ���汾*/
	SNAPSHOTS("snapshots");
	
	private final String label;
	
	VersionType(String label){
		this.label = label;
	}
	
	/**
	 * ���ذ汾�ı�ǩ��
	 * @return �汾�ı�ǩ��
	 */
	public String getLabel(){
		return this.label;
	}
}
