package leecode.monthly.jan._1

//3589
object canFormArray extends App {

  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {

    val map = pieces.groupBy(_.apply(0)).view.mapValues(_.apply(0)).toMap
    var j = 0
    for (i <- arr.indices if j <= i) {
      val ok = map.get(arr(j)) match {
        case Some(list) =>
          for (a <- list) {
            if (arr(j) != a) {
              return false
            }
            j += 1
          }
          true
        case None => false
      }
      if (!ok) {
        return false
      }
    }
    true
  }

  val result = canFormArray(Array(91, 4, 64, 78), Array(Array(78), Array(4, 64), Array(91)))
  println(result)
}
