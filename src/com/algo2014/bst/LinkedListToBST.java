package com.algo2014.bst;

import com.algo2014.common.BSTNode;
import com.algo2014.common.Item;

public class LinkedListToBST {

	static class List{
		List next;
		Item value;
	}

	
	private static List constructList(){
		List root = null;
		root = new List();
		List head = root;
		root.value = new Item(0);
		for(int i = 1 ; i < 10;i++){
			root.next= new List();
			root.next.value = new Item(i);
			root = root.next;
		}
		return head;
	}


	List current = constructList();

	//O(n) implementation of tree construction
	public  BSTNode listToBST(int m , int n){
		if(m>n){
			return null;
		}
		int mid = (m + n)/2;
		BSTNode bst = new BSTNode(current.value);
		bst.left = listToBST(m, mid-1);
		bst.t = current.value;
		current=current.next;
		bst.right = listToBST(mid+1, n);
		return bst;
	}
}
