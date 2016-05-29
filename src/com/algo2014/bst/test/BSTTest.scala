package com.algo2014.bst.test

import com.algo2014.common.Item
import com.algo2014.bst.BST
import com.algo2014.bst.FloorAndCeiling
import com.algo2014.bst.FloorAndCeiling1
import com.algo2014.bst.LinkedListToBST

object test1 extends App {
  val fc: FloorAndCeiling = new FloorAndCeiling(BST.getRoot)
  System.out.println(fc.floor(new Item(5)).i)
  System.out.println(fc.ceil(new Item(5)).i)
}

object test2 extends App {
  val lbst: LinkedListToBST = new LinkedListToBST
  val fc1: FloorAndCeiling1 = new FloorAndCeiling1(lbst.listToBST(0, 9))
  System.out.println(fc1.ceil(new Item(5)).i)
}

object test3 extends App {
  val bst: BST = new BST
  val lbst: LinkedListToBST = new LinkedListToBST
  bst.root = lbst.listToBST(0, 9)

  {
    val fc1: FloorAndCeiling1 = new FloorAndCeiling1(bst.subTree(5, 10))
    System.out.println(fc1.ceil(new Item(5)))
    System.out.println(fc1.ceil(new Item(1)))
    System.out.println(fc1.ceil(new Item(9)))
  }

  {
    val fc1: FloorAndCeiling1 = new FloorAndCeiling1(bst.subTree(10, 10))
    System.out.println(fc1.ceil(new Item(5)))
    System.out.println(fc1.ceil(new Item(1)))
    System.out.println(fc1.ceil(new Item(9)))
  }
}

