def odd(n:Int): Stream[Int] = {
    if (n % 2 != 0) {n #:: odd(n + 2)}
    else odd(n + 1)

}
odd(12)
