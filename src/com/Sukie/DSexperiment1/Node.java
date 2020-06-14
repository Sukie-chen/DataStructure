package com.Sukie.DSexperiment1;

public class Node<T> {  //单链表节点类(泛型)
	public T data; //数据域
	public Node<T> next; //后继
	//构造函数初始化设置(带参数与无参数)
	public Node() {
		this(null, null);
	}
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	//返回数据域的字符串型
	@Override
	public String toString() {
		return this.data.toString();
	}
}
