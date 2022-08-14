package com.tutorials.scala.lightspeed.implicits

object ImplicitClass extends App {
  sealed trait Currency

  object Currency {
    case object CAD extends Currency
    case object JPY extends Currency
    case object MXN extends Currency

    type CAD = CAD.type
    type JPY = JPY.type
    type MXN = MXN.type
  }

  case class Amount[T <: Currency](value: Double, currency: T)

  implicit class AmountExt[T <: Currency](amt: Amount[T]) {
    def + (that: Amount[T]): Amount[T] = amt.copy(value = amt.value + that.value)
  }

  implicit class AmountDouble(d: Double) {
    import Currency._
    def cad: Amount[CAD] = Amount(d, CAD)
  }

  import scala.language.postfixOps // required to use the postfix syntax in 1 cad

  val oneCad = 1 cad
  val tenCad = 10 cad

  val result = oneCad + tenCad

  println(result)
}
