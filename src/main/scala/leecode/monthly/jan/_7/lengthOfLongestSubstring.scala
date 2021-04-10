package leecode.monthly.jan._7

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/
object lengthOfLongestSubstring extends App {

  def lengthOfLongestSubstring(s: String): Int = {
    if (s.isEmpty) {
      0
    }
    else if (s.toSet.size == 1) {
      1
    } else {
      var maximum = 1
      var i = 0
      var base = 0
      var set = scala.collection.mutable.Set[Char]()
      while (i < s.length) {
        if (!set.contains(s(i))) {
          set += s(i)
          i += 1
        } else {
          set.remove(s(base))
          base += 1
          //          i = base
        }
        maximum = maximum max (i - base)
      }
      maximum
    }
  }

  def lengthOfLongestSubstringOptimized(s: String): Int = {
    if (s.isEmpty) {
      0
    } else {
      var ans = 0
      var map: Map[Char, Int] = Map()
      var i = 0
      for (j <- 0 until s.length) {
        if (map.contains(s(j))) {
          i = i max map(s(j))
        }
        ans = ans max (j - i + 1)
        map = map + (s(j) -> (j + 1))
      }
      ans
    }
  }

  def lengthOfLongestSubstring2(s: String): Int = {
    if (s.isEmpty) {
      0
    }
    else if (s.toSet.size == 1) {
      1
    } else {
      var base = 0
      var length = 0
      var maximum = 1
      var i = 0
      var set = scala.collection.mutable.Set[Char]()
      base = 0
      while (i < s.length) {
        if (i == 0 || !set.contains(s(i))) {
          set += s(i)
          i += 1
          length += 1
        } else {
          length = 0
          set.clear()
          base += 1
          i = base
        }
        maximum = maximum max length
      }
      maximum
    }
  }

  def lengthOfLongestSubstringRec(s: String): Int = {
    //abcabcbb

    def findLongestRec(chars: Vector[Char], remaining: String, length: Int): Int = {
      if (remaining.isEmpty) {
        length
      }
      else if (!chars.contains(remaining(0))) {
        findLongestRec(chars :+ remaining(0), remaining.tail, length + 1)
      } else {
        val index = s.substring(0, s.length - remaining.length).lastIndexOf(remaining(0)) + 1
        length max findLongestRec(Vector(s(index)), s.substring(index + 1), 1)
      }
    }

    if (s.isEmpty)
      0
    else
      findLongestRec(Vector(s(0)), s.tail, 1)
  }

  var res = lengthOfLongestSubstringOptimized("abccabf")
  println(res)
}
