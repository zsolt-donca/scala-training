
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
  case Cons(h, _) => h
}

List(1, 2, 3) match {
  case Cons(_, t) => t
}

List(1, 2, 3) match {
  case Nil => 42
}

val list = Cons("one", Cons("two", Cons("three", Cons("four", Cons("five", Nil)))))

// this works for Cons only
val h0 = list.head
val t0 = list.tail

// variable declaration with decomposition
val Cons(h1, t1) = list

// decomposition into two heads and tail
val Cons(h2, Cons(h3, t3)) = list

//
val numberList: List[Int] = Nil
val Cons(h4, t4) = numberList

