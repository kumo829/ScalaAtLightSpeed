package com.tutorials.scala.lightspeed

object PatternMatching extends App {
  //literal matching
  var amount =  51

  amount match {
    case 50 => println("value is 50")
    case 100 => println("valur is 100")
    case _ => println("Another value")
  }


  // variable matching
  amount match {
    case a => println(s"The amount is $a" )
  }

  //conditional matching
  amount match {
    case a if a == 100 => println("The amount is 100")
    case a if a >= 50 => println("The amount is >= 50, it's " + a)
    case a => println(s"The amount is $a" )
  }

  //pattern matching as expression
  val result: String = amount match {
    case a if a == 100 => "The amount is 100"
    case a if a >= 50 => ("The amount is >= 50, it's " + a)
    case a => (s"The amount is $a" )
  }

  println(s"The result is: $result")


  //type matching
  abstract class Currency
  case class CAD() extends Currency
  case class JPY() extends Currency
  case class MXN() extends Currency

  var currency: Currency = CAD()

  currency match {
    case c: CAD => println(s"CAD $amount")
    case j: JPY => println(s"CAD $amount")
    case m: MXN => println(s"CAD $amount")
  }

  //extracting data
  val anArray = Array(100, 200, 300)

  anArray match {
    case Array(first, second, third) => println("second= " + second)
  }

  anArray match {
    case Array(_, second, _) => println("second= " + second)
  }
}
