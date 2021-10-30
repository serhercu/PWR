def half_geometric(first:Double, ratio:Double, size:Double): List[Double]= {
  if (size > 0) first / 2 :: half_geometric(first*ratio, ratio, size - 1)
  else Nil
}

half_geometric(1,2,4)
half_geometric (1.0,3.0,3)