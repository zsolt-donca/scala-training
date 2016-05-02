package com.fp

package object state {
  type State[S, +A] = S => (A, S)

  def unit[S, A](a: A): State[S, A] = s => (a, s)

  def flatMap[S, A, B](f: State[S, A])(g: A => State[S, B]): State[S, B] = {
    state => {
      val (a, rng2) = f(state)
      g(a)(rng2)
    }
  }

  def map[S, A, B](s: State[S, A])(f: A => B): State[S, B] = flatMap(s)(a => unit(f(a)))

  def map2[S, A, B, C](ra: State[S, A], rb: State[S, B])(f: (A, B) => C): State[S, C] = {
    //    flatMap(ra)(a => map(rb)(b => f(a, b)))
    for (a <- ra; b <- rb) yield f(a, b)
  }

  implicit class StateMonad[S, A](rand: State[S, A]) {
    def map[B](f: A => B) = state.map(rand)(f)

    def flatMap[B](f: A => State[S, B]) = state.flatMap(rand)(f)
  }

  def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] = {
    fs match {
      case head :: tail => map2(head, sequence(tail))(_ :: _)
      case Nil => unit(Nil)
    }
  }

  def get[S]: State[S, S] = s => (s, s)

  def set[S](s: S): State[S, Unit] = _ => ((), s)

  def modify[S](f: S => S): State[S, Unit] =
    for {
      s <- get[S]
      _ <- set[S](f(s))
    } yield ()

}
