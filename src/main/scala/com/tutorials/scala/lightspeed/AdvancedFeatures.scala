package com.tutorials.scala.lightspeed

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object AdvancedFeatures extends App {
  //lazy evaluation

  lazy val aLazyValue = 2

  val lazyValueWithSideEffect = {
    println("I'm a very lazy value")
    43
  }

  println("I'm just a random text")
  println(s"lazy value $lazyValueWithSideEffect")


  //pseudo collections: Options, Try

  def methodWhichCanReturnNull(): String = "hello, Scala"

  val anOption = Option(methodWhichCanReturnNull()) //Some("Hello, Scala") or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  println(stringProcessing)

  def methodWhichCanThrowAnException(): String = throw new RuntimeException("Ooops!!")

  // Old boring Java like way to handle exceptions
  //  try {
  //    methodWhichCanThrowAnException()
  //  } catch {
  //    case e: RuntimeException => "I catch a RuntimeException"
  //    case ex: Exception => "Defend against this evil exception"
  //  }

  val aTry = Try(methodWhichCanThrowAnException())
  val anotherProcessingString = aTry match {
    case Success(validValue) => s"I have obtainded a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception $ex"
  }

  println(anotherProcessingString)

  //asynchronous programming
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }

  aFuture onComplete {
    case Success(value) => println(s"I found the value: $value")
    case Failure(ex) => println(s"I found a problem $ex")
  }

  Thread.sleep(2000)

  /**
   * Implicit basics
   */

  // #1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitVal = 42

  println(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(myImplicitVal)

  //#2: implicit conversions
  implicit class MyRichInteger(n: Int){
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) //new MyRichInteger(23)
  println(24.isEven())
}
