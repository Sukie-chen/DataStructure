package com.Sukie.DSexperiment3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyQueue {

	//������Ӳ���
	public static void operate(Queue<Integer> queue,int n){
		if (n==0) {
			System.exit(0);
		} else if (n%2 == 0){ //ż��
			queue.poll(); //��һ��Ԫ�س���
			for(int q : queue){
	            System.out.print(q+" ");
	        }
		} else if (n%2 != 0) {
			queue.offer(n); //�������
			for(int q : queue){
	            System.out.print(q+" ");
	        }
		}else {
			System.out.println("��������ȷ����");
		}
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();//�ն���
		System.out.println("������int�����֣����ڵ���0��");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int num = scanner.nextInt();
			operate(queue, num);
		}
		
		
	}

}
