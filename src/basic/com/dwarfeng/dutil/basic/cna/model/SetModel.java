package com.dwarfeng.dutil.basic.cna.model;

import java.util.Set;

import com.dwarfeng.dutil.basic.cna.model.obv.SetObverser;
import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ����ģ�͡�
 * <p> �ṩһ����������ģ�ͣ�����ģ�Ϳ��Դ�����ɸ�����ȵ�Ԫ�أ�����֤Ԫ�ص�˳��
 * ��ģ���� {@link Set} ��һ��ʵ�֡�
 * <p> ���б��е�Ԫ�ر����ӡ�ɾ������յ�ʱ�򣬻Ὣ��Ҫ����Ϣ�ṩ��ע����ģ���ϵ����������ϡ�
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface SetModel<E>  extends Set<E>, ObverserSet<SetObverser<E>>{

}
