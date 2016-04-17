
def fibonacci: Stream[Int] = {

  def fibo(a: Int, b: Int): Stream[Int] = {
    b #:: fibo(b, a + b)
  }

  fibo(0, 1)
}

fibonacci.zipWithIndex.map({
  case (fibo, index) => s"The $index. fibonacci number is $fibo."
}).take(20).foreach(println)