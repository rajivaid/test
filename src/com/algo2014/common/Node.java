package com.algo2014.common;

public class Node<T,T1> {

	public T1 right;
	public T1 left;
	public int size;
	public T t;
		
	public Node(T i) {
		t=i;
		size=1;
	}
	public Node() {
	}
}
