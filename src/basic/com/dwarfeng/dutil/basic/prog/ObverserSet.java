package com.dwarfeng.dutil.basic.prog;

import java.util.Set;

/**
 * �۲������ϡ�
 * <p>
 * ʵ�ָýӿ���ζ���ܹ���������ӡ��Ƴ�������۲�����Ҳ���Ա��������е����й۲����� <br>
 * �۲����������� mvc ģ���С�ģ�Ͳ㳣��ͨ����������ע��Ĺ۲������㲥һϵ���¼������ýӿ�������һ���۲����ļ���Ӧ��ӵ�еķ�����
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public interface ObverserSet<T extends Obverser> {

	/**
	 * �Լ��ϵ���ʽ���ظù۲������ϡ�
	 * <p>
	 * �ü���Ϊֻ�����ϣ������κ��޸ķ��������׳� {@link UnsupportedOperationException}��
	 * 
	 * @return ������ʽ�Ĺ۲������ϡ�
	 */
	public Set<T> getObversers();

	/**
	 * ��������ģ������ӹ۲�����
	 * 
	 * @param obverser
	 *            ָ���Ĺ۲�����
	 * @return �ö����Ƿ������˹۲������ϵĸı䡣
	 */
	public boolean addObverser(T obverser);

	/**
	 * ��������ģ�����Ƴ��۲�����
	 * 
	 * @param obverser
	 *            ָ���Ĺ۲�����
	 * @return �ö����Ƿ������˹۲������ϵĸı䡣
	 */
	public boolean removeObverser(T obverser);

	/**
	 * ��������ģ�����Ƴ����й۲�����
	 */
	public void clearObverser();

}
