package com.dwarfeng.dfunc.prog.mvc;


/**
 * ��������������
 * <p>�����ṩ��������������ʵ�֡� 
 * @author DwArFeng
 * @since 1.8
 */
public abstract class AbstractProgramManager<P extends ProgramControlPort, A extends ProgramAttrSet> 
implements ProgramManager<P, A>{

	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfunc.prog.mvc.ProgramManager#getProgramControlPort()
	 */
	@Override
	public abstract P getProgramControlPort();
	
	/*
	 * (non-Javadoc)
	 * @see com.dwarfeng.dfunc.prog.mvc.ProgramManager#getProgramAttrSet()
	 */
	@Override
	public abstract A getProgramAttrSet();
}
