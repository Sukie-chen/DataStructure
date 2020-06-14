package com.Sukie.DSexperiment1;

public class SList<T> { //��������
	
	private Node<T> headNode; //ͷ�ڵ�
	
	
	//���캯��
	public SList() { //����������������
		this.headNode = new Node<T>(); 
	}
	
	public SList(T[] values) { //�������������Ǵ洢�����������
		this(); //����ͷ�ڵ�
		//forѭ�������������ݰ���˳����뵥������
		Node<T> bridgeNode = this.headNode;
		for (int i = 0; i < values.length; i++) {
			bridgeNode.next = new Node<T>(values[i], null);
			bridgeNode = bridgeNode.next;
		}
	}
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return this.headNode.next == null;
	}
	
	//�ڵ�i��λ�ò���Ԫ��
	public boolean insert(int i, T data){
        if(i <= 0 && i > length()){
            System.out.println("iֵ���ڷ�Χ��");
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
	
	//׷��
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
	
	//ɾ����i��Ԫ��
	public boolean delete(int i){
        if(i <= 0 && i > length()){
            System.out.println("iֵ���ڷ�Χ��");
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
	
	//���ص�i��Ԫ��(����)
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
	
	//���õ�i��Ԫ�ص�data
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
	
	//���
    public int length(){
        Node<T> p = this.headNode.next;
        int i = 0;
        while(p != null){
            i++;
            p = p.next;
        }
        return i;
    }
    
    @Override //��������data
    public String toString() {
    	if (isEmpty()) {
			System.out.println("����Ϊ��");
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
