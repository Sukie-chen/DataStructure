package com.Sukie.DSexperiment5;

import java.util.Scanner;

public class Main {
	
	
	public static void done(BinaryTree<String> binaryTree, int n){
		switch (n){
        case 1:
            binaryTree.preOrder();
            break;
        case 2:
            binaryTree.inOrder();
            break;
        case 3:
            binaryTree.postOrder();
            break;
        case 4:
            binaryTree.levelOrder();
            break;
        case 5:
            System.out.println("�������������"+binaryTree.getCount());
            break;
        case 6:
            System.out.println("�������߶ȣ�"+binaryTree.getHeight());
            break;
        case 0:
            System.exit(0);
        default:
            System.out.println("����Ĳ˵�ָ�����Ҫ��");
		}
	}

	public static void main(String[] args) {
		//���������
		String[] prelist = {"A", "B", "D",null, "G",null,null,null, "C", "E",null,null, "F", "H"};
		BinaryTree<String> binaryTree= new BinaryTree<String>(prelist);
		
		
		System.out.println("�˵����£�");
		System.out.println("1�����������");
		System.out.println("2�����������");
		System.out.println("3�����������");
		System.out.println("4������α���");
		System.out.println("5������������");
		System.out.println("6������߶�");
		System.out.println("0�����˳�");
		System.out.println("����˵�ѡ��ɽ�����Ӧ������������");
		
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			done(binaryTree, n);
		}
		
		
	}

}
