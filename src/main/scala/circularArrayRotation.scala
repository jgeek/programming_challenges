
/**
 * @see [[rotLeft]]
 */
object circularArrayRotation {

  // Complete the circularArrayRotation function below.
  def circularArrayRotation(a: Array[Int], k: Int, queries: Array[Int]): Array[Int] = {

    val length = a.length
    val arr = Array.ofDim[Int](length)
    for (i <- a.indices) {
      arr((k + i) % length) = a(i)
    }
    for (i <- queries.indices)
      queries(i) = arr(queries(i))
    queries
  }

}
