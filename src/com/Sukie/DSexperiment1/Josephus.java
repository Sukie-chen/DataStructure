package com.Sukie.DSexperiment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
	
	public Josephus(int number,int start,int distance){
		List<String> list=new ArrayList<String>(number);
		Scanner scanner  = new Scanner(System.in); //获取用户输入的元素
		System.out.println("请依次输入约瑟夫环中number个数据元素");
		for(int i=0;i<number;i++){
			String element = scanner.nextLine();
			list.add(element);
		}
		System.out.print("约瑟夫环("+number+","+start+","+distance+"),");
		System.out.println(list.toString());
		int i=start;
		while(list.size()>1){
			i=(i+distance-1)%list.size();
			System.out.print("删除的元素："+list.remove(i).toString()+",");
			System.out.println(list.toString());
		}
		System.out.println("被赦免的罪犯是："+list.get(0).toString());
	}

	
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in); //获取用户输入的元素
		System.out.println("输入约瑟夫环长度number");
		int number = scanner.nextInt();
		System.out.println("起始位置start(小于number)");
		int start = scanner.nextInt();
		System.out.println("计数值distance(小于number)");
		int distance = scanner.nextInt();
		new Josephus(number, start, distance);
	}

}
