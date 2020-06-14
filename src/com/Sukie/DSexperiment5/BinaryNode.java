package com.Sukie.DSexperiment5;

public class BinaryNode<T> { //二叉链表的结点类
	public T data; //数据域
	public BinaryNode<T> left, right; //左孩子和右孩子
	//构造结点，指定data和左右孩子
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	//叶子节点
	public BinaryNode(T data) {
		this(data, null, null);
	}
	
	
	//返回数据域字符串
	@Override
	public String toString() {
		return this.data.toString();
	}
	
	//判断是否为叶子节点
	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}
}
