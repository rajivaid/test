package com.algo2014.bst;

import com.algo2014.bst.interfaces.BSTInterface;
import com.algo2014.common.BSTNode;
import com.algo2014.common.Item;

public class BST implements BSTInterface {

	@Override
	public void put(Item key) {
		root=insert(root,key);
	}

	private BSTNode insert(BSTNode node, Item key){

		if(node ==null){
			return new BSTNode(key);
		}
		if(key.compareTo(node.t)<=0){
			node.left=insert(node.left,key);
		}else{
			node.right = insert(node.right, key);
		}
		node.size=size(node.left)+size(node.right)+1;
		return node;
	}

	@Override
	public int size() {
		return size(root);
	}

	public int size(BSTNode node){
		return node==null?0:node.size;
	}


	public BSTNode root;
	public static BSTNode getRoot(){
		BST bstsearch = new BST();
		for(int i=10;i>=0;i--){
			bstsearch.put(new Item(i*2));
		}
		return bstsearch.root;
	}

	@Override
	public BSTNode subTree(int m, int n) {
		return subTree(m, n, root);
	}

	private BSTNode subTree(int m, int n, BSTNode current){
		if(current == null)
			return null;

		if(current.t.i>=m &&  current.t.i<=n){
			BSTNode node = new BSTNode(new Item(current.t.i));
			node.right = subTree(m, n,current.right);
			node.left = subTree(m, n,current.left);
			return node;
		}else if(current.t.i>m){
			return subTree(m, n,current.left);
		}else {
			return subTree(m, n,current.right);
		}
	}
}
