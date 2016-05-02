import scala.annotation.tailrec

trait RNG {
  def nextInt: (Int, RNG)
}

type Rand[+A] = RNG => (A, RNG)

def unit[A](a: A): Rand[A] =
  rng => (a, rng)

def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
  rng => {
    val (a, rng2) = f(rng)
    g(a)(rng2)
  }
}

def map[A, B](s: Rand[A])(f: A => B): Rand[B] = flatMap(s)(a => unit(f(a)))

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }
}

// concrete Rands

val int: Rand[Int] = _.nextInt

val nonNegativeInt: Rand[Int] = {
  (rng: RNG) => {
    val (int, rng2) = rng.nextInt
    if (int == Int.MinValue) nonNegativeInt(rng2)
    else (Math.abs(int), rng2)
  }
}

def nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)

val double: Rand[Double] = map(nonNegativeInt)(_.toDouble / Int.MaxValue)

def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
  flatMap(ra)(a => map(rb)(b => f(a, b)))
}

def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
  ???
}

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
  if (n <= 0) unit(Nil)
  else flatMap(rand)(head => map(list(n - 1, rand))(tail => head :: tail))
}


val rng = SimpleRNG(1)

list(10, int)(rng)