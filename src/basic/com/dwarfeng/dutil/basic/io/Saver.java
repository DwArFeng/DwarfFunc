package com.dwarfeng.dutil.basic.io;

import java.util.Set;

/**
 * ��������
 * <p> ʵ�ָýӿ���ζ�Ÿö����ܽ�ָ�������е���Ϣ��ĳ�ַ�ʽ���д洢��
 * <p> ������ӵ��������Ϊ�ı��淽ʽ��
 * <br>1�����������б��棬�������쳣��ʱ�򣬱��������ֹ�����׳��쳣��
 * <br>2�����������б��棬�������쳣��ʱ���ڼ����м�¼������쳣�����Ҽ������棬�ȵ�ȫ��������Ϻ󣬷����쳣���ϡ�
 * <p> ����������Ƴ�һ����ʹ�õ��࣬����������һ�ֱ��淽��֮�󣬸�����ʧЧ����˲��ܷ������ñ��淽����
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface Saver<T> {
	
	/**
	 * ��ָ���Ķ����е����ݽ��б��档
	 * @param obj ָ���Ķ���
	 * @throws SaveFailedException ����ʧ���쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalStateException �ظ����ñ��淽��ʱ�׳����쳣��
	 */
	public void save(T obj) throws SaveFailedException, IllegalStateException;
	
	/**
	 * ��ָ���Ķ����������������ݡ�
	 * <p>  �÷�����ָ���Ķ����г����������ݣ�����������������κ��쳣���÷����Ὣ�쳣��¼���쳣�����У�
	 * ���������׳��������е�����ȫ��������Ϻ󣬸÷����������������쳣���쳣���ϵ���ʽ���ء�
	 * @param obj ָ���Ķ���
	 * @return ��������������������쳣��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalStateException ���ظ����ñ��淽��ʱ�׳����쳣��
	 */
	public Set<SaveFailedException> countinuousSave(T obj) throws IllegalStateException;

}
