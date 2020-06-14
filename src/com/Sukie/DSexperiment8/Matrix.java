package com.Sukie.DSexperiment8;


public class Matrix { //�ڽӾ�����
	private int rows, columns;//���������
	private int[][] element; //��ά���飬�洢Ȩֵ
	
	public Matrix(int m ,int n) {
		this.element = new int[m][n];//�����ʼ��
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
				element[i][j] = value[i][j]; //����Ԫ��
			}
		}
	}
	
	//����������
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
	
	//���ض�ӦȨֵ
	public int getElement(int i, int j) {
		if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) { //i��jֵ����ȷ��Χ��
			return this.element[i][j];
		} else {
			throw new IllegalArgumentException("i��jֵ������ȷ��Χ��");
		}
	}
	
	//���ö�ӦȨֵ
	public void setElement(int i, int j, int weight) {
		if (i >= 0 && i < this.rows && j >= 0 && j < this.columns) { //i��jֵ����ȷ��Χ��
			this.element[i][j] = weight;
		} else {
			throw new IllegalArgumentException("i��jֵ������ȷ��Χ��");
		}
	}
	
	//��ӡ����
	public String toString() {
		String string = "����" + this.getClass().getName() + ":("+this.rows+"*"+this.columns+") \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				string += String.format("%6d", this.element[i][j]); 
			}
			string += "\n";
		}
		return string;
	}
	
	//��ɾ�����߶������ӵ�ʱ�����¶���element��ά����
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
			throw new IllegalArgumentException("����������������ֵ");
		}
	}
}
