import java.io.PrintWriter

import scala.io.StdIn

object BirthdayCakeCandles extends App {

  /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

  def birthdayCakeCandles(candles: Array[Int]): Int = {
    // Write your code here
    //    val p: Seq[Int] => Int = (s: Seq[Int]) => s.length
    candles.groupBy(identity).view.mapValues(_.length).toMap.values.max
  }


  val candlesCount = StdIn.readLine.trim.toInt

  val candles = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

  val result = birthdayCakeCandles(candles)
  print(result)
}
