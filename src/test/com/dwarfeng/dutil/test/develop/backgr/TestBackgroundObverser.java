package com.dwarfeng.dutil.test.develop.backgr;

import java.util.ArrayList;
import java.util.List;

import com.dwarfeng.dutil.develop.backgr.Task;
import com.dwarfeng.dutil.develop.backgr.obv.BackgroundObverser;


public class TestBackgroundObverser implements BackgroundObverser {
	
	public final List<Task> submittedTasks = new ArrayList<>();
	public final List<Task> startedTasks = new ArrayList<>();
	public final List<Task> finishedTasks = new ArrayList<>();
	public final List<Task> removedTasks = new ArrayList<>();
	public boolean shutDown = false;
	public boolean terminated = false;

	@Override
	public void fireTaskSubmitted(Task task) {
		submittedTasks.add(task);
	}

	@Override
	public void fireTaskStarted(Task task) {
		startedTasks.add(task);
	}

	@Override
	public void fireTaskFinished(Task task) {
		finishedTasks.add(task);
	}

	@Override
	public void fireTaskRemoved(Task task) {
		removedTasks.add(task);
	}

	@Override
	public void fireShutDown() {
		shutDown = true;
	}
	
	@Override
	public void fireTerminated() {
		terminated = true;
	}
	
}
