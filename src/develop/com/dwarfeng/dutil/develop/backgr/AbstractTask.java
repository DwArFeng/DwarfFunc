package com.dwarfeng.dutil.develop.backgr;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dwarfeng.dutil.develop.backgr.obv.TaskObverser;

/**
 * ��������
 * <p>
 * ����ӿڵĳ���ʵ�֡�
 * <p>
 * �������õض����� <code>run</code>������������<code>run</code> ������ִ��<code>todo</code>
 * ������<code>todo</code>��������д��Ҫʵ�ֵľ�������
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractTask<O extends TaskObverser> implements Task<O> {

	/** �۲������ϡ� */
	protected final Set<O> obversers = Collections.newSetFromMap(new WeakHashMap<>());
	/** ͬ����д�� */
	protected final ReadWriteLock lock = new ReentrantReadWriteLock();
	/** д����Condition */
	protected final Condition condition = lock.writeLock().newCondition();

	private boolean finishFlag = false;
	private boolean startFlag = false;
	private Exception exception = null;

	/**
	 * ����������Ҫʵ�ֵľ�������
	 * <p>
	 * �÷��������׳��쳣������׳��쳣�����������ֹ�����ҵ��� <code>getException</code>�����᷵���׳����쳣��
	 * 
	 * @throws Exception
	 *             �׳����쳣��
	 */
	protected abstract void todo() throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.threads.ExternalReadWriteThreadSafe#getLock()
	 */
	@Override
	public ReadWriteLock getLock() {
		return lock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#getObversers()
	 */
	@Override
	public Set<O> getObversers() {
		lock.readLock().lock();
		try {
			return obversers;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.prog.ObverserSet#addObverser(com.dwarfeng.dutil.
	 * basic.prog.Obverser)
	 */
	@Override
	public boolean addObverser(O obverser) {
		lock.writeLock().lock();
		try {
			return obversers.add(obverser);
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dwarfeng.dutil.basic.prog.ObverserSet#removeObverser(com.dwarfeng.
	 * dutil.basic.prog.Obverser)
	 */
	@Override
	public boolean removeObverser(O obverser) {
		lock.writeLock().lock();
		try {
			return obversers.remove(obverser);
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.basic.prog.ObverserSet#clearObverser()
	 */
	@Override
	public void clearObverser() {
		lock.writeLock().lock();
		try {
			obversers.clear();
		} finally {
			lock.writeLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.Task#isStarted()
	 */
	@Override
	public boolean isStarted() {
		lock.readLock().lock();
		try {
			return startFlag;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.Task#isFinish()
	 */
	@Override
	public boolean isFinish() {
		lock.readLock().lock();
		try {
			return finishFlag;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.Task#getException()
	 */
	@Override
	public Exception getException() {
		lock.readLock().lock();
		try {
			return exception;
		} finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.Task#awaitFinish()
	 */
	@Override
	public void awaitFinish() throws InterruptedException {
		while (!finishFlag) {
			condition.await();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dwarfeng.dutil.develop.backgr.Task#awaitFinish(long,
	 * java.util.concurrent.TimeUnit)
	 */
	@Override
	public boolean awaitFinish(long timeout, TimeUnit unit) throws InterruptedException {
		long nanosTimeout = unit.toNanos(timeout);
		while (!finishFlag) {
			if (nanosTimeout > 0)
				nanosTimeout = condition.awaitNanos(nanosTimeout);
			else
				return false;
		}
		return true;
	}

}
