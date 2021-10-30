
def multiplicate(list:LazyList[Int], listMult: LazyList[Int]): LazyList[Any]= {
  def repeat(element: Int, reps: Int): LazyList[Int] = {
    reps match {
      case 0 => LazyList()
      case _ => element +: repeat(element, reps - 1)
    }
  }

  list match {
    case LazyList() => LazyList()
    case _ => repeat(list.head, listMult.head) :++ multiplicate(list.tail, listMult.tail)
  }
}
multiplicate(LazyList(1, 2, 3,4),LazyList (0, 3, 1, 4)).toList.take(8)