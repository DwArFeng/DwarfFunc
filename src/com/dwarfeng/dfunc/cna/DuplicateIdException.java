package com.dwarfeng.dfunc.cna;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;

/**
 * ID�ظ��쳣��
 * <p>��ĳЩ���а���һЩ����IDֵ�ļ��ϣ��Ҳ�������IDֵ�ظ���������Щ������ͼ�����Ѿ����ڵ�IDʱͨ��
 * ���׳����쳣��
 * @author DwArFeng
 * @since 1.8
 */
public final class DuplicateIdException extends Exception {

	private static final long serialVersionUID = -122201342919712293L;
	
	private int id;
	
	/**
	 * ����һ��Ĭ�ϵ�ID�ظ��쳣��
	 */
	public DuplicateIdException() {
		this(0,null,null);
	}
	/**
	 * ����һ������ָ��ID�ŵ�ID�쳣��
	 * @param id ָ����ID�š�
	 */
	public DuplicateIdException(int id){
		this(id,null,null);
	}
	/**
	 * ����һ������ָ��ID�ţ�ָ�����쳣��Ϣ��ID�ظ��쳣��
	 * @param id ָ����ID�š�
	 * @param message ָ�����쳣��Ϣ��
	 */
	public DuplicateIdException(int id,String message) {
		this(id,message,null);
	}
	/**
	 * ����һ������ָ����ID�ţ�ָ���ķ���ԭ���ID�ظ��쳣��
	 * @param id ָ����ID�š�
	 * @param cause ָ���ķ���ԭ��
	 */
	public DuplicateIdException(int id,Throwable cause) {
		this(id,null,cause);
	}
	/**
	 * ����һ������ָ����ID�ţ�ָ�����쳣��Ϣ��ָ�����쳣����ԭ���ID�ظ��쳣��
	 * @param id ָ����ID�š�
	 * @param message ָ�����쳣��Ϣ��
	 * @param cause ָ�����쳣����ԭ��
	 */
	public DuplicateIdException(int id,String message, Throwable cause) {
		super(message, cause);
		this.id = id;
	}
	
	/**
	 * ���ظ�ID�ظ��쳣���ظ�ID�š�
	 * @return ID�š�
	 */
	public int getID(){return this.id;}
	
	@Override
	public String getMessage(){
		if(super.getMessage() == null || super.getMessage().equals(""))
			return DwarfFunction.getStringField(StringFiledKey.DuplicateIdException_0) + getID();
		return super.getMessage();
	}
}