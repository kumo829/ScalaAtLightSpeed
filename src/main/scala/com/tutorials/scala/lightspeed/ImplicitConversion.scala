package com.tutorials.scala.lightspeed

case class Currency(code: String, amount: Double, toCad: Double)

object ImplicitConversion extends App{

  //money "CAD 100
  implicit def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amountAsDouble = value.toDouble

    code match {
      case "CAD" => Currency("CAD", amountAsDouble, amountAsDouble)
      case "USD" => Currency("CAD", amountAsDouble, amountAsDouble * (1 / 1.5))
      case "JPY" => Currency("CAD", amountAsDouble, amountAsDouble * (1 / 1.30))
    }
  }

  //not implicit conversion
  println(stringToCurrency("USD 100"))
  println(stringToCurrency("JPY 100"))

  //Implicit conversion =)
  val cad: Currency = "CAD 100"
  println(cad)
}
