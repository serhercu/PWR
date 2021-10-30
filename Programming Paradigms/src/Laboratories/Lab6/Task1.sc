sealed trait BTree[+T]
case object Leaf extends BTree[Nothing]
case class Branch[+T](value: T, left: BTree[T], right: BTree[T]) extends BTree[T]

def find(element:String, t:BTree[String]): List[String] = {
  t match {
    case Leaf => List()
    case Branch(x,left,right) =>
      if(x.contains(element))
        {x :: find(element,left) ::: find(element,right)}
      else
        {find(element,left) ::: find(element,right)}
    }

  }
find("Tes", Branch("Test",Branch("Testtt", Leaf, Leaf), Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf))))
