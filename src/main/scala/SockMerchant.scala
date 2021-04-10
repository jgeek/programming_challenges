object SockMerchant extends App {

  def sockMerchant(n: Int, ar: Array[Int]): Int = {

      ar.groupMapReduce(identity)(_ => 1)(_ + _).view.mapValues(_ / 2).toMap.values.sum
  }

  sockMerchant(1, Array(10, 20, 20, 10, 10, 30, 50, 10, 20))
}
