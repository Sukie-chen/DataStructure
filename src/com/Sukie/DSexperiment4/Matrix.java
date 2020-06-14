package com.Sukie.DSexperiment4;

import java.util.Scanner;


public class Matrix {
	
	private static void setMatrix(int n){
		//创建int型二维数组
		if(n%2 == 0){
			System.out.println("你输入数字不是奇数，请输入奇数:");
			Scanner sc = new Scanner(System.in);
			int again = sc.nextInt();
			setMatrix(again);
		}else {
			int r = n-1;//方便索引
			int array[][] = new int[n][n];
			int m = 0; //行
			int j = r/2; //列
			array[m][j] =1; //1放在第一行的中间列
			for(int i = 2; i <= (n*n); i++){
				m -=1; //行减1
				j +=1;//列加1
				 if(m<0 && j>r)  //上一个数是第1行第n列时，则把下一个数放在上一个数的下面
				  {
				   m += 2;  //因为行数已经减1，所以需加2
				   j -= 1;  //因为列数已经加1,所以需减1
				  }
				  else {
					if(m <0){
						m = r;//上一个数的行数为1，则下一个数的行数为n
					}
					if(j >r){ //上一个数的列数为n时，下一个数的列数应为1
						j = 0;
					}
				  }
				if(array[m][j] != 0) {
					m += 2;
					j -= 1;
				}
				array[m][j] = i;
				
				
			}
			
			//输出矩阵
			for (int k = 0; k < n; k++) {		//输出魔方阵
				for (int l = 0; l < n; l++) {
					System.out.print(array[k][l] + "\t");
				}
				System.out.println();
			}
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println("请输入奇数构造一个n阶魔阵：");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		setMatrix(n);

	}

}
