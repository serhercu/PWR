import scala.annotation.tailrec

def divideLists(list:List[Int]): (List[Int],List[Int]) = {
  @tailrec
  def tailSplit(list:List[Int], resList1:List[Int], resList2:List[Int]): (List[Int],List[Int])={
    if (list.isEmpty) (resList1, resList2)
    else if (list.head % 2 == 0) tailSplit(list.tail, resList1 :+(list.head * list.head), resList2)
    else tailSplit(list.tail, resList1, resList2 :+ (list.head * 3))
  }
  tailSplit(list,List(),List())
}

divideLists(List(1,4,5,6,7,1,2,3))
divideLists(List(3,6,8,9,13))

List(1,3,Nil,4)

def divideListsRec(list:List[Int]): (List[Int],List[Int]) = {
  if (list.isEmpty) (Nil,Nil)
  else if (list.head % 2 == 0) ((divideListsRec(list.tail) + ((list.head * list.head),Nil)), Nil)
  else (Nil, (list.head * 3) ::: divideListsRec(list.tail))
}

List(1,3,Nil,4)