package com.scalatraining.session02.functions

object FunExample06 extends App {

  // this is a higher-order polymorphic function
  // apply a function partially
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)

    // TODO How many different (pure) implementations can this function have?
  }


  def concat(a: String, b: String): String = a + b

  val addPrefix = partial1("pre", concat)

  val words = List("historic", "disposed", "order")

  println(words map addPrefix)

}

// TODO show partial application built-in into language
//
// TODO Exercise:
//  1. implement curry and replace "partial1" with currying
//  2. implement uncurry
//
// def curry[A, B, C](f: (A, B) => C): A => (B => C)
//
// def uncurry[A, B, C](f: A => B => C): (A, B) => C
//
// TODO show currying built-in into language
//
// TODO Exercise: Implement the higher-order function that composes two functions.
//
// def compose[A,B,C](f: B => C, g: A => B): A => C

