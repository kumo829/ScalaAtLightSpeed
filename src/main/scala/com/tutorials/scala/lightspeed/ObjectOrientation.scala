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

  println(animal1 == animal1)
  println(animal1 == animal2)

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

  //singleton object
  object MySingleton { //the only instance of the MySingleton type
    val mySpecialValue = 53278

    def mySpecialMethod() : Int = 53278

    def apply(x: Int): Int = x + 1
  }

  println(MySingleton.mySpecialMethod())
  println(MySingleton.apply(10))
  println(MySingleton(10)) //equivalent to MySingleton.apply(10)


  object Animal { //companion object
    //companions can access each other's private fields/methods
    //Singleton Animal and instances of Animal class are different things
    val liveForever = false
  }
  println(Animal.liveForever) //call to static
  println(Animal.getClass.==(animal1.getClass))
  println(animal2.getClass.==(animal1.getClass))
  println(Animal.getClass)
  println(animal1.getClass)


  /* case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
  */
  case class Person(name: String, age: Int)

  //May be constructed without new
  val bob = Person("Bob", 10) //Person.apply("Bob", 54)

  println(bob)


  //exceptions
  try {
    //code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    //execute some code no matter what
  }


  //generics
  abstract class MyList[T]{
    def head: T
    def tail: MyList[T]
  }

  //using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) //List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("Hello", "Scala")
  val firstString = aStringList.head


//  Point #1: In Scala we usually operate with IMMUTABLE values/objects
//  any modification to an object must return ANOTHER object
  /*
  Benefits:
    - Works miracles in multithreading/dist environments
   */
  val reversedList = aList.reverse //returns a NEW List
}
