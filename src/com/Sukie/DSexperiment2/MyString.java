package com.Sukie.DSexperiment2;

public class MyString implements Comparable<MyString>{
	
	private final char[] value;
	
	public MyString() {
		this.value = new char[0]; //����մ�
	}

	public MyString(String string){
		this.value = new char[string.length()]; //��������ַ�����ַ���value������
		for (int i = 0; i < this.value.length; i++) {
			this.value[i] = string.charAt(i);
		}
	}
	
	
	//��ָ��value�����н�ȡ��iλ�ÿ�ʼ��n���ַ�
	public MyString(char[] value, int i, int n){
		if (i >= 0 && n >= 0 && i+n <= value.length) { //����i��n���ں���Χ��
			this.value = new char[n];
			for (int j = 0; j < n; j++) {
				this.value[j] = value[i+j];
			}
		}else {
			throw new StringIndexOutOfBoundsException("i:"+i+",n:"+n);
		}
	}
	
	//ֻ����value����
	public MyString(char[] value){
		this(value, 0, value.length);
	}
	
	public MyString(MyString string){
		this(string.value);
	}
	
	//���ش��ĳ���
	public int getLength(){
		return this.value.length;
	}
	
	//���ش�
	@Override
	public String toString() {
		return new String(this.value);
	}
	
	
	//���ص�i���ַ�
	public char CharAt(int i) { 
		if (i >= 0 && i < this.value.length) {
			return this.value[i];
		}else {
			throw new StringIndexOutOfBoundsException("iֵ������Ҫ��");
		}
	}
	
	
	//��ȡ�Ӵ�
	public MyString subString(int begin, int end) {
		if (begin == 0 && end == this.value.length) {
			return this;
		} else {
			return new MyString(this.value, begin, end-begin);
		}
	}
	public MyString subString(int begin) {
		return  subString(begin, this.value.length);
	}
	
	//���غϳɴ�
	public MyString conbat(MyString string) {
		if (string == null) {
			string = new MyString("null");
		}
		char[] bridge = new char[this.value.length + string.getLength()];
		int i;
		for (i= 0; i < this.value.length; i++) {
			bridge[i] = this.value[i];
		}
		for (int j = 0; j < string.value.length; j++) {
			bridge[i+j] = string.value[j];
		}
		
		return new MyString(bridge);
	}
	
	//�Ƚ�this��str�������Ĵ�С�����ز�ֵ
	public int compareTo(MyString str) {
		for (int i = 0; i < this.value.length; i++) {
			if (this.value[i] != str.value[i]) {
				return this.value[i] - str.value[i]; //��ͬ�ַ�֮��Ĳ�ֵ
			}
		}
		return this.value.length - str.value.length; //��ǰ׺��ͬʱ�����س��ȵĲ�ֵ
	}
	
	
	//����ƥ��
	public int indexOfBF(MyString patternStr){
		return this.indexOfBF(patternStr, 0);  //Ĭ�ϴ�0��λ�ÿ�ʼƥ��
	}
	
	public int indexOfBF(MyString pattrenStr, int begin){
		int n = this.getLength();
		int m = pattrenStr.getLength();
		if (begin < 0) {
			begin = 0; 
		}
		//���Ŀ�괮�ַ�����Ϊ�㡢Ŀ�괮�ַ�����С��ģʽ������ʼƥ���λ�ó���Ŀ�괮�ķ�Χ����ֱ�ӷ��� -1 ��ʾƥ��ʧ��
		if (n==0 || n < m || begin >= n) {  
			return -1;
		}
		
		int counts = 0; //��¼ƥ�����
		//��ֵ��������ѭ��ƥ��  j Ϊ��Ŀ�괮��ƥ�����ͬ�ַ��ĳ��ȣ�δƥ��֮ǰ�ĳ�ʼֵΪ�㣨Ҳ��ΪĿ�괮���ַ�������±꣩
		int i = begin, j = 0; 
		while(i < n && j < m){
			counts++;
			if (this.CharAt(i) == pattrenStr.CharAt(j)) {
				i++;
				j++;
			}else {
				i = i - j + 1; //ƥ��ʧ���˻ص�ԭ����ʼƥ��λ�õ���һ��λ�ã���������ƥ��
				j = 0; 
				if (i > n - m) {//��Ŀ�괮�ĳ��Ȳ������˳�ѭ����ƥ��ʧ��
					break;
				}
			}
			
		}
		if (j == m) {
			return i - j; //ƥ��ɹ�
		}
		return -1;
		
	}
	
}
