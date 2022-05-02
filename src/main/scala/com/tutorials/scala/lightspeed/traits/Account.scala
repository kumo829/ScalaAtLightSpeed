package com.tutorials.scala.lightspeed.traits

import java.time.LocalDateTime
import java.util.UUID

abstract class Account(uuid: UUID, name: String, dateOpened: LocalDateTime) { //primaty constructor
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

class CreditAccount(name: String) extends Account(name: String) {
  override val _accountType = "Credit"

  override def toString: String = s"${super.toString}, ${_accountType}"
}

class DepositsAccount(name: String) extends Account(name: String) {
  override val _accountType = "Credit"
}

trait Balance {
  private var _balance: Double = 0

  def getBalance: Double = _balance

  def setBalance(balance: Double): Unit = _balance = balance

  override def toString: String = s"Balance=$getBalance"
}

trait AnnualFees extends Balance{
  override def setBalance(balance: Double): Unit = super.setBalance(balance - 100)
}

trait HighSavings extends Balance {
  override def setBalance(balance: Double): Unit = super.setBalance((balance + 500) * (1 + 0.50))
}

class PremiumSavingAccount(name: String) extends DepositsAccount(name) with AnnualFees

class PremiumPromotionalSavingAccount(name: String) extends DepositsAccount(name) with AnnualFees with HighSavings //stackable modifications


object AccountRunner extends App {
  val a1 = new PremiumSavingAccount("Premium 01")
  a1.setBalance(999)

  println(a1.getBalance)

  val a2 = new PremiumPromotionalSavingAccount("Premium Promotional 01")
  a2.setBalance(999)

  println(a2.getBalance)
}