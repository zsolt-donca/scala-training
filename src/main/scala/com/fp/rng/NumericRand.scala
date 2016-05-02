package com.fp.rng

object NumericRand {

  val int: Rand[Int] = _.nextInt

  val nonNegativeInt: Rand[Int] = {
    flatMap(int)(int => {
      if (int == Int.MinValue) nonNegativeInt
      else unit(Math.abs(int))
    })
  }

  val nonNegativeInt_old: Rand[Int] = {
    (rng: RNG) => {
      val (int, rng2) = rng.nextInt
      if (int == Int.MinValue) nonNegativeInt(rng2)
      else (Math.abs(int), rng2)
    }
  }

  val nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)

  val double: Rand[Double] = map(nonNegativeInt)(_.toDouble / Int.MaxValue)

  def lessThan(n: Int): Rand[Int] = {
    flatMap(nonNegativeInt)(i => {
      val mod = i % n
      if (i + (n - 1) - mod >= 0) unit(i)
      else lessThan(n)
    })
  }
}
