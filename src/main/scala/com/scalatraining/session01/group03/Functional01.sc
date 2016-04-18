
val numbers: Seq[Int] = 1 to 10

numbers.take(3)

numbers.drop(3)

numbers.drop(3).take(2)

// Java-8 equivalent:
// numbers.stream().filter(num -> num % 3 == 0).collect(Collectors.toList())

numbers.filter(_ % 3 == 0)

// multiple return values
val (even, odd) = numbers.partition(_ % 2 == 0)

numbers.map(num => "value: " + num.toString)

numbers.sum

// TODO Exercise
// Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number,
// and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”.


val nums = 1 to 100
nums collect {
  case value if value % 3 == 0 && value % 5 == 0 => println("FizzBuzz")
  case value if value % 3 == 0 => println("Fizz")
  case value if value % 5 == 0 => println("Buzz")
  case value => println(value)
}
