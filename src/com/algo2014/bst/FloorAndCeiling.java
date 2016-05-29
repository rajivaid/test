package com.algo2014.bst;

import com.algo2014.common.BSTNode;
import com.algo2014.common.Item;

public class FloorAndCeiling implements FloorAndCielingInterface {

	private BSTNode root =null;
	
	public FloorAndCeiling(BSTNode root){
		this.root =root;
	}
	
	@Override
	public Item floor(Item data) {
		BSTNode ret =floor(root,data);
		return ret!=null ? ret.t : null;
	}

	@Override
	public Item ceil(Item data) {
		BSTNode ret =ceil(root,data);
		return ret!=null ? ret.t : null;
	}
	
	
	private BSTNode floor(BSTNode current, Item data){
		if(current==null){
			return null;
		}
		if(current.t.i <= data.i){
			BSTNode rt = floor(current.right,data);
			if(rt==null){
				return current;
			}else{
				return rt;
			}
		}else{
			return floor(current.left,data);
		}
	}
	
	private BSTNode ceil(BSTNode current, Item data){
		if(current==null)
			return null;
		BSTNode prev1 = ceil(current.right,data);
		if(current.t.i < data.i){
			return prev1;
		}else if (current.t.i==data.i){
			return current;
		}
		prev1 =  ceil(current.left,data);
		return prev1!=null ? prev1 : current;
	}

	
}
