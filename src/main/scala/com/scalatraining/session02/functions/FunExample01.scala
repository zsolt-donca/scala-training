package com.scalatraining.session02.functions

object FunExample01 extends App {

  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  // a function taking an Int and returning a String
  def formatAbs(n: Int): String = {
    s"The absolute value of $n is ${abs(n)}"
  }

  println(formatAbs(-42))
}
