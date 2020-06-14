package com.Sukie.Dsecperiment7;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			int n = 5;
			String vertexs[] = {"A", "B", "C", "D", "E"};
			Graph graph = new Graph(n);
			//��Ӷ���
			for (String vertex : vertexs) {
				graph.insertVertex(vertex);
			}
			//��ӳ�ʼ����µı�
			graph.insertEdge(0, 1, 45);
			graph.insertEdge(0, 2, 28);
			graph.insertEdge(0, 3, 10);
			graph.insertEdge(1, 0, 45);
			graph.insertEdge(1, 2, 12);
			graph.insertEdge(1, 4, 21);
			graph.insertEdge(2, 0, 28);
			graph.insertEdge(2, 1, 12);
			graph.insertEdge(2, 3, 17);
			graph.insertEdge(2, 4, 26);
			graph.insertEdge(3, 0, 10);
			graph.insertEdge(3, 2, 17);
			graph.insertEdge(3, 4, 15);
			graph.insertEdge(4, 1, 21);
			graph.insertEdge(4, 2, 26);
			graph.insertEdge(4, 3, 15);
			//��һ�δ�ӡ�ڽӾ���
			graph.showGraph();
			System.out.println("\n");
			
			//���붥��F�������(D,F,13)��(E,F,11)
			graph.insertVertex("F");
			graph.insertEdge(3, 5, 13);
			graph.insertEdge(4, 5, 11);
			//�ڶ��δ�ӡ�ڽӾ���
			graph.showGraph();
			System.out.println("\n");
			
			//ɾ����(E,F,11)
			graph.removeEdge(4, 5);
			//�����δ�ӡ�ڽӾ���
			graph.showGraph();
			System.out.println("\n");
			
			//ɾ������D�����붥��G
			graph.removeVertex(3);
			graph.insertVertex("G");
			//���Ĵδ�ӡ�ڽӾ���
			graph.showGraph();
	}

}
