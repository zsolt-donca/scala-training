package com.scalatraining.session01.group01

object HelloWorld04 extends App {

  def greet(name: String): Unit = {
    println(s"Hello $name!")
  }

  val names = List("World", "Scala", "Awesomeness")

  // functional-style, infix notation
  names foreach greet
}
