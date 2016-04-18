package com.scalatraining.session01.group01

object HelloWorld03 extends App {

  def greet(name: String): Unit = {
    println(s"Hello $name!")
  }

  val names = List("World", "Scala", "Awesomeness") // TODO show "Add type annotation"

  for (name <- names) {
    greet(name)
  }

  // CTRL+SHIFT+P
  // quick documentation: CTRL+Q or F1
}
