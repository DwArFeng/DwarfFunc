package com.dwarfeng.dutil.develop.backgr;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.threads.NumberedThreadFactory;
import com.dwarfeng.dutil.develop.backgr.obv.BackgroundObverser;
import com.dwarfeng.dutil.develop.backgr.obv.TaskObverser;

/**
 * ִ������̨��
 * 
 * <p>
 * �ú�̨ʹ��һ��ִ���������йܣ��ú�̨�����ύ�������͸�ִ����ִ�С�ִ��������Ϊ�����˸ú�̨����Ϊ��
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public class ExecutorServiceBackground extends AbstractBackground {

	/** ִ������̨Ĭ�ϵ��̹߳����� */
	public static final ThreadFactory THREAD_FACTORY = new NumberedThreadFactory("EsBackgr", false,
			Thread.NORM_PRIORITY);

	/** �йܺ�̨��ִ������ */
	protected final ExecutorService executorService;
	/** ��̨����������ļ��ϡ� */
	protected final Set<Task> tasks = new HashSet<>();

	private final Lock runningLock = new ReentrantLock();
	private final Condition runningCondition = runningLock.newCondition();

	private boolean shutdownFlag = false;
	private boolean terminateFlag = false;

	/**
	 * ����һ��Ĭ�ϵ�ִ������̨��
	 */
	public ExecutorServiceBackground() {
		this(Executors.newSingleThreadExecutor(THREAD_FACTORY), Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ��ִ������ָ���Ĺ۲������ϵ�ִ������̨��
	 * 
	 * @param executorService
	 *            ָ����ִ������
	 * @param obversers
	 *            ָ���Ĺ۲������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public ExecutorServiceBackground(ExecutorService executorService, Set<BackgroundObverser> obversers) {
		super(obversers);
		Objects.requireNonNull(executorService, DwarfUtil.getStringField(StringFieldKey.EXECUTORSERVICEBACKGROUND_0));
		this.executorService = executorService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.develop.backgr.BackGround#submit(com.dwarfeng.dutil.
	 * develop.backgr.Task)
	 */
	@Override
	public boolean submit(Task task) {
		lock.writeLock().lock();
		try {
			if (isShutdown())
				throw new IllegalStateException(DwarfUtil.getStringField(StringFieldKey.EXECUTORSERVICEBACKGROUND_1));
			if (Objects.isNull(task))
				return false;
			if (tasks.contains(task))
				return false;
			if (!task.addObverser(new TaskInspector(task)))
				return false;

			try {
				executorService.submit(task);
				tasks.add(task);
				fireTaskSubmitted(task);
				return true;
			} catch (Exception e) {
				return false;
			}
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#submitAll(java.util.
	 * Collection)
	 */
	@Override
	public boolean submitAll(Collection<? extends Task> c) {
		Objects.requireNonNull(c, DwarfUtil.getStringField(StringFieldKey.EXECUTORSERVICEBACKGROUND_2));

		lock.writeLock().lock();
		try {
			boolean aFlag = false;
			for (Task task : c) {
				if (submit(task))
					aFlag = true;
			}
			return aFlag;
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#shutdown()
	 */
	@Override
	public void shutdown() {
		lock.writeLock().lock();
		try {
			executorService.shutdown();
			shutdownFlag = true;
			fireShutDown();
			if (tasks.isEmpty()) {
				terminateFlag = true;
				fireTerminated();
				runningLock.lock();
				try {
					runningCondition.signalAll();
				} finally {
					runningLock.unlock();
				}
			}
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		lock.readLock().lock();
		try {
			return shutdownFlag;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		lock.readLock().lock();
		try {
			return terminateFlag;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#awaitTermination()
	 */
	@Override
	public void awaitTermination() throws InterruptedException {
		runningLock.lock();
		try {
			while (!isTerminated()) {
				runningCondition.await();
			}
		} finally {
			runningLock.unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#awaitTermination(long,
	 * java.util.concurrent.TimeUnit)
	 */
	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		runningLock.lock();
		try {
			long nanosTimeout = unit.toNanos(timeout);
			while (!isTerminated()) {
				if (nanosTimeout > 0)
					nanosTimeout = runningCondition.awaitNanos(nanosTimeout);
				else
					return false;
			}
			return true;
		} finally {
			runningLock.unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.BackGround#tasks()
	 */
	@Override
	public Set<Task> tasks() {
		return Collections.unmodifiableSet(tasks);
	}

	private class TaskInspector implements TaskObverser {

		private final Task task;

		public TaskInspector(Task task) {
			this.task = task;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.dwarfeng.dutil.develop.backgr.obv.TaskObverser#fireStarted()
		 */
		@Override
		public void fireStarted() {
			fireTaskStarted(task);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.dwarfeng.dutil.develop.backgr.obv.TaskObverser#fireFinished()
		 */
		@Override
		public void fireFinished() {
			lock.writeLock().lock();
			try {
				fireTaskFinished(task);
				tasks.remove(task);
				fireTaskRemoved(task);
				if (isShutdown() && tasks.isEmpty()) {
					runningLock.lock();
					try {
						terminateFlag = true;
						fireTerminated();
						runningCondition.signalAll();
					} finally {
						runningLock.unlock();
					}
				}
			} finally {
				lock.writeLock().unlock();
			}
		}

	}

}
