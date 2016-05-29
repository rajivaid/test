package com.algo.dp

class DPSingleChoice {
  def maxRequests(sortedIntervals: Array[WeightIntervals], compatible: Array[Int]): Int = {
    val optimal = new Array[Int](sortedIntervals.size)
    optimal(0) = 0

    val inclusioncost = (index: Int, value:Int) => {
      value + optimal(compatible(index))
    }

    for (i <- 1 until optimal.length) {
      //one option
      optimal(i) = Math.max(optimal(i - 1), inclusioncost(i, sortedIntervals(i).weight))
    }

    backtrack(optimal,sortedIntervals,compatible)

    optimal.last
  }

  def backtrack(optimal:Array[Int], sortedIntervals: Array[WeightIntervals], compatible: Array[Int]) = {
    var j = optimal.length - 1
    while (j != 0) {
      if (optimal(j) == optimal(j - 1)) {
        j = j - 1
      } else {
        println(sortedIntervals(j).start + "," + sortedIntervals(j).end + "," + sortedIntervals(j).weight)
        j = compatible(j)
      }
    }
  }
}

class DPMultiChoice {
  val SEG_COST = 100

  def errormatrix(sortedPoints: Array[Point]): Array[Array[Int]] = {
    val errors = Array.ofDim[Int](sortedPoints.length, sortedPoints.length)
    for (i <- 1 until sortedPoints.length) {
      //i is starting point, j is ending point
      for (j <- i + 1 until sortedPoints.length) {
        errors(i)(j) = errors(i)(j - 1) + DPMultiChoice.error(sortedPoints(j), sortedPoints(j - 1))
      }
    }
    errors
  }

  def maxSegments(sortedPoints: Array[Point], errormatrix: Array[Array[Int]]): Int = {
    val optimal = new Array[Int](sortedPoints.size)
    optimal(0) = 0

    val backtrackindex = new Array[Int](sortedPoints.size)

    val inclusioncost = (index: Int) => {
      var min = SEG_COST + optimal(index - 1)
      var k = index
      for (i <- 1 until index) {
        min = {
          val error_st_i = errormatrix(i)(index) + SEG_COST + optimal(i - 1)
          if (min > error_st_i){k = i ; error_st_i} else min
        }
        //min = Math.min(min, errormatrix(i)(x) + SEG_COST + optimal(i-1))
      }
      backtrackindex(index) = k
      min
    }

    for (i <- 1 until optimal.length) {
      //new segment starting here vs extending existing segments
      optimal(i) = Math.min(SEG_COST + optimal(i - 1), inclusioncost(i))
    }


    print("backtrackindex ")
    backtrackindex.foreach(f=>{print(f + ",")})

    backtrack(optimal,sortedPoints)
    optimal.last


  }

  def backtrack(optimal:Array[Int], sortedPoints:Array[Point])={

    var j = optimal.length - 1
    while (j != 0) {
      if (optimal(j) == (optimal(j - 1) + SEG_COST)) {
        println(sortedPoints(j).x + "," + sortedPoints(j).y)
      }
      j = j - 1
    }
  }

}

class DPMultiDimension {

  def maxSubsetSum (set:Array[Interval], weight:Int): Int ={
    val summatrix = Array.ofDim[Int](set.length, weight+1)
    for(i<-1 until set.length){
      for(j <- 1 until weight+1){
        //do not include i
        val option1 = summatrix(i-1)(j)
        //include i
        val option2  = if(set(i).time <= j) set(i).time + summatrix(i-1)(j-set(i).time) else -1
        summatrix(i)(j) = Math.max(option1,option2)
      }
    }
    summatrix(set.length-1)(weight)

  }

}


object DPSingleChoice {

  def wtintervals(): Array[WeightIntervals] = {
    //dummy interval at 0
    Array(WeightIntervals(0, 0, 0), WeightIntervals(0, 10, 100), WeightIntervals(0, 5, 10), WeightIntervals(6, 8, 110),
      WeightIntervals(3, 4, 100), WeightIntervals(9, 10, 1000), WeightIntervals(0, 1, 10)).sorted
  }

  def apply() = new DPSingleChoice

}



//rod-cut problem
object DPMultiChoice {
  def apply() = new DPMultiChoice()

  def points(): Array[Point] = {
    //Array(Point(0,0),Point(0,1),Point(1,0), Point(1,1), Point(2,0), Point(2,1)).sorted
    Array(Point(0, 0), Point(0, 1), Point(0, 5), Point(4, 1), Point(4, 2), Point(4, 3), Point(4, 5), Point(100, 0), Point(100, 3)).sorted
  }

  def error(p1: Point, p2: Point): Int = {
    100 * Math.abs(p1.x - p2.x) + 10 * Math.abs(p1.y - p2.y)
  }
}

object DPMultiDimension {
  def set:Array[Interval] = {
    Array(Interval(0),Interval(10),Interval(30),Interval(5),Interval(20))
  }

  val MAX_WEIGHT = 56
}
