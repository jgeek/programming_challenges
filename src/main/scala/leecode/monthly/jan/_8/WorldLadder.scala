package leecode.monthly.jan._8

import scala.collection.immutable.Queue

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3598/
object WorldLadder extends App {
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {

    val wordLen = beginWord.length
    var dictionary: Map[String, List[String]] = Map.empty
    for {word <- wordList
         i <- 0 until wordLen
         } {
      val newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen)
      var list = dictionary.getOrElse(newWord, List(word))
      list = word :: list
      dictionary += (newWord -> list)
    }

    var q: Queue[(String, Int)] = Queue((beginWord, 1))
    var visited = Set(beginWord)

    while (q.nonEmpty) {
      val (tuple, tail) = q.dequeue
      q = tail
      val (word, level) = tuple

      for (i <- 0 until wordLen) {
        val newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen)
        val adjacentWords = dictionary.getOrElse(newWord, Nil)
        if (adjacentWords.contains(endWord)) {
          return level + 1
        }
        for (adjacentWord <- adjacentWords) {
          if (!visited.contains(adjacentWord)) {
            visited += adjacentWord
            q = q.enqueue((adjacentWord, level + 1))
          }
        }
      }
    }

    0
  }

  val res = ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log", "cog"))
  println(res)

}