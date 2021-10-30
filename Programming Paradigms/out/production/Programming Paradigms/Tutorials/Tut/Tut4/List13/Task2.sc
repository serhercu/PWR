class Foo {
  def method(input: String) = input
}
class Bar {
  def method(input: String) = input
}
var foo: Foo = new Foo(); // <- error
var bar: Bar = new Bar();

foo = bar.asInstanceOf[Foo]