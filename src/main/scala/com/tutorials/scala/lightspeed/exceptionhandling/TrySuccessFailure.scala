package com.tutorials.scala.lightspeed.exceptionhandling

import java.io.{BufferedReader, FileReader}
import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try, Using}

object TrySuccessFailure extends App {

  def getLinesFromFile(filename: String): Try[BufferedSource] = {
    Try(Source.fromFile(filename))
  }

  println("Part 1")
  val trySourcePath: Try[BufferedSource] = getLinesFromFile("")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines.toList
    case Failure(exception) => println(exception.getMessage)
  }


  // this idiom is using by other Scala classes like Utility, which performs automatic resource management; after the
  // operation is complete it releases resources in reverse order of creation

  println("Part 2")
  val lines: Try[List[String]] = Using(new BufferedReader(new FileReader(""))){
    reader => Iterator.continually(reader.readLine()).takeWhile( _ != null).toList
  }

  lines match {
    case Success(lines) => lines.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }
}
