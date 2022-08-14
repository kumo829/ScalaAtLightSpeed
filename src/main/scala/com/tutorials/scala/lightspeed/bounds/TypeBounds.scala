package com.tutorials.scala.lightspeed.bounds

import java.time.LocalDate

object TypeBounds extends App{
  class Employee(val name: String, val dept: String){
    override def toString: String = s"Employee ($name, $dept)"
  }

  class ContractEmployee(name: String, dept: String, val contractExpiry: LocalDate) extends Employee(name, dept) {
    override def toString: String = s"ContractEployee ($name, $dept, $contractExpiry)"
  }

  class AccessCard[-T <: Employee](val number: Int) //Employee is the upper bound for type T

  /** Lower Type Bound is Contract Employee and upper type bound is Employee */
  def access[T >: ContractEmployee <: Employee](accessCard: AccessCard[ContractEmployee]: Unit = {
    println(s"accessCard: ${accessCard.number} used.")
  }

  val contractEmpCard = new AccessCard[ContractEmployee](1)
  access(contractEmpCard)
}
