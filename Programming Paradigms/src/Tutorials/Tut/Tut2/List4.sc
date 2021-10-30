// 1. (3pt.) Write a function which return all primes from list of numbers (limit values
//to: 0-200). Hint: use Sieve of Eratosthenes to generate list of primes and use
//filter for the list.
def sieveOf(list:List[Int]): List[Int] = {
    list match {
      case x :: Nil => List(x)
      case x :: tail => list.head :: sieveOf (list.tail.filter (x => x % list.head != 0) )

  }
}

sieveOf(List(1,2,3,4,5,6,7,8,9,10))

// 2.(3pt.) Using ADT and pattern matching, write a simple calculator that supports
//two functions: add (a + b) and negation (-n).
sealed trait Func
final case class add(a:Int, b:Int) extends Func
final case class neg(n:Int) extends Func

def addition(f:Func): Int = {
      f match {
      case add(a,b) => a + b
}}

def negation(f:Func): Int = {
  f match {
  case neg(n) => n - n - n
}}

addition(add(2,5))
negation(neg(1))

// 3. (2pt.) Using ADT define your own Bool type and write functions AND, OR, XOR,
//NAND, NOR.
sealed trait Bools
final case class And(a:Boolean, b:Boolean) extends Bools
final case class Or(a:Boolean, b:Boolean) extends Bools
final case class Xor(a:Boolean, b:Boolean) extends Bools
final case class Nand(a:Boolean, b:Boolean) extends Bools
final case class Nor(a:Boolean, b:Boolean) extends Bools

def and(b:Bools): Boolean = {
  b match {
    case And(true, false) => false
    case And(false, true) => false
    case And(false, false) => false
    case And(true, true) => true
  }
}
and(And (true,false))

def or(b:Bools): Boolean = b match {
  case Or(true, false) => true
  case Or(false, true) => true
  case Or(false, false) => false
  case Or(true, true) => true
}
or(Or(true,false))

def xor(b:Bools): Boolean = b match {
  case Xor(true, false) => true
  case Xor(false, true) => true
  case Xor(false, false) => false
  case Xor(true, true) => false
}
xor(Xor(true,false))

def nand(b:Bools): Boolean = b match {
  case Nand(true, false) => true
  case Nand(false, true) => true
  case Nand(false, false) => true
  case Nand(true, true) => false
}
nand(Nand(true,false))

def nor(b:Bools): Boolean = b match {
  case Nor(true, false) => false
  case Nor(false, true) => false
  case Nor(false, false) => true
  case Nor(true, true) => false
}
nor(Nor(true,false))

// 4. (2pt.) Using pattern matching write function which print information what is the
//type or argument. It should support 5 types.
def typeOf(x:Any): String = x match {
  case x:String => "This is a String"
  case x:Int => "This is an Int"
  case x:Double => "This is a Double"
  case x:Boolean => "This is a Boolean"
  case x:Char => "This is a Char"
}

typeOf(1.5)
typeOf("Luke, I'm your father")
typeOf(true)