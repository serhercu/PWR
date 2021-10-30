import scala.annotation.tailrec

def combineLists (list1:List[Int], list2:List[Int]): List[Int] = {
  @tailrec
  def tailCombineLists(list1:List[Int], list2:List[Int], resList:List[Int]): List[Int] = {
    if(list1.isEmpty && list2.isEmpty) resList
    else if (list1.isEmpty && list2.nonEmpty) tailCombineLists(list1, list2.tail, resList :+ list2.head)
    else if (list1.nonEmpty && list2.isEmpty) tailCombineLists(list1.tail, list2, resList :+ list1.head)
    else tailCombineLists(list1.tail, list2.tail, resList :+ (list1.head + list2.head))
  }
  tailCombineLists(list1, list2, List())
}

combineLists(List(5,4,3,2), List(1,2,3,4,5,6))
combineLists(List(5,4,3,2), List(3,4,5,6))

def combineListsRec(list1:List[Int], list2:List[Int]): List[Int] = {
  if(list1.isEmpty && list2.isEmpty) Nil
  else if (list1.isEmpty && list2.nonEmpty) list2.head :: combineListsRec(list1, list2.tail)
  else if (list1.nonEmpty && list2.isEmpty) list1.head :: combineListsRec(list1.tail, list2)
  else (list1.head + list2.head) :: combineListsRec(list1.tail, list2.tail)
}

combineListsRec(List(5,4,3,2), List(1,2,3,4,5,6))
combineLists(List(5,4,3,2), List(3,4,5,6))

def divideListsRec(list:List[Int]): (List[Int],List[Int]) = {
  if (list.isEmpty) (Nil,Nil)
  else if (list.head % 2 == 0) ((divideListsRec(list.tail) :+ ((list.head * list.head),Nil)), Nil)
  else (Nil, (list.head * 3) :: divideListsRec(list.tail))
}