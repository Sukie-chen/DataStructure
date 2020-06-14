package com.Sukie.DSexperiment3;

public class DoubleNode<T> { //双链表结点类
	public T data; //数据域
	public DoubleNode<T> prev, next; //前驱后继
	
	public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public DoubleNode(T data) {
		this(data, null, null);
	}
	public DoubleNode() {
		this(null, null, null);
	}
	
	public String toString() {
		return this.data.toString();
	}

}
