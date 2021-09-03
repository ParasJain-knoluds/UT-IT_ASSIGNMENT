package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val rahulUser: User = User("Rahul","Soni",24,"Google","rahul.soni@gmail.com")

    val result = userImpl.createUser(rahulUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val shivamUser: User = User("Shivam","Aggarwal",23,"Knoldus","shivam.aggarwal@knoldus")

    val result = userImpl.createUser(shivamUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val lokeshUser: User = User("Lokesh","Kumar",22,"Microsoft","lokesh.kumar@microsoft")

    val result = userImpl.createUser(lokeshUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val parasUser: User = User("Paras","Jain",22,"Knoldus","paras.jain@knoldus.com")

    val result = userImpl.createUser(parasUser)
    assert(!result.isEmpty)
  }

}
