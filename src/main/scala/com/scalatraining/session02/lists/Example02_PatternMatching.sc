
sealed trait List[+A]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]

object List {
  def apply[A](elems: A*): List[A] = {
    if (elems.isEmpty) Nil
    else Cons(elems.head, apply(elems.tail: _*))
  }
}

// Pattern Matching


List(1, 2, 3) match {
  case _ => 42
}

List(1, 2, 3) match {
  case Cons(h, t) => h
}

List(1, 2, 3) match {
  case Cons(_, t) => t
}

// TODO fix
List(1, 2, 3) match {
  case Nil => "nothing"
}

// TODO write printing the elements of a list to the console into a single line

def printList[A](list: List[A]): Unit = {
  ???
}
