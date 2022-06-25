package com.tutorials.scala.lightspeed

object FunctionalProgramming extends App {
  def square(n: Int): Int = n * n //Int => Int

  def cube(n: Int): Int = n * n * n //Int => Int

  def sum(a: Int, b: Int): Int = a + b // (Int, Int) => Int

  def length(a: String): Int = a.length // String => Int

  def transform(f: Int => Int, numbers: Int*) = numbers.map(f)

  println(transform(square, 1, 2, 3, 4))
  println(transform(cube, 1, 2, 3, 4))
  println(transform((n: Int) => n * n, 1, 2, 3, 4))
  println(transform(n => n * n, 1, 2, 3, 4))


  val numbers = Array(1, 2, 3, 4, 5, 6, 7)
  println(numbers.filter(n => n % 2 == 0).mkString("Array(", ", ", ")"))
  println(numbers.filter(n => n % 2 == 1).mkString("Array(", ", ", ")"))

  class Person(name: String) {
    def apply(age: Int) = println(s"I aged $age years old")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Invoking bob as a function === bob.apply(43)

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  println(simpleIncrementer.apply(23))
  println(simpleIncrementer(23))

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + " " + arg2
  }

  println(stringConcatenator("Hello", "World"))

  //syntax sugar
  val stringConcatenator2: Function2[String, String, String] = (arg1: String, arg2: String) => arg1 + " " + arg2
  val stringConcatenator3: (String, String) => String = (arg1: String, arg2: String) => arg1 + " " + arg2
  val stringConcatenator4 = (arg1: String, arg2: String) => arg1 + " " + arg2

  println(stringConcatenator2("Hello", "World"))
  println(stringConcatenator3("Hello", "World"))
  println(stringConcatenator4("Hello", "World"))

  //high-order function: takes functions as args/return functions as result
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1)
  println(aMappedList)

  val aFilteredList1: List[Int] = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  val aFilteredList2: List[Int] = List(1, 2, 3, 4, 5).filter(_ <= 3)
  println(aFilteredList1)
  println(aFilteredList2)


  //all pairs between the numbers 1,2,3 and the letters 'a', 'b', and 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

  var alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"

  println(allPairs)
  println(alternativePairs)


  // function as argument
  def ejemplo2(cifra1: Int, f: (Int) => Int): Int = {
    f(cifra1)
  }
  // the second parameter is a function equivalent to  (x:Int) => x * 20
  println(ejemplo2(10, _ * 20))

  //  val funcion:Int => Int = (x:Int) => x * 20
  val funcion = (x: Int) => x * 20

  println(ejemplo2(10, funcion))



  //Currying functions
  def sum_normal(x:Int, y:Int): Int = x + y
  def sum_currying(x:Int) = (y: Int) => x + y
  def sum_currying_scala (x: Int)(y: Int) = x + y

  println(sum_normal(10, 20))
  println(sum_currying(10)(20))

  var part = sum_currying(10)
  println(part(20))

  var part2 = sum_currying_scala(10)_ //the underscore is required in this case
  println(part2(20))
}
