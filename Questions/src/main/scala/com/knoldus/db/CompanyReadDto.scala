package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val facebookCompany: Company = Company("facebook", "facebook556@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "facebook" -> facebookCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
