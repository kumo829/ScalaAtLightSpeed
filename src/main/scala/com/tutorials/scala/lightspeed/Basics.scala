package com.tutorials.scala.lightspeed

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42

  println(s"Meaning of life $meaningOfLife") //Interpolated String

  val aBoolean = false //the type is optional

  //Int, Boolean, Char, Double, Float, and String are the standard types
  println(s"boolean value is $aBoolean")


  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3
  println(s"The value of the expression = $anExpression")

  //if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  println(s"IF-expression: $ifExpression")

  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else 0

  println(s"Chained if expression $chainedIfExpression")


  //Code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    //value of block is the value of last expression
    aLocalValue + 3
  }

  println(s"Code Block $aCodeBlock")

  //define a function
  def myFunction(x: Int, y: String): String =
    x + " " + y

  val myValue = myFunction(1, "Hello")
  println(s"My function $myValue")


  //function with varargs
  def multply(numbers: Int*) : Int = {
    var product = 1
    for (num <- numbers) product = product * num
    product
  }

  println(multply(10, 20, 30, 40, 50))

// Local functions
  def sumOdd(n: Int): Int = {
    def getOdd(x: Int): Array[Int] = {
      var result = Array[Int]()

      var current = 1

      while(current <= x) {
        if(current % 2 == 1) result = result :+ current
        current = current + 1
      }
      result
    }

    val odds = getOdd(n)
    println(odds.mkString(","))
    odds.sum
  }

  println(sumOdd(10))


  //named arguments
  def greet(first: String, last: String): Unit = {
    println(s"Hello! $first, $last")
  }

  greet("Tony", "Stark")
  greet("Stark", "Tony")
  greet(last = "Stark", first = "Tony")


  //default values
  def logTransaction(amount: Double, debit: Boolean = true, currency: String = "CAD") : Unit = {
    val symbol = if(debit) "-" else "+"

    println(symbol + currency + amount)
  }

  logTransaction(100.25)
  logTransaction(82.67)
  logTransaction(1.84)
  logTransaction(1.84, currency = "JPY")


  //initialize variable with default value

  var aStringWithDefaultValue:String = _
  var aIntWithDefaultValue:Int = _

  println(aStringWithDefaultValue)
  println(aIntWithDefaultValue)
}
