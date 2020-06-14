package com.Sukie.DSexperiment3;

public class Process implements Comparable<Process>{
	private String processName; //������
	private int priority; //���ȼ� [1,10]��Ĭ��ֵΪ5
	
	//���캯���������ȼ��������ȼ�
	public Process(String name, int priority) {
		this.processName = name;
		if (priority >= 1 && priority <= 10) {
			this.priority = priority;
		}else {
			throw new IllegalArgumentException("priority����[0,10]�ķ�Χ");
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
