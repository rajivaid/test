package com.algo2014.bst.test;

import com.algo2014.bst.BST;
import com.algo2014.bst.FloorAndCeiling;
import com.algo2014.bst.FloorAndCeiling1;
import com.algo2014.bst.LinkedListToBST;
import com.algo2014.common.Item;


public class BSTTest {

	public void test() {
			FloorAndCeiling fc = new FloorAndCeiling(BST.getRoot());
			System.out.println(fc.floor(new Item(5)).i);
			System.out.println(fc.ceil(new Item(5)).i);
	}

	public void test1() {
			LinkedListToBST lbst = new LinkedListToBST();
			FloorAndCeiling1 fc1 = new FloorAndCeiling1(lbst.listToBST(0, 9));
			System.out.println(fc1.ceil(new Item(5)).i);
	}
	public void test2() {
			BST bst = new BST();
			LinkedListToBST lbst = new LinkedListToBST();
			bst.root = lbst.listToBST(0, 9);

			{
			FloorAndCeiling1 fc1 = new FloorAndCeiling1(bst.subTree(5, 10));
			System.out.println(fc1.ceil(new Item(5)));
			System.out.println(fc1.ceil(new Item(1)));
			System.out.println(fc1.ceil(new Item(9)));
			}
			{
			FloorAndCeiling1 fc1 = new FloorAndCeiling1(bst.subTree(10, 10));
			System.out.println(fc1.ceil(new Item(5)));
			System.out.println(fc1.ceil(new Item(1)));
			System.out.println(fc1.ceil(new Item(9)));
			}
	}
}
