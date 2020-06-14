package com.Sukie.DSexperiment1;

public class SList<T> { //单链表类
	
	private Node<T> headNode; //头节点
	
	
	//构造函数
	public SList() { //不带参数，空链表
		this.headNode = new Node<T>(); 
	}
	
	public SList(T[] values) { //带参数，参数是存储数据域的数组
		this(); //安排头节点
		//for循环，把数组数据按照顺序插入单链表中
		Node<T> bridgeNode = this.headNode;
		for (int i = 0; i < values.length; i++) {
			bridgeNode.next = new Node<T>(values[i], null);
			bridgeNode = bridgeNode.next;
		}
	}
	//判断链表是否为空
	public boolean isEmpty() {
		return this.headNode.next == null;
	}
	
	//在第i个位置插入元素
	public boolean insert(int i, T data){
        if(i <= 0 && i > length()){
            System.out.println("i值不在范围内");
            return false;
        }
        Node<T> p = this.headNode.next;
        Node<T> q = p;
        int j = 1;
        while(p != null && j < i){
            q = p;
            p = p.next;
            j++;
        }
        Node<T> node = new Node<T>(data, q.next);
        q.next = node;
        return true;
    }
	
	//追加
	public boolean insert(T data){
        Node<T> p = this.headNode.next;
        int j = 1;
        while(p != null ){
            p = p.next;
            j++;
        }
        p= new Node<T>(data, null);
        return true;
    }
	
	//删除第i个元素
	public boolean delete(int i){
        if(i <= 0 && i > length()){
            System.out.println("i值不在范围内");
            return false;
        }
        Node<T> p = this.headNode.next;
        Node<T> q = this.headNode;
        int j = 1;
        while(p != null && j < i){
            q = p;
            p = p.next;
            j++;
        }
        q.next = p.next;
        p.next = null;
        return true;
    }
	
	//返回第i个元素(查找)
	public T getData(int i) {
		if (i <= 0 && i > length()) {
			return null;
		}
		Node<T> eleNode = this.headNode;
		for (int j = 0; j < i && eleNode != null; j++) {
			eleNode = eleNode.next;
		}
		return (eleNode != null)? eleNode.data : null;
	}
	
	//设置第i个元素的data
	public boolean setData(int i, T data){
		if (i <= 0 && i > length()) {
			return false;
		}
		Node<T> eleNode = this.headNode.next;
        int j = 1;
        while(eleNode != null && j < i){
            eleNode = eleNode.next;
            j++;
        }
        eleNode.data = data;
        return true;
	}
	
	//求表长
    public int length(){
        Node<T> p = this.headNode.next;
        int i = 0;
        while(p != null){
            i++;
            p = p.next;
        }
        return i;
    }
    
    @Override //返回所有data
    public String toString() {
    	if (isEmpty()) {
			System.out.println("链表为空");
		}
    	String string = "(";
    	Node<T> p = this.headNode.next;
    	while (p != null) {
			string += p.data.toString();
			if (p.next != null) {
				string += ",";
			}
			p = p.next;
		}
    	string += ")";
    	return string;
    }
}
