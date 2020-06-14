package com.Sukie.DSexperiment8;

public class Triple implements Comparable<Triple>{ //图带权值的边类
	int row, column, value;
	
	public Triple(int row, int column, int value) {
		if (row >= 0 && column >= 0) {
			this.row = row;
			this.column = column;
			this.value = value;
		}else {
			throw new IllegalArgumentException("行列数不能为负数");
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
