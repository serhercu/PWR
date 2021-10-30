def sumLis (list: List[Int]):Int = {
  list match {
      case x :: _ :: tail => x + sumLis(tail)
      case x :: Nil => x
      case Nil => 0
  }
}
val l1 = List(1,3,5,7,9,11,13)
sumLis(l1)

sumLis(List(1,8))
sumLis(List(-1))
sumLis(List(7,-2,-1))


def connectStrings(listOfString: List[String],
                   separator: String):String = {
  listOfString match {
    case x :: Nil => x
    case x :: tail => x + separator + connectStrings(tail, separator)
  }
}

connectStrings(List("Pepe", "Eduardo", "Ana"), " || ")
connectStrings(List("Pepe"), " || ")


def ocuCount[A](list:List[A], element: A): Int = {
    if (list.isEmpty) 0
    else if (list.head == element) 1 + ocuCount(list.tail, element)
    else ocuCount(list.tail, element)
}

ocuCount(List(1,3,4,1,1,1,1),1)
ocuCount(List("Valencia","Madrid","Sevilla","Barcelona"),"Valencia")
ocuCount(List(12.4,23.1,1.01,9.69), 356.0)


def fibo(n:Int):Int = {
  if (n == 0) 0
  else if (n == 1) 1
  else fibo(n-1) + fibo(n-2)
}

fibo(10)
fibo(0)
fibo(10)
fibo(7)