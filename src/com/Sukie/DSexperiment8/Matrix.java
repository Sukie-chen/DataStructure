package com.Sukie.DSexperiment8;


public class Matrix { //邻接矩阵类
	private int rows, columns;//矩阵的行列
	private int[][] element; //二维数组，存储权值
	
	public Matrix(int m ,int n) {
		this.element = new int[m][n];//数组初始化
		this.rows = m;
		this.columns = n;
	}
	public Matrix(int n) {
		this(n, n);
	}
	public Matrix(int m, int n, int[][] value) {
		this(m, n);
		for (int i = 0; i < value.length && i < m; i++) {
			for (int j = 0; j < value[i].length; j++) {
				element[i][j] = value[i][j]; //插入元素
			}
		}
	}
	
	//返回行列数
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
	
	//返回对应权值
	public int getElement(int i, int j) {
		if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) { //i和j值在正确范围内
			return this.element[i][j];
		} else {
			throw new IllegalArgumentException("i和j值不在正确范围内");
		}
	}
	
	//设置对应权值
	public void setElement(int i, int j, int weight) {
		if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) { //i和j值在正确范围内
			this.element[i][j] = weight;
		} else {
			throw new IllegalArgumentException("i和j值不在正确范围内");
		}
	}
	
	//打印矩阵
	public String toString() {
		String string = "矩阵" + this.getClass().getName() + ":("+this.rows+"*"+this.columns+") \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				string += String.format("%6d", this.element[i][j]); 
			}
			string += "\n";
		}
		return string;
	}
	
	//当删除或者额外增加的时候重新定义element二维数组
	public void getNewElement(int m, int n){
		if (m > 0 && n >0) {
			if (m > this.element.length || n > this.element[0].length) {
				int[][] bridge = this.element;
				this.element = new int[m][n];
				for (int i = 0; i < this.rows; i++) {
					for (int j = 0; j <this.columns; j++) {
						this.element[i][j] = bridge[i][j];
					}
				}
				this.rows = m;
				this.columns = n;
			}
		} else {
			throw new IllegalArgumentException("矩阵行列数非正常值");
		}
	}
}
