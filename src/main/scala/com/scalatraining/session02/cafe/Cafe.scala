package com.scalatraining.session02.cafe


case class CreditCard(number: String)

class Coffee {
  val price: Int = 7

  override def toString = s"Coffee"
}

case class Charge(cc: CreditCard, amount: Int) {

  def combine(other: Charge): Charge = {
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
  }

}

object Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }

  def coalesce(charges: List[Charge]): List[Charge] = charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList

}
