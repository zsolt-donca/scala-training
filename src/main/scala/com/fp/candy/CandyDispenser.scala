package com.fp.candy

import com.fp.state._

object CandyDispenser {

  sealed trait Input

  case object Coin extends Input

  case object Turn extends Input

  case class Candy()

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  type CandyState[+A] = State[Machine, A]

  val insert: CandyState[Unit] = {
    modifyPF {
      case Machine(true, candies, coins) if candies > 0 =>
        Machine(locked = false, candies, coins + 1)
    }
  }

  val turnKnob: CandyState[Option[Candy]] = {
    case Machine(false, candies, coins) if candies > 0 =>
      (Some(Candy()), Machine(locked = true, candies - 1, coins))
    case machine =>
      (None, machine)
  }

  val apply: Input => CandyState[Option[Candy]] = {
    case Coin => insert.map(_ => None)
    case Turn => turnKnob
  }

  val buyCandy: CandyState[Option[Candy]] = {
    for {
      _ <- insert
      candyOption <- turnKnob
    } yield candyOption
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

  def simulateMachine(inputs: List[Input]): CandyState[(List[Candy], Int, Int)] = {
    for {
      candies <- sequence(inputs map apply).map(_.flatten)
      machine <- get[Machine]
    } yield (candies, machine.coins, machine.candies)
  }
}
