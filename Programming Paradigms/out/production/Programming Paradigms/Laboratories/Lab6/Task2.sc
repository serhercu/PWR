def arthemticSeries(first:Int, dif:Int): Stream[Int] = {
  first #:: arthemticSeries(first + dif, dif)
}

arthemticSeries(1,2)