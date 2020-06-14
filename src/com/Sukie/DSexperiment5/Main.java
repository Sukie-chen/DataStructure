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
            System.out.println("二叉树结点数："+binaryTree.getCount());
            break;
        case 6:
            System.out.println("二叉树高度："+binaryTree.getHeight());
            break;
        case 0:
            System.exit(0);
        default:
            System.out.println("输入的菜单指令不符合要求");
		}
	}

	public static void main(String[] args) {
		//构造二叉树
		String[] prelist = {"A", "B", "D",null, "G",null,null,null, "C", "E",null,null, "F", "H"};
		BinaryTree<String> binaryTree= new BinaryTree<String>(prelist);
		
		
		System.out.println("菜单如下：");
		System.out.println("1——先序遍历");
		System.out.println("2——中序遍历");
		System.out.println("3——后序遍历");
		System.out.println("4——层次遍历");
		System.out.println("5——求结点总数");
		System.out.println("6——求高度");
		System.out.println("0——退出");
		System.out.println("输入菜单选项，可进行相应操作并输出结果");
		
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			done(binaryTree, n);
		}
		
		
	}

}
