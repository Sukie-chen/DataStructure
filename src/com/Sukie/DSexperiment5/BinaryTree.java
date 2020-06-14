package com.Sukie.DSexperiment5;

import java.util.LinkedList;

public class BinaryTree<T> {
	public BinaryNode<T> root; //根结点
	private int i = 0;
	//构造空二叉树
	public BinaryTree() {
		this.root = null;
	}
	//判断是否为空二叉树
	public boolean isEmpty(){
		return this.root==null;
	}
	
	//构造非空二叉树
	public BinaryTree(T[] prelist){
		this.root = create(prelist);
	}
	
	//创建以prelist（先序遍历）数据为基础的二叉树
	private BinaryNode<T> create(T[] prelist){
		BinaryNode<T> p = null;
		if (i < prelist.length) { //递归方法
			T element = prelist[i]; //获得第1个数据 
			i++;
			if (element != null) { //不为空则赋值给p 取出来作为根节点
				p = new BinaryNode<T>(element);  //当作叶子节点
				p.left = create(prelist); //递归获取左孩子
				p.right = create(prelist); //递归获得右孩子
			}
		}
		return p;
	}
	
	
	//先序遍历
	public void preOrder(){ //公共方法方便其他类调用，输出先序遍历序列
		preorder(root);
		System.out.println();
	}
	
	private void preorder(BinaryNode<T> p) {
		if (p != null) {
			System.out.print(p.data.toString()+ " ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	
	//中序遍历
	public void inOrder(){ //公共方法方便其他类调用，输出先序遍历序列
		inorder(root);
		System.out.println();
	}
	
	private void inorder(BinaryNode<T> p) {
		if (p != null) {
			preorder(p.left);
			System.out.print(p.data.toString()+ " ");
			preorder(p.right);
		}
	}
	
	//后序遍历
	public void postOrder(){ //公共方法方便其他类调用，输出先序遍历序列
		postorder(root);
		System.out.println();
	}
	
	private void postorder(BinaryNode<T> p) {
		if (p != null) {
			preorder(p.left);
			preorder(p.right);
			System.out.print(p.data.toString()+ " ");
		}
	}
	
	//层次遍历
	public void levelOrder(){
		BinaryNode<T> p = this.root;
		if (p == null) {
			return;
		}
		LinkedList<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();  //创建空队列
		BinaryNode<T> current = null;
		queue.offer(root);//将根节点入队
		while(!queue.isEmpty()){
			current = queue.poll();//出队队头元素并访问
			System.out.print(current.data +" ");
			if(current.left != null){//如果当前节点的左节点不为空  入队
				queue.offer(current.left);
			}
			if(current.right != null){//如果当前节点的右节点不为空，把右节点入队
				queue.offer(current.right);
			}
		}
	}
	
	//获得二叉树的高度
	public int getHeight(){
        return height(root);
    }
    private int height(BinaryNode<T> p){
        if(p==null)
            return 0;
        int lh=height(p.left);
        int rh=height(p.right);
        return (lh>rh)?lh+1:rh+1;
    }
    
    //获得二叉树的结点数
    public int getCount(){
        return count(root);
    }
    private int count(BinaryNode<T> p){
        if(p==null)
            return 0;
        return 1+count(p.left)+count(p.right);
    }

	
}
