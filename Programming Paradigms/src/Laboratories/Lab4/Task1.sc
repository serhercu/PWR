import scala.annotation.tailrec

def difSumList (list: List[Int]): Int = {
  @tailrec
  def tailDifSumList(list: List[Int], res:Int): Int = {
    if (list.isEmpty) res
    else tailDifSumList(list.tail, res - list.head)
  }
  tailDifSumList(list.tail, list.head)

}

difSumList(List(1,2))
difSumList(List(1,2,1,4,-7))