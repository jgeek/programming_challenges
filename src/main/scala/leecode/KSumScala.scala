package leecode

object KSumScala {

  def kSum(nums: Array[Int], target: Int, k: Int): List[List[Int]] = {
    nums.sortInPlace()
    kSum(nums, target, k, 0)

  }

  private def kSum(nums: Array[Int], target: Int, k: Int, start: Int): List[List[Int]] = {

    var result = List[List[Int]]()
    if (start == nums.length || nums(start) * k > target || nums(nums.length - 1) * 4 < target) {
      return result
    }
    if (k == 2) {
      return twoSum2(nums, target, start)
    }

    for (i <- start until nums.length) {

      if (i == start || nums(i) != nums(i - 1)) {
        for (list <- kSum(nums, target - nums(i), k - 1, i + 1)) {
          result = (nums(i) :: list) :: result
        }
      }
    }
    result
  }

  private def twoSum(nums: Array[Int], target: Int, start: Int): List[List[Int]] = {
    var twoSumResult: List[List[Int]] = Nil
    var set: Set[Int] = Set.empty
    for (i <- start until nums.length) {
      if (twoSumResult.isEmpty || twoSumResult.head(1) != nums(i)) {
        if (set.contains(target - nums(i))) {
          twoSumResult = List(target - nums(i), nums(i)) :: twoSumResult
        }
      }
      set += nums(i)
    }
    //    println(twoSumResult.map(_.mkString(",")).mkString("|"))
    twoSumResult
  }

  def twoSum2(nums: Array[Int], target: Int, start: Int): List[List[Int]] = {
    var res: List[List[Int]] = Nil
    var lo: Int = start
    var hi: Int = nums.length - 1
    while (lo < hi) {
      val sum: Int = nums(lo) + nums(hi)
      if (sum < target || (lo > start && nums(lo) == nums(lo - 1)))
        lo += 1
      else if (sum > target || (hi < nums.length - 1 && nums(hi) == nums(hi + 1)))
        hi -= 1
      else {
        res = List(nums(lo), nums(hi)) :: res
        hi -= 1;
        hi + 1
      }
    }
//    println(res.map(_.mkString(",")).mkString("|"))
    res
  }
}
