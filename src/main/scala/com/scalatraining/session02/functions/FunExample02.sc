
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

// a function taking an Int and returning a String

def formatAbs(n: Int): String = {
  s"The absolute value of $n is ${abs(n)}"
}

def formatFactorial(n: Int): String = {
  s"The factorial of $n is ${factorial(n)}"
}

formatAbs(-42)
formatFactorial(7)

// TODO Exercise: Write a recursive function to get the n-th Fibonacci number.
// TODO The first two Fibonacci numbers are 0 and 1.
// TODO Your definition should use a local tail-recursive function.

def fibonacci(n: Int): Int = {
  def go(prev: Int, current: Int, i: Int): Int = {
    if (i == n) {
      current
    } else {
      go(current, prev + current, i + 1)
    }
  }

  go(0, 1, 0)
}

(0 to 10) map fibonacci