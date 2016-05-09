import scala.annotation.tailrec

// polymorphic function ("parametric polymorphism", not to be confused with to OOP "subtype polymorphism")

def findFirst[T](strings: Array[T], p: T => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= strings.length) -1
    else if (p(strings(n))) n
    else loop(n + 1)
  }

  loop(0)
}

val names = Array("alice", "bobby", "bob", "joe")

findFirst(names, (name: String) => name == "bob")

findFirst(names, (name: String) => name.startsWith("b"))

findFirst(names, (name: String) => name.contains("bob"))


// TODO Exercise: Write a function that checks whether an array is sorted according to a given comparison function

def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  // not (yet) implemented
  ???
}

val stringCompare: (String, String) => Boolean = {
  (a, b) => a.compareToIgnoreCase(b) <= 0
}

// should be false
isSorted(names, stringCompare)

val names2 = Array("alice", "bob", "bobby", "joe")

// should be true
isSorted(names2, stringCompare)