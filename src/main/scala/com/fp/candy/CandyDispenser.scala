package com.fp.candy

import com.fp.state._

object CandyDispenser {

  sealed trait Input

  case object Coin extends Input

  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  type CandyState[+A] = State[Machine, A]

  val insert: CandyState[String] = {
    machine =>
      machine match {
        case Machine(true, candies, coins) if candies > 0 =>
          ("charged", Machine(locked = false, candies, coins + 1))
        case machine =>
          ("lost a coin", machine)
      }
  }

  val turnKnob: CandyState[String] = {
    case Machine(false, candies, coins) if candies > 0 =>
      ("candy", Machine(locked = true, candies - 1, coins))
    case machine =>
      ("nothing", machine)
  }

  val apply: Input => CandyState[String] = {
    case Coin => insert
    case Turn => turnKnob
  }

  val buyCandy: CandyState[List[String]] = {
    for {
      r1 <- insert
      r2 <- turnKnob
    } yield List(r1, r2)
  }

  /*

  var locked = ...
  var candies: Int = ...
  var coin: Int = ...

  def insert() = {
  }

  def buyCandy: List[String] = {
    val r1 = insert();
    val r2 = turnKnob();
    return List(r1, r2);
  }

   */

  def simulateMachine(inputs: List[Input]): CandyState[(List[String], Int, Int)] = {
    for {
      results <- sequence(inputs map apply)
      machine <- get[Machine]
    } yield (results, machine.coins, machine.candies)
  }
}
