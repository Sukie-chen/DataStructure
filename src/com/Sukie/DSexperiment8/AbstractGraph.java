package com.Sukie.DSexperiment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractGraph<T> {  //���㼯����
	protected static final int MAX_WEIGHT = 0x0000ffff;
	protected ArrayList<T> vertexList; //����˳���
	public AbstractGraph(int length) {
		this.vertexList =  new ArrayList<T>(length);  //��������Ϊlength�Ŀձ�
	}
	public AbstractGraph() {
		this(10); //��������ΪlengthĬ��Ϊ10�Ŀձ�
	}
	
	//���ض������
	public int getNumOfVertex(){
		return vertexList.size();
	}
	
	//���ض��㼯��
	public String toString(){
		return "���㼯��:" + this.vertexList.toString() + "\n";
	}
	
	//���ض�Ӧ�±�Ķ���ֵ
	public T getVertex(int i){
		return vertexList.get(i);
	}
	
	//���ö�Ӧ�±�Ķ���ֵ
	public T setVertex(int i, T x) {
		return vertexList.set(i, x);
	}
	
	public abstract int insertVertex(T x); //����Ԫ��Ϊx�Ķ���
	public abstract void removeVertex(int i); //ɾ������Vi �������й����ı�
	public abstract int weight(int i, int j); //���ض�Ӧ�ߵ�Ȩֵ
	public abstract int next(int i, int j);  //����Vi �� Vj��ĺ���ڽӶ������
	
	//������ȱ���
	public void DFSTraverse(int i){
		boolean[] visited = new boolean[this.getNumOfVertex()];
		int j = i;
		System.out.print("������ȱ���:{");
		do {
			if (!visited[j]) {
				this.depthfs(j, visited);
			}
			j = (j+1)%this.getNumOfVertex();
		} while (j != i);
		System.out.println("}");
	}
	
	public void depthfs(int i, boolean[] visited){ //�Ӷ���Vi��ʼ������ȱ���
		System.out.print(this.getVertex(i) + "");
		visited[i] = true;
		int j = this.next(i, -1);
		while(j != -1){
			if (!visited[j]) {
				depthfs(j, visited); //�ݹ����
			}
			j = this.next(i, j);
		}
	}
	
	//������ȱ���
	public void BFSTraverse(int i){
		boolean[] visited = new boolean[this.getNumOfVertex()];
		int j = i;
		System.out.print("������ȱ���:{");
		do {
			if (!visited[j]) {
				this.depthfs(j, visited);
			}
			j = (j+1)%this.getNumOfVertex();
		} while (j != i);
		System.out.println("}");
	}
	
	public void breadthfs(int i, boolean[] visited){ //�Ӷ���Vi��ʼ������ȱ���
		System.out.print(this.getVertex(i) + "");
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		while(!queue.isEmpty()){
			i = queue.poll();
			for (int j = next(i, -1); j != -1; j = next(i, j)) {
				if (!visited[j]) { //����δ���ʵĶ���
					System.out.print(this.getNumOfVertex() + "");
					visited[j] = true;
					queue.add(j);
				}
			}
			
		}
	}
	
	
   //Prim�㷨
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
		System.out.println("\n ��С�������ıߵļ��ϣ�");
		int mincost = 0;
		for (int i = 0; i < mstTriples.length; i++) {
			System.out.print(mstTriples[i] + "");
			mincost += mstTriples[i].value;
		}
		System.out.println("\n ��С����Ϊ" + mincost);
	}
}
