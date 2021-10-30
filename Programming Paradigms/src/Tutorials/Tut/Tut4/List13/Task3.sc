case class Person(firstName:String, lastName:String) extends Ordered[Person] {
  def compare(that: Person) =
    if(this.lastName == that.lastName){
      this.firstName compare that.firstName
    }
    else this.lastName compare that.lastName

}

val valueList = List(Person("Javi","Perez"), Person("Aaron","Perez"),Person("Adri","Garcia"))

valueList.sorted