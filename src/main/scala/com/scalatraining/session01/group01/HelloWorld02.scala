package com.scalatraining.session01.group01

object HelloWorld02 extends App {

  def greet(name: String): Unit = {
    println("Hello " + name + "!") // TODO use string interpolation
  }

  greet("World")
}
