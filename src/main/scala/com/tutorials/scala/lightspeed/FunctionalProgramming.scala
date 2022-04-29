package com.tutorials.scala.lightspeed

object FunctionalProgramming extends App {
  def square(n: Int) : Int = n * n //Int => Int
  def cube(n: Int): Int = n * n * n //Int => Int
  def sum(a: Int, b: Int): Int = a  + b // (Int, Int) => Int
  def length(a: String): Int = a.length // String => Int

  def transform(f: Int => Int, numbers: Int*) = numbers.map(f)

  println(transform(square, 1, 2, 3, 4))
  println(transform(cube, 1, 2, 3, 4))
  println(transform( (n: Int) => n * n, 1, 2, 3, 4))
  println(transform( n => n * n, 1, 2, 3, 4))


  val numbers = Array(1, 2, 3, 4, 5, 6, 7)
  println(numbers.filter(n => n % 2 == 0).mkString("Array(", ", ", ")"))
  println(numbers.filter(n => n % 2 == 1).mkString("Array(", ", ", ")"))
}
