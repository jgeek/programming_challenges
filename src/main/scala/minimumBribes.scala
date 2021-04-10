// https://www.hackerrank.com/challenges/new-year-chaos/

object minimumBribes extends App {

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]): Unit = {
    var moves = 0

    for (i <- q.indices) {
      val person = q(i)
      if (person - 1 - i > 2) {
        println("Too chaotic")
        return
      }
      val start = 0 max person -2
      val end = q.indexOf(person)

      for (j <- start to end) {
        if (q(j) > person) {
          moves += 1
        }
      }
    }
    println(moves)
  }
  def minimumBribes2(qq: Array[Int]) {

//    q.mapInPlace(_ - 1)
    val q = qq.map(_ - 1)
    var moves = 0

    for (i <- q.indices) {
      val person = q(i)
      if (person - i > 2) {
        println("Too chaotic")
        return
      }

      val currentIndex = q.indexOf(person)

//      var start, end = 0
//      if (person > currentIndex) {
//        start = currentIndex - 1 max 0
//        end = person - 1
//      } else {
//        start = person - 1 max 0
//        end = i - 1 max 0
//      }
      val start = 0 max person -2
      val end = currentIndex
      for (j <- start to end) {
        if (q(j) > person) {
          moves += 1
        }
      }
    }
    println(moves)
  }

  //    minimumBribes(Array(2,1,5,3,4))
  //    minimumBribes(Array(2,5,1,3,4))
  //  minimumBribes(Array(3, 1, 2, 4, 5, 8, 6, 7))
  minimumBribes(Array(1, 2, 5, 3, 7, 8, 6, 4))
  minimumBribes(Array(1,2,3,5,6,7,8,4))
//
}

/*


No need to swap values, no need to loop backwards, no need to loop more than once. Just loop through each person in the queue and check two things:
  1. Has this person moved more than two positions forward? 2. How many times has this person been bribed?

In Python3:

def minimumBribes(Q):
#
# initialize the number of moves
moves = 0
#
# decrease Q by 1 to make index-matching more intuitive
# so that our values go from 0 to N-1, just like our
# indices.  (Not necessary but makes it easier to
# understand.)
Q = [P-1 for P in Q]
#
# Loop through each person (P) in the queue (Q)
for i,P in enumerate(Q):
# i is the current position of P, while P is the
# original position of P.
#
# First check if any P is more than two ahead of
# its original position
if P - i > 2:
  print("Too chaotic")
return
#
# From here on out, we don't care if P has moved
# forwards, it is better to count how many times
# P has RECEIVED a bribe, by looking at who is
# ahead of P.  P's original position is the value
# of P.
# Anyone who bribed P cannot get to higher than
# one position in front if P's original position,
# so we need to look from one position in front
# of P's original position to one in front of P's
# current position, and see how many of those
# positions in Q contain a number large than P.
# In other words we will look from P-1 to i-1,
# which in Python is range(P-1,i-1+1), or simply
# range(P-1,i).  To make sure we don't try an
# index less than zero, replace P-1 with
# max(P-1,0)
for j in range(max(P-1,0),i):
if Q[j] > P:
  moves += 1
print(moves)*/
