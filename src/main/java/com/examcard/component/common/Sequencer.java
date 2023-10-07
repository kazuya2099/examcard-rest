package com.examcard.component.common;

public interface Sequencer<T> {

	T getNext();
	T getCurrent();
}
