// 1. (3pt.) Define a function which for each number k (1…n) converts lazy list to lazy
//list in which eachelement of input list occurs k times
def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[Any] = {
  def rep[A](k: Int, x:A): LazyList[A] = {
    if (k==0) {return LazyList()}
    else {x #:: rep(k - 1,x)}
  }
  lxs match {
    case LazyList()=> LazyList()
    case x #:: xs => rep(k,x) #::: lrepeat(k)(xs)
  }
}
lrepeat(2)(LazyList(1,2,3,4)).toList


// 2. (3pt.) Define function which generate Fibonacci
// Sequence in lazy way
def fib:LazyList[BigInt] = {
  def lazyFib(a:BigInt, b:BigInt): LazyList[BigInt] = {
    a #:: lazyFib(b, a + b)
  }
  lazyFib(0,1)
}

fib.take(8).toList

// 3. (4pt.) Define function which generate infinity tree
// which as root has number n (parameter) and sub trees:
// Tree (2*n) and Tree( 2*n+1).

trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A],
                     right:()=>lBT[A]) extends lBT[A]

def lazyGen(n:Int): lBT[Int] = {
  LNode(n,() => lazyGen(2 * n), () => lazyGen(2 * n + 1))
}

lazyGen(1)
lazyGen(4)
