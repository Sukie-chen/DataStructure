package com.Sukie.Dsecperiment7;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	private ArrayList<String> vertexList; //存储顶点的集合
	private int[][] edge; //存储图对应的邻接矩阵
	private int numOfEdge;//边的数目
	private int vertexSize;//接收构造函数初始化参数
	
	//构造函数初始化（带参数与不带参数）
	public Graph() {
		this(10);
		vertexSize = 10;
	}
	public Graph(int n) {
		edge = new int[n][n];
		vertexList = new ArrayList<String>();
		numOfEdge = 0;
		vertexSize = n;
	}
	
	
	//插入顶点
	public void insertVertex(String vertex){
		vertexList.add(vertex);
		int n = vertexList.size();
		if(n > vertexSize){
			inEdge(n);
		}
		
	}
	
	//添加边
	/**
	 * @param v1 下标
	 * @param v2
	 * @param weight 权值
	 */
	public void insertEdge(int v1, int v2, int weight){ //对角矩阵
		edge[v1][v2] = weight;
		edge[v2][v1] = weight;
		numOfEdge++;
	}
	
	//顶点减少，重新定义edge的数组容量
	public void deEdge(int m){
		if(m>0){
			int [][] another = this.edge;
			this.edge = new int[m][m];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					this.edge[i][j] = another[i][j];
				}
			}
		}else {
			throw new IllegalArgumentException("矩阵行列数不符合要求");
		}
	}
	
	//顶点额外增加时，重新定义数组
	public void inEdge(int m){
		if(m>0){
			int [][] another = this.edge;
			this.edge = new int[m][m];
			for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < m-1; j++) {
					this.edge[i][j] = another[i][j];
				}
			}
		}else {
			throw new IllegalArgumentException("矩阵行列数不符合要求");
		}
	}
	//返回顶点个数
	public int getNumOfVertex(){
		return vertexList.size();
	}
	//返回对应下标的顶点值
	public String getVertex(int i){
		return vertexList.get(i);
	}
	//返回边的数目
	public int getEdge(){
		return numOfEdge;
	}
	//返回对应的权值
	public int getWeight(int v1, int v2){
		return edge[v1][v2];
	}
	
	//删除对应顶点
	public void removeVertex(int i){
		int n = vertexList.size(); //获得顶点个数
		//上移
		if (i >= 0 && i < n) {
			vertexList.remove(i);
			for (int j = i+1; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					edge[j-1][j2] = edge[j][j2]; 
				}
			}
			//左移
			for (int j = 0; j < n; j++) {
				for (int j2 = i+1; j2 < n; j2++) {
					edge[j][j2-1] = edge[j][j2]; 
				}
			}
			deEdge(n-1);
		} else {
			throw new IndexOutOfBoundsException("i值不在范围内");
		}
		
	}
	
	//删除对应边
	public void removeEdge(int v1, int v2){
		int n = vertexList.size();
		if (v1 < n && v2 < n) {
			if(v1 != v2){
				insertEdge(v1, v2, 0);
			}
		}else {
			throw new IndexOutOfBoundsException("v1,v2值不符合要求");
		}
		
	}
	
	//打印矩阵
	public void showGraph(){
		for (int[] value : edge) {
			System.out.println(Arrays.toString(value));
		}
	}
	
}
