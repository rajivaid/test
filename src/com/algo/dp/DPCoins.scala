package com.algo.dp

object DPCoins extends App {
  val s =  Array(3,2,2,3,1,2);
  
  def maxSum (m:Int, n:Int):Int = {
    //a[i] a[j] ; bruteforce
    
    if(m==n){
      s(m)
    }else{
      var sum =0
      for(i <- m+1 to n-1)
        sum = sum + s(i)
      
      val s1 = s(m) + (sum + s(n) - maxSum(m+1,n)) 
      val s2 = s(n) + (sum + s(m) - maxSum(m,n-1)) 
 
      //if(s1>s2) println(s(m)) else println(s(n))
      Math.max(s1, s2)
    }
  }
  println(maxSum(0,s.length-1)) 
  
  
  def maxSum_Dp(m:Int, n:Int) = {
   val subsum = Array.ofDim[Int](s.length+1,s.length+1)
   //base-case
   for(i <- 1 to n ){
     subsum(i)(i) = s(i)
   }
   for(i <- 1 to n-1 ){
     subsum(i)(i+1) = if(s(i) > s(i+1)) s(i) else s(i+1)
   }

   for(width <- 2 to n){
    for(i <- 1 to n){
     val j = i + width
     if(j < n){
       val i1 = s(i) + subsum(i+1)(j)
       val i2 = s(j) + subsum(i)(j-1)
     }
    }
   }
   
   for(i <- 1 to n ){
     for(j <- i+1 to n){
       subsum(i)(j) = s(i)
     }
   }
   for(i <- 0 to n ){
     for(j <- 0 to n){
        
     }
   }
  }
  
  
  var cost = Array(10,20,40)
  def paint(mx:Int, n:Int):Int = {
    var min = Integer.MAX_VALUE
    if(n==0){
      0
    }else{
      for(i<-0 until cost.length){
        if(i!=mx){
          val s = cost(i) + paint(i,n-1)
          if(s<min)
            min=s
        }
      }
      min
    }
  }
  //println(paint(cost.length,5))
}