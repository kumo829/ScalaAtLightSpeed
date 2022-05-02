ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaAtLightSpeed"
  )

lazy val background = settingKey[String]("My background as a programmer")
background := "Java programmer"

lazy val status = settingKey[String]("What was your previous job?")
status := {
  val e = background.value
  s"I was a $e"
}

val randomInt = taskKey[Int]("Give me a random number")
randomInt := {
  println(background.value)
  scala.util.Random.nextInt
}