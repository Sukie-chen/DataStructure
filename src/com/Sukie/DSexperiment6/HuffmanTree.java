package com.Sukie.DSexperiment6;

public class HuffmanTree {
	private int[] weights; //存储权值的数组
	private int n;
	private TreeNode[] nodes; //存储节点的数组
	private int m;
	
	//构造函数，传入权值
	public HuffmanTree(int[] w) {
		this.weights = w;
		int n = w.length;  //获得传入权值的个数(节点个数)
		if(n <=1){
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.m = 2*n-1;
		//初始化节点数组
		this.nodes = new TreeNode[m]; 
		
		for (int i = 0; i < n; i++) {
			nodes[i] = new TreeNode(weights[i]); //构建叶子节点
		}
	}
	
	//根据权值构建哈夫曼树
	public void create(){
		int min = Integer.MAX_VALUE, secmin = min; //最小和次小权值
		for (int i = n; i < m; i++) {
			int minIndex = -1; //最小权值结点下标
			int secminIndex = -1; //次小权值结点下标
			for (int j = 0; j < i; j++) { //找出最小和次小
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
				//最小和次小叶子节点合并，安排父节点
				this.nodes[minIndex].parent = i;
				this.nodes[secminIndex].parent = i;
				this.nodes[i] = new TreeNode(min+secmin, -1, minIndex, secminIndex);
				
			} 
			
		}
	}
	
	//获取哈夫曼编码
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
	
	//返回结点数组和编码字符串
	public String toString() {
		String string = "哈夫曼树的结点数组：";
		for (int i = 0; i < this.nodes.length; i++) {
			string += this.nodes[i].toString() + ",";
		}
		string += "\n 哈夫曼编码：";
		for (int i = 0; i < this.weights.length; i++) {
			string += "A"+i+":"+getCode(i)+",";
		}
		return string;
	}
	
}
