package com.algo2014.bst.interfaces;

import com.algo2014.common.BSTNode;
import com.algo2014.common.Item;


public interface BSTInterface {

	public abstract void put(Item key);

	public abstract int size();
	
	public BSTNode subTree(int m, int n);
	
}