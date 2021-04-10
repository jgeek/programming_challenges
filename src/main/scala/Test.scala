object Test extends App {

  val ar = Array(1, 2, 3)
  ar(0) = 1000
  println(ar.mkString("(", ",", ")"))

  val l = List(1, 2, 3, 4)
  val l2 = List(10, 20, 30, 40)
  List(1, 2, 3, 4).withFilter(_ > 2)
  List(1, 2, 3, 4).view.filter(_ > 0)

  l.map(i => (i, l.indexOf(i)))

  l.zipAll(l2, 11, 22)

  // Example 2
  case class Pet(species: String, name: String, age: Int)

  val pets = List(
    Pet("cat", "sassy", 2), Pet("cat", "bella", 3),
    Pet("dog", "poppy", 3), Pet("dog", "bodie", 4), Pet("dog", "poppy", 2),
    Pet("bird", "coco", 2), Pet("bird", "kiwi", 1)
  )

  pets.groupBy(_.species).view.mapValues(_.map(_.name))
  pets.groupMap(_.species)(_.name)

  // Example 4

  import java.time.LocalDate

  case class Product(id: String, saleDate: LocalDate, listPrice: Double, discPrice: Double)

  val products = List(
    Product("p001", LocalDate.of(2019, 9, 11), 10, 8.5),
    Product("p002", LocalDate.of(2019, 9, 18), 12, 10),
    Product("p003", LocalDate.of(2019, 9, 27), 10, 9),
    Product("p004", LocalDate.of(2019, 10, 6), 15, 12.5),
    Product("p005", LocalDate.of(2019, 10, 20), 12, 8),
    Product("p006", LocalDate.of(2019, 11, 8), 15, 12),
    Product("p007", LocalDate.of(2019, 11, 16), 10, 8.5),
    Product("p008", LocalDate.of(2019, 11, 25), 10, 9)
  )
  // Example 4: groupBy/mapValues
  products.groupBy(_.saleDate.getMonth).mapValues(
    _.map(p => (p.listPrice, p.discPrice)).reduce(
      (total, prc) => (total._1 + prc._1, total._2 + prc._2))
  )
  // res2: scala.collection.immutable.Map[java.time.Month,(Double, Double)] =
  //   Map(OCTOBER -> (27.0,20.5), SEPTEMBER -> (32.0,27.5), NOVEMBER -> (35.0,29.5))

  println()

  val a = 10 % 3


  for (i <- 1 to 10 by 2) {
    println(i)
  }



}
