package com.Sukie.DSexperiment3;

public class ProcessMain {
	public static void main(String[] args) {
		
		Process process[] = {new Process("A", 4), new Process("B", 3), new Process("C"), new Process("D", 4), new Process("E", 10), new Process("F", 1)};
		PriorityQueue<Process> queue = new PriorityQueue<Process>(false); //����
		System.out.println("��ӽ��̣�");
		for (int i = 0; i < process.length; i++) {
			queue.add(process[i]);
			System.out.println(process[i] + "");
		}
		System.out.println("\n ���ӽ��̣�");
		while (!queue.isEmpty() ) {
			System.out.println(queue.poll().toString() + "");
			
		}
	}

}
