package com.tutorials.scala.lightspeed.functions

object PartialFunctions extends App{


  /*
  Is equivalent to (x: Int) => x match {
    case 1 => 100
    case 2 => 300
    case 5 => 500
  }

  Partial functions are based on pattern matching, and can only have one parameter type (Int in this example)
   */
  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 100
    case 2 => 300
    case 5 => 500
  }

  println(aPartialFunction(2))
//  println(aPartialFunction(10)) //throws a MatchError

  //Partial Function Utilities
  println(aPartialFunction.isDefinedAt(65)) //will let us know if the functions is applicable for that argument
  println(aPartialFunction.isDefinedAt(5))

  //lift - lift PF to total functions returning an Option
  val lifted = aPartialFunction.lift
  println(lifted(5)) // returns Some(500)
  println(lifted(100)) //returns None


  //orOlse allows to chain partial functions
  val pfChain = aPartialFunction.orElse[Int, Int]{
    case 3 => 300
  }

  println(pfChain(5))
  println(pfChain(3))

  //High Order Functions accept partial functions as well
  val aMappedList = List(1, 2, 3).map{
    case 1 => 100
    case 2 => 200
    case 3 => 300
  }

  println(aMappedList)
}
