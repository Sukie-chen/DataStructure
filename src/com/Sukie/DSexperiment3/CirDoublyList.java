package com.Sukie.DSexperiment3;


public class CirDoublyList<T> { //ѭ��˫����
	
	public DoubleNode<T> head; //ͷ���
	//����յ�ѭ��˫����
	public CirDoublyList() { 
		this.head = new DoubleNode<T>();
		this.head.prev = this.head;
		this.head.next = this.head;
	}
	
	public boolean isEmpty(){
		return this.head.next == this.head;
	}
	
	public DoubleNode<T> insert(int i, T x) {//����x ��Ϊ��i��Ԫ�� ��ͷ���β�壩
		if (x == null) {
			throw new NullPointerException("X==null");
		}
		DoubleNode<T> font = this.head; 
		for (int j = 0; font.next != this.head && j < i; j++) {
			font = font.next;
		}
		DoubleNode<T> q = new DoubleNode<T>(x, font, font.next); //��font֮�����x
		font.next.prev = q;
		font.next = q;
		return q;
	}
	public DoubleNode<T> insert(T x) {//����x ��Ϊ��i��Ԫ�� ��ͷ���β�壩
		if (x == null) {
			throw new NullPointerException("X==null");
		}
		DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); // β��
		head.prev.next = q;
		head.prev = q;
		return q;
	}
	
	
	//ɾ������
	public T removeLast(){
		DoubleNode<T> p = this.head;
		while (p.next != this.head) {
			p = p.next;
		}
		p.prev.next = this.head;
		this.head.prev = p.prev;
		return p.data;
	}
	
	public T remove(int i){
		DoubleNode<T> p = this.head;
		for (int j = 0; p.next != this.head && j < i; j++) {
			p = p.next;
		}
		p.prev.next = p.next.next;
		p.next.next.prev = p.prev;
		return p.data;
	}
	
	//��ѯ����
	public T get(int i){
		DoubleNode<T> p = this.head;
		for (int j = 0; p.next != this.head && j < i; j++) {
			p = p.next;
		}
		return p.data;
	}
	
	
	//�������
	public String toPreviousString(){
		DoubleNode<T> p = this.head;
		while (p.prev != this.head) {
			p = p.prev;
			return p.toString();
		}
		return null;
	}
}
