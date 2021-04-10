package leecode.monthly.jan._1

object palindromes extends App {
  def canPermutePalindrome(s: String): Boolean = {

    if (s.length == 1) {
      return true
    }

    // one char string
    if (s.toSet.size == 1) {
      return true
    }

    val map = s.groupMapReduce(identity)(_ => 1)(_ + _)
    val numbers = map.values
    val allEven = numbers.forall(_ % 2 == 0)
    if (allEven) {
      return true
    }

    if (numbers.count(_ % 2 == 1) != 1) {
      return false
    }
    true
  }

  println(canPermutePalindrome("aaabbccdddd"))

}
