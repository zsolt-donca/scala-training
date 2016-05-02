package com.fp.rng

import org.scalacheck.Shapeless._
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
        (result % 2) should be(0)
    }
  }

  "lessThan" should "return positive or zero values less than an arbitrary value" in {
    forAll(rngGenerator, Gen.choose(1, Int.MaxValue)) {
      (rng: RNG, limit: Int) =>
        val (result, _) = lessThan(limit)(rng)
        result should be >= 0
        result should be < limit
    }
  }

  implicit val rngGenerator: Gen[RNG] = Gen.choose(Long.MinValue, Long.MaxValue).map(SimpleRNG)
  implicit val arbitraryRng = Arbitrary(rngGenerator)

}
