package com.tutorials.scala.lightspeed.traits

import java.util.UUID

class Customer(first: String, last: String, email: String) {
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

  def getId: UUID = _id

  def getFirst: String = _first

  def getLast: String = _last

  def getEmail: String = _email
}

trait Address {
  protected var _zip: Int
  protected var _street: String
  protected var _state: String

  def setZip(zip: Int): Unit

  def setStreet(street: String): Unit

  def setState(state: String): Unit

  def printAddress(): Unit = println(s"${_street} ${_state} ${_zip}")
}

trait SecretCodeGenerator {
  def getOTP: String = UUID.randomUUID().toString
}

class CustomerWitAddress(first: String, last: String, email: String) extends Customer(first: String, last: String, email: String)
  with Address with SecretCodeGenerator {
  override protected var _zip: Int = -1
  override protected var _street: String = ""
  override protected var _state: String = ""

  override def setZip(zip: Int): Unit = _zip = zip

  override def setStreet(street: String): Unit = _street = street

  override def setState(state: String): Unit = _state = state
}

class DepositBoxContainer extends SecretCodeGenerator{

}

object CustomerRunner extends App {
  val c1 = new CustomerWitAddress("Tony", "Stark", "tony@stark.com")
  c1.setZip(12345)
  c1.setState("California")
  c1.setStreet("45 Freemont St")

  c1.printAddress

  val s: SecretCodeGenerator = new DepositBoxContainer()

  println(c1.getOTP)
  println(s.getOTP)
}