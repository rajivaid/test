package com.algo.dc

object MergeCountDC extends App with MergeCountArray{
  def sortAndCount(arr : Array[Int]) :(Array[Int],Int) = {
    if(arr.length > 1) {
      val arrsplits = arr.splitAt(arr.length/2)
    
      val arr1 = sortAndCount(arrsplits._1)
      val arr2 = sortAndCount(arrsplits._2)
    
      val arrm = merge(arr1._1,arr2._1)
      (arrm._1, arr1._2 + arr2._2 + arrm._2)
    }else{
      (arr,0)
    }
  }
 }