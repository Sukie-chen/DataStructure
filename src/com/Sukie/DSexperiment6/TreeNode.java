package com.Sukie.DSexperiment6;

public class TreeNode {
	int data; //������
	int parent; //���ڵ��±�
	int lChild; //�����±�
	int rChild; //�Һ����±�
	
	//���캯��  ����������Ӧ�ı���ֵ
	public TreeNode(int data, int parent, int lChild, int rChild) {
		this.data = data;
		this.parent = parent;
		this.lChild = lChild;
		this.rChild = rChild;
	}
	
	public TreeNode(int data) {  //�޸��ڵ��Ҷ�ӽڵ�
		this(data, -1, -1, -1);
	}
	
	//�����ַ���
	public String toString() {
		String result = "("+this.data+","+this.parent+","+this.lChild+","+this.rChild+")";
		return result;
		
	}

	//�ж��Ƿ�ΪҶ�ӽڵ�
	public boolean isLeaf(){
		return this.lChild == -1 && this.rChild == -1;
	}
}
