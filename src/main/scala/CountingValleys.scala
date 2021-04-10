object CountingValleys extends App {

  def countingValleys(steps: Int, path: String): Int = {
    // Write your code here
    val result = path.map {
      case 'U' => 1
      case 'D' => -1
    }
    var valley = 0
    var sum = 0
    var down = 0
    var up = 0
    for (i <- result) {
      sum += i
      if (sum == 0 && i == 1)
        valley += 1
    }
    println(valley)
    valley
  }

  countingValleys(8, "UDDDUDUU")

}
