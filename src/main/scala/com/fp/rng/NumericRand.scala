package com.fp.rng

object NumericRand {

  val int: Rand[Int] = _.nextInt

  val nonNegativeInt: Rand[Int] = {
    (rng: RNG) => {
      val (int, rng2) = rng.nextInt
      if (int == Int.MinValue) nonNegativeInt(rng2)
      else (Math.abs(int), rng2)
    }
  }

  val nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)

  val double: Rand[Double] = map(nonNegativeInt)(_.toDouble / Int.MaxValue)

  def nonNegativeLessThan(n: Int): Rand[Int] = {
    rng: RNG => {
      val (i, rng2) = nonNegativeInt(rng)
      val mod = i % n
      if (i + (n - 1) - mod >= 0)
        (mod, rng2)
      else nonNegativeLessThan(n)(rng)
    }
  }

  def lessThan(n: Int): Rand[Int] = {
    flatMap(int)(i => {
      val mod = i % n
      if (i + (n - 1) - mod >= 0) unit(i)
      else lessThan(n)
    })
  }

  def list[A](n: Int, rand: Rand[A]): Rand[List[A]] = {
    sequence(List.fill(n)(rand))
  }
}
