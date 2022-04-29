# Scala Learning Path
This project will be my repository/diary to write the elements of the Scala programming language


## Features
- Scala is a Blended Language. It combines elements from an **Object Oriented** and **Functional** languages.
- It has a Strong Type System.
```scala
    val number: Int = "One"  //Wrong
    val number: Int = 1// OK
```
- Functional over imperative Style of Programming
```java
//Java, Imperative
public static int getNumber(int a, int b){
  int number;
  
  if(a < b) {
    number = 10;
  } else {
    number = 5;
  }
}
```

```scala
//Scala, Functional
def getNumber(a: Int, b: Int): Int ={
  val number = if (a < b) 10 else 5
  number
}
```
- Enables multiple inheritance using *Traits*.
- Better concurrency support.
- Less verbosity, higher developer productivity.

```java
class Person {
    private String first;
    private String last;
    private int age;
    
    //Constructor
    
    //Getters & Setters
}
```

```scala
case class Person(first: String, last: String, age: Int)
```

## Advantages 
- A blend of **Object Oriented** and **Functional** paradigm
- A concise and expressive language
- Interoperable with Java
- A strongly typed language

## Disadvantages
- A High Learning Curve
- Takes a long time to compile

## Scala Type Hierarchy

![Scala types](https://docs.scala-lang.org/resources/images/tour/unified-types-diagram.svg)

`Any` is the supertype of all types, also called the **top type**. It defines certain universal methods such as `equals`, `hashCode`, and `toString`. Any has two direct subclasses: `AnyVal` and `AnyRef`.

`AnyVal` represents value types. There are nine predefined value types and they are non-nullable: 
- `Double`
- `Float`
- `Long` 
- `Int` 
- `Short`
- `Byte`
- `Char`
- `Unit`
- `Boolean` 

`Unit` is a value type which carries no meaningful information. There is exactly one instance of `Unit` which can be declared literally like so: `()`. **All functions must return something** so sometimes `Unit` is a useful return type.

`AnyRef` represents reference types. All non-value types are defined as reference types. Every user-defined type in Scala is a subtype of `AnyRef`. If Scala is used in the context of a Java runtime environment, `AnyRef` corresponds to `java.lang.Object`.

### Type Casting

Value types can be cast in the following way:

![Scala Type Hierarchy](https://docs.scala-lang.org/resources/images/tour/type-casting-diagram.svg)

```scala
val x: Long = 987654321
val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)

val face: Char = '☺'
val number: Int = face  // 9786
```

Casting is unidirectional. This will not compile:

```scala
val x: Long = 987654321
val y: Float = x  // 9.8765434E8
val z: Long = y  // Does not conform
```

### Nothing and Null

`Nothing` is a subtype of all types, also called the **bottom type**. There is no value that has type `Nothing`. A common use is to signal non-termination such as a thrown exception, program exit, or an infinite loop (i.e., it is the type of an expression which does not evaluate to a value, or a method that does not return normally).

`Null` is a subtype of all reference types (i.e. any subtype of `AnyRef`). It has a single value identified by the keyword literal `null`. `Null` is provided mostly for interoperability with other JVM languages and should almost never be used in Scala code.

## Examples
- [Types](./src/main/scala/com/tutorials/scala/lightspeed/Types.scala)
- [Basics](./src/main/scala/com/tutorials/scala/lightspeed/Basics.scala)
- [Loops](./src/main/scala/com/tutorials/scala/lightspeed/Loops.scala)
- [Pattern Matching](./src/main/scala/com/tutorials/scala/lightspeed/PatternMatching.scala)
- [Object Orientation](./src/main/scala/com/tutorials/scala/lightspeed/ObjectOrientation.scala)
- [Functional Programming](./src/main/scala/com/tutorials/scala/lightspeed/FunctionalProgramming.scala)
- [Implicit Conversion](./src/main/scala/com/tutorials/scala/lightspeed/ImplicitConversion.scala)
- [Xml](./src/main/scala/com/tutorials/scala/lightspeed/XmlApp.scala)

### Package and running a CLI
```
scalac com/tutorials/scala/lightspeed/Hello.scala -d main.jar -Xmain-class com.tutorials.scala.lightspeed.Hello

scala -cp main.jar com.tutorials.scala.lightspeed.Hello 
```

### Sources:
- [Scala Language: The big Picture](https://app.pluralsight.com/course-player?clipId=418d779b-b660-43fa-bd37-c4db682c4ec4)
- [Scala at LightSpeed](https://www.udemy.com/course/fast-scala/learn/lecture/27123394#overview)