package com.fp

import com.fp.state._

package object rng {

  trait RNG {
    def nextInt: (Int, RNG)
  }

  type Rand[+A] = State[RNG, A]

  def list[A](n: Int, rand: Rand[A]): Rand[List[A]] = {
    sequence(List.fill(n)(rand))
  }

  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }

}
