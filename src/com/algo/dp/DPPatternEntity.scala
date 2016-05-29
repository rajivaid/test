package com.algo.dp


class WeightIntervals(val start: Int, val end: Int, val weight: Int) extends Ordered[WeightIntervals] {
  override def compare(that: WeightIntervals): Int = this.end.compareTo(that.end)
}

object WeightIntervals {
  def apply(start: Int, end: Int, weight: Int): WeightIntervals = new WeightIntervals(start, end, weight)

  def compatible(intervals: Array[WeightIntervals]): Array[Int] = {
    val op = new Array[Int](intervals.length)
    for (i <- 1 until op.length) {
      var j = i - 1
      while (j != 0 && intervals(i).start < intervals(j).end) {
        j -= 1
      }
      op(i) = j
    }
    op
  }
}


class Point(val x: Int, val y: Int) extends Ordered[Point] {
  override def compare(that: Point): Int = this.x.compareTo(that.x)
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)

}
//1-D array

//Weighted interval scheduling(Maximize #of requests)
//least square sum (LCS) (Minimize error)

//2-D array
//subset-sum (Maximize sum)

class Interval (val time : Int)

object Interval {
  def apply(time:Int): Interval = new Interval(time)
}


