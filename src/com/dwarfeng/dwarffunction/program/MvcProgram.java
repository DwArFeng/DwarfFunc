package com.dwarfeng.dwarffunction.program;

import com.dwarfeng.dwarffunction.DwarfFunction;
import com.dwarfeng.dwarffunction.DwarfFunction.StringFiledKey;
import com.dwarfeng.dwarffunction.program.mvc.ControlManager;
import com.dwarfeng.dwarffunction.program.mvc.ControlPort;
import com.dwarfeng.dwarffunction.program.mvc.ModuleControlPort;
import com.dwarfeng.dwarffunction.program.mvc.ModuleManager;
import com.dwarfeng.dwarffunction.program.mvc.ProgramConstField;
import com.dwarfeng.dwarffunction.program.mvc.ProgramControlPort;
import com.dwarfeng.dwarffunction.program.mvc.ProgramManager;
import com.dwarfeng.dwarffunction.program.mvc.ViewControlPort;
import com.dwarfeng.dwarffunction.program.mvc.ViewManager;

/**
 * MVC��ܳ���
 * <p> ���������MVC��ܣ����Ҽ���ͨ�û���ͨ������ָ�������ؾ���Ŀ���վ�����������Ͱ�ȫ������������д��
 * <br> �ÿ���ڱ�д����ѭ��󻯷���MVC��ԭ�򣬿��Ҳ����ȫ���ر�׼MVC������������MVC���ϸ���롣
 * @author DwArFeng
 * @since 1.8
 */
public abstract class MvcProgram<P extends ProgramControlPort, M extends ModuleControlPort, V extends ViewControlPort, C extends ControlPort,
O extends ProgramConstField> implements ProgramManager<P,O>{
	
	/**�����ģ�͹�����*/
	protected final ModuleManager<M, O> moduleManager;
	/**�������ͼ������*/
	protected final ViewManager<V, C, O> viewManager;
	/**����Ŀ��ƹ�����*/
	protected final ControlManager<P, M, V, C> controlManager;
	
	/**
	 * ����һ������ָ��ģ�͹�������ָ����ͼ��������ָ�����ƹ�������MVC��ܳ���
	 * @param moduleManager ָ����ģ�͹�������
	 * @param viewManager ָ������ͼ��������
	 * @param controlManager ָ���Ŀ��ƹ�������
	 * @throws NullPointerException ������ڲ�������һ��Ϊ<code>null</code>ʱ�׳���
	 */
	public MvcProgram(ModuleManager<M, O> moduleManager, ViewManager<V, C, O> viewManager,
	ControlManager<P,M,V,C> controlManager){
		
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
		this.viewManager.setControlPort(this.controlManager.getControlPort());
		this.viewManager.setProgramConstField(getProgramConstField());
		this.moduleManager.setProgramConstField(getProgramConstField());
		
	}

	
	
}
