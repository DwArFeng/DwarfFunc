package com.dwarfeng.dutil.basic.cna;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.ExceptionStringKey;

/**
 * ID重复异常。
 * <p>当某些类中包含一些具有ID值的集合，且不允许其ID值重复。当向这些类中试图添加已经存在的ID时通常
 * 会抛出该异常。
 * @author DwArFeng
 * @since 0.0.2-beta
 */
class DuplicateIdException extends Exception {

	private static final long serialVersionUID = -1961152389935867480L;
	
	private int id;
	
	/**
	 * 生成一个默认的ID重复异常。
	 */
	public DuplicateIdException() {
		this(0,null,null);
	}
	/**
	 * 生成一个具有指定ID号的ID异常。
	 * @param id 指定的ID号。
	 */
	public DuplicateIdException(int id){
		this(id,null,null);
	}
	/**
	 * 生成一个具有指定ID号，指定的异常信息的ID重复异常。
	 * @param id 指定的ID号。
	 * @param message 指定的异常信息。
	 */
	public DuplicateIdException(int id,String message) {
		this(id,message,null);
	}
	/**
	 * 生成一个具有指定的ID号，指定的发生原因的ID重复异常。
	 * @param id 指定的ID号。
	 * @param cause 指定的发生原因。
	 */
	public DuplicateIdException(int id,Throwable cause) {
		this(id,null,cause);
	}
	/**
	 * 生成一个具有指定的ID号，指定的异常信息，指定的异常发生原因的ID重复异常。
	 * @param id 指定的ID号。
	 * @param message 指定的异常信息。
	 * @param cause 指定的异常发生原因。
	 */
	public DuplicateIdException(int id,String message, Throwable cause) {
		super(message, cause);
		this.id = id;
	}
	
	/**
	 * 返回该ID重复异常的重复ID号。
	 * @return ID号。
	 */
	public int getID(){return this.id;}
	
	@Override
	public String getMessage(){
		if(super.getMessage() == null || super.getMessage().equals(""))
			return DwarfUtil.getExceptionString(ExceptionStringKey.DUPLICATEIDEXCEPTION_0) + getID();
		return super.getMessage();
	}
}
