import scala.annotation.tailrec

def sumLis (list: List[Int]):Int = {
  @tailrec
  def sumTail(acc: Int, list:List[Int]):Int = {
    list match {
      case Nil => acc
      case x :: tail => sumTail(x + acc,tail)
    }
  }
  sumTail(0, list)
}

val l1 = List(1,3,5,7,9,11,13)
sumLis(l1)

def recReverseList[A] (list: List[A]): List[A] = {
  list match {
    case x :: Nil => List(x)
    case x :: tail => recReverseList(tail) :+ x

  }
}
recReverseList(List(1,4,8,12))



def tailReverseList [A](list: List[A]): List[A] = {
  @tailrec
  def listTailRev(list: List[A], resList: List[A]): List[A] = {
    if(list.length == 1) list.head :: resList
    else listTailRev(list.tail, list.head :: resList )
  }
  listTailRev(list, List())
}

tailReverseList(List(1,4,8,12))
tailReverseList(List("Juan", "Jorge", "Pepe"))


def mergeLists [A](list1: List[A], list2: List[A]): List[A] = {
  @tailrec
  def tailMerge(list1: List[A], list2: List[A], resList: List[A]): List[A] = {
    if (list1.isEmpty && list2.isEmpty) resList
    else if (list1.isEmpty && list2.nonEmpty) tailMerge(list1, list2.tail,resList :+ list2.head)
    else if (list1.nonEmpty && list2.isEmpty) tailMerge(list1.tail, list2,resList :+ list1.head)
    else tailMerge(list1.tail, list2.tail,resList :+ list1.head :+ list2.head)
  }
  tailMerge(list1, list2, List())
}
mergeLists(List(1), List(4,5,6))
mergeLists(List(1,2,3), List(4,5))
mergeLists(List("Pepe","Juan"), List("Maria", "Lucia"))


def fib(n:Int): Int = {
  require(n > 0)
  @tailrec
  def tailFibs(n:Int, prev:Int, current:Int):Int = {
    if(n==0) current
    else tailFibs(n - 1, prev = prev + current, current = prev)
  }
  tailFibs(n, 1, 0)
}
fib(7)
fib(10)






def splitLists(list:List[Int]): (List[Int],List[Int]) = {
  @tailrec
  def tailSplit(list:List[Int], resList1:List[Int], resList2:List[Int]): (List[Int],List[Int])={
    if (list.isEmpty) (resList1, resList2)
    else if (list.head % 2 == 0) tailSplit(list.tail, list.head :: resList1, resList2)
    else tailSplit(list.tail, resList1, list.head :: resList2)
  }
  tailSplit(list,List(),List())
}

splitLists(List(1,4,5,6,7,1,2,3))