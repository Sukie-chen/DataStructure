package com.Sukie.DSexperiment5;

import java.util.LinkedList;

public class BinaryTree<T> {
	public BinaryNode<T> root; //�����
	private int i = 0;
	//����ն�����
	public BinaryTree() {
		this.root = null;
	}
	//�ж��Ƿ�Ϊ�ն�����
	public boolean isEmpty(){
		return this.root==null;
	}
	
	//����ǿն�����
	public BinaryTree(T[] prelist){
		this.root = create(prelist);
	}
	
	//������prelist���������������Ϊ�����Ķ�����
	private BinaryNode<T> create(T[] prelist){
		BinaryNode<T> p = null;
		if (i < prelist.length) { //�ݹ鷽��
			T element = prelist[i]; //��õ�1������ 
			i++;
			if (element != null) { //��Ϊ����ֵ��p ȡ������Ϊ���ڵ�
				p = new BinaryNode<T>(element);  //����Ҷ�ӽڵ�
				p.left = create(prelist); //�ݹ��ȡ����
				p.right = create(prelist); //�ݹ����Һ���
			}
		}
		return p;
	}
	
	
	//�������
	public void preOrder(){ //��������������������ã���������������
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
	
	//�������
	public void inOrder(){ //��������������������ã���������������
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
	
	//�������
	public void postOrder(){ //��������������������ã���������������
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
	
	//��α���
	public void levelOrder(){
		BinaryNode<T> p = this.root;
		if (p == null) {
			return;
		}
		LinkedList<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();  //�����ն���
		BinaryNode<T> current = null;
		queue.offer(root);//�����ڵ����
		while(!queue.isEmpty()){
			current = queue.poll();//���Ӷ�ͷԪ�ز�����
			System.out.print(current.data +" ");
			if(current.left != null){//�����ǰ�ڵ����ڵ㲻Ϊ��  ���
				queue.offer(current.left);
			}
			if(current.right != null){//�����ǰ�ڵ���ҽڵ㲻Ϊ�գ����ҽڵ����
				queue.offer(current.right);
			}
		}
	}
	
	//��ö������ĸ߶�
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
    
    //��ö������Ľ����
    public int getCount(){
        return count(root);
    }
    private int count(BinaryNode<T> p){
        if(p==null)
            return 0;
        return 1+count(p.left)+count(p.right);
    }

	
}
