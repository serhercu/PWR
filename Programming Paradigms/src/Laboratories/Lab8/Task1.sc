def split(list:List[Int]): (List[Int], List[Int]) = {
  def splitOdd(list:List[Int]): List[Int] = {
    list match {
      case Nil => List()
      case x :: Nil => List(x)
      case x :: y :: tail => x :: splitOdd(tail)
    }
  }
  def splitEven(list:List[Int]): List[Int] = {
        list match {
          case Nil => List()
          case x :: Nil => List()
          case x :: y :: tail => y :: splitEven(tail)
        }
  }
  list match{
    case Nil => (List(),List())
    case _ => (splitOdd(list), splitEven(list))
  }
}
split(List(1,2,3,4))

def splitImp(list:List[Int]): (List[Int], List[Int]) = {
  var oddList = List[Int]()
  var evenList = List[Int]()
  for(i <- 0 until list.length) {
    if(i % 2 != 0) {
      oddList = list(i) :: oddList
    }
    else {
      evenList = list(i) :: evenList
    }
  }
  return (evenList.reverse, oddList.reverse)

}

splitImp(List(1,2,3,4))