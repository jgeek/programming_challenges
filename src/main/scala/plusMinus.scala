import scala.collection.immutable.TreeMap

object plusMinus extends App {

  val filter: PartialFunction[Int, Int] = {
    case a: Int if a > 0 => 1
    case a: Int if a < 0 => -1
    case a: Int if a == 0 => 0
  }

  //
  def countFilter(t: Tuple2[Int, Seq[Int]]) = t._2.length

  val countF = (arr: Seq[Int]) => arr.length

  val arr = Array(-1, -1, 1, 1, 0, 0, 0)
  val ratio = arr.groupBy(filter)
  val len = arr.length

  println(formatted(len, ratio.get(1)))
  println(formatted(len, ratio.get(-1)))
  println(formatted(len, ratio.get(0)))

  def formatted(len: Int, ints: Option[Array[Int]]) = {
    ints match {
      case Some(arr) => f"${arr.length.toFloat / len}%1.6f"
      case None => f"${0.toFloat / len}%1.6f"
    }
  }

}
