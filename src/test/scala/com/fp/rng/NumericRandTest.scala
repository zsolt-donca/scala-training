package com.fp.rng

import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}


class NumericRandTest extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {

  import com.fp.rng.NumericRand._

  "nonNegativeInt" should "return a zero or positive number" in {
    forAll {
      rng: RNG =>
        val (result, _) = nonNegativeInt(rng)
        result should be >= 0
    }
  }

  "nonNegativeEven" should "return zero or a positive even number" in {
    forAll {
      rng: RNG =>
        val (result, _) = nonNegativeEven(rng)
        result should be >= 0
        (result % 2) shouldBe 0
    }
  }

  implicit val rngGenerator: Arbitrary[RNG] = Arbitrary(Gen.choose(Long.MinValue, Long.MaxValue).map(SimpleRNG))

}
