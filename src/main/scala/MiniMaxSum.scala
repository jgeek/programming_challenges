object MiniMaxSum extends App {

  // Complete the miniMaxSum function below.
  def miniMaxSum(arr: Array[Int]) {

    var sum: Long = 0
    arr.foreach(i => sum += i)
    var list: List[Long] = Nil
    arr.foreach(i => {
      list = (sum - i) :: list
    })
    print(list.min + " " + list.max)
  }

  val stdin = scala.io.StdIn

  val arr = stdin.readLine.split(" ").map(_.trim.toInt)
  miniMaxSum(arr)

}
