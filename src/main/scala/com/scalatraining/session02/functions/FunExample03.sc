
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
  s"The $name of $n is ${f(n)}"
}

formatResult("absolute value", -42, abs)
formatResult("factorial", 7, factorial)


// TODO: show Function1[T, R]
