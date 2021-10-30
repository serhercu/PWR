def and(bool:(Boolean,Boolean)):Boolean = {
  bool match {
    case (true,true) => true
    case (true,false) => false
    case(false,true) => false
    case (false,false) => false

  }
}

