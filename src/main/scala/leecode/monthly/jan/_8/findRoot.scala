package leecode.monthly.jan._8

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3596/
object findRoot extends App {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }


  def findRoot(tree: List[Node]): Node = {

    val nums = tree.map(_.value)
    val internalNums = tree.view.groupMapReduce(identity)(_.children.map(_.value))((a, b) => (a ::: b)).values.filter(_.nonEmpty).flatten.toList
    val rootNum = nums diff internalNums
    tree.find(_.value == rootNum.head).get
  }

  val n1 = new Node(1)
  val n2 = new Node(2)
  val n3 = new Node(3)
  val n4 = new Node(4)
  n1.children = List(n2, n3, n4)
  findRoot(List(n1, n2, n3, n4))

}
