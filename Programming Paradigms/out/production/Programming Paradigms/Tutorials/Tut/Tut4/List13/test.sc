def alpha(that:List[Int]):List[Int] = {
  that match{
    case x :: xs :: tail =>
      if(x > xs){alpha(xs::x::tail)}
      else {x :: alpha(that.tail)}
    case x => that
  }

}

alpha(List(4, 1, 2, 5, 124, 0))