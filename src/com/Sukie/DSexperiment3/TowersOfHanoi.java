package com.Sukie.DSexperiment3;

import java.util.Scanner;

public class TowersOfHanoi {
	static int numOfMove = 0; //����ƶ�����
	/**������ƶ�����
	 * @param disks Բ��
	 * @param M ��M�� �ƶ��� N��
	 * @param N
	 */
	public static void move(int disks, char M, char N){
		System.out.println("��" +(++numOfMove)+ "���ƶ�����" +disks+ "��Բ�̴�" +M+ "�ƶ���" +N);
	}
	
	//�ݹ�ʵ�ֺ�ŵ��
	/**
	 * @param n Բ�̵ĸ���
	 * @param A A B C ������
	 * @param B
	 * @param c
	 */
	public static void hanoi(int n, char A, char B, char C){
		if (n==1) {
			move(1, A, C);
		} else {
			 hanoi(n - 1, A, C, B);//�ݹ飬��A���ϱ��1~n-1��Բ���Ƶ�B�ϣ���CΪ������
	         move(n, A, C);//��A���ϱ��Ϊn��Բ���Ƶ�C��
	         hanoi(n - 1, B, A, C);//�ݹ飬��B���ϱ��1~n-1��Բ���Ƶ�C�ϣ���AΪ������
		}
		
	}
	public static void main(String[] args) {
		System.out.println("������Բ����Ŀ��");
		Scanner scan=new Scanner(System.in); //����Բ����Ŀ
		int number=scan.nextInt();
		hanoi(number,'A','B','C'); //����hanoi����
	}

}
