package com.scalatraining.session02.functions

object FunExample02 extends App {

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

  println(formatAbs(-42))
  println(formatFactorial(7))

  // TODO Exercise: Write a recursive function to get the n-th Fibonacci number.
  // TODO The first two Fibonacci numbers are 0 and 1.
  // TODO Your definition should use a local tail-recursive function.
}
