package com.scalatraining.session01.group01

object HelloWorld03 extends App {

  def greet(name: Any): Unit = {
    println(s"Hello $name!")
  }

  val names: List[String] = List("World", "Scala", "Awesomeness")

  for (name: String <- names) {
    greet(name)
  }

  // CTRL+SHIFT+P
  // quick documentation: CTRL+Q or CTRL+J or F1
}
