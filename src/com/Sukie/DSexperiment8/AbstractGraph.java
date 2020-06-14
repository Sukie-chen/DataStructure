package com.Sukie.DSexperiment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractGraph<T> {  //顶点集合类
	protected static final int MAX_WEIGHT = 0x0000ffff;
	protected ArrayList<T> vertexList; //顶点顺序表
	public AbstractGraph(int length) {
		this.vertexList =  new ArrayList<T>(length);  //构造容量为length的空表
	}
	public AbstractGraph() {
		this(10); //构造容量为length默认为10的空表
	}
	
	//返回顶点个数
	public int getNumOfVertex(){
		return vertexList.size();
	}
	
	//返回顶点集合
	public String toString(){
		return "顶点集合:" + this.vertexList.toString() + "\n";
	}
	
	//返回对应下标的顶点值
	public T getVertex(int i){
		return vertexList.get(i);
	}
	
	//设置对应下标的顶点值
	public T setVertex(int i, T x) {
		return vertexList.set(i, x);
	}
	
	public abstract int insertVertex(T x); //插入元素为x的顶点
	public abstract void removeVertex(int i); //删除顶点Vi 及其所有关联的边
	public abstract int weight(int i, int j); //返回对应边的权值
	public abstract int next(int i, int j);  //返回Vi 在 Vj后的后继邻接顶点序号
	
	//深度优先遍历
	public void DFSTraverse(int i){
		boolean[] visited = new boolean[this.getNumOfVertex()];
		int j = i;
		System.out.print("深度优先遍历:{");
		do {
			if (!visited[j]) {
				this.depthfs(j, visited);
			}
			j = (j+1)%this.getNumOfVertex();
		} while (j != i);
		System.out.println("}");
	}
	
	public void depthfs(int i, boolean[] visited){ //从顶点Vi开始深度优先遍历
		System.out.print(this.getVertex(i) + "");
		visited[i] = true;
		int j = this.next(i, -1);
		while(j != -1){
			if (!visited[j]) {
				depthfs(j, visited); //递归调用
			}
			j = this.next(i, j);
		}
	}
	
	//广度优先遍历
	public void BFSTraverse(int i){
		boolean[] visited = new boolean[this.getNumOfVertex()];
		int j = i;
		System.out.print("广度优先遍历:{");
		do {
			if (!visited[j]) {
				this.depthfs(j, visited);
			}
			j = (j+1)%this.getNumOfVertex();
		} while (j != i);
		System.out.println("}");
	}
	
	public void breadthfs(int i, boolean[] visited){ //从顶点Vi开始深度优先遍历
		System.out.print(this.getVertex(i) + "");
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		while(!queue.isEmpty()){
			i = queue.poll();
			for (int j = next(i, -1); j != -1; j = next(i, j)) {
				if (!visited[j]) { //访问未访问的顶点
					System.out.print(this.getNumOfVertex() + "");
					visited[j] = true;
					queue.add(j);
				}
			}
			
		}
	}
	
	
   //Prim算法
	public void minSpanTree(){
		Triple[] mstTriples = new Triple[getNumOfVertex() -1];
		for (int i = 0; i < mstTriples.length; i++) {
			mstTriples[i] = new Triple(0, i+1, this.weight(0, i+1));
		}
		for (int i = 0; i < mstTriples.length; i++) {
			int minWeight = mstTriples[i].value;
			int min = i;
			for (int j = i + 1; j < mstTriples.length; j++) {
				if (mstTriples[j].value < minWeight) {
					minWeight = mstTriples[j].value;
					min = j;
				}
			}
			Triple edge = mstTriples[min];
			mstTriples[min] = mstTriples[i];
			mstTriples[i] = edge;
			int tv = edge.column;
			for (int j = i+1; j < mstTriples.length; j++) {
				int v = mstTriples[j].column;
				int weight = this.weight(tv, v);
				if (weight < mstTriples[j].value) {
					mstTriples[j] = new Triple(tv, v, weight);
				}
			}
		}
		System.out.println("\n 最小生成树的边的集合：");
		int mincost = 0;
		for (int i = 0; i < mstTriples.length; i++) {
			System.out.print(mstTriples[i] + "");
			mincost += mstTriples[i].value;
		}
		System.out.println("\n 最小代价为" + mincost);
	}
}
