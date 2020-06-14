package com.Sukie.DSexperiment3;

public class Sotred<T extends Comparable<? super T>> extends CirDoublyList<T>{
	
	public DoubleNode<T> insert(T x){
		if (this.isEmpty() || x.compareTo(this.head.prev.data) > 0) {
			return super.insert(x);//最大值插入头节点之前
		}
		DoubleNode<T> p = this.head.next;
		while (p != head && x.compareTo(p.data) > 0) {
			p = p.next;
			
		}
		DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //在p节点之前插入data为x的节点
		p.prev.next = q;
		p.prev = q;
		
		return q;
	}
}
