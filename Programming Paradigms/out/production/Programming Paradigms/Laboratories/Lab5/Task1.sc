def gray(n:Int):List[String] = {
  require(n > 0)

  def addBit(list: List[String], x: String): List[String] = {
    def recAddBit(list: List[String], bit: String, resList: List[String]): List[String] = {
      list match {
        case Nil => resList
        case x :: xs => recAddBit(xs, bit, resList :+ (bit.concat(x)))
      }
    }
    recAddBit(list, x, List())
  }
  n match {
    case 1 => List("0", "1")
    case n => addBit(gray(n - 1), "0") ::: (addBit(gray(n - 1), "1")).reverse
    }
}

gray(3)