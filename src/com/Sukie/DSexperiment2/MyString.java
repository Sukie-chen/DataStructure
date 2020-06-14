package com.Sukie.DSexperiment2;

public class MyString implements Comparable<MyString>{
	
	private final char[] value;
	
	public MyString() {
		this.value = new char[0]; //构造空串
	}

	public MyString(String string){
		this.value = new char[string.length()]; //将传入的字符串拆分放在value数组内
		for (int i = 0; i < this.value.length; i++) {
			this.value[i] = string.charAt(i);
		}
	}
	
	
	//在指定value数组中截取从i位置开始的n个字符
	public MyString(char[] value, int i, int n){
		if (i >= 0 && n >= 0 && i+n <= value.length) { //控制i和n处于合理范围内
			this.value = new char[n];
			for (int j = 0; j < n; j++) {
				this.value[j] = value[i+j];
			}
		}else {
			throw new StringIndexOutOfBoundsException("i:"+i+",n:"+n);
		}
	}
	
	//只传入value数组
	public MyString(char[] value){
		this(value, 0, value.length);
	}
	
	public MyString(MyString string){
		this(string.value);
	}
	
	//返回串的长度
	public int getLength(){
		return this.value.length;
	}
	
	//返回串
	@Override
	public String toString() {
		return new String(this.value);
	}
	
	
	//返回第i个字符
	public char CharAt(int i) { 
		if (i >= 0 && i < this.value.length) {
			return this.value[i];
		}else {
			throw new StringIndexOutOfBoundsException("i值不符合要求");
		}
	}
	
	
	//截取子串
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
	
	//返回合成串
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
	
	//比较this和str两个串的大小，返回差值
	public int compareTo(MyString str) {
		for (int i = 0; i < this.value.length; i++) {
			if (this.value[i] != str.value[i]) {
				return this.value[i] - str.value[i]; //不同字符之间的差值
			}
		}
		return this.value.length - str.value.length; //当前缀相同时，返回长度的差值
	}
	
	
	//暴力匹配
	public int indexOfBF(MyString patternStr){
		return this.indexOfBF(patternStr, 0);  //默认从0的位置开始匹配
	}
	
	public int indexOfBF(MyString pattrenStr, int begin){
		int n = this.getLength();
		int m = pattrenStr.getLength();
		if (begin < 0) {
			begin = 0; 
		}
		//如果目标串字符数组为零、目标串字符长度小于模式串、开始匹配的位置超出目标串的范围，则直接返回 -1 表示匹配失败
		if (n==0 || n < m || begin >= n) {  
			return -1;
		}
		
		int counts = 0; //记录匹配次数
		//赋值操作进行循环匹配  j 为与目标串相匹配的相同字符的长度，未匹配之前的初始值为零（也可为目标串的字符数组的下标）
		int i = begin, j = 0; 
		while(i < n && j < m){
			counts++;
			if (this.CharAt(i) == pattrenStr.CharAt(j)) {
				i++;
				j++;
			}else {
				i = i - j + 1; //匹配失败退回到原来开始匹配位置的下一个位置，进行重新匹配
				j = 0; 
				if (i > n - m) {//若目标串的长度不够，退出循环，匹配失败
					break;
				}
			}
			
		}
		if (j == m) {
			return i - j; //匹配成功
		}
		return -1;
		
	}
	
}
