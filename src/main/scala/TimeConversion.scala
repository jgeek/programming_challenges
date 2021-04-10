object TimeConversion extends App {

  def timeConversion(str: String): String = {
    /*
     * Write your code here.
     */
    val parts = s.split(":")
    val sec = parts(2).slice(0, parts(2).length - 2)

    def leftPad(s: Int) = f"${s}%02d"

    str match {
      case str if "12:\\d{2}:\\d{2}AM".r.matches(str) =>
        val hour = leftPad(parts(0).toInt - 12)
        s"${hour}:${parts(1)}:${sec}"
      case str if "\\d{2}:\\d{2}:\\d{2}AM".r.matches(str) => str.slice(0, str.length - 2)
      case str if "12:\\d{2}:\\d{2}PM".r.matches(str) => str.slice(0, str.length - 2)
      case str if "\\d{2}:\\d{2}:\\d{2}PM".r.matches(str) => s"${parts(0).toInt + 12}:${parts(1)}:${sec}"

      case _ => "haha"
    }
  }

  val scan = scala.io.StdIn
  val s = scan.readLine

  val result = timeConversion(s)
  print(result)

}

//07:05:45PM