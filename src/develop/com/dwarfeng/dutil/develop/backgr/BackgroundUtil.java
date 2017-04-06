package com.dwarfeng.dutil.develop.backgr;

import java.util.Objects;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;

/**
 * �йغ�̨�Ĺ��߰���
 * <p>
 * �ð��а�����̨�ĳ��÷�����
 * <p>
 * ������ֻ���о�̬�����Ĺ��߰������Ը����޷����̳С�
 * 
 * @author DwArFeng
 * @since 0.1.1-beta
 */
public final class BackgroundUtil {

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
		Objects.requireNonNull(runnable, DwarfUtil.getStringField(StringFieldKey.BACKGROUNDUTIL_0));
		return new RunnableTask(runnable);
	}

	private final static class RunnableTask extends AbstractTask {

		private final Runnable runnable;

		public RunnableTask(Runnable runnable) {
			this.runnable = runnable;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.backgr.AbstractTask#todo()
		 */
		@Override
		protected void todo() throws Exception {
			runnable.run();
		}

	}

	private BackgroundUtil() {
	}
}
