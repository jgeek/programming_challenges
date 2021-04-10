object SequenceEquation extends App {

  def permutationEquation(p: Array[Int]): Array[Int] = {

    val p2 = Array.ofDim[Int](p.length + 1)
    p.copyToArray(p2, 1)
    val arr = Array.ofDim[Int](p.length)
    for (i <- 1 to p.length) {
      //      arr(i - 1) = p2(p2(p2(i)))
      arr(i - 1) = p2.indexOf(p2.indexOf(i))
    }
    arr
  }

  val a = permutationEquation(Array(2, 3, 1))
  println()

}
