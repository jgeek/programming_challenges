package leecode.monthly.jan._5

object deleteDuplicates extends App {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def deleteDuplicates(head: ListNode): ListNode = {

    var h = head
    var newList: ListNode = null
    var p1: ListNode = null
    var p2: ListNode = null
    while (h != null) {
      val value = h.x
      var counter = 0
      while (h.next != null && h.next.x == value) {
        counter += 1
        h = h.next
      }
      if (counter == 0) {
        if (newList == null) {
          newList = new ListNode(h.x, null)
          newList.next = null
          p1 = newList
          p2 = newList
        } else {
          val newNode = new ListNode(h.x, null)
          p2 = newNode
          p1.next = p2
          p1 = p1.next
//          newList.next = p1
          //          newListEnd = newListHead.next
          //          newList.next.next = null
        }
      }
      h = h.next
    }

    newList
  }

  val l = new ListNode(1, new ListNode(2, new ListNode(3,
    new ListNode(4, null))))
  deleteDuplicates(l)
}




