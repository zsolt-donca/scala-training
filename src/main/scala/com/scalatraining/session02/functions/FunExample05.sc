import scala.annotation.tailrec

// polymorphic function ("parametric polymorphism", not to be confused with to OOP "subtype polymorphism")
def findFirst[T](strings: Array[T], p: T => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= strings.length) -1
    else if (p(strings(n))) n // string comparison with == is perfectly okay
    else loop(n + 1)
  }

  loop(0)
}

val names = Array("alice", "bob", "joe")

findFirst(names, (name: String) => name == "bob")

findFirst(names, (name: String) => name.startsWith("b"))


// TODO Exercise: Write a function that checks whether an array is sorted according to a given comparison function
//
// def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean
//