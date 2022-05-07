package com.tutorials.scala.lightspeed.functions

object FunctionalLiteralsAndPlaceholders extends App{
  var multiplyBy = (x: Int) => x * 100 //function literal

  println(multiplyBy(5))
  println(multiplyBy(10))

//  multiplyBy = (x: String) => x.toUpperCase //Illegal reasignment
  multiplyBy = (x: Int) => x * 100 //Legal reasignment

  println(multiplyBy(5))
  println(multiplyBy(10))

  var calculateResult = (x: Int, y: Int) => { //function expression block
    val sum = x + y
    val diff = x - y
    val product = x * y
    val quotient = x / y

    (sum, diff, product, quotient)
  }

  println("----- 10 and 5")
  println(calculateResult(10, 5))

  println("----- 40 and 8")
  println(calculateResult(40, 8))

  val googleStockPrices = List(126.48, 8468.48, 4468.4, 9647.5, 5684.5)

//  googleStockPrices.foreach((price: Double) => println(price))
//  googleStockPrices.foreach(price => println(price))
  googleStockPrices.foreach(println)

//  println(googleStockPrices.filter( price => price > 5000))
  println(googleStockPrices.filter( _ > 5000)) //placeholder

  val stockTickersInLowerCase = List("googl", "ps", "tesla", "aapl", "msft")

  println(stockTickersInLowerCase.map(_.toUpperCase))


  val sayHello = () => println("Hello function literal")
  val multiplyBy100 = (x: Int) => x * 100
  val addTwoNumbers = (x: Int, y: Int) => x + y
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z

  println("sayHello.isInstanceOf[Function0[_]]: " + sayHello.isInstanceOf[Function0[_]])
  println("multiplyBy100.isInstanceOf[Function1[_,_]]: " + multiplyBy100.isInstanceOf[Function1[_,_]])
  println("addTwoNumbers.isInstanceOf[Function2[_,_,_]]: " + addTwoNumbers.isInstanceOf[Function2[_,_,_]])
  println("addThreeNumbers.isInstanceOf[Function3[_,_,_,_]]: " + addTwoNumbers.isInstanceOf[Function3[_,_,_,_]])

}
