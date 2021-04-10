package leecode.monthly.jan._8

// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/
object arrayStringsAreEqual extends App {

  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {

    val res = word1.reduce((a, b) => a + b) == word2.view.reduce((a, b) => a + b)
    val buf1 = new StringBuffer()
    val buf2 = new StringBuffer()
    word1.foreach(s => buf1.append(s))
    word2.foreach(s => buf2.append(s))
    buf1.toString == buf2.toString
  }

  def arrayStringsAreEqual2(word1: Array[String], word2: Array[String]): Boolean = {

    var strIndex, charIndex = 0
    val word2Len = word2.length
    val word2LenList = word2.map(_.length)
    val wordCharCount = word2LenList.sum
    var charCount = 0

    for (s <- word1; c <- s) {
      if (strIndex >= word2Len || c != word2(strIndex).charAt(charIndex)) {
        return false
      }
      charCount += 1
      charIndex += 1
      if (charIndex == word2LenList(strIndex)) {
        charIndex = 0
        strIndex += 1
      }
    }
    charCount ==  wordCharCount
  }

  //  arrayStringsAreEqual2(Array("a", "cb"), Array("ab", "c"))
  arrayStringsAreEqual2(Array("ac", "b"), Array("a", "cbd"))
}
