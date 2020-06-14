package com.Sukie.DSexperiment3;

public class Process implements Comparable<Process>{
	private String processName; //进程名
	private int priority; //优先级 [1,10]，默认值为5
	
	//构造函数，有优先级与无优先级
	public Process(String name, int priority) {
		this.processName = name;
		if (priority >= 1 && priority <= 10) {
			this.priority = priority;
		}else {
			throw new IllegalArgumentException("priority超出[0,10]的范围");
		}
	}
	public Process(String name) {
		this(name, 5);
	}
	public int compareTo(Process p) {
		return this.priority - p.priority;
	}
	
	public String toString() {
		return "("+this.processName+":"+this.priority+")";
	}
	
}
