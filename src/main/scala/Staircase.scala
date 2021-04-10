object Staircase extends App {

  //  val stdin = scala.io.StdIn
  //
  //  val n = stdin.readLine.trim.toInt
  val n = 4;

  def staircase(n: Int) = {

    def staircaseRec(k: Int): Unit = {
      if (k < n + 1) {
        val row = List().padTo(n - k, " ").padTo(n, "#").mkString("")
//        val aa = Array.fill(k)("#")
        println(row)
        staircaseRec(k + 1)
      }
    }

    staircaseRec(1)
  }

  staircase(n)

}
