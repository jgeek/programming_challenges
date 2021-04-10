object JumpingOnClouds extends App {

  def jumpingOnClouds(c: Array[Int]): Int = {

    def jumpRec(jumps: Int, index: Int, c: Array[Int]): Int = {
      if (index >= c.length) {
        Int.MaxValue
      }
      else if (index == c.length - 1) {
        jumps
      }
      else {
        if (c(index) == 1)
          Int.MaxValue
        else
          jumpRec(jumps + 1, index + 1, c) min jumpRec(jumps + 1, index + 2, c)
      }
    }

    jumpRec(0, 0, c)
  }

  jumpingOnClouds(Array(0, 0, 0, 1, 0, 0))

}
