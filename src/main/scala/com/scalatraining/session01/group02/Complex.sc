
class Complex(val re: Double, val im: Double) {

  // auxiliary constructor
  // constructor is defined as a method named 'this'
  // it must call another constructor
  def this(real: Double) = this(real, 0)

  // public methods (the default modifier is public)
  def +(that: Complex) = new Complex(re + that.re, im + that.im)

  override def toString = {
    im match {
      case 1 => s"$re + i"
      case 0 => s"$re"
      case -1 => s"$re - i"
      case value if value < 0 => s"$re - ${-value}i"
      case value if value > 0 => s"$re + ${im}i"
    }
  }
}

val x = new Complex(1, 2)
val y = new Complex(3, -4)

x + y

// 3.0 - 4.0i

x.re
x.im

// TODO companion object (zero, one, i)

// TODO exercise:
//   - better toString (when imag is negative, or zero)
//   - define + - *
//   - conjugate = re - im * i
//   - modulus = sqrt(re^2 + im^2)
