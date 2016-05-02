package com.fp

package object rng {

  trait RNG {
    def nextInt: (Int, RNG)
  }

  type Rand[+A] = RNG => (A, RNG)

  def unit[A](a: A): Rand[A] = rng => (a, rng)

  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, rng2) = f(rng)
      g(a)(rng2)
    }
  }

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = flatMap(s)(a => unit(f(a)))

  implicit class RandMonad[A](rand: Rand[A]) {
    def map[B](f: A => B) = rng.map(rand)(f)

    def flatMap[B](f: A => Rand[B]) = rng.flatMap(rand)(f)
  }

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    //    flatMap(ra)(a => map(rb)(b => f(a, b)))
    for (a <- ra; b <- rb) yield f(a, b)
  }

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
    fs match {
      case head :: tail => map2(head, sequence(tail))(_ :: _)
      case Nil => unit(Nil)
    }
  }

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
