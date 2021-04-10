package leecode.monthly.jan._8

import scala.collection.immutable.Queue
//import scala.collection.Queue

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3598/
object WorldLadderByDirectional extends App {
  var dictionary: Map[String, Set[String]] = Map.empty
  //  var visitedBegin: Map[String, Int] = Map.empty
  //  var visitedEnd: Map[String, Int] = Map.empty
  //  var qBegin: Queue[(String, Int)] = Queue.empty
  //  var qEnd: Queue[(String, Int)] = Queue.empty


  def visitWordNode(queue: Queue[(String, Int)], visited: Map[String, Int], otherVisited: Map[String, Int]): (Int, Map[String, Int], Queue[(String, Int)]) = {

    var visited1 = visited
    var visited2 = otherVisited
    var q = queue

    val (wordLevel, tail) = queue.dequeue
    q = tail
    val word = wordLevel._1
    val level = wordLevel._2
    val wordLen = word.length
    for (i <- 0 until wordLen) {
      val newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen)
      val adjacentWords = dictionary.getOrElse(newWord, Set.empty)
      for (adjacentWord <- adjacentWords) {
        if (otherVisited.contains(adjacentWord)) {
          return (level + otherVisited(adjacentWord), visited1, q)
        }
        if (!visited.contains(adjacentWord)) {
          visited1 += (adjacentWord -> (level + 1))
          q = q.enqueue((adjacentWord, level + 1))
        }
      }
    }

    (-1, visited1, q)
  }

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {

    if (!wordList.contains(endWord))
      return 0

    var visitedBegin: Map[String, Int] = Map(beginWord -> 1)
    var visitedEnd: Map[String, Int] = Map(endWord -> 1)
    //      var qBegin: Queue[(String, Int)] = Queue.empty
    //      var qEnd: Queue[(String, Int)] = Queue.empty


    val wordLen = beginWord.length

    for {word <- wordList
         i <- 0 until wordLen
         } {
      val newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen)
      var set = dictionary.getOrElse(newWord, Set(word))
      set += word
      dictionary += (newWord -> set)
    }

    var qBegin: Queue[(String, Int)] = Queue((beginWord, 1))
    var qEnd: Queue[(String, Int)] = Queue((endWord, 1))


    while (qBegin.nonEmpty && qEnd.nonEmpty) {
      // One hop from begin word
      var res = visitWordNode(qBegin, visitedBegin, visitedEnd)
      var ans = res._1
      visitedBegin = res._2
      qBegin = res._3
      if (ans > -1) {
        return ans;
      }

      res = visitWordNode(qEnd, visitedEnd, visitedBegin);
      ans = res._1
      visitedEnd = res._2
      qEnd = res._3
      if (ans > -1) {
        return ans;
      }
    }

    0
  }

  //  val res = ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log", "cog"))
  val res = ladderLength("hot", "dog", List("hot", "dog"))
  println(res)

}