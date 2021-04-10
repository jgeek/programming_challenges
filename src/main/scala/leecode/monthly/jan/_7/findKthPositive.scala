package leecode.monthly.jan._7

//https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/
object findKthPositive extends App {

  def findKthPositive(arr: Array[Int], k: Int): Int = {

    val set = Set(arr: _*)

    var kk = 0
    val lastElement = arr(arr.length - 1)
    for (i <- 0 to lastElement if i + 1 <= lastElement) {
      if (!set.contains(i + 1)) {
        kk += 1
        if (kk == k) {
          return i + 1
        }
      }
    }
    val diff = k - kk
    lastElement + diff
  }

  def findKthPositive2(arr: Array[Int], k: Int): Int = {

    val lastElement = arr(arr.length - 1)
    var kk = 0

    var i, j = 0
    while (j < arr.length) {
      if (i + 1 != arr(j) && (i > j || (i == 0 || arr(i - 1) + 1 != arr(i)))) {

        if (i == 0) {
          var m = arr(j) - (i + 1)
          while (m > 0) {
            kk += 1
            m -= 1
            if (kk == k) {
              return arr(i) - 1 - m
            }
          }
          i += 1
        } else {
          var m = arr(j) - arr(j - 1) - 1
          while (m > 0) {
            kk += 1
            m -= 1
            if (kk == k) {
              return arr(j - 1) + (arr(j) - arr(j - 1) - 1 - m)
            }
          }
          i = arr(j)
        }
        j += 1
      } else {
        j += 1
        i += 1
      }
    }

    val diff = k - kk
    lastElement + diff
  }

  // 1,5,6,8,9,10,12,13,14
  //  val res = findKthPositive2(Array(1, 2, 3, 4), 2)
  //  val res = findKthPositive2(Array(2, 3, 4, 7, 11), 8)
  //  1,5,6,8,9,10
  //  val res = findKthPositive2(Array(2, 3, 4, 7, 11), 5)
//  val res = findKthPositive2(Array(2), 1)
  val res = findKthPositive2(Array(3,4,9,10,12,19,24,25,27,30), 8)
  // 1,2,5,6,7,8,11,13,14,15
  println(res)

}
