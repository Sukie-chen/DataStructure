package com.Sukie.DSexperiment1;

public class Main1 {

	public static void main(String[] args) {
		String[] values = {"A", "B", "C", "D", "E"};
		SList<String> sList = new SList<String>(values);
		System.out.println(sList.toString());//�״δ�ӡ��������
		sList.insert("F");//׷��F��G
		sList.insert("G");
		System.out.println(sList.toString());//�ڶ��δ�ӡ��������
		sList.delete(3); //ɾ����3��yuans
		System.out.println(sList.toString());//��3�δ�ӡ��������
		System.out.println(sList.getData(4)); //��õ�4��Ԫ��dataֵ
	}

}
