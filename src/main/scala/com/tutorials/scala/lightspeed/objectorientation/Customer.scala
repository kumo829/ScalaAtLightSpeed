package com.tutorials.scala.lightspeed.objectorientation

import java.util.UUID

final class Customer (first: String, last: String, email: String){
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

  def getId: UUID = _id
  def getFirst: String = _first
  def getLast: String = _last
  def getEmail: String = _email
}
