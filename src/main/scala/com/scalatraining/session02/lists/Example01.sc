

sealed trait List[+A]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]

// List is an "Algebraic Data Type"

val list1 = Cons("one", Cons("two", Cons("three", Cons("four", Cons("five", Nil)))))


// Companion Object
object List {
  // A* means varargs
  def apply[A](elems: A*): List[A] = {
    if (elems.isEmpty) Nil
    else Cons(elems.head, apply(elems.tail: _*))
  }
}


val list2 = List("one", "two", "three", "four", "five")


list1 == list2
