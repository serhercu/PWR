def wordCounter(text: String): scala.collection.mutable.Map[String, Int] = {

  def countWords(splittedA: List[String]): scala.collection.mutable.Map[String, Int] = {
    val list = splittedA
    if (splittedA.length == 1) {
      scala.collection.mutable.Map(splittedA.head -> 1)
    } else {
      scala.collection.mutable.Map(splittedA.head -> countA(splittedA.head)) ++ countWords(splittedA.tail)
    }
  }

  def countA(word:String): Int = {
    val list = text.split(" ").toList
    val length = list.length
    var count = 0
    var number = 0
    if (list.length == length) { return number }
    else if (word == list(count)) {
      number = number + 1
    }
    else {
      countA(word)
    }
    count = count + 1
  }
  countWords(text.split(" ").toList)
}

wordCounter("pepe pepe pepe lotas es un cabron lotas pepe")