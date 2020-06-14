package com.Sukie.DSexperiment8;

public class Main {

	public static void main(String[] args) {
		//������Ȩ����ͼ
		String[] verStrings = {"A", "B", "C", "D", "E"};
		Triple edge[] ={new Triple(0, 1, 45), new Triple(0, 2, 28), new Triple(0, 3, 10),
				new Triple(1, 0, 45), new Triple(1, 2, 12), new Triple(1, 4, 21), new Triple(2, 0, 28),
				new Triple(2, 1, 12), new Triple(2, 3, 17), new Triple(2, 4, 26), new Triple(3, 0, 10),
				new Triple(3, 2, 17), new Triple(3, 4, 15), new Triple(4, 1, 21), new Triple(4, 2, 26),
				new Triple(4, 3, 15)}; 
		MatrixGraph<String> graph = new MatrixGraph<String>(verStrings, edge);
		System.out.println("��Ȩ����ͼG3" + graph.toString());
		
		//����������ȱ����͹�����ȱ�����G3���б����������������
		graph.DFSTraverse(0);
		graph.BFSTraverse(0);
		graph.DFSTraverse(2);
		graph.BFSTraverse(2);
		graph.DFSTraverse(4);
		graph.BFSTraverse(4);
		
		//����Prim�㷨���G3����С�������������С������������
		graph.minSpanTree();
	}

}
