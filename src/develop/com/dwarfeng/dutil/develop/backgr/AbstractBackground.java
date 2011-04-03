package com.dwarfeng.dutil.develop.backgr;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.develop.backgr.obv.BackgroundObverser;

/**
 * �����̨��
 * 
 * <p>
 * ��̨�ĳ���ʵ�֣��ṩ�����͹۲�����ʵ�֡�
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public abstract class AbstractBackground implements Background {

	/** �۲������� */
	protected final Set<BackgroundObverser> obversers;
	/** ͬ���� */
	protected final ReadWriteLock lock = new ReentrantReadWriteLock();

	/**
	 * ����һ��Ĭ�ϵĺ�̨��
	 */
	public AbstractBackground() {
		this(Collections.newSetFromMap(new WeakHashMap<>()));
	}

	/**
	 * ����һ������ָ���Ĺ۲������ϵĳ����̨��
	 * 
	 * @param obversers
	 *            ָ���Ĺ۲������ϡ�
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public AbstractBackground(Set<BackgroundObverser> obversers) {
		Objects.requireNonNull(obversers, DwarfUtil.getStringField(StringFieldKey.ABSTRACTBACKGROUND_0));
		this.obversers = obversers;
	}

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
	public Set<BackgroundObverser> getObversers() {
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
	public boolean addObverser(BackgroundObverser obverser) {
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
	public boolean removeObverser(BackgroundObverser obverser) {
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

	/**
	 * ֪ͨ�۲���ָ���������ύ��
	 * 
	 * @param task
	 *            ָ��������
	 */
	protected void fireTaskSubmitted(Task task) {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireTaskSubmitted(task);
		}
	}

	/**
	 * ֪ͨ�۲���ָ��������ʼ��
	 * 
	 * @param task
	 *            ָ��������
	 */
	protected void fireTaskStarted(Task task) {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireTaskStarted(task);
		}
	}

	/**
	 * ֪ͨ�۲���ָ�������������
	 * 
	 * @param task
	 *            ָ��������
	 */
	protected void fireTaskFinished(Task task) {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireTaskFinished(task);
		}
	}

	/**
	 * ֪ͨ�۲���ָ���������Ƴ���
	 * 
	 * @param task
	 *            ָ��������
	 */
	protected void fireTaskRemoved(Task task) {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireTaskRemoved(task);
		}
	}

	/**
	 * ֪ͨ�۲�����̨���رա�
	 */
	protected void fireShutDown() {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireShutDown();
		}
	}

	/**
	 * ֪ͨ�۲�����̨���սᡣ
	 */
	protected void fireTerminated() {
		for (BackgroundObverser obverser : obversers) {
			if (Objects.nonNull(obverser))
				obverser.fireTerminated();
		}
	}

}
