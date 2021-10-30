class Animal {
  def makeNoise(c:{def noise():String}) = println(c.noise)
}
class Cat {
  def noise():String = "Meow"
}

class Dog {
  def noise():String = "Woof"
}

val walkerStruct = new Animal();
walkerStruct.makeNoise(new Cat())
walkerStruct.makeNoise(new Dog())
