def mantisa(number:Double): Double = {
  if(number < 1) {return number}
  else {mantisa(number - 1)}
}

mantisa (1020312.71273871238)
mantisa(3.4)