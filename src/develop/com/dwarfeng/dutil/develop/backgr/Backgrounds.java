package com.dwarfeng.dutil.develop.backgr;

/**
 * �йغ�̨�Ĺ��߰���
 * <p>
 * �ð��а�����̨�ĳ��÷�����
 * <p>
 * ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * 
 * @deprecated ���ڸ��಻���������淶���Ѿ��� {@link BackgroundUtil}���档
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public final class Backgrounds {

	/**
	 * ��ָ���� {@link Runnable} ������һ���µ�����
	 * 
	 * @param runnable
	 *            ָ���� {@link Runnable}��
	 * @return ��ָ���� {@link Runnable} �����ɵ�������
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public static Task newTaskFromRunnable(Runnable runnable) {
		return BackgroundUtil.newTaskFromRunnable(runnable);
	}

	private Backgrounds() {
	}
}
