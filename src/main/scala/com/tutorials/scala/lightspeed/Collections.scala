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
  val arrBuff1 = ArrayBuffer(9,10,11)
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
}
