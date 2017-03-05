package com.dwarfeng.dutil.basic.cna.model;

import java.util.List;

import com.dwarfeng.dutil.basic.cna.model.obv.ListObverser;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * �б�ģ�͡�
 * <p> �ṩһ���б�����ģ�ͣ�����Ԫ�����б����һ��ȷ�е���ţ�����ͨ����ѯ��Ż�á�
 * ��ģ���� {@link List} ��һ��ʵ�֡�
 * <p> ���б��е�Ԫ�ر����ӡ�ɾ�����ı䡢��յ�ʱ�򣬻Ὣ��Ҫ����Ϣ�ṩ��ע����ģ���ϵ����������ϡ�
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ListModel<E> extends List<E>, ObverserSet<ListObverser<E>>{

}
