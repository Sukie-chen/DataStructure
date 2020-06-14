package com.Sukie.DSexperiment1;

public class Node<T> {  //������ڵ���(����)
	public T data; //������
	public Node<T> next; //���
	//���캯����ʼ������(���������޲���)
	public Node() {
		this(null, null);
	}
	
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	//������������ַ�����
	@Override
	public String toString() {
		return this.data.toString();
	}
}
