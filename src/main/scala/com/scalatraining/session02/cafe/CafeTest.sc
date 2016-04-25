import com.scalatraining.session02.cafe.{Cafe, CreditCard}

val cc1 = new CreditCard("1234-4567-8901-2345")

val (coffee, charge1) = Cafe.buyCoffee(cc1)

val (coffees, charge2) = Cafe.buyCoffees(cc1, 12)

val cc2 = new CreditCard("0000-1111-2222-3333")

val (coffees2, charge3) = Cafe.buyCoffees(cc2, 4)

Cafe.coalesce(List(charge1, charge2, charge3))