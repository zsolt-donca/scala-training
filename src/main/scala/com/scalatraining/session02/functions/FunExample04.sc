import scala.annotation.tailrec

def findFirst(strings: Array[String], key: String): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= strings.length) -1
    else if (strings(n) == key) n // string comparison with == is perfectly okay
    else loop(n + 1)
  }

  loop(0)
}

// indexing an Array[T] behaves like a function: Int => T
//
// hence the syntax:   array(i)

def findFirstMatching(strings: Array[String], pred: String => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= strings.length) -1
    else if (pred(strings(n))) n
    else loop(n + 1)
  }

  loop(0)
}

def findFirstMatching2(strings: Array[Int], pred: Int => Boolean): Int = {
  @tailrec
  def loop(n: Int): Int = {
    if (n >= strings.length) -1
    else if (pred(strings(n))) n
    else loop(n + 1)
  }

  loop(0)
}

val names = Array("alice", "bobby", "bob", "joe")
findFirst(names, "bob")

// find first that starts with "b"

findFirstMatching(names, (str: String) => str.startsWith("b"))

// find first that contains "bob" (matches "bob" or "bobby")

findFirstMatching(names, str => str.contains("bob"))
