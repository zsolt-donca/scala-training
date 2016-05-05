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


val names = Array("alice", "bobby", "bob", "joe")
findFirst(names, "bob")

// find first that starts with "b"
// find first that contains "bob" (matches "bob" or "bobby")
