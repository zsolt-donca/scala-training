package com.scalatraining.session02.functions

import scala.annotation.tailrec

object FunExample04 extends App {

  def findFirst(strings: Array[String], key: String): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n >= strings.length) -1
      else if (strings(n) == key) n // string comparison with == is perfectly okay
      else loop(n + 1)
    }

    loop(0)
  }


  val names = Array("alice", "bob", "joe")
  println(findFirst(names, "bob"))

}
