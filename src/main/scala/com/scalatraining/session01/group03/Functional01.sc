
val numbers: Seq[Int] = 1 to 10

numbers.take(3)

numbers.drop(3)

numbers.drop(3).take(2)

numbers.filter(num => num % 3 == 0) // TODO _

val (even, odd) = numbers.partition(_ % 2 == 0)

numbers.map(num => num.toString)

numbers.sum

// TODO Exercise
// Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number,
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.
