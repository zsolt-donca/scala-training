
val x = new StringBuilder("Hello")

val y = x.append(", World")

val r1 = y.toString

val r2 = y.toString

// r1 == r2

// TODO inline y

// TODO Change StringBuilder to String

// Referential Transparency: easier reasoning
//
// No need to track all the state changes that may occur before or
// after our function’s execution to understand what our function
// will do; we simply look at the function’s definition and substitute
// the arguments into its body.