

case class Person(name:String, last:String) extends Ordered[Person] {
  def compare(that: Person) = this.name compare that.name
}


val valueList = List(Person("Javi","Perez"), Person("Adri","Garcia"))
valueList.sorted
valueList.min