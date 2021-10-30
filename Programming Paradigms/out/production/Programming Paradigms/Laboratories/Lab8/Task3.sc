def oddNumbersImp(number:Int, k:Int): List[Int] = {
  var listRes = List[Int]()
  var auxNumber = number
  var i = 0
  while(i!=k) {
    if (auxNumber % 2 != 0) {
      listRes = auxNumber :: listRes
      auxNumber = auxNumber + 2
      i = i + 1
    }
    else {
      auxNumber = auxNumber + 1
    }
  }
  return listRes.reverse
}

oddNumbersImp(12,2)

def oddNumbers(number:Int, k:Int): List[Int] = {
  k match {
    case 0 => List()
    case _ => if (number % 2 != 0) {
      List(number) ::: oddNumbers(number + 2, k - 1)
    }
    else {
      List(number + 1) ::: oddNumbers(number + 2, k - 1)
    }
  }
}
oddNumbers(12,2)
