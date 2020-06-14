package com.Sukie.DSexperiment3;


public class CirDoublyList<T> { //循环双链表
	
	public DoubleNode<T> head; //头结点
	//构造空的循环双链表
	public CirDoublyList() { 
		this.head = new DoubleNode<T>();
		this.head.prev = this.head;
		this.head.next = this.head;
	}
	
	public boolean isEmpty(){
		return this.head.next == this.head;
	}
	
	public DoubleNode<T> insert(int i, T x) {//插入x 作为第i个元素 （头插和尾插）
		if (x == null) {
			throw new NullPointerException("X==null");
		}
		DoubleNode<T> font = this.head; 
		for (int j = 0; font.next != this.head && j < i; j++) {
			font = font.next;
		}
		DoubleNode<T> q = new DoubleNode<T>(x, font, font.next); //在font之后插入x
		font.next.prev = q;
		font.next = q;
		return q;
	}
	public DoubleNode<T> insert(T x) {//插入x 作为第i个元素 （头插和尾插）
		if (x == null) {
			throw new NullPointerException("X==null");
		}
		DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); // 尾插
		head.prev.next = q;
		head.prev = q;
		return q;
	}
	
	
	//删除操作
	public T removeLast(){
		DoubleNode<T> p = this.head;
		while (p.next != this.head) {
			p = p.next;
		}
		p.prev.next = this.head;
		this.head.prev = p.prev;
		return p.data;
	}
	
	public T remove(int i){
		DoubleNode<T> p = this.head;
		for (int j = 0; p.next != this.head && j < i; j++) {
			p = p.next;
		}
		p.prev.next = p.next.next;
		p.next.next.prev = p.prev;
		return p.data;
	}
	
	//查询操作
	public T get(int i){
		DoubleNode<T> p = this.head;
		for (int j = 0; p.next != this.head && j < i; j++) {
			p = p.next;
		}
		return p.data;
	}
	
	
	//反向输出
	public String toPreviousString(){
		DoubleNode<T> p = this.head;
		while (p.prev != this.head) {
			p = p.prev;
			return p.toString();
		}
		return null;
	}
}
