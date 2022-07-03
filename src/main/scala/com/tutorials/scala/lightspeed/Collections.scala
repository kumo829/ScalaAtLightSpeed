package com.tutorials.scala.lightspeed

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Collections extends App {
  /*
  * List immutable collection
   */
  val list1: List[String] = List("A", "B", "C")

  println(list1)

  val list2: List[Any] = List("A", "B", 3)
  println(list2)

  println(list1.length)
  println(list1.head)
  println(list1.last)

  var list3: List[Int] = List.fill(5)(10)
  println(list3)


  list3 = list3 :+ 5 //Add an element at the end of the list
  println(list3)

  list3 = 6 +: list3
  println(list3) //Add an element at the beginning of the list


  //Add a list to another list
  val list4 = list1 :: list2
  println(list4)

  val list5 = list1 ::: list2
  println(list5)


  /*
   * ListBuffer - mutable collection
   */
  val lb1 = ListBuffer(8, 76, 7, 9)
  println(lb1)

  lb1 += 90
  println(lb1)

  lb1 -= 76 //or lb1.remove(1)
  println(lb1)

  lb1.remove(0, 2) //removes from position 0 to 2
  println(lb1)


  /*
   * Array - immutable collection with fix size
   */
  val array1: Array[String] = Array("A", "B", "C")
  for (x <- array1) {
    print(x)
  }

  println()

  val array2: Array[Int] = new Array(5) //initialize an array of 5 elements
  array2(3) = 5
  array2.foreach(print(_))
  println()

  val array3 = (1 to 10).toArray[Int]
  array3.foreach(print(_))


  /*
  * ArrayBuffer - mutable collection with variable size
   */
  val arrBuff1 = ArrayBuffer(9, 10, 11)
  println(arrBuff1)

  arrBuff1 += 100
  println(arrBuff1)

  arrBuff1(1) = 99
  println(arrBuff1)

  arrBuff1 ++= List(1000, 1001, 1002)
  println(arrBuff1)

  arrBuff1 -= 9
  println(arrBuff1)


  /*
  Map
   */
  val map1 = Map((1, "One"), (2, "Two"), (3, "Three"))
  println(map1)

  var map2 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
  println(map2)

  println(map1(2))
  //  println(map1(4)) //Throws a NoSuchElementException
  map2 += (4 -> "Four")
  println(map2)


  case class Contact(name: String)

  val addressBook: List[Contact] = List(Contact("Alice"), Contact("Bob"))

  val secondContactName = addressBook match {
    case first :: second :: Nil => second.name //match a list with exactly two contacts
    case first :: second :: tail => first.name //match a list with more than two contacts
    case Nil => "Empty List"
    case _ => "List with one element" // match an empty list, a list with one contact
  }

  println(secondContactName)



  //Transforming collections

  /*  foldLeft
  * The first parameter is an accumulator (the value we've computed over the portion of the list we've seen so far)
  * the second argument, the function, is how we combine the accumulator with the current element to create a new accumulator
   */
  val sum = List(1, 2, 3).foldLeft(0)((accum, elem) => {
    accum + elem
  })
  println(sum)


  /* groupBy
   */
  val emails = List("alice@gmail.com", "bob@gmail.com", "carol@hotmail.com")
  val domain: String => String = (_: String).dropWhile(c => c != '@').drop(1)

  val emailsByDomain = emails.groupBy(domain)
  println(emailsByDomain)
}
