package com.dwarfeng.dwarffunction.program;

/**
 * Ĭ�ϵİ汾ʵ����ʽ��
 * <p> ��������õİ汾��ʽ��
 * <br> �汾����ʽ���£�<code>alpha_0.3.2_160701_build_A</code>
 * @author DwArFeng
 * @since 1.8
 */
public class PDefaultVersion implements PVersion {

	/**��ʾ����汾���ֶ�*/
	protected static final String BUILD_TEXT = "build";
	/**�汾���ֶ�֮��ķָ���*/
	protected static final char VERSION_SEP = '.';
	/**�汾���ֶ�֮��ķָ���*/
	protected static final char FIELD_SEP = '_';
	
	/**�汾������*/
	protected final PVersionType type;
	/**��һ���汾��*/
	protected final byte firstVersion;
	/***/
	protected final byte secondVersion;
	protected final byte thirdVersion;
	protected final String buildDate;
	protected final char buildVersion;
	
	/**
	 * Ĭ�ϰ汾�Ĺ����ߡ�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static class Productor{
		
		private PVersionType type = PVersionType.RELEASE;
		private byte firstVersion = 0;
		private byte secondVersion = 0;
		private byte thirdVersion = 0;
		private String buildDate = "19700101";
		private char buildVersion = 'A';
		
		/**
		 * ����Ĭ�ϵİ汾�����ߡ�
		 */
		public Productor(){}
		
		/**
		 * ���ù������еİ汾���͡�
		 * @param val ָ���İ汾���͡�
		 * @return ����������
		 */
		public Productor type(PVersionType val){
			this.type = val;
			return this;
		}
		
		/**
		 * ���ù������е�һ���汾��ֵ��
		 * @param val ָ����ֵ��
		 * @return ����������
		 */
		public Productor firstVersion(byte val){
			this.firstVersion = val;
			return this;
		}
		
		/**
		 * ���ù������еڶ����汾��ֵ��
		 * @param val ָ����ֵ��
		 * @return ����������
		 */
		public Productor secondVersion(byte val){
			this.secondVersion = val;
			return this;
		}
		
		/**
		 * ���ù������е������汾��ֵ��
		 * @param val ָ����ֵ��
		 * @return ����������
		 */
		public Productor thirdVersion(byte val){
			this.thirdVersion = val;
			return this;
		}
		
		/**
		 * ���ù������еı���ʱ�䡣
		 * @param val ָ���ı���ʱ�䡣
		 * @return ����������
		 */
		public Productor buildDate(String val){
			this.buildDate = val;
			return this;
		}
		
		/**
		 * ���ù������еı���汾�š�
		 * @param val �������еı���汾�š�
		 * @return ����������
		 */
		public Productor buildVersion(char val){
			this.buildVersion = val;
			return this;
		}
		
		/**
		 * ���ݹ����������õĲ�������汾��
		 * @return ����İ汾��
		 */
		public PDefaultVersion product(){
			return new PDefaultVersion(type, firstVersion, secondVersion, thirdVersion, buildDate, buildVersion);
		}
	}
	
	private PDefaultVersion(
			PVersionType type,
			byte firstVersion,
			byte secondVersion,
			byte thirdVersion,
			String buildDate,
			char buildVersion
	) {
		this.type = type;
		this.firstVersion = firstVersion;
		this.secondVersion = secondVersion;
		this.thirdVersion = thirdVersion;
		this.buildDate = buildDate;
		this.buildVersion = buildVersion;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.PVersion#getVersionType()
	 */
	@Override
	public PVersionType getVersionType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.PVersion#getLongName()
	 */
	@Override
	public String getLongName() {
		return 
				type.getLabel() + FIELD_SEP +
				firstVersion + VERSION_SEP + secondVersion + VERSION_SEP + thirdVersion + VERSION_SEP + 
				buildDate + FIELD_SEP + BUILD_TEXT + FIELD_SEP + buildVersion;
	}

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dwarffunction.program.PVersion#getShortName()
	 */
	@Override
	public String getShortName() {
		return 
				type.getLabel() + FIELD_SEP +
				firstVersion + VERSION_SEP + secondVersion + VERSION_SEP + thirdVersion + VERSION_SEP;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return getLongName();
	}

}
