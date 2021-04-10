object HourGlass extends App {

  def hourglassSum(arr: Array[Array[Int]]): Int = {

    var maxSum = 0
    for (i <- 1 to arr.length - 2)
      for (j <- 1 to arr.length - 2)
        maxSum = maxSum max hsum(i, j)

    def hsum(i: Int, j: Int): Int = {
      var sum = arr(i)(j)
      for (m <- -1 to 1 by 2) {
        for (n <- -1 to 1 )
          sum += arr(m + i)(n + j)
      }
      sum
    }

    maxSum
  }

  val arr = Array.ofDim[Int](6, 6)
  val max = hourglassSum(arr)
  println(max)


}
