package com.knoldus.db

import com.knoldus.models.Employee
import scala.collection.immutable.HashMap

class EmployeeReadDto {

  val parasEmployee: Employee = Employee("Paras","Jain",23,15000,"Intern","knoldus","paras.jain@knoldus.com")
  val rahulEmployee: Employee = Employee("Rahul","Gupta",28,15000,"Software Engineer","Philips","rahul.gupta@philips.com")

  val employees: HashMap[String, Employee] = HashMap("Paras" -> parasEmployee, "Rahul" -> rahulEmployee)
  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
