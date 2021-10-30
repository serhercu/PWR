///class 3 task 3
def combine(listOfString: List[String],
                   separator: String):String = {
  listOfString match {
    case x :: Nil => x
    case x :: tail => x + separator + combine(tail, separator)
  }
}

combine(List("Pepe", "Eduardo", "Ana"), " || ")
combine(List("Pepe"), " || ")

