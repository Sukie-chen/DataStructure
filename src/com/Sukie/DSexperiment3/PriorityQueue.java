package com.Sukie.DSexperiment3;


public class PriorityQueue<T extends  Comparable<? super T>> implements Queue<T>{
	private Sotred<T> list; //优先级排序的循环双链表
	private boolean asc; //升序还是降序

	public PriorityQueue(boolean asc) {
		this.list = new Sotred<T>();
		this.asc = asc;
	}
	public PriorityQueue() {
		this(true); //默认升序
	}
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public boolean add(T e) {
		return this.list.insert(e) != null;
	}

	public T poll() {
		return this.asc? this.list.remove(0) : this.list.removeLast();
	}

	public T peek() {
		return this.asc? this.list.get(0) : this.list.head.prev.data;
	}
	
	public String toString() {
		return this.getClass().getName()+" "+(this.asc ? this.list.toString() : this.list.toPreviousString());
	}

}
