package com.tutorials.scala.lightspeed.exceptionhandling

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

object TryCatchFinally extends App {

  try {
    val sourcePath = Source.fromFile("")

    val lines = sourcePath.getLines.toList
  } catch {
    case ex: FileNotFoundException => {
      println("File not found")
    }

    case ex: IOException => {
      println("IO Exception")
    }
  } finally {
    println("Everything finises now")
  }
}
