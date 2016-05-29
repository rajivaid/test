package com.algo.dc

trait MergeCountArray {
   def merge(arr1: Array[Int], arr2: Array[Int]) : (Array[Int],Int) = {
    var cnt = 0
    val arr3= new Array[Int](arr1.length+arr2.length)
    var i = 0 
    var j = 0
    for(k <- 0 until arr3.length){
      if(j == arr2.length || (i!=arr1.length && arr1(i) < arr2(j))){
        //cnt = cnt + j
        arr3(k) = arr1(i)
        i+=1
      }else if(i ==arr1.length ||  (j!=arr2.length && arr1(i) > arr2(j))){
        cnt = cnt + (arr1.length - i)
        arr3(k) = arr2(j)
        j+=1
      }
    }
    println("inversions" + cnt)
    (arr3,cnt)
  }
}