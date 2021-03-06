package com.tutorials.scala.lightspeed.caseclasses

import java.time.LocalDateTime

sealed trait Kind
case object Debit extends Kind
case object Credit extends Kind
case object Refund extends Kind

case class Transaction(name: String, amount: Double, kind: Kind, when: LocalDateTime)

object TransactionRunner extends App{

  val when = LocalDateTime.now()

  val t1 = Transaction("T1", 1.2, Debit, when)
  val t2 = Transaction("T1", 1.2, Credit, when)

  println(t1)
  println(t1 == t2)
  println(t1.hashCode())

  val t3 = t1.copy(name = "T3")
  println(t3)

  val amount = t3 match {
    case  Transaction(_, amount, kind, _) if kind == Debit => amount - 20
    case t: Transaction => t.amount
  }

  println(amount)



  sealed trait Shape

  case class Rectangle(width: Int) extends Shape
  case class Circle(radius: Int) extends Shape

  val someShape: Shape = Rectangle(5)

  val someShapeArea = someShape match {
    case Rectangle(width) => width * width
    case Circle(radius) => radius * radius * 3.14
  }

  println(someShapeArea)
}
