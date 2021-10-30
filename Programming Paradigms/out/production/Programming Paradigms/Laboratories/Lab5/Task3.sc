import scala.collection.immutable.TreeSeqMap.Empty

sealed trait BTree[+T]
case object Leaf extends BTree[Nothing]
case class Branch[+T](value: T, left: BTree[T], right: BTree[T]) extends BTree[T]

def mirrorTree[T](t: BTree[T]): BTree[T] = t match {
  case Leaf => Leaf
  case Branch(x, left, right) => Branch(x, mirrorTree(right), mirrorTree(left))
}

val t = Branch(1,Branch(2,Leaf,Branch(3,Leaf,Branch(4,Leaf,Leaf))),Leaf)
mirrorTree(t)