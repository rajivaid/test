package com.algo.dc

class MergeCount {
  
  
  //# of inversions the array
}

object MergeCountBrute extends App {
  
  var a = Array(10,20,5,6,7,8);
  
  var inversions = 0
  for(i <- 0 until a.length){
    for(j <- i+1 until a.length){
      if(a(i) > a(j)){
        inversions+=1;
        println(a(i) + "," + a(j));
      }
    }
  }
  println ("Merge Count :- Hello World " + inversions)
  

    val arr = MergeCountDC.sortAndCount(a)
    arr._1.foreach { x => println(x) }
    println(arr._2)
}
