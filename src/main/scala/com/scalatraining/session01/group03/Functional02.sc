
val numbers: Seq[Int] = 1 to 15

numbers.find(num => num.toString.length > 1)

def divisors(num: Int): Seq[Int] = (2 to num).filter(num % _ == 0)
// TODO fix divisors of 1
// TODO fix divisors to return num only for primes

numbers.map(num => (num, divisors(num)))

numbers.find(divisors(_).size > 3)

def isPrime(num: Int) = divisors(num).size == 1
// TODO optimizations: sqrt(num)

numbers.filter(isPrime)

val primeStream = Stream.from(2).filter(isPrime)

primeStream.take(50).toList




