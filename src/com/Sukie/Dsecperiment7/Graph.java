package com.Sukie.Dsecperiment7;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	private ArrayList<String> vertexList; //�洢����ļ���
	private int[][] edge; //�洢ͼ��Ӧ���ڽӾ���
	private int numOfEdge;//�ߵ���Ŀ
	private int vertexSize;//���չ��캯����ʼ������
	
	//���캯����ʼ�����������벻��������
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
	
	
	//���붥��
	public void insertVertex(String vertex){
		vertexList.add(vertex);
		int n = vertexList.size();
		if(n > vertexSize){
			inEdge(n);
		}
		
	}
	
	//��ӱ�
	/**
	 * @param v1 �±�
	 * @param v2
	 * @param weight Ȩֵ
	 */
	public void insertEdge(int v1, int v2, int weight){ //�ԽǾ���
		edge[v1][v2] = weight;
		edge[v2][v1] = weight;
		numOfEdge++;
	}
	
	//������٣����¶���edge����������
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
			throw new IllegalArgumentException("����������������Ҫ��");
		}
	}
	
	//�����������ʱ�����¶�������
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
			throw new IllegalArgumentException("����������������Ҫ��");
		}
	}
	//���ض������
	public int getNumOfVertex(){
		return vertexList.size();
	}
	//���ض�Ӧ�±�Ķ���ֵ
	public String getVertex(int i){
		return vertexList.get(i);
	}
	//���رߵ���Ŀ
	public int getEdge(){
		return numOfEdge;
	}
	//���ض�Ӧ��Ȩֵ
	public int getWeight(int v1, int v2){
		return edge[v1][v2];
	}
	
	//ɾ����Ӧ����
	public void removeVertex(int i){
		int n = vertexList.size(); //��ö������
		//����
		if (i >= 0 && i < n) {
			vertexList.remove(i);
			for (int j = i+1; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					edge[j-1][j2] = edge[j][j2]; 
				}
			}
			//����
			for (int j = 0; j < n; j++) {
				for (int j2 = i+1; j2 < n; j2++) {
					edge[j][j2-1] = edge[j][j2]; 
				}
			}
			deEdge(n-1);
		} else {
			throw new IndexOutOfBoundsException("iֵ���ڷ�Χ��");
		}
		
	}
	
	//ɾ����Ӧ��
	public void removeEdge(int v1, int v2){
		int n = vertexList.size();
		if (v1 < n && v2 < n) {
			if(v1 != v2){
				insertEdge(v1, v2, 0);
			}
		}else {
			throw new IndexOutOfBoundsException("v1,v2ֵ������Ҫ��");
		}
		
	}
	
	//��ӡ����
	public void showGraph(){
		for (int[] value : edge) {
			System.out.println(Arrays.toString(value));
		}
	}
	
}
