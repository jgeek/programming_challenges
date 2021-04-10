import scala.io.StdIn

object Result {

  /*
   * Complete the 'diagonalDifference' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */


  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here
    var sum1 = 0
    var sum2 = 0
    for (i <- arr.indices; j <- arr(i).indices) {
      if (i == j) sum1 += arr(i)(j)
      if (i + j == arr.length - 1) {
        sum2 += arr(i)(j)
      }
    }
    math.abs(sum1 - sum2)
  }
}

object Solution {
  def main(args: Array[String]) {

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n, n)

    for (i <- 0 until n) {
      val line = StdIn.readLine;
      val regex = line.replaceAll("\\s+$", "")
      arr(i) = regex.split(" ").filter(!_.isEmpty).map(_.trim.toInt)
    }

    val result = Result.diagonalDifference(arr)
    println(result)
  }
}