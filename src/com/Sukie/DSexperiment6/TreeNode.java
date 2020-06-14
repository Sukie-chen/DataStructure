package com.Sukie.DSexperiment6;

public class TreeNode {
	int data; //数据域
	int parent; //父节点下标
	int lChild; //左孩子下标
	int rChild; //右孩子下标
	
	//构造函数  传参设置相应的变量值
	public TreeNode(int data, int parent, int lChild, int rChild) {
		this.data = data;
		this.parent = parent;
		this.lChild = lChild;
		this.rChild = rChild;
	}
	
	public TreeNode(int data) {  //无父节点的叶子节点
		this(data, -1, -1, -1);
	}
	
	//返回字符串
	public String toString() {
		String result = "("+this.data+","+this.parent+","+this.lChild+","+this.rChild+")";
		return result;
		
	}

	//判断是否为叶子节点
	public boolean isLeaf(){
		return this.lChild == -1 && this.rChild == -1;
	}
}
