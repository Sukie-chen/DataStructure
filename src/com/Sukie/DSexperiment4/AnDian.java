package com.Sukie.DSexperiment4;

import java.util.Scanner;



public class AnDian {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("请输入矩阵的行数：");
		int row = scan1.nextInt();
		Scanner scan2 = new Scanner(System.in);
		System.out.println("请输入矩阵的列数：");
		int cell = scan2.nextInt();
		
		int array[][] = new int[row][cell];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j <cell; j++){
				System.out.println("请输入矩阵中第"+ (i+1)+"行，第"+(j+1)+" 列的（int）元素");
				Scanner scan3 = new Scanner(System.in);
				array[i][j] = scan3.nextInt();
			}
		}
		
		int[] temp1 = new int[row];
		int[] temp2 = new int[cell];
		int temp = 1;

		for(int i = 0; i < row; i++){
			temp1[i] = array[i][0];
			for(int j = 1; j < cell; j++){
				if(temp1[i] > array[i][j]){
					temp1[i] =array[i][j];
				}else continue;
			}
			System.out.println("第"+(i+1)+"行最小的数为："+temp1[i]);}

		for(int j = 0; j < cell; j++){
			temp2[j] = array[0][j];
			for(int i = 1;i < row; i++){
				if(temp2[j] < array[i][j]){
					temp2[j] = array[i][j];
				} else continue;
			} 
			System.out.println("第"+(j+1)+"列最大的数为："+temp2[j]);
		}

		for(int i=0;i<row;i++){
			for(int j=0;j<cell;j++){
				if(array[i][j]==temp1[i] && array[i][j]==temp2[j]){
					System.out.println("用户输入的数组的鞍点为：array["+i+"]["+j+"] ="+array[i][j]);
				} else temp=0;
		};
		if(temp==0){
			System.out.println("用户输入的数组中没有鞍点");
			}
		}
		
	}

}
