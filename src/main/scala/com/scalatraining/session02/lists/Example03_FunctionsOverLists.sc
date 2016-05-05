


sealed trait List[+A]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]

object List {
  def apply[A](elems: A*): List[A] = {
    if (elems.isEmpty) Nil
    else Cons(elems.head, apply(elems.tail: _*))
  }
}


/**
  * Concatenate a list, that is:
  * return empty string for empty list
  * return string values joined with " " space otherwise
  */
def concat(list: List[String]): String = {
  list match {
    case Nil => "" // == 0 elements
    case Cons(head, tail) => head + " " + concat(tail) // >= 1 elements
  }
}

concat(List("one", "two", "three", "four", "five"))

//   Substitution Model

// step 0
concat(List("one", "two", "three", "four", "five"))

// step 1
"one" + " " + concat(List("two", "three", "four", "five"))

// step 2
"one " + concat(List("two", "three", "four", "five"))

// step 3
"one " + "two" + " " + concat(List("three", "four", "five"))

// step 4
"one two " + concat(List("three", "four", "five"))

// step 5
"one two " + "three" + " " + concat(List("four", "five"))

// step 6
"one two three " + concat(List("four", "five"))

// step 7
"one two three " + "four" + " " + concat(List("five"))

// step 8
"one two three four " + concat(List("five"))

// step 9
"one two three four " + "five" + " " + concat(List())

// step 10
"one two three four five " + concat(List())

// step 11
"one two three four five " + ""

// step 12
"one two three four five "



/**
  * Calculate the sum of a numeric list, that is:
  * return 0 for empty list
  * return the sum of elements otherwise
  */
def sum(list: List[Int]): Int = {
  list match {
    case Nil => 0
    case Cons(head, tail) => head + sum(tail)
  }
}

val nums1 = List(3, 4, 5)
sum(nums1)


/**
  * Calculate a product of a list, that is:
  * return 1.0 for empty list
  * return the product of elements otherwise
  */
def product(list: List[Double]): Double = {
  list match {
    case Nil => 1.0
    case Cons(0, _) => 0.0
    case Cons(head, tail) => head * product(tail)
  }
}

val nums2 = List(4.0, 3.0, 0.5)
product(nums2)




// TODO make "concat" parametric in separator
// TODO use it with "," to make comma-separated list
// TODO drop the last comma (to make it "one, two, three, four, five)"


//
// Exercises:
//
// - Implement the function tail for removing the first element of a List.
//   What are different choices you could make in your implementation if the List is Nil?
//
//     def tail[A](l: List[A]): List[A]
//
//   Example:
//
//     tail(List(1, 2, 3, 4) == List(2, 3, 4)
//
//
// - Implement the function setHead for replacing the first element of a List with a different value.
//
//     def setHead[A](l: List[A], elem: A]: List[A]
//
//   Example:
//
//     setHead(List(1, 2, 3, 4), 5) == List(5, 2, 3, 4)
//
//
// - Generalize tail to the function drop, which removes the first n elements from a list.
//   Note that this function takes time proportional only to the number of elements being dropped;
//   we don’t need to make a copy of the entire List.
//
//     def drop[A](l: List[A], n: Int): List[A]
//
//   Example:
//
//     drop(List(1, 2, 3, 4), 2) == List(3, 4)
//
//
// - Implement dropWhile, which removes elements from the List prefix as long as they match a predicate.
//
//     def dropWhile[A](l: List[A], f: A => Boolean): List[A]
//
//   Example:
//
//     dropWhile(List(1, 2, 3, 4), (i: Int) => i % 3 != 0)) == List(3, 4)
//
//
// - Implement a function that appends two lists.
//   Note that the second list does not need to be copied.
//
//     def append[A](a1: List[A], a2: List[A]): List[A]
//
//   Example:
//
//     append(List(1, 2), List(3, 4)) == List(1, 2, 3, 4)
//
// - Implement a function, init, that returns a List consisting of all but the last element of a List.
//   Can this function be implemented in constant-time like "tail"?
//
//     def init[A](l: List[A]): List[A]
//
//   Example:
//
//     init(List(1, 2, 3, 4) == List(1, 2, 3)
//
//
//
//
//

// TODO S-99: Ninety-Nine Scala Problems:   http://aperiodic.net/phil/scala/s-99/
