package com.scalatraining.session01

object Example03 extends App {

  def greet(name: String): Unit = {
    println(s"Hello $name!")
  }

  val names = List("World", "Scala", "Awesomeness")

  for (name <- names) {
    greet(name)
  }
}
