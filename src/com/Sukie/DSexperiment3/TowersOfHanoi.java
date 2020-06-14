package com.Sukie.DSexperiment3;

import java.util.Scanner;

public class TowersOfHanoi {
	static int numOfMove = 0; //标记移动次数
	/**输出的移动过程
	 * @param disks 圆盘
	 * @param M 从M塔 移动到 N塔
	 * @param N
	 */
	public static void move(int disks, char M, char N){
		System.out.println("第" +(++numOfMove)+ "次移动：把" +disks+ "号圆盘从" +M+ "移动到" +N);
	}
	
	//递归实现汉诺塔
	/**
	 * @param n 圆盘的个数
	 * @param A A B C 三座塔
	 * @param B
	 * @param c
	 */
	public static void hanoi(int n, char A, char B, char C){
		if (n==1) {
			move(1, A, C);
		} else {
			 hanoi(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
	         move(n, A, C);//把A塔上编号为n的圆盘移到C上
	         hanoi(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
		}
		
	}
	public static void main(String[] args) {
		System.out.println("请输入圆盘数目：");
		Scanner scan=new Scanner(System.in); //输入圆盘数目
		int number=scan.nextInt();
		hanoi(number,'A','B','C'); //调用hanoi方法
	}

}
