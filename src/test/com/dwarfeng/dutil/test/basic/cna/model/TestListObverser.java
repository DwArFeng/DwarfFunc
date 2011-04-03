package com.dwarfeng.dutil.test.basic.cna.model;

import java.util.ArrayList;
import java.util.List;

import com.dwarfeng.dutil.basic.cna.model.obv.ListObverser;

class TestListObverser<T> implements ListObverser<T> {

	public List<Integer> removeIndexes = new ArrayList<>();
	public List<T> removeElements = new ArrayList<>();

	public int clearedCount = 0;

	public List<Integer> changedIndexes = new ArrayList<>();
	public List<T> changedOldElements = new ArrayList<>();
	public List<T> changedNewElements = new ArrayList<>();

	public List<Integer> addedIndexes = new ArrayList<>();
	public List<T> addedElements = new ArrayList<>();

	@Override
	public void fireRemoved(int index, T element) {
		removeIndexes.add(index);
		removeElements.add(element);
	}

	@Override
	public void fireCleared() {
		clearedCount++;
	}

	@Override
	public void fireChanged(int index, T oldElement, T newElement) {
		changedIndexes.add(index);
		changedOldElements.add(oldElement);
		changedNewElements.add(newElement);
	}

	@Override
	public void fireAdded(int index, T element) {
		addedIndexes.add(index);
		addedElements.add(element);
	}

	public void reset() {
		removeIndexes.clear();
		removeElements.clear();

		clearedCount = 0;

		changedIndexes.clear();
		changedOldElements.clear();
		changedNewElements.clear();

		addedIndexes.clear();
		addedElements.clear();
	}
}
