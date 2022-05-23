package com.tutorials.scala.lightspeed

object Loops extends App{
  val amounts = Array(10, 24, 35, 23, 12)
  val currencies = Array("JPY", "CAD")


  //Simple for loop with one generator
  for(amount <- amounts) {
    println(s"amount $amount")
  }


  //for loop with range inclusive (to)
  for(z <- 1 to 10) {
    println(s"inclusive ${z}") // prints numbers 1 to 10
  }

  //for loop with range exclusive (until)
  for(z <- 1 until  10) {
    println(s"until ${z}") //prints numbers 1 to 9
  }

  //for loop with range using steps
  for(z <- 1 to 20 by 4) {
    println(s"by ${z}")
  }

  //for loop with conditions
  for(z <- 1 to 10 if z%2 == 0) {
    println(s"if ${z}")
  }


  // for as an expression
  val result: Array[Int] = for(amount <- amounts) yield {  //curly braces are optional
    amount + 1
  }

  println(result.mkString("Array(", ", ", ")"))
  result.foreach(value => println(value))


  //simple for loop with multiple generators
  for{amount   <- amounts
      currency <- currencies} {
    println(s"amount: $amount, currency: $currency")
  }

  //for loop with multiple generators as an expression
  var currencyResult: Array[String] = for{
    amount   <- amounts
    currency <- currencies
  } yield {
    amount  + " " + currency
  }

  currencyResult.foreach(value => println(value))


  currencyResult = for{
    amount   <- amounts
    currency <- currencies
    if amount > 20 && amount < 30 //guard or filter
  } yield {
    amount  + " " + currency
  }

  currencyResult.foreach(value => println(value))
}
