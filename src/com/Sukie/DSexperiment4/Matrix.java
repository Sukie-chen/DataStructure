package com.Sukie.DSexperiment4;

import java.util.Scanner;


public class Matrix {
	
	private static void setMatrix(int n){
		//����int�Ͷ�ά����
		if(n%2 == 0){
			System.out.println("���������ֲ�������������������:");
			Scanner sc = new Scanner(System.in);
			int again = sc.nextInt();
			setMatrix(again);
		}else {
			int r = n-1;//��������
			int array[][] = new int[n][n];
			int m = 0; //��
			int j = r/2; //��
			array[m][j] =1; //1���ڵ�һ�е��м���
			for(int i = 2; i <= (n*n); i++){
				m -=1; //�м�1
				j +=1;//�м�1
				 if(m<0 && j>r)  //��һ�����ǵ�1�е�n��ʱ�������һ����������һ����������
				  {
				   m += 2;  //��Ϊ�����Ѿ���1���������2
				   j -= 1;  //��Ϊ�����Ѿ���1,�������1
				  }
				  else {
					if(m <0){
						m = r;//��һ����������Ϊ1������һ����������Ϊn
					}
					if(j >r){ //��һ����������Ϊnʱ����һ����������ӦΪ1
						j = 0;
					}
				  }
				if(array[m][j] != 0) {
					m += 2;
					j -= 1;
				}
				array[m][j] = i;
				
				
			}
			
			//�������
			for (int k = 0; k < n; k++) {		//���ħ����
				for (int l = 0; l < n; l++) {
					System.out.print(array[k][l] + "\t");
				}
				System.out.println();
			}
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println("��������������һ��n��ħ��");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		setMatrix(n);

	}

}
