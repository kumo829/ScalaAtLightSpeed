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
- [Collections](./src/main/scala/com/tutorials/scala/lightspeed/Collections.scala)
- [Functional Programming](./src/main/scala/com/tutorials/scala/lightspeed/FunctionalProgramming.scala)
- [Implicit Conversion](./src/main/scala/com/tutorials/scala/lightspeed/ImplicitConversion.scala)
- [Xml](./src/main/scala/com/tutorials/scala/lightspeed/XmlApp.scala)
- [Advanced Features](./src/main/scala/com/tutorials/scala/lightspeed/AdvancedFeatures.scala)

**Note**: There are more examples on the internal packages. 

### Package and running a CLI
```shell script
scalac com/tutorials/scala/lightspeed/Hello.scala -d main.jar -Xmain-class com.tutorials.scala.lightspeed.Hello

scala -cp main.jar com.tutorials.scala.lightspeed.Hello 
```

## Scala Build Tool (sbt)
A built tool provide us with a system were we can automate out process to compile the source files (standalone or from one or more sources); help us manage dependencies of our project; help us with automating the process of testing the project sources; and provided us a way to package and deploy our project.

**sbt** is one of the popular chooses in the Scala ecosystem. It was launched is 2008 with the name of *Simple Build Tool*. It is used for scala and Java projects. It is used by popular frameworks like Akka, PlayFramework, Slick, and more.

### Features
- Zero or minimal configuration
- Extensive support for testing with frameworks like *ScalaTest*, *ScalaCheck*, *Spec* and *JUnit*
- Incremental compilation
- Support for multi-projects
- Parallel Task Execution
- Library Management Support using inline declarations, IVY or Maven configurations

### Useful Commands

```shell script
sbtVersion 
```

```shell script
scalaVersion 
```

```shell script
help 
help <command name>
```

```shell script 
run 
```

To run multiple commands add a semicolon before each command:
```shell script
;clean ;compile
```

Display the history commands:
```shell script
!
```

Enter into the scala console:
```shell script
console
```

Reloads the project in the current directory:
```shell script
reload
```
Shows how many projects are contained in the build definition file:
```shell script
projects
```

### Custom Settings
To create a new setting key, in the `build.sbt` file:

```
lazy val background = settingKey[String]("My background as a programmer")
background := "Java programmer"
```
To use the setting:
```shell script
help background
background
inspect background
```

A setting that depends on another setting:
```shell script
lazy val status = settingKey[String]("What was your previous job?")
status := {
  val e = background.value
  s"I was a $e"
}
```
### Custom Task

To create a new task, in the `build.sbt` file

```
val randomInt = taskKey[Int]("Give me a random number")
randomInt := scala.util.Random.nextInt
```
to execute the task:
```shell script
show randomInt
```

A task that uses a setting:
```
val randomInt = taskKey[Int]("Give me a random number")
randomInt := {
    println(background.value)
    scala.util.Random.nextInt
}
```

**A setting can not depend on a Task**.

### Multi-project configuration
In the `build.sbt` file:
```
lazy val subproject-1 = project
    .dependsOn(subproject-2)
    .settings(
        libraryDependencies += ("org.scalatest" %% "scalatest" % "3.0.5" % Test)
    )
    
lazy val subproject-2 = project
    .settings(
        libraryDependencies ++= Seq(
            "org.scalatest" %% "scalatest" % "3.0.5" % Test,
            "com.lihaoyi" %% "request" % "0..1.7"
        )
    )
```

or, using the `project` directory. In `Dependencies.scala`:
```scala
import sbt._

object Dependencies {

  val scalaRequests = "com.lihaoyi" %% "requests" % "0.1.7"
  val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.1.1"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

  val commonDependencies: Seq[ModuleID] = Seq(scalaTest % Test)

  val apiDependencies: Seq[ModuleID] = Seq(scalaRequests,
    scalaXml) ++ commonDependencies

  val calculatorDependencies: Seq[ModuleID] = commonDependencies
}
```

In `build.sbt`:
```
lazy val subproject-1 = project
  .dependsOn(subproject-2)
  .settings(
    libraryDependencies ++= Dependencies.calculatorDependencies
  )

lazy val subproject-2 = project
  .settings(
    libraryDependencies ++= Dependencies.apiDependencies
  )
```

## Useful design patterns
- Typeclass pattern
- Cake pattern for Dependency Injection
- Scala Implicits for Dependency Injection
- Optimizing Performance by Lazy Evaluation
- Overcoming Inmutability Limitation by Lens Pattern
- Memoization Pattern 

## Sources:
- [Scala Language: The big Picture](https://app.pluralsight.com/library/courses/scala-language-big-picture/table-of-contents)
- [Scala Language: Getting Started](https://app.pluralsight.com/library/courses/scala-language-getting-started/table-of-contents)
- [Scala Build Tool: Getting Started](https://app.pluralsight.com/library/courses/scala-build-tool-getting-started/table-of-contents)
- [Scala at LightSpeed](https://www.udemy.com/course/fast-scala/learn/lecture/27123394#overview)