def merge(list1:List[Int], list2:List[Int]) : List[Int] = {
  list1 match {
    case Nil => list2 match {
      case Nil => List()
      case x => x
    }

    case x :: tail => list2 match {
      case Nil => x :: tail
      case y :: tail2 => List(x, y) ::: merge(tail, tail2)
    }
  }
}
merge(List(1,3,5), List(2,4,6))

def mergeImp(list1:List[Any], list2:List[Any]) : List[Any] = {
  var length = 0
  var listRes = List[Any]()
  if (list1.length > list2.length) {
    length = list1.length
  } else { length = list2.length }

  for(i <- 0 until length) {
    if (list1(i) != Nil) {listRes = List(list1(i)) ::: listRes}
    if(list2(i) != Nil) {listRes = List(list2(i)) ::: listRes}
  }
  return listRes.reverse
}

mergeImp(List(1,3,5), List(2,4,6))