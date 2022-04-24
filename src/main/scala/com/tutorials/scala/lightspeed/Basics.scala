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
}
