package com.tutorials.scala.lightspeed.exceptionhandling

object OptionSomeNone extends App {
  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e: NumberFormatException => None
    }
  }

  val stockPrices = List("123.4", "a")
  val floatPrices = stockPrices.map(convertToFloat)

  for (optionPrice <- floatPrices) {
    optionPrice match {
      case Some(price) => println(price)
      case None => println("Skipping over None")
    }
  }
  
  println(floatPrices.map(_.getOrElse(0)))
}
