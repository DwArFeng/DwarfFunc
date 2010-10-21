package com.dwarfeng.dutil.basic.prog;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.prog.mvc.ControlManager;
import com.dwarfeng.dutil.basic.prog.mvc.ControlPort;
import com.dwarfeng.dutil.basic.prog.mvc.ModelControlPort;
import com.dwarfeng.dutil.basic.prog.mvc.ModelManager;
import com.dwarfeng.dutil.basic.prog.mvc.ProgramAttrSet;
import com.dwarfeng.dutil.basic.prog.mvc.ProgramControlPort;
import com.dwarfeng.dutil.basic.prog.mvc.ProgramManager;
import com.dwarfeng.dutil.basic.prog.mvc.ViewControlPort;
import com.dwarfeng.dutil.basic.prog.mvc.ViewManager;

/**
 * MVC��ܳ���
 * <p> ���������MVC��ܣ����Ҽ���ͨ�û���ͨ������ָ�������ؾ���Ŀ���վ�����������Ͱ�ȫ������������д��
 * <br> �ÿ���ڱ�д����ѭ��󻯷���MVC��ԭ�򣬿��Ҳ����ȫ���ر�׼MVC������������MVC���ϸ���롣
 * @author DwArFeng
 * @since 1.8
 */
public abstract class MvcProgram<P extends ProgramControlPort, M extends ModelControlPort, V extends ViewControlPort, C extends ControlPort,
A extends ProgramAttrSet>{
	
	/**�����ģ�͹�����*/
	protected final ModelManager<M, A> modelManager;
	/**�������ͼ������*/
	protected final ViewManager<V, C, A> viewManager;
	/**����Ŀ��ƹ�����*/
	protected final ControlManager<P, M, V, C, A> controlManager;
	/**����ĳ��������*/
	protected final ProgramManager<P, A> programManager;
	
	/**
	 * ����һ������ָ��ģ�͹�������ָ����ͼ��������ָ�����ƹ�������ָ���ĳ����������MVC��ܳ���
	 * @param modelManager ָ����ģ�͹�������
	 * @param viewManager ָ������ͼ��������
	 * @param controlManager ָ���Ŀ��ƹ�������
	 * @param programManager ָ���ĳ����������
	 * @throws NullPointerException ������ڲ�������һ��Ϊ<code>null</code>ʱ�׳���
	 */
	public MvcProgram(ModelManager<M, A> modelManager, ViewManager<V, C, A> viewManager,
	ControlManager<P, M, V, C, A> controlManager, ProgramManager<P, A> programManager){
		
		//�ж�null�쳣��
		if(modelManager == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.MvcProgram_0));
		if(viewManager == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.MvcProgram_1));
		if(controlManager == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.MvcProgram_2));
		if(programManager == null) throw new NullPointerException(DwarfUtil.getStringField(StringFieldKey.MvcProgram_3));
		
		//Ϊ��������ֵ
		this.modelManager = modelManager;
		this.viewManager = viewManager;
		this.controlManager = controlManager;
		this.programManager = programManager;
		
		//������������
		this.controlManager.setModelControlPort(this.modelManager.getModelControlPort());
		this.controlManager.setViewControlPort(this.viewManager.getViewControlPort());
		this.controlManager.setProgramControlPort(programManager.getProgramControlPort());
		this.controlManager.setProgramAttrSet(programManager.getProgramAttrSet());
		this.viewManager.setControlPort(this.controlManager.getControlPort());
		this.viewManager.setProgramAttrSet(programManager.getProgramAttrSet());
		this.modelManager.setProgramAttrSet(programManager.getProgramAttrSet());
		
	}
	
	/**
	 * ��ȡ����Ŀ���վ�㡣
	 * @return ����Ŀ���վ�㡣
	 */
	public C getControlPort(){
		return controlManager.getControlPort();
	}
	
}
