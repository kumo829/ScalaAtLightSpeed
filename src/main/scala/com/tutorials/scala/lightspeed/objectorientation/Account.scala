package com.tutorials.scala.lightspeed.objectorientation

import java.time.LocalDateTime
import java.util.UUID

abstract class Account (uuid: UUID, name: String, dateOpened: LocalDateTime){ //primaty constructor
  private val _id = uuid
  private var _name = name
  private val _dateOpened = dateOpened
  val _accountType: String

  def this(name: String) { //Auxiliary Constructor
    this(UUID.randomUUID(), name, LocalDateTime.now())
  }

  def getId: UUID = _id
  def getName: String = _name
  def getDateOpened: LocalDateTime = _dateOpened
  def getAccountType: String = _accountType
  def updateName(newName: String): Unit = _name = newName

  override def toString: String = s"Account id=${_id}, name=${_name}, dateOpened=${_dateOpened}"
}

class CreditAccount(name: String) extends Account(name: String){
   override val _accountType = "Credit"

  override def toString: String = s"${super.toString}, ${_accountType}"
}

class DepositsAccount(name: String) extends Account(name: String){
  override val _accountType = "Credit"
}

object AccountRunner extends App{
//  val a1 = new Account(UUID.randomUUID(), "Account 1", LocalDateTime.now())
//  val a2 = new Account(UUID.randomUUID(), "Account 2", LocalDateTime.now().plusDays(6))
//  val a3 = new Account("Account 3")

//  println(a1.getId, a1.getName, a1.getDateOpened)
//  println(a2.getId, a2.getName, a2.getDateOpened)
//  println(a3.getId, a3.getName, a3.getDateOpened)

  val a4:Account = new CreditAccount("Credit 01")
  val a5:Account = new DepositsAccount("Deposit 01")

  println(a4)
  println(a5)
}