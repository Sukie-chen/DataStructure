package com.Sukie.DSexperiment8;

public class Main {

	public static void main(String[] args) {
		//构建带权无向图
		String[] verStrings = {"A", "B", "C", "D", "E"};
		Triple edge[] ={new Triple(0, 1, 45), new Triple(0, 2, 28), new Triple(0, 3, 10),
				new Triple(1, 0, 45), new Triple(1, 2, 12), new Triple(1, 4, 21), new Triple(2, 0, 28),
				new Triple(2, 1, 12), new Triple(2, 3, 17), new Triple(2, 4, 26), new Triple(3, 0, 10),
				new Triple(3, 2, 17), new Triple(3, 4, 15), new Triple(4, 1, 21), new Triple(4, 2, 26),
				new Triple(4, 3, 15)}; 
		MatrixGraph<String> graph = new MatrixGraph<String>(verStrings, edge);
		System.out.println("带权无向图G3" + graph.toString());
		
		//采用深度优先遍历和广度优先遍历对G3进行遍历，输出遍历序列
		graph.DFSTraverse(0);
		graph.BFSTraverse(0);
		graph.DFSTraverse(2);
		graph.BFSTraverse(2);
		graph.DFSTraverse(4);
		graph.BFSTraverse(4);
		
		//运用Prim算法求出G3的最小生成树，输出最小生成树及代价
		graph.minSpanTree();
	}

}
