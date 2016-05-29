package com.algo2014.bst;

import com.algo2014.common.BSTNode;
import com.algo2014.common.Item;

public class FloorAndCeiling1 implements FloorAndCielingInterface {
	//traverse in sorted order and find the last element < data;
	private BSTNode root =null;
	
	public FloorAndCeiling1(BSTNode root){
		this.root =root;
	}
	
	@Override
	public Item floor(Item data) {
		floor(root,data);
		return found!=null ? found.t:null;
	}

	@Override
	public Item  ceil(Item data) {
		ceil(root,data);
		return found!=null ? found.t:null;
	}
	
	
	BSTNode found;
	//traverse in decreasing order
	public void ceil(BSTNode current, Item data){
		if(current==null)
			return;
		ceil(current.right,data);		
		if(current.t.i >= data.i){
			found = current;
		}
		ceil(current.left,data);
	}
	
	//traverse in increasing order
	public void floor(BSTNode current, Item data){
		if(current==null)
			return;
		floor(current.left,data);
		if(current.t.i <= data.i){
			found = current;
		}
		floor(current.right,data);
	}

	
}
