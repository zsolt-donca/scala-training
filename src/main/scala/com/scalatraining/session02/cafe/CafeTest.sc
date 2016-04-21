import com.scalatraining.session02.cafe.{Cafe, CreditCard}

val cc = new CreditCard("1234-4567-8901-2345")

val (coffee, charge1) = Cafe.buyCoffee(cc)

val (coffees, charge2) = Cafe.buyCoffees(cc, 12)
