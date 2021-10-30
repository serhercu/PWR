import scala.collection.mutable

def copy[A] (collection: mutable.Set[A]):mutable.Set[A] = {
  collection.clone()
}
val set = mutable.Set(1,2,3)
val setCopy = copy(set)
set.remove(1)
set
setCopy