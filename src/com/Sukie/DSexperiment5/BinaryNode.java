package com.Sukie.DSexperiment5;

public class BinaryNode<T> { //��������Ľ����
	public T data; //������
	public BinaryNode<T> left, right; //���Ӻ��Һ���
	//�����㣬ָ��data�����Һ���
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	//Ҷ�ӽڵ�
	public BinaryNode(T data) {
		this(data, null, null);
	}
	
	
	//�����������ַ���
	@Override
	public String toString() {
		return this.data.toString();
	}
	
	//�ж��Ƿ�ΪҶ�ӽڵ�
	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}
}
