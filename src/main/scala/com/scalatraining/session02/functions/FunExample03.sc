
def abs(n: Int): Int = {
  if (n < 0) -n
  else n
}

def factorial(n: Int): Int = {
  // tail recursion
  def go(n: Int, acc: Int): Int = {
    if (n <= 0) acc else go(n - 1, n * acc)
  }

  go(n, 1)
}

// higher-order function (a function that takes another function as parameter)

def formatResult(name: String, n: Int, f: Int => Int): String = {
  val result: Int = f(n)
  s"The $name of $n is ${result}"
}

formatResult("absolute value", -42, abs)
formatResult("factorial", 7, factorial)






// TODO: explain Function1[T, R]

val absFun: Int => Int = new Function1[Int, Int] {
  override def apply(arg1: Int): Int = abs(arg1)
}

val absFun2: Int => Int = abs

val average: (Int, Int) => Double = new Function2[Int, Int, Double] {
  override def apply(arg1: Int, arg2: Int): Double = (arg1 + arg2) / 2.0
}

average(1, 2)

// TODO: compare to java.util.function.BiFunction

// java.util.function.BiConsumer
