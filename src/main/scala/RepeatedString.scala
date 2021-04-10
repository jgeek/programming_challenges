object RepeatedString extends App {

  def repeatedString(s: String, n: Long): Long = {

    val repeat = n / s.length
    val remained = s.slice(0, (n % s.length).toInt)
    repeat * s.count(_ == 'a') + remained.count(_ == 'a')
  }

  val res = repeatedString("aba", 10)
  println(res)
}
