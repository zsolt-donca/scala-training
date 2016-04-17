package com.scalatraining.session01

object Example02 extends App {

  def greet(name: String): Unit = {
    println("Hello " + name + "!") // TODO use string interpolation
  }

  greet("World")
}
