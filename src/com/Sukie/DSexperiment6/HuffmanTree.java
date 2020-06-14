package com.Sukie.DSexperiment6;

public class HuffmanTree {
	private int[] weights; //�洢Ȩֵ������
	private int n;
	private TreeNode[] nodes; //�洢�ڵ������
	private int m;
	
	//���캯��������Ȩֵ
	public HuffmanTree(int[] w) {
		this.weights = w;
		int n = w.length;  //��ô���Ȩֵ�ĸ���(�ڵ����)
		if(n <=1){
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.m = 2*n-1;
		//��ʼ���ڵ�����
		this.nodes = new TreeNode[m]; 
		
		for (int i = 0; i < n; i++) {
			nodes[i] = new TreeNode(weights[i]); //����Ҷ�ӽڵ�
		}
	}
	
	//����Ȩֵ������������
	public void create(){
		int min = Integer.MAX_VALUE, secmin = min; //��С�ʹ�СȨֵ
		for (int i = n; i < m; i++) {
			int minIndex = -1; //��СȨֵ����±�
			int secminIndex = -1; //��СȨֵ����±�
			for (int j = 0; j < i; j++) { //�ҳ���С�ʹ�С
				if (this.nodes[j].parent == -1) {
					if (this.nodes[j].data < min) {
						 secmin = min;
						 secminIndex = minIndex;
						 min = this.nodes[j].data;
						 minIndex = j;
					}else if(this.nodes[j].data < secmin){
						secmin = this.nodes[j].data;
						secminIndex = j;
					}
				}
				//��С�ʹ�СҶ�ӽڵ�ϲ������Ÿ��ڵ�
				this.nodes[minIndex].parent = i;
				this.nodes[secminIndex].parent = i;
				this.nodes[i] = new TreeNode(min+secmin, -1, minIndex, secminIndex);
				
			} 
			
		}
	}
	
	//��ȡ����������
	private String getCode(int i){
		int k = 8;
		char hufCode[] = new char[k];
		int child = i;
		int parent = this.nodes[child].parent;
		for ( i = k-1; parent != -1; i--) {
			hufCode[i] = (nodes[parent].lChild == child)?'0':'i';
			child = parent;
			parent = nodes[child].parent;
		}
		return new String(hufCode, i+1, k-1-i);
	}
	
	//���ؽ������ͱ����ַ���
	public String toString() {
		String string = "���������Ľ�����飺";
		for (int i = 0; i < this.nodes.length; i++) {
			string += this.nodes[i].toString() + ",";
		}
		string += "\n ���������룺";
		for (int i = 0; i < this.weights.length; i++) {
			string += "A"+i+":"+getCode(i)+",";
		}
		return string;
	}
	
}
