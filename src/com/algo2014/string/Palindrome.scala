package com.algo2014.string

class Palindrome(var s:String) {
     var table  = Array.ofDim[Int](s.length(),s.length()); 
  
     
     for(i<-0 until s.length()){
       table(i)(i) = 1;
     }
     for(i <- 0 until s.length()-1){
       table(i)(i+1) = {if(s.charAt(i)==s.charAt(i+1)) 1 else 0}
     }
     
     for(l <- 2 until s.length()){
       for(i <- 0 until s.length()-l){
         table(i)(i+l) = {if(s.charAt(i)==s.charAt(i+l)) table(i+1)(i+l-1) else 0}
       }
     }
}

object longestPalindrome extends App {
  val p = new Palindrome("rajivi")
  
  
  for(i <- 0 until p.s.length()){
    for(j <- 0 until p.s.length()){
      if(p.table(i)(j)==1)
        println(i + ";" + j)
    }
  }
}