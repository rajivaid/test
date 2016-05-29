package com.algo.dp


object Test extends App {
  println("hello world")
  // DynamicProgramming.wtintervals().
  val int = DPSingleChoice.wtintervals()
  val opt = WeightIntervals.compatible(int)
  //int.foreach((f:WeightIntervals)=>println(f.start + "," +f.end + "," + f.weight))
  //opt.foreach(println)
  println(DPSingleChoice().maxRequests(int, opt))

}
object Test1 extends App {
  val points = DPMultiChoice.points()
  var errormatrix = DPMultiChoice().errormatrix(points)

  points.foreach(f => {
    println(f.x + "," + f.y)
  })
  println(DPMultiChoice().maxSegments(points, errormatrix))

}


object Test2 extends App {

  val algo = new DPMultiDimension
  println(algo.maxSubsetSum(DPMultiDimension.set,56))
}