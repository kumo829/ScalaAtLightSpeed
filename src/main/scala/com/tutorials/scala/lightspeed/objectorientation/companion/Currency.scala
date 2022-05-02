package com.tutorials.scala.lightspeed.objectorientation.companion

object Currency {
  private val conversionTable: Map[String, Double] = Map("CAD" -> 1, "MXN" -> 0.063075, "JPY" -> 0.009904)

  def apply(code: String, amount: Double) = new Currency(code, amount, getCostInCad(code, amount))

  def createCAD(amount: Double): Currency = Currency("CAD", amount)

  def createMXN(amount: Double): Currency = Currency("MXN", amount)

  def createJPY(amount: Double): Currency = Currency("JPY", amount)

  private def getCostInCad(code: String, amount: Double): Double = {
    code match {
      case "CAD" => amount
      case "MXN" => amount * conversionTable("MXN")
      case "JPY" => amount * conversionTable("JPY")
      case _ => throw new IllegalArgumentException(s"No conversion available for $code")
    }
  }

  implicit def stringToCurrency(value: String): Currency = {
    val Array(code: String, amount: String) = value.split("\\s")
    Currency(code, amount.toDouble)
  }
}

class Currency(code: String, amount: Double, inCAD: Double) {
  private val _code = code
  private val _amount = amount
  private val _inCAD: Double = inCAD

  override def toString: String = s"${_code} ${_amount} = CAD ${_inCAD}"
}


object CurrencyRunner extends App {
  val cad1 = Currency(code = "CAD", amount = 100.02)
  println(cad1)

  val mxn1 = Currency(code = "MXN", amount = 100.02)
  println(mxn1)

  val jpy1 = Currency(code = "JPY", amount = 100.02)
  println(jpy1)

  import Currency._

  val cad2 = createCAD(25)
  val mxn2 = createMXN(25)
  val jpy2 = createJPY(25)

  println(cad2)
  println(mxn2)
  println(jpy2)

  import Currency.stringToCurrency

  val cad3: Currency = "CAD 125"
  val mxn3: Currency = "MXN 125"
  val jpy3: Currency = "JPY 125"

  println(cad3)
  println(mxn3)
  println(jpy3)
}
