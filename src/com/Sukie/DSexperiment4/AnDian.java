package com.Sukie.DSexperiment4;

import java.util.Scanner;



public class AnDian {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("����������������");
		int row = scan1.nextInt();
		Scanner scan2 = new Scanner(System.in);
		System.out.println("����������������");
		int cell = scan2.nextInt();
		
		int array[][] = new int[row][cell];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j <cell; j++){
				System.out.println("����������е�"+ (i+1)+"�У���"+(j+1)+" �еģ�int��Ԫ��");
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
			System.out.println("��"+(i+1)+"����С����Ϊ��"+temp1[i]);}

		for(int j = 0; j < cell; j++){
			temp2[j] = array[0][j];
			for(int i = 1;i < row; i++){
				if(temp2[j] < array[i][j]){
					temp2[j] = array[i][j];
				} else continue;
			} 
			System.out.println("��"+(j+1)+"��������Ϊ��"+temp2[j]);
		}

		for(int i=0;i<row;i++){
			for(int j=0;j<cell;j++){
				if(array[i][j]==temp1[i] && array[i][j]==temp2[j]){
					System.out.println("�û����������İ���Ϊ��array["+i+"]["+j+"] ="+array[i][j]);
				} else temp=0;
		};
		if(temp==0){
			System.out.println("�û������������û�а���");
			}
		}
		
	}

}
