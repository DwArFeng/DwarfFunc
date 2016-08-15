package com.dwarfeng.dfunc.program;

import com.dwarfeng.dfunc.DwarfFunction;
import com.dwarfeng.dfunc.DwarfFunction.StringFiledKey;
import com.dwarfeng.dfunc.program.mvc.ControlManager;
import com.dwarfeng.dfunc.program.mvc.ControlPort;
import com.dwarfeng.dfunc.program.mvc.ModuleControlPort;
import com.dwarfeng.dfunc.program.mvc.ModuleManager;
import com.dwarfeng.dfunc.program.mvc.ProgramAttrSet;
import com.dwarfeng.dfunc.program.mvc.ProgramControlPort;
import com.dwarfeng.dfunc.program.mvc.ProgramManager;
import com.dwarfeng.dfunc.program.mvc.ViewControlPort;
import com.dwarfeng.dfunc.program.mvc.ViewManager;

/**
 * MVC��ܳ���
 * <p> ���������MVC��ܣ����Ҽ���ͨ�û���ͨ������ָ�������ؾ���Ŀ���վ�����������Ͱ�ȫ������������д��
 * <br> �ÿ���ڱ�д����ѭ��󻯷���MVC��ԭ�򣬿��Ҳ����ȫ���ر�׼MVC������������MVC���ϸ���롣
 * @author DwArFeng
 * @since 1.8
 */
public abstract class MvcProgram<P extends ProgramControlPort, M extends ModuleControlPort, V extends ViewControlPort, C extends ControlPort,
A extends ProgramAttrSet> implements ProgramManager<P, A>{
	
	/**�����ģ�͹�����*/
	protected final ModuleManager<M, A> moduleManager;
	/**�������ͼ������*/
	protected final ViewManager<V, C, A> viewManager;
	/**����Ŀ��ƹ�����*/
	protected final ControlManager<P, M, V, C, A> controlManager;
	
	/**
	 * ����һ������ָ��ģ�͹�������ָ����ͼ��������ָ�����ƹ�������MVC��ܳ���
	 * @param moduleManager ָ����ģ�͹�������
	 * @param viewManager ָ������ͼ��������
	 * @param controlManager ָ���Ŀ��ƹ�������
	 * @throws NullPointerException ������ڲ�������һ��Ϊ<code>null</code>ʱ�׳���
	 */
	public MvcProgram(ModuleManager<M, A> moduleManager, ViewManager<V, C, A> viewManager,
	ControlManager<P, M, V, C, A> controlManager){
		
		//�ж�null�쳣��
		if(moduleManager == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.MvcProgram_0));
		if(viewManager == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.MvcProgram_1));
		if(controlManager == null) throw new NullPointerException(DwarfFunction.getStringField(StringFiledKey.MvcProgram_2));
		
		//Ϊ��������ֵ
		this.moduleManager = moduleManager;
		this.viewManager = viewManager;
		this.controlManager = controlManager;
		
		//������������
		this.controlManager.setModuleControlPort(this.moduleManager.getModuleControlPort());
		this.controlManager.setViewControlPort(this.viewManager.getViewControlPort());
		this.controlManager.setProgramControlPort(this.getProgramControlPort());
		this.controlManager.setProgramAttrSet(this.getProgramAttrSet());
		this.viewManager.setControlPort(this.controlManager.getControlPort());
		this.viewManager.setProgramAttrSet(getProgramAttrSet());
		this.moduleManager.setProgramAttrSet(getProgramAttrSet());
		
	}
	
}
