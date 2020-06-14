package com.Sukie.DSexperiment3;

public class Sotred<T extends Comparable<? super T>> extends CirDoublyList<T>{
	
	public DoubleNode<T> insert(T x){
		if (this.isEmpty() || x.compareTo(this.head.prev.data) > 0) {
			return super.insert(x);//���ֵ����ͷ�ڵ�֮ǰ
		}
		DoubleNode<T> p = this.head.next;
		while (p != head && x.compareTo(p.data) > 0) {
			p = p.next;
			
		}
		DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //��p�ڵ�֮ǰ����dataΪx�Ľڵ�
		p.prev.next = q;
		p.prev = q;
		
		return q;
	}
}
