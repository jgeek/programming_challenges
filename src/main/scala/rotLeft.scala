//https://www.hackerrank.com/challenges/ctci-array-left-rotation/

/**
 * @see [[circularArrayRotation]]
 */
object rotLeft extends App {

  // d left rotate means length - d right rotate
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {

    val length = a.length
    val arr = Array.ofDim[Int](length)
    for (i <- a.indices) {
      arr((length - d + i) % length) = a(i)
    }
    arr
  }

  val arr = rotLeft(Array(1,2,3,4,5), 4)
  println(arr.mkString(","))

}
