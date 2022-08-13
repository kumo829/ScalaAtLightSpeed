package com.tutorials.scala.lightspeed.exceptionhandling

object EitherRightLeft extends App {
  def convertToFloat(someString: String): Either[String, Float] ={ //returns a String in case of error or Float in case of success
    try {
      Right(someString.toFloat)
    } catch {
      case e: NumberFormatException => Left("There was an error parsing: " + someString)
    }
  }

  val stockPrices = List("123.4", "a")

  println(stockPrices.map(convertToFloat))

  val floatPrices = stockPrices.map(convertToFloat)

  for(optionPrice <- floatPrices) {
    optionPrice match {
      case Right(price) => println(price)
      case Left(message) => println(message)
    }
  }
}
