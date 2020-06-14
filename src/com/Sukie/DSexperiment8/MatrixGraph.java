package com.Sukie.DSexperiment8;

public class MatrixGraph<T> extends AbstractGraph<T>{//�ڽӾ����ʾ�Ĵ�Ȩͼ��
	
	protected Matrix matrix; //�洢ͼ���ڽӾ���
	
	public MatrixGraph(int length) {
		super(length);
		this.matrix = new Matrix(length);
	}
	public MatrixGraph() {
		this(10);
	}
	public MatrixGraph(T[] vertexs) {
		this(vertexs.length);
		for (int i = 0; i < vertexs.length; i++) {
			this.insertVertex(vertexs[i]);
		}
	}
	
	public MatrixGraph(T[] vertexs, Triple[] edge) {
		this(vertexs);
		for (int i = 0; i < edge.length; i++) {
			this.insertEdge(edge[i]);
		}
	}

	@Override
	public int insertVertex(T x) {
		this.vertexList.add(x);
		int i = vertexList.size();
		if (i >= this.matrix.getRows()) {
			this.matrix.getNewElement(i+1, i+1);
		}
		return i;
	}

	//����ߣ���Ȩֵ
	public void insertEdge(int i, int j, int weight) {
		if(i != j){ //���ܲ�������
			if (weight < 0 || weight > MAX_WEIGHT) {
				weight = 0; //weight������ֵ���ض���Ϊ0
			}
			this.matrix.setElement(i, j, weight);
		}else {
			throw new IllegalArgumentException("���ܲ�������");
		}
	}
	public void insertEdge(Triple edge) {
		this.insertEdge(edge.row, edge.column, edge.value);
	}
	@Override
	public void removeVertex(int i) {
		int n = this.getNumOfVertex(); //ԭ������
		if (i >= 0 && i < n) {
			this.vertexList.remove(i);
			//ɾ�����㣬ͬʱɾ�������й�ϵ�ıߣ����Ѻ����Ԫ����ǰ�ƶ�
			for (int j = i + 1; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					this.matrix.setElement(j-1, j2, this.matrix.getElement(j, j2)); 
				}
			}
			for (int j = 0; j < n; j++) {
				for (int j2 = i + 1; j2 < n; j2++) {
					this.matrix.setElement(j, j2-1, this.matrix.getElement(j, j2));
				}
			}
			this.matrix.getNewElement(n-1, n-1);
		}else {
			throw new IllegalArgumentException("iֵ����������Χ��");
		}
	}
	//ɾ����Ӧ����֮ǰ�� ��
	public void removeEdge(int i, int j) {
		if(i != j){ //���ܲ�������
			this.matrix.setElement(i, j, 0);
		}
	}
	public void removeEdge(Triple edge) {
		this.removeEdge(edge.row, edge.column);
	}
	@Override
	public int weight(int i, int j) {
		return matrix.getElement(i, j);
	}

	@Override
	public int next(int i, int j) {
		for (int j2 = 0; j2 > j && j2 < this.matrix.getColumns(); j2++) {
			if(matrix.getElement(i, j2) > 0){
				return j2;
			}
		}
		return -1;
	} 
	
	@Override
	public String toString() {
		String string = super.toString() + "�ڽӾ���" + "\n";
		int n = this.getNumOfVertex();
		for (int i = 0; i <n; i++) {
			for (int k = 0; k < n; k++) {
				string += String.format("%6d", this.matrix.getElement(i, k));
			}
			string += "\n";
		}
		return string;
	}
		
}
