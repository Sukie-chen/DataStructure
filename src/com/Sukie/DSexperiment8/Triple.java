package com.Sukie.DSexperiment8;

public class Triple implements Comparable<Triple>{ //ͼ��Ȩֵ�ı���
	int row, column, value;
	
	public Triple(int row, int column, int value) {
		if (row >= 0 && column >= 0) {
			this.row = row;
			this.column = column;
			this.value = value;
		}else {
			throw new IllegalArgumentException("����������Ϊ����");
		}
	}
	
	public Triple(Triple tri) {
		this(tri.row, tri.column, tri.value);
	}
	
	public String toString(){
		return "("+row+","+column+","+value+")";
	}

	public int compareTo(Triple o) {
		if (this.row == o.row && this.column == o.column) {
			return 0;
		}
		return (this.row < o.row || this.row == o.row && this.column < o.column)? -1 : 1;
	}
	
}
