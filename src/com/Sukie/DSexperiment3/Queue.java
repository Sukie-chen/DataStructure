package com.Sukie.DSexperiment3;

public interface Queue<T> {
	public abstract boolean isEmpty();
	public abstract boolean add(T e);
	public T poll(); 
	public T peek(); 
}
