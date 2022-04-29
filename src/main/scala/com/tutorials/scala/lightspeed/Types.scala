package com.tutorials.scala.lightspeed

object Types extends App {

  //Numeric types
  val anInt = 5
  val aDouble = 3.2
  val aFloat = 4.5f
  val aLong = 199L
  val aChar = 'c'
  val aShort = 120
  val aByte = 1
  val aBoolean = true

  val five: Int = 5
  val anotherFive: AnyVal = five
  println(anotherFive)

  //Non-numeric
  val aUnit : Unit = ()
  println(aUnit)

  //Arrays
  val arr: Array[Int] = Array(1,2)
  println(arr(1))

  var aTouple = ("CAD", 100)
  println(aTouple._1)
  println(aTouple._2)

  //Null
  val aNull: Null = null
  println(aNull)


}
