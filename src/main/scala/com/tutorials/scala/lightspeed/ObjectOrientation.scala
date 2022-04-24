package com.tutorials.scala.lightspeed

object ObjectOrientation extends App {

  //define a class
  class Animal {
    val age: Int = 0 //by default is public. Can restrict by private or protected

    def eat(): Unit =
      println("I'm eating")
  }

  //creating a new instance
  val animal1: Animal = new Animal
  val animal2 = new Animal

  //Inheritance
  class Dog(val name: String) extends Animal //Constructor definition. Constructor arguments are NOT fields: Need to put 'val' before the constructor argument

  val myDog = new Dog("Lassie")

  println(myDog.eat())
  println(myDog.age)
  println(myDog.name)

  //Abstract class
  abstract class WalkingAnimal {
    protected val hasLegs = true

    def walk():Unit
  }

  //"interface"
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  //single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore{
    override def eat(animal: Animal): Unit = println("I'm eating you")
  }

  val crock = new Crocodile

  crock.eat(myDog)
  crock eat myDog //infix notation = object method argument. Only for methods with ONE argument

  //operators in Scala are methods
  val basicMath =  1 + 2
  val anotherBasicMath = 1.+(2)

  println(basicMath)
  println(anotherBasicMath)

}
