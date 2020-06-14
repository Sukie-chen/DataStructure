package com.Sukie.DSexperiment1;

public class Main1 {

	public static void main(String[] args) {
		String[] values = {"A", "B", "C", "D", "E"};
		SList<String> sList = new SList<String>(values);
		System.out.println(sList.toString());//首次打印链表数据
		sList.insert("F");//追加F和G
		sList.insert("G");
		System.out.println(sList.toString());//第二次打印链表数据
		sList.delete(3); //删除第3个yuans
		System.out.println(sList.toString());//第3次打印链表数据
		System.out.println(sList.getData(4)); //获得第4个元素data值
	}

}
