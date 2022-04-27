package com.tutorials.scala.lightspeed

import scala.xml.{Elem, NodeSeq}

object XmlApp extends App{
  val person: Elem = <person>
    <firstName>John</firstName>
    <emails>
      <email type="primary">john.doe@noone.com</email>
      <email type="secondary">john.doe@noone.com</email>
    </emails>
  </person>


  val name: NodeSeq = person \ "firstName"
  println(name)

  val emails: NodeSeq = person \\ "email"
  println(emails)

  emails.map(e => println(e))

  val types: NodeSeq = person \\ "@type"
  println(types)
}
