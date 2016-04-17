
class Complex(real: Double, imaginary: Double) {

  // auxiliary constructor
  def this(real: Double) = this(real, 0)

  def re() = real
  def im() = imaginary

  override def toString = {
    s"$real + ${imaginary}i"
  }
}

val x = new Complex(1, 2)
val y = new Complex(3, -4)
val z = new Complex(5)

x.re()
x.im()

// TODO parentheses in class

// TODO constructor vals

// TODO def/val for all members

// TODO companion object (zero, one, i)

// TODO exercise:
//   - better toString (when imag is negative, or zero)
//   - define + - *
//   - conjugate = re - im * i
//   - modulus = sqrt(re^2 + im^2)
