package com.scalatraining.session01

object Example04 extends App {

  def greet(name: String): Unit = {
    println(s"Hello $name!")
  }

  val names = List("World", "Scala", "Awesomeness")

  names foreach greet
}
