package leecode

object KSumScalaTest extends App {

  val nums = Array(1, 0, -1, 0, -2, 2)

  val result = KSumScala.kSum(nums, 0, 4)
  println(result.map(_.mkString(",")).mkString("|"))
}
