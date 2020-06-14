package com.Sukie.DSexperiment3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyQueue {

	//出队入队操作
	public static void operate(Queue<Integer> queue,int n){
		if (n==0) {
			System.exit(0);
		} else if (n%2 == 0){ //偶数
			queue.poll(); //第一个元素出队
			for(int q : queue){
	            System.out.print(q+" ");
	        }
		} else if (n%2 != 0) {
			queue.offer(n); //奇数入队
			for(int q : queue){
	            System.out.print(q+" ");
	        }
		}else {
			System.out.println("请输入正确数字");
		}
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();//空队列
		System.out.println("请输入int型数字（大于等于0）");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int num = scanner.nextInt();
			operate(queue, num);
		}
		
		
	}

}
