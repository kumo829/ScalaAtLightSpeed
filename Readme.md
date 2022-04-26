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

### Sources:
- [Scala Language: The big Picture](https://app.pluralsight.com/course-player?clipId=418d779b-b660-43fa-bd37-c4db682c4ec4)
- [Scala at LightSpeed](https://www.udemy.com/course/fast-scala/learn/lecture/27123394#overview)