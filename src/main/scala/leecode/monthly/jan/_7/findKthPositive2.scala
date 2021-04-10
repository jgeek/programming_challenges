package leecode.monthly.jan._7

import scala.annotation.tailrec

//https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/
object findKthPositive2 extends App {

  def findKthPositive(arr: Array[Int], k: Int): Int = {

    val left = 0
    val right = arr.length - 1


    @tailrec
    def findRec(left: Int, right: Int): Int = {
      if (left <= right) {
        val pivot = left + (right - left) / 2
        if (arr(pivot) - pivot - 1 < k) {
          findRec(pivot + 1, right)
        } else {
          findRec(left, pivot - 1)
        }
      } else {
        // here left = right + 1
        //        arr(right) + k - (arr(right) - right - 1)
        k + left
      }
    }

    findRec(left, right)
  }

  var res = findKthPositive(Array(1, 2, 3, 4), 8)
  res = findKthPositive(Array(10,16), 12)
  println(res)

}
