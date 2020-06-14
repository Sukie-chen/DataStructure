package com.Sukie.DSexperiment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
	
	public Josephus(int number,int start,int distance){
		List<String> list=new ArrayList<String>(number);
		Scanner scanner  = new Scanner(System.in); //��ȡ�û������Ԫ��
		System.out.println("����������Լɪ����number������Ԫ��");
		for(int i=0;i<number;i++){
			String element = scanner.nextLine();
			list.add(element);
		}
		System.out.print("Լɪ��("+number+","+start+","+distance+"),");
		System.out.println(list.toString());
		int i=start;
		while(list.size()>1){
			i=(i+distance-1)%list.size();
			System.out.print("ɾ����Ԫ�أ�"+list.remove(i).toString()+",");
			System.out.println(list.toString());
		}
		System.out.println("��������ﷸ�ǣ�"+list.get(0).toString());
	}

	
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in); //��ȡ�û������Ԫ��
		System.out.println("����Լɪ�򻷳���number");
		int number = scanner.nextInt();
		System.out.println("��ʼλ��start(С��number)");
		int start = scanner.nextInt();
		System.out.println("����ֵdistance(С��number)");
		int distance = scanner.nextInt();
		new Josephus(number, start, distance);
	}

}
